package tests;

import org.junit.Assert;
import org.junit.BeforeClass;

import implementations.Event;
import implementations.EventList;
import implementations.Plane;
import implementations.Segment;
import interfaces.EventInterface.EventType;

import org.junit.Test;

public class EventListTest {

	static Segment seg = new Segment();
	static Plane p1 = new Plane(1, 1);
	static Plane p2 = new Plane(1, 2);
	static Plane p3 = new Plane(2, 0);
	static Event e0 = new Event(seg, p3, EventType.END);
	static Event e1 = new Event(seg, p1, EventType.END);
	static Event e2 = new Event(seg, p1, EventType.PLANAR);
	static Event e3 = new Event(seg, p1, EventType.START);
	static Event e4 = new Event(seg, p2, EventType.END);
	static EventList events = new EventList();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

}
