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
	int getDim();
	
	/**
	 * Setter
	 * @param dim
	 */
	void setDim(int dim);
	
	/**
	 * Getter
	 * @return position value
	 */
	double getValue();
	
	/**
	 * Setter
	 * @param value
	 */
	void setValue(double value);
	
	/**
	 * Getter
	 * @return side
	 */
	Side getSide();
	
	/**
	 * Setter
	 * @param side
	 */
	void setSide(Side side);
	
	public static enum Side {
		LEFT,
		RIGHT
	}
	
}
