package tests;

import implementations.Event;
import implementations.EventList;
import implementations.Plane;
import implementations.Point;
import implementations.QuickNode;
import implementations.Segment;
import interfaces.EventInterface.EventType;
import interfaces.EventListInterface;
import interfaces.SegmentInterface.StrictSide;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickNodeTest {

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
	static QuickNode node;
	Plane west = new Plane(1, 0);
	Plane south = new Plane(2, 0);
	Plane east = new Plane(1, 1);
	Plane north = new Plane(2, 1);
	
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
		Plane plane = new Plane(2, 0.5);
		Point min = new Point(-2, -2);
		Point max = new Point(2, 2);
		node = new QuickNode(min, max, events);
		node.setPlane(plane);
	}
	
	@Test
	public void testClassifyLeftRightBoth() {
		Assert.assertEquals(5, events.size());
		Assert.assertEquals(1, node.getSegments().size());
		node.classifyLeftRightBoth();
		Assert.assertEquals(StrictSide.BOTH, segRight.getSide());
	}
	
	@Test
	public void testClipSegments() {
		EventListInterface[] both = node.clipSegments();
		Assert.assertEquals(3, both[0].size());
		Assert.assertEquals(3, both[1].size());
		Segment low = new Segment(new Point(0,0), new Point(0,0.5), null);
		Segment up = new Segment(new Point(0,0.5), new Point(0,1), null);
		Assert.assertTrue(both[0].getEventList().contains(new Event(low, south, EventType.START)));
		Assert.assertTrue(both[0].getEventList().contains(new Event(low, new Plane(2, 0.5), EventType.END)));
		Assert.assertTrue(both[0].getEventList().contains(new Event(low, west, EventType.PLANAR)));
		Assert.assertTrue(both[1].getEventList().contains(new Event(up, new Plane(2, 0.5), EventType.START)));
		Assert.assertTrue(both[1].getEventList().contains(new Event(up, north, EventType.END)));
		Assert.assertTrue(both[1].getEventList().contains(new Event(up, west, EventType.PLANAR)));
	}

}
