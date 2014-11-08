package implementations;

import interfaces.EventInterface;
import interfaces.PlaneInterface;
import interfaces.SegmentInterface;

/**
 * Plan sweeping event.
 * @author gwlemoul
 *
 */
public class Event implements EventInterface {

	private Segment segment;
	private Plane plane;
	private EventType type;
	
	/**
	 * Constructor
	 * @param segment
	 * @param plan
	 * @param type
	 */
	public Event(Segment segment, Plane plane, EventType type) {
		this.segment = segment;
		this.plane = plane;
		this.type = type;
	}
	
	@Override
	public boolean inf(EventInterface e) {
		if(this.plane.getValue() < e.getPlane().getValue() ||
			(this.plane.getValue() == e.getPlane().getValue()
			&& this.plane.getDim() < e.getPlane().getDim()) ||
			(this.plane.getValue() == e.getPlane().getValue()
			&& this.plane.getDim() == e.getPlane().getDim()
			&& this.type.ordinal() < e.getType().ordinal()))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((plane == null) ? 0 : plane.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Event other = (Event) obj;
		if (plane == null) {
			if (other.plane != null)
				return false;
		} else if (!plane.equals(other.plane))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public SegmentInterface getSegment() {
		return segment;
	}

	@Override
	public void setSegment(SegmentInterface segment) {
		this.segment = (Segment) segment;
	}

	@Override
	public PlaneInterface getPlane() {
		return plane;
	}

	@Override
	public void setPlane(PlaneInterface plane) {
		this.plane = (Plane) plane;
	}

	@Override
	public EventType getType() {
		return this.type;
	}

	@Override
	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Event [segment=" + segment + ", plane=" + plane + ", type="
				+ type + "]";
	}
	
}
