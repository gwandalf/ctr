package implementations;

import interfaces.DelimitableInterface;
import interfaces.PointInterface;

/**
 * Represents an object which can be defined by two points.
 * @author gwlemoul
 *
 */
public abstract class Delimitable implements DelimitableInterface {

	protected Point origin;
	protected Point end;
	
	/**
	 * Constructor
	 * @param origin
	 * @param end
	 */
	public Delimitable(Point origin, Point end) {
		this.origin = origin;
		this.end = end;
	}
	
	@Override
	public PointInterface getOrigin() {
		return this.origin;
	}

	@Override
	public void setOrigin(PointInterface origin) {
		this.origin = (Point)origin;
	}

	@Override
	public PointInterface getEnd() {
		return this.end;
	}

	@Override
	public void setEnd(PointInterface end) {
		this.end = (Point) end;
	}

}
