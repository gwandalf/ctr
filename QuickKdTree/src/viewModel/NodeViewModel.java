package viewModel;

import implementations.Node;

import java.awt.geom.Line2D;
import java.util.Observable;
import java.util.Observer;

public class NodeViewModel extends Observable implements Observer {

	private NodeViewModel leftNode;
	private NodeViewModel rightNode;
	private Line2D.Double plane;
	private double[] bounds;
	private double[] leftBounds;
	private double[] rightBounds;
	private Node observed;
	private double maxX;
	private double maxY;
	private int offset;
	
	public NodeViewModel(Node observed, double[] bounds, double maxX, double maxY, int offset) {
		this.observed = observed;
		this.observed.addObserver(this);
		this.bounds = bounds;
		this.maxX = maxX;
		this.maxY = maxY;
		this.leftBounds = new double[4];
		leftBounds[0] = this.bounds[0];
		leftBounds[1] = this.bounds[1];
		this.rightBounds = new double[4];
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
			double x1 = Transformations.xCoordinate(this.observed.getPlane().getValue(), this.maxX);
			line = new Line2D.Double(x1, this.bounds[1] + offset, x1, this.bounds[3] + offset);
			leftBounds[2] = x1;
			leftBounds[3] = bounds[3];
		} else {
			double y1 = Transformations.yCoordinate(this.observed.getPlane().getValue(), this.maxY) + offset;
			line = new Line2D.Double(this.bounds[0], y1, this.bounds[2], y1);
			rightBounds[1] = y1;
			rightBounds[0] = bounds[0];
		}
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

	public double[] getBounds() {
		return bounds;
	}

	public void setBounds(double[] bounds) {
		this.bounds = bounds;
	}

	public double[] getLeftBounds() {
		return leftBounds;
	}

	public void setLeftBounds(double[] leftBounds) {
		this.leftBounds = leftBounds;
	}

	public double[] getRightBounds() {
		return rightBounds;
	}

	public void setRightBounds(double[] rightBounds) {
		this.rightBounds = rightBounds;
	}

	public Observable getObserved() {
		return observed;
	}

	public void setObserved(Node observed) {
		this.observed = observed;
	}

}
