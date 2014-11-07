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
	
}
