package implementations;

import interfaces.PlaneInterface;

/**
 * Splitting plan
 * @author gwlemoul
 *
 */
public class Plane implements PlaneInterface {

	private int dim;
	private int value;
	private Side side;
	
	/**
	 * Constructor
	 * @param dim
	 * @param value
	 */
	public Plane(int dim, int value) {
		this.setDim(dim);
		this.value = value;
	}
	
	@Override
	public int getDim() {
		return dim;
	}

	@Override
	public void setDim(int dim) {
		if(dim == 1 || dim == 2)
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

	@Override
	public Side getSide() {
		return this.side;
	}

	@Override
	public void setSide(Side side) {
		this.side = side;
	}

}
