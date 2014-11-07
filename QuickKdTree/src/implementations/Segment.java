package implementations;

import interfaces.AffineInterface;
import interfaces.EventListInterface;
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
	private StrictSide side;
	
	/**
	 * Constructor
	 * with (0,0) and (0,1).
	 */
	public Segment() {
		super(new Point(0,0), new Point(0,1));
		this.innerCost = 1;
	}
	
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
		SegmentInterface[] res = new SegmentInterface[2];
		Point bound;
		if(plane.getDim() == 1) {
			double y = this.getAffine().image(plane.getValue());
			bound = new Point(plane.getValue(), y);
			if(this.origin.getX() < this.end.getX()) {
				res[0] = new Segment(this.origin, bound, this.scene);
				res[1] = new Segment(bound, this.end, this.scene);
			} else {
				res[1] = new Segment(this.origin, bound, this.scene);
				res[0] = new Segment(bound, this.end, this.scene);
			}
		} else {
			double x = this.getAffine().antecedent(plane.getValue());
			bound = new Point(x, plane.getValue());
			if(this.origin.getY() < this.end.getY()) {
				res[0] = new Segment(this.origin, bound, this.scene);
				res[1] = new Segment(bound, this.end, this.scene);
			} else {
				res[1] = new Segment(this.origin, bound, this.scene);
				res[0] = new Segment(bound, this.end, this.scene);
			}
		}
		return res;
	}
	
	@Override
	public EventListInterface generateEvents() {
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

	@Override
	public StrictSide getSide() {
		return this.side;
	}

	@Override
	public void setSide(StrictSide side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "Segment [origin=" + origin + ", end=" + end + "]";
	}

}
