package implementations;

import interfaces.EventInterface;
import interfaces.PlanInterface;
import interfaces.SegmentInterface;

/**
 * Plan sweeping event.
 * @author gwlemoul
 *
 */
public class Event implements EventInterface {

	private Segment segment;
	private Plan plan;
	private char type;
	
	/**
	 * Constructor
	 * @param segment
	 * @param plan
	 * @param type
	 */
	public Event(Segment segment, Plan plan, char type) {
		this.segment = segment;
		this.plan = plan;
		this.type = type;
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
	public PlanInterface getPlan() {
		return plan;
	}

	@Override
	public void setPlan(PlanInterface plan) {
		this.plan = (Plan) plan;
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
