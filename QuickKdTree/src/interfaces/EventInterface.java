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
	 * @return plane
	 */
	PlaneInterface getPlane();
	
	/**
	 * Setter
	 * @param plane
	 */
	void setPlane(PlaneInterface plane);
	
	/**
	 * Getter
	 * @return type : END, PLANAR or START
	 */
	EventType getType();
	
	/**
	 * Setter
	 * @param type : END, PLANAR or START
	 */
	void setType(EventType type);
	
	public static enum EventType {
		END,
		PLANAR,
		START
	}
	
}
