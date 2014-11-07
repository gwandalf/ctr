package tests;

import implementations.Delimitable;
import implementations.Event;
import implementations.EventList;
import implementations.Plane;
import implementations.Point;
import implementations.Segment;
import interfaces.EventInterface.EventType;
import interfaces.SegmentInterface;

import org.junit.Assert;
import org.junit.Test;

public class SegmentTest {

	Point p00 = new Point(0,0);
	Point p02 = new Point(0,2);
	Point p20 = new Point(2,0);
	Point p22 = new Point(2,2);
	Point p11 = new Point(1,1);
	Point p21 = new Point(2,1);
	Point p12 = new Point(1,2);
	Segment vert = new Segment(p20, p22, null);
	Segment hori = new Segment(p02, p22, null);
	Segment obli = new Segment(p00, p22, null);
	Plane west = new Plane(1, 0);
	Plane south = new Plane(2, 0);
	Plane east = new Plane(1, 2);
	Plane north = new Plane(2, 2);
	
	@Test
	public void testSplit() {
		Plane x1 = new Plane(1, 1);
		Plane y1 = new Plane(2, 1);
		SegmentInterface[] vertTab = vert.split(y1);
		SegmentInterface[] horiTab = hori.split(x1);
		SegmentInterface[] obliTab = obli.split(y1);
		Assert.assertEquals((Delimitable)new Segment(p20, p21, null), (Delimitable)vertTab[0]);
		Assert.assertEquals((Delimitable)new Segment(p21, p22, null), (Delimitable)vertTab[1]);
		Assert.assertEquals((Delimitable)new Segment(p02, p12, null), (Delimitable)horiTab[0]);
		Assert.assertEquals((Delimitable)new Segment(p12, p22, null), (Delimitable)horiTab[1]);
		Assert.assertEquals((Delimitable)new Segment(p00, p11, null), (Delimitable)obliTab[0]);
		Assert.assertEquals((Delimitable)new Segment(p11, p22, null), (Delimitable)obliTab[1]);
	}
	
	@Test
	public void testGenerateEvents() {
		EventList vertEvs = (EventList)vert.generateEvents();
		EventList horiEvs = (EventList)hori.generateEvents();
		EventList obliEvs = (EventList)obli.generateEvents();
		Assert.assertEquals(3, vertEvs.size());
		Assert.assertEquals(3, horiEvs.size());
		Assert.assertEquals(4, obliEvs.size());
		Assert.assertTrue(vertEvs.getEventList().contains(new Event(vert, south, EventType.START)));
		Assert.assertTrue(vertEvs.getEventList().contains(new Event(vert, north, EventType.END)));
		Assert.assertTrue(vertEvs.getEventList().contains(new Event(vert, east, EventType.PLANAR)));
		
		//horizontal segment
		Assert.assertTrue(horiEvs.getEventList().contains(new Event(hori, west, EventType.START)));
		Assert.assertTrue(horiEvs.getEventList().contains(new Event(hori, north, EventType.PLANAR)));
		Assert.assertTrue(horiEvs.getEventList().contains(new Event(hori, east, EventType.END)));
		
		//oblic segment
		Assert.assertTrue(obliEvs.getEventList().contains(new Event(obli, west, EventType.START)));
		Assert.assertTrue(obliEvs.getEventList().contains(new Event(obli, north, EventType.END)));
		Assert.assertTrue(obliEvs.getEventList().contains(new Event(obli, east, EventType.END)));
		Assert.assertTrue(obliEvs.getEventList().contains(new Event(obli, west, EventType.START)));
	}

}
