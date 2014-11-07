package tests;

import implementations.Event;
import implementations.EventList;
import implementations.Plane;
import implementations.Segment;
import interfaces.EventInterface.EventType;
import interfaces.EventListInterface;
import interfaces.SegmentInterface.StrictSide;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class EventListTest {

	static Segment segLeft = new Segment();
	static Segment segRight = new Segment();
	static Segment segBoth = new Segment();
	static Plane p1 = new Plane(1, 1);
	static Plane p2 = new Plane(1, 2);
	static Plane p3 = new Plane(2, 0);
	static Event e0 = new Event(segLeft, p3, EventType.END);
	static Event e1 = new Event(segBoth, p1, EventType.END);
	static Event e2 = new Event(segRight, p1, EventType.PLANAR);
	static Event e3 = new Event(segLeft, p1, EventType.START);
	static Event e4 = new Event(segRight, p2, EventType.END);
	static EventList events = new EventList();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		segLeft.setSide(StrictSide.LEFTONLY);
		segRight.setSide(StrictSide.RIGHTONLY);
		segBoth.setSide(StrictSide.BOTH);
		events.add(e2);
		events.add(e1);
		events.add(e3);
		events.add(e0);
		events.add(e4);
	}
	
	@Test
	public void testSort() {
		events.sort();
		Assert.assertEquals(e0, events.get(0));
		Assert.assertEquals(e1, events.get(1));
		Assert.assertEquals(e2, events.get(2));
		Assert.assertEquals(e3, events.get(3));
		Assert.assertEquals(e4, events.get(4));
	}
	
	@Test
	public void testStrictSplit() {
		EventListInterface[] eventsTab = events.strictSplit();
		Assert.assertEquals(2, eventsTab[0].size());
		Assert.assertEquals(2, eventsTab[1].size());
		for(int i = 0 ; i < eventsTab[0].size() ; i++) {
			Segment seg = (Segment)eventsTab[0].get(i).getSegment();
			Assert.assertEquals(StrictSide.LEFTONLY, seg.getSide());
		}
		for(int i = 0 ; i < eventsTab[1].size() ; i++) {
			Segment seg = (Segment)eventsTab[1].get(i).getSegment();
			Assert.assertEquals(StrictSide.RIGHTONLY, seg.getSide());
		}
	}
	
	@Test
	public void testMerge() {
		events.sort();
		EventListInterface[] eventsTab = events.strictSplit();
		EventList evs = (EventList)eventsTab[0].merge(eventsTab[1]);
		Assert.assertEquals(4, evs.size());
		Assert.assertEquals(e0, evs.get(0));
		Assert.assertEquals(e2, evs.get(1));
		Assert.assertEquals(e3, evs.get(2));
		Assert.assertEquals(e4, evs.get(3));
	}

}
