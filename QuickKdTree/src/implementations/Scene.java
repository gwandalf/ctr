package implementations;

import interfaces.SceneInterface;
import interfaces.SegmentInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * 2D Scene
 * @author gwlemoul
 *
 */
public class Scene extends Delimitable implements SceneInterface {

	protected List<Segment> segments;

	/**
	 * Constructor
	 * @param origin
	 * @param end
	 */
	public Scene(Point origin, Point end) {
		super(origin, end);
		this.segments = new ArrayList<Segment>();
	}

	@Override
	public void addSegment(SegmentInterface segment) {
		this.segments.add((Segment)segment);
	}

	@Override
	public SegmentInterface getSegment(int i) {
		return this.segments.get(i);
	}

}
