package interfaces;

/**
 * Ray or portion of a ray.
 * @author gwlemoul
 *
 */
public interface RayInterface extends Delimitable {

	/**
	 * Getter
	 * @return corresponding affine function.
	 */
	AffineInterface getAffine();
	
}
