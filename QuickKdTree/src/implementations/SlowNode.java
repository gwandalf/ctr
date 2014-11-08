package implementations;

import interfaces.PlaneInterface;

/**
 * Node built by SAH heuristic, but in O(N^2)
 * @author gwendal
 *
 */
public class SlowNode extends Node {

	public SlowNode(Point origin, Point end) {
		super(origin, end);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buildChildren() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public PlaneInterface findPlane() {
		// TODO Auto-generated method stub
		return null;
	}

}
