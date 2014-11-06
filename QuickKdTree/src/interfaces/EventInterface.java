package interfaces;

/**
 * Plan sweeping event.
 * @author gwlemoul
 *
 */
public interface EventInterface {
	
	/**
	 * Getter
	 * @return segment
	 */
	SegmentInterface getSegment();
	
	/**
	 * Setter
	 * @param segment
	 */
	void setSegment(SegmentInterface segment);
	
	/**
	 * Getter
	 * @return plan
	 */
	PlanInterface getPlan();
	
	/**
	 * Setter
	 * @param plan
	 */
	void setPlan(PlanInterface plan);
	
	/**
	 * Getter
	 * @return type : +, | or -
	 */
	char getType();
	
	/**
	 * Setter
	 * @param type : +, | or -
	 */
	void setType(char type);
	
}
