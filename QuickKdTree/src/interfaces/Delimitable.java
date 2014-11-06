package interfaces;

/**
 * Represents an object which can be defined by two points.
 * @author gwlemoul
 *
 */
public interface Delimitable {
	
	/**
	 * Getter
	 * @return origin
	 */
	PointInterface getOrigin();
	
	/**
	 * Setter
	 * @param origin
	 */
	void setOrigin(PointInterface origin);
	
	/**
	 * Getter
	 * @return end
	 */
	PointInterface getEnd();
	
	/**
	 * Setter
	 * @param end
	 */
	void setEnd(PointInterface end);
	
}
