package implementations;

import interfaces.LeafInterface;
import interfaces.NodeInterface;
import interfaces.PlaneInterface;
import interfaces.PointInterface;
import interfaces.RayInterface;
import interfaces.SegmentInterface;

/**
 * Kd-Tree node
 * @author gwendal
 *
 */
public abstract class Node extends Scene implements NodeInterface {

	protected int innerCost;
	private Node leftChild;
	private Node rightChild;
	
	/**
	 * Constructor
	 * @param origin
	 * @param end
	 */
	public Node(Point origin, Point end) {
		super(origin, end);
		this.innerCost = 2;
	}

	@Override
	public boolean isNextCrossed(RayInterface ray) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInnerCost() {
		return this.innerCost;
	}

	@Override
	public void setInnerCost(int innerCost) {
		this.innerCost = innerCost;
	}

	@Override
	public double sah(PlaneInterface plan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LeafInterface nextVoxel(RayInterface ray) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isIn(SegmentInterface segment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIn(PointInterface point) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlaneInterface findPlane() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodeInterface getLeftChild() {
		return this.leftChild;
	}

	@Override
	public void setLeftChild(NodeInterface leftChild) {
		this.leftChild = (Node) leftChild;
	}

	@Override
	public NodeInterface getRightChild() {
		return this.rightChild;
	}

	@Override
	public void setRightChild(NodeInterface rightChild) {
		this.rightChild = (Node) rightChild;
	}

}
