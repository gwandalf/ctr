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
	private char type;
	
	/**
	 * Constructor
	 * @param segment
	 * @param plan
	 * @param type
	 */
	public Event(Segment segment, Plane plane, char type) {
		this.segment = segment;
		this.plane = plane;
		this.type = type;
	}
	
	@Override
	public boolean inf(EventInterface e) {
		// TODO Auto-generated method stub
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
	public char getType() {
		return type;
	}

	@Override
	public void setType(char type) {
		if(type == '+' || type == '-' || type == '|')
			this.type = type;
	}

}
