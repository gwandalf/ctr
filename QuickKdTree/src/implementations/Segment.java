package implementations;

import interfaces.PointInterface;
import interfaces.RayInterface;
import interfaces.SceneInterface;
import interfaces.SegmentInterface;

/**
 * Segment (equivalent of the 3D triangle).
 * @author gwlemoul
 *
 */
public class Segment implements SegmentInterface {

	@Override
	public boolean isNextCrossed(RayInterface ray) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInnerCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setInnerCost(int innerCost) {
		// TODO Auto-generated method stub

	}

	@Override
	public PointInterface getOrigin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOrigin(PointInterface origin) {
		// TODO Auto-generated method stub

	}

	@Override
	public PointInterface getEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEnd(PointInterface end) {
		// TODO Auto-generated method stub

	}

	@Override
	public SceneInterface getScene() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScene(SceneInterface scene) {
		// TODO Auto-generated method stub

	}

}
