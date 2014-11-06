package interfaces;

/**
 * 2D Scene
 * @author gwlemoul
 *
 */
public interface SceneInterface extends DelimitableInterface {

	/**
	 * Adds a segment to the scene.
	 * @param segment Segment to be added. 
	 */
	void addSegment(SegmentInterface segment);
	
	/**
	 * Getter
	 * @param i Index of the segment.
	 * @return segment at index i.
	 */
	SegmentInterface getSegment(int i);
	
}
