package implementations;

import interfaces.AffineInterface;
import interfaces.RayInterface;

/**
 * Ray
 * @author gwendal
 *
 */
public class Ray extends Delimitable implements RayInterface {

	private Affine affine;
	
	/**
	 * Constructor
	 * @param origin
	 * @param end
	 */
	public Ray(Point origin, Point end) {
		super(origin, end);
	}

	@Override
	public AffineInterface getAffine() {
		if(this.affine == null)
			this.affine = new Affine(this.origin, this.end);
		return this.affine;
	}

}
