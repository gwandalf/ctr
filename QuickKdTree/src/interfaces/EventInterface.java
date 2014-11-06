package interfaces;

/**
 * Plan sweeping event.
 * @author gwlemoul
 *
 */
public interface EventInterface {
	
	/**
	 * Tells if the current event is inferior to the given one :
	 * e1 < e2 if e1.plan.value < e2.plan.value or (e1.plan.value = e2.plan.value and e1.type < e2.type)
	 * with - < | < +
	 * @param e Event to be compared with.
	 * @return true if the current event is inferior to the given one, fale otherwise.
	 */
	boolean inf(EventInterface e);
	
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
	PlaneInterface getPlan();
	
	/**
	 * Setter
	 * @param plan
	 */
	void setPlan(PlaneInterface plan);
	
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
