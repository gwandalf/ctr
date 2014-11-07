package implementations;

import interfaces.AffineInterface;
import interfaces.EventInterface.EventType;
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
		EventList res = new EventList();
		Event ev1, ev2, ev3, ev4;
		Plane p1, p2, p3, p4;
		double minX = Math.min(this.origin.getX(), this.end.getX());
		double maxX = Math.max(this.origin.getX(), this.end.getX());
		double minY = Math.min(this.origin.getY(), this.end.getY());
		double maxY = Math.max(this.origin.getY(), this.end.getY());
		p1 = new Plane(1, minX);
		p2 = new Plane(1, maxX);
		p3 = new Plane(2, minY);
		p4 = new Plane(2, maxY);
		if(this.origin.getX() == this.end.getX()) {
			ev1 = new Event(this, p1, EventType.PLANAR);
			ev3 = new Event(this, p3, EventType.START);
			ev4 = new Event(this, p4, EventType.END);
			res.add(ev4);
			res.add(ev1);
			res.add(ev3);
		} else if(this.origin.getY() == this.end.getY()) {
			ev1 = new Event(this, p1, EventType.START);
			ev2 = new Event(this, p2, EventType.END);
			ev4 = new Event(this, p4, EventType.PLANAR);
			res.add(ev2);
			res.add(ev4);
			res.add(ev1);
		} else {
			ev1 = new Event(this, p1, EventType.START);
			ev2 = new Event(this, p2, EventType.END);
			ev3 = new Event(this, p3, EventType.START);
			ev4 = new Event(this, p4, EventType.END);
			res.add(ev1);
			res.add(ev2);
			res.add(ev3);
			res.add(ev4);
		}
		return res;
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
