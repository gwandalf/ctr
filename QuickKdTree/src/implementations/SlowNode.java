package implementations;

import interfaces.PlaneInterface;
import interfaces.SegmentInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Node built by SAH heuristic, but in O(N^2)
 * @author gwendal
 *
 */
public class SlowNode extends ClassicNode {

	/**
	 * Constructor
	 * @param origin Origin point (low left)
	 * @param end Up right corner
	 * @param segments Contained segments.
	 */
	public SlowNode(Point origin, Point end, Set<SegmentInterface> segments) {
		super(origin, end);
		this.segments = segments;
	}
	
	@Override
	public PlaneInterface findPlane() {
		Plane res = null;
		double cost = Double.MAX_VALUE;
		Set<PlaneInterface> candidates = new HashSet<PlaneInterface>();
		for(SegmentInterface seg : this.segments)
			candidates.addAll(seg.generatePlanes());
		for(PlaneInterface plane : candidates) {
			int nbLeft = 0;
			int nbRight = 0;
			for(SegmentInterface seg : this.segments) {
				if((plane.getDim() == 1 && seg.minX() <= plane.getValue()) ||
						(plane.getDim() == 2 && seg.minY() <= plane.getValue()))
					nbLeft++;
				if((plane.getDim() == 1 && seg.maxX() >= plane.getValue()) ||
						(plane.getDim() == 2 && seg.maxY() >= plane.getValue()))
					nbRight++;
			}
			double newCost = this.sah(plane, nbLeft, nbRight);
			if(newCost < cost) {
				res = (Plane)plane;
				cost = newCost;
			}
		}
		return res;
	}

	@Override
	public ClassicNode makeClassicNode(Point p1, Point p2,
			Set<SegmentInterface> segments) {
		return new SlowNode(p1, p2, segments);
	}

	@Override
	public List<Set<SegmentInterface>> split() {
		List<Set<SegmentInterface>> res = new ArrayList<Set<SegmentInterface>>();
		res.add(new HashSet<SegmentInterface>());
		res.add(new HashSet<SegmentInterface>());
		for(SegmentInterface seg : this.segments) {
			if((plane.getDim() == 1 && seg.maxX() <= plane.getValue()) ||
					(plane.getDim() == 2 && seg.maxY() <= plane.getValue()))
				res.get(0).add(seg);
			else if((plane.getDim() == 1 && seg.minX() >= plane.getValue()) ||
					(plane.getDim() == 2 && seg.minY() >= plane.getValue()))
				res.get(1).add(seg);
			else {
				SegmentInterface[] parts = seg.split(plane);
				res.get(0).add(parts[0]);
				res.get(1).add(parts[1]);
			}
		}
		return res;
	}

}
