package interfaces;

import java.util.Set;

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
	 * Size
	 * @return size
	 */
	int size();
	
	/**
	 * Getter
	 * @return segment set.
	 */
	@SuppressWarnings("rawtypes")
	Set getSegments();
	
}
