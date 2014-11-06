package implementations;

import interfaces.PlanInterface;

/**
 * Splitting plan
 * @author gwlemoul
 *
 */
public class Plan implements PlanInterface {

	private char dim;
	private int value;
	
	/**
	 * Constructor
	 * @param dim
	 * @param value
	 */
	public Plan(char dim, int value) {
		this.dim = dim;
		this.value = value;
	}
	
	@Override
	public char getDim() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDim(char dim) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setValue(int value) {
		// TODO Auto-generated method stub

	}

}
