package tests;

import implementations.Delimitable;
import implementations.Plane;
import implementations.Point;
import implementations.Segment;
import interfaces.SegmentInterface;

import org.junit.Assert;
import org.junit.Test;

public class SegmentTest {

	@Test
	public void testSplit() {
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

}
