package interfaces;

/**
 * Element that can be crossed by a ray with a certain cost.
 * @author gwlemoul
 *
 */
public interface GeometricElement extends Delimitable {
	
	/**
	 * Tells if the current object is the next to be crossed by the given ray.
	 * @param ray Ray which maybe crosses the current object.
	 * @return true if the current object is the next to be crossed by the given ray, false otherwise.
	 */
	boolean isNextCrossed(RayInterface ray);
	
	/**
	 * Getter
	 * @return cost
	 */
	int getInnerCost();
	
	/**
	 * Setter
	 * @param innerCost
	 */
	void setInnerCost(int innerCost);

}
