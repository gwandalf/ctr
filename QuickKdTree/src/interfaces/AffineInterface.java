package interfaces;

/**
 * Affine function.
 * @author gwendal
 *
 */
public interface AffineInterface {

	/**
	 * Computes the image of the given number.
	 * @param x Number to evaluate.
	 * @return The image of the given number.
	 */
	double image(double x);
	
	/**
	 * Computes the antecedent of the given number.
	 * @param y Number to devaluate.
	 * @return The antecedent of the given number.
	 */
	double antecedent(double y);
	
	/**
	 * Computes the x coordinate of the common point of the current affine and the given one.
	 * @param a Affine to compute the crossing point with.
	 * @return The x coordinate of the common point of the current affine and the given one.
	 */
	double crossX(AffineInterface a);
	
	/**
	 * Computes the y coordinate of the common point of the current affine and the given one.
	 * @param a Affine to compute the crossing point with.
	 * @return The y coordinate of the common point of the current affine and the given one.
	 */
	double crossY(AffineInterface a);
	
	/**
	 * Getter
	 * @return m (coefficient)
	 */
	double getM();
	
	/**
	 * Getter
	 * @return p (image of 0.0)
	 */
	double getP();
	
}
