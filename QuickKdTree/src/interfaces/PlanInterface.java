package interfaces;

/**
 * Splitting plan
 * @author gwlemoul
 *
 */
public interface PlanInterface {

	/**
	 * Getter
	 * @return dimension
	 */
	char getDim();
	
	/**
	 * Setter
	 * @param dim
	 */
	void setDim(char dim);
	
	/**
	 * Getter
	 * @return position value
	 */
	int getValue();
	
	/**
	 * Setter
	 * @param value
	 */
	void setValue(int value);
	
}
