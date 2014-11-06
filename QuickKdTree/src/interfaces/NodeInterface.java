package interfaces;

/**
 * Node of a kd-tree, which subdivide a scene.
 * Equivalent to a voxel.
 * @author gwlemoul
 *
 */
public interface NodeInterface extends GeometricElement {

	/**
	 * Computes the estimated cost defined by the SAH heuristic.
	 * @param plan Candidate plan which may split the current node.
	 * @return The estimated cost defined by the SAH heuristic.
	 */
	double sah(PlanInterface plan);
	
	/**
	 * Computes the next voxel to be crossed by the given ray.
	 * @param ray Ray which may cross a voxel.
	 * @return The next voxel to be crossed by the given ray.
	 */
	LeafInterface nextVoxel(RayInterface ray);
	
}
