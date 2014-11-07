package implementations;

import interfaces.PlaneInterface;

/**
 * Splitting plan
 * @author gwlemoul
 *
 */
public class Plane implements PlaneInterface {

	private int dim;
	private double value;
	private Side side;
	
	/**
	 * Constructor
	 * @param dim
	 * @param value
	 */
	public Plane(int dim, double value) {
		this.setDim(dim);
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dim;
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		if (dim != other.dim)
			return false;
		if (side != other.side)
			return false;
		if (Double.doubleToLongBits(value) != Double
				.doubleToLongBits(other.value))
			return false;
		return true;
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
	public double getValue() {
		return value;
	}

	@Override
	public void setValue(double value) {
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
