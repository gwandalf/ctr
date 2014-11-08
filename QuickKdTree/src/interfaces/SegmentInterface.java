package interfaces;

import java.util.Set;

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
	 * Generates the planes from the current segment.
	 * @return The planes related to this segment.
	 */
	Set<PlaneInterface> generatePlanes();
	
	/**
	 * Minimum X coordinate.
	 * @return Minimum X coordinate.
	 */
	double minX();
	
	/**
	 * Maximum X coordinate.
	 * @return Maximum X coordinate.
	 */
	double maxX();
	
	/**
	 * Minimum Y coordinate.
	 * @return Minimum Y coordinate.
	 */
	double minY();
	
	/**
	 * Maximum Y coordinate.
	 * @return Maximum Y coordinate.
	 */
	double maxY();
	
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
