package interfaces;

/**
 * Leaf of a kd-tree.
 * Equivalent to a voxel.
 * @author gwlemoul
 *
 */
public interface LeafInterface {
	
	/**
	 * Computes the portion of the given ray which is clipped inside the voxel.
	 * @param totalRay Referenced rays.
	 * @return The portion of the given ray which is clipped inside the voxel.
	 */
	RayInterface localRay(RayInterface totalRay);

}
