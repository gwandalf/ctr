package interfaces;

/**
 * Node of a kd-tree, which subdivide a scene.
 * Equivalent to a voxel.
 * @author gwlemoul
 *
 */
public interface NodeInterface extends GeometricElement, SceneInterface {

	/**
	 * Computes the estimated cost defined by the SAH heuristic.
	 * @param plane Candidate plan which may split the current node.
	 * @return The estimated cost defined by the SAH heuristic.
	 */
	double sah(PlaneInterface plane, int nbLeft, int nbRight);
	
	/**
	 * Computes the next voxel to be crossed by the given ray.
	 * @param ray Ray which may cross a voxel.
	 * @return The next voxel to be crossed by the given ray.
	 */
	LeafInterface nextVoxel(RayInterface ray);
	
	/**
	 * Builds its children.
	 */
	void buildChildren();
	
	/**
	 * Tells if the given segment belongs to the voxel.
	 * @param segment Segment to place.
	 * @return true if the given segment belongs to the voxel, false otherwise.
	 */
	boolean isIn(SegmentInterface segment);
	
	/**
	 * Tells if the given point belongs to the voxel.
	 * @param point Point to place.
	 * @return true if the given point belongs to the voxel, false otherwise.
	 */
	boolean isIn(PointInterface point);
	
	/**
	 * Computes the best splitting plane.
	 * @return The best splitting plane.
	 */
	PlaneInterface findPlane();
	
	/**
	 * Classifies the segment in the node according to the splitting plane.
	 */
	void classifyLeftRightBoth();
	
	/**
	 * Getter
	 * @return leftChild
	 */
	NodeInterface getLeftChild();
	
	/**
	 * Setter
	 * @param leftChild
	 */
	void setLeftChild(NodeInterface leftChild);
	
	/**
	 * Getter
	 * @return rightChild
	 */
	NodeInterface getRightChild();
	
	/**
	 * Setter
	 * @param rightChild
	 */
	void setRightChild(NodeInterface rightChild);
	
	/**
	 * Getter
	 * @return splitting plane
	 */
	PlaneInterface getPlane();
	
	/**
	 * Setter
	 * @param plane Splitting plane
	 */
	void setPlane(PlaneInterface plane);
	
}
