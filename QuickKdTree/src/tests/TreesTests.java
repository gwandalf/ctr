package tests;

import implementations.Point;
import implementations.QuickTree;
import implementations.Scene;
import implementations.Segment;
import implementations.SlowTree;

import org.junit.BeforeClass;
import org.junit.Test;

public class TreesTests {

	static Scene s1;
	static Scene s2;
	static Scene s3;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		s1 = makeScene(200, 100);
		s2 = makeScene(2000, 1000);
		s3 = makeScene(4000, 2000);
	}
	
	public static Scene makeScene(int nbSegments, int dim) {
		Scene res = new Scene(new Point(0, 0), new Point(dim, dim));
		for(int i = 0 ; i < nbSegments ; i++) {
			double x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			while(x1 == x2 && y1 == y2) {
				x1 = dim * Math.random();
				x2 = dim * Math.random();
				y1 = dim * Math.random();
				y2 = dim * Math.random();
			}
			Segment segment = new Segment(new Point(x1, y1), new Point(x2, y2), res);
			res.addSegment(segment);
		}
		return res;
	}
	
	@Test
	public void testSlowTreeS1() {
		SlowTree tree = new SlowTree(s1);
		tree.build();
	}
	
	@Test
	public void testQuickTreeS1() {
		QuickTree tree = new QuickTree(s1);
		tree.build();
	}
	
	@Test
	public void testSlowTreeS2() {
		SlowTree tree = new SlowTree(s2);
		tree.build();
	}
	
	@Test
	public void testQuickTreeS2() {
		QuickTree tree = new QuickTree(s2);
		tree.build();
	}

	@Test
	public void testSlowTreeS3() {
		SlowTree tree = new SlowTree(s3);
		tree.build();
	}
	
	@Test
	public void testQuickTreeS3() {
		QuickTree tree = new QuickTree(s3);
		tree.build();
	}
	
}
