package interfaces;

/**
 * Segment (equivalent of the 3D triangle).
 * @author gwlemoul
 *
 */
public interface SegmentInterface extends GeometricElement {

	/**
	 * Splits the current segment according to the current plane.
	 * @param plane
	 * @return Two resulting segments.
	 */
	SegmentInterface[] split(PlaneInterface plane);
	
	/**
	 * Generates events from the current segment.
	 * @return Events from the current segment.
	 */
	EventListInterface generateEvents();
	
	/**
	 * Getter
	 * @return owner scene
	 */
	SceneInterface getScene();
	
	/**
	 * Setter
	 * @param scene
	 */
	void setScene(SceneInterface scene);
	
	/**
	 * Getter
	 * @return corresponding affine function.
	 */
	AffineInterface getAffine();
	
	/**
	 * Getter
	 * @return side
	 */
	StrictSide getSide();
	
	/**
	 * Setter
	 * @param side
	 */
	void setSide(StrictSide side);
	
	public static enum StrictSide {
		BOTH,
		LEFTONLY,
		RIGHTONLY
	}
	
}
