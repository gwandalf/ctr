package implementations;

import interfaces.PlaneInterface;

/**
 * Splitting plan
 * @author gwlemoul
 *
 */
public class Plane implements PlaneInterface {

	private char dim;
	private int value;
	
	/**
	 * Constructor
	 * @param dim
	 * @param value
	 */
	public Plane(char dim, int value) {
		this.setDim(dim);
		this.value = value;
	}
	
	@Override
	public char getDim() {
		return dim;
	}

	@Override
	public void setDim(char dim) {
		if(dim == 'x' || dim == 'y')
			this.dim = dim;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void setValue(int value) {
		this.value = value;
	}

}
