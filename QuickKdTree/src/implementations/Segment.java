package implementations;

import interfaces.AffineInterface;
import interfaces.PlaneInterface;
import interfaces.RayInterface;
import interfaces.SceneInterface;
import interfaces.SegmentInterface;

/**
 * Segment (equivalent of the 3D triangle).
 * @author gwlemoul
 *
 */
public class Segment extends Delimitable implements SegmentInterface {

	private int innerCost;
	private Scene scene;
	private Affine affine;
	
	/**
	 * Constructor
	 * @param origin
	 * @param end
	 */
	public Segment(Point origin, Point end, Scene scene) {
		super(origin, end);
		this.innerCost = 1;
		this.scene = scene;
	}
	
	@Override
	public SegmentInterface[] split(PlaneInterface plane) {
		// TODO Auto-generated method stub
		return null;
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
	public SceneInterface getScene() {
		return this.scene;
	}

	@Override
	public void setScene(SceneInterface scene) {
		this.scene = (Scene) scene;
	}

	@Override
	public AffineInterface getAffine() {
		if(this.affine == null)
			this.affine = new Affine(this.origin, this.end);
		return this.affine;
	}

}
