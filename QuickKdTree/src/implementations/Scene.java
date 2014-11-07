package implementations;

import interfaces.SceneInterface;
import interfaces.SegmentInterface;

import java.util.HashSet;
import java.util.Set;

/**
 * 2D Scene
 * @author gwlemoul
 *
 */
public class Scene extends Delimitable implements SceneInterface {

	protected Set<Segment> segments;

	/**
	 * Constructor
	 * @param origin
	 * @param end
	 */
	public Scene(Point origin, Point end) {
		super(origin, end);
		this.segments = new HashSet<Segment>();
	}

	@Override
	public void addSegment(SegmentInterface segment) {
		this.segments.add((Segment)segment);
	}

	@Override
	public int size() {
		return segments.size();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Set getSegments() {
		return this.segments;
	}

}
