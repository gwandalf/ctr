package viewModel;

import implementations.Node;

import java.awt.geom.Line2D;
import java.util.Observable;
import java.util.Observer;

public class NodeViewModel extends Observable implements Observer {

	private NodeViewModel leftNode;
	private NodeViewModel rightNode;
	private Line2D.Double plane;
	private int[] bounds;
	private int[] leftBounds;
	private int[] rightBounds;
	private Node observed;
	private double maxX;
	private double maxY;
	private int offset;
	
	public NodeViewModel(Node observed, int[] bounds, double maxX, double maxY, int offset) {
		this.observed = observed;
		this.observed.addObserver(this);
		this.bounds = bounds;
		this.maxX = maxX;
		this.maxY = maxY;
		this.leftBounds = new int[4];
		leftBounds[0] = this.bounds[0];
		leftBounds[1] = this.bounds[1];
		this.rightBounds = new int[4];
		rightBounds[2] = this.bounds[2];
		rightBounds[3] = this.bounds[3];
		this.offset = offset;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 == this.observed) {
			String msg = (String)arg1;
			if("plane".equals(msg)) {
				this.setUpPlane();
				System.out.println("Bounds = " + leftBounds[0] + ',' + leftBounds[1] + ',' + leftBounds[2] + ',' + leftBounds[3]);
			} else if("leftNode".equals(msg)) {
				setLeftNode(new NodeViewModel((Node)this.observed.getLeftChild(), leftBounds, maxX, maxY, offset));
			} else {
				setRightNode(new NodeViewModel((Node)this.observed.getRightChild(), rightBounds, maxX, maxY, offset));
			}
		}
	}
	
	private void setUpPlane() {
		Line2D.Double line;
		if(this.observed.getPlane().getDim() == 1) {
			int x1 = (int)Transformations.xCoordinate(this.observed.getPlane().getValue(), this.maxX);
			line = new Line2D.Double(x1, this.bounds[1], x1, this.bounds[3]);
			leftBounds[2] = x1;
			leftBounds[3] = bounds[3];
			rightBounds[1] = bounds[1];
			rightBounds[0] = x1;
		} else {
			int y1 = (int)Transformations.yCoordinate(this.observed.getPlane().getValue(), this.maxY) + offset;
			line = new Line2D.Double(this.bounds[0], y1, this.bounds[2], y1);
			rightBounds[1] = y1;
			rightBounds[0] = bounds[0];
			leftBounds[2] = bounds[2];
			leftBounds[3] = y1;
		}
		System.out.println(this.observed.getPlane().getValue());
		this.setPlane(line);
	}

	public NodeViewModel getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(NodeViewModel leftNode) {
		this.leftNode = leftNode;
		this.setChanged();
		this.notifyObservers("leftNode");
	}

	public NodeViewModel getRightNode() {
		return rightNode;
	}

	public void setRightNode(NodeViewModel rightNode) {
		this.rightNode = rightNode;
		this.setChanged();
		this.notifyObservers("rightNode");
	}

	public Line2D.Double getPlane() {
		return plane;
	}

	public void setPlane(Line2D.Double plane) {
		this.plane = plane;
		this.setChanged();
		this.notifyObservers("plane");
	}

	public int[] getBounds() {
		return bounds;
	}

	public void setBounds(int[] bounds) {
		this.bounds = bounds;
	}

	public int[] getLeftBounds() {
		return leftBounds;
	}

	public void setLeftBounds(int[] leftBounds) {
		this.leftBounds = leftBounds;
	}

	public int[] getRightBounds() {
		return rightBounds;
	}

	public void setRightBounds(int[] rightBounds) {
		this.rightBounds = rightBounds;
	}

	public Observable getObserved() {
		return observed;
	}

	public void setObserved(Node observed) {
		this.observed = observed;
	}

}
