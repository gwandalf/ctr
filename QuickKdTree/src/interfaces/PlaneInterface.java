package interfaces;

/**
 * Splitting plan
 * @author gwlemoul
 *
 */
public interface PlaneInterface {

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
