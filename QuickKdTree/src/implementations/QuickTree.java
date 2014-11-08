package implementations;

import interfaces.SegmentInterface;

/**
 * Kd-Tree buit with the O(NlogN) algorithm.
 * @author gwendal
 *
 */
public class QuickTree extends Tree {

	/**
	 * Constructor
	 * @param scene Scene containing the segments
	 */
	public QuickTree(Scene scene) {
		EventList events = new EventList();
		for(SegmentInterface seg : scene.getSegments()) {
			EventList newEvents = (EventList)seg.generateEvents();
			events.getEventList().addAll(newEvents.getEventList());
		}
		events.sort();
		this.root = new QuickNode(scene.origin, scene.end, events);
		this.root.buildChildren();
	}
	
}
