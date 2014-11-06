package interfaces;

/**
 * Ray or portion of a ray.
 * @author gwlemoul
 *
 */
public interface RayInterface extends DelimitableInterface {

	/**
	 * Getter
	 * @return corresponding affine function.
	 */
	AffineInterface getAffine();
	
}
