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
	private Plane plan;
	private char type;
	
	/**
	 * Constructor
	 * @param segment
	 * @param plan
	 * @param type
	 */
	public Event(Segment segment, Plane plan, char type) {
		this.segment = segment;
		this.plan = plan;
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
	public PlaneInterface getPlan() {
		return plan;
	}

	@Override
	public void setPlan(PlaneInterface plan) {
		this.plan = (Plane) plan;
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
