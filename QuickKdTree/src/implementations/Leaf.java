package implementations;

import interfaces.LeafInterface;
import interfaces.RayInterface;

public class Leaf extends Node implements LeafInterface {

	/**
	 * Constructor
	 * @param origin
	 * @param end
	 */
	public Leaf(Point origin, Point end) {
		super(origin, end);
	}

	@Override
	public RayInterface localRay(RayInterface totalRay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildChildren() {
		// TODO Auto-generated method stub
		
	}

}
