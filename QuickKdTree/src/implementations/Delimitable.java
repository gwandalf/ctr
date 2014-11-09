package implementations;

import interfaces.DelimitableInterface;
import interfaces.PointInterface;

import java.util.Observable;

/**
 * Represents an object which can be defined by two points.
 * @author gwlemoul
 *
 */
public abstract class Delimitable extends Observable implements DelimitableInterface {

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delimitable other = (Delimitable) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		return true;
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
