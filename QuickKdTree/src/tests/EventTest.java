package tests;

import org.junit.Assert;
import implementations.Event;
import implementations.Plane;
import implementations.Segment;
import interfaces.EventInterface.EventType;

import org.junit.Test;

public class EventTest {

	Segment seg = new Segment();
	Plane p1 = new Plane(1, 1);
	Plane p2 = new Plane(1, 2);
	Plane p3 = new Plane(2, 0);
	Event e0 = new Event(seg, p3, EventType.END);
	Event e1 = new Event(seg, p1, EventType.END);
	Event e2 = new Event(seg, p1, EventType.PLANAR);
	Event e3 = new Event(seg, p1, EventType.START);
	Event e4 = new Event(seg, p2, EventType.END);
	
	@Test
	public void testInf() {
		Assert.assertTrue(e0.inf(e1));
		Assert.assertTrue(e1.inf(e2));
		Assert.assertTrue(e2.inf(e3));
		Assert.assertTrue(e3.inf(e4));
	}

}
