package tests;

import implementations.Point;
import implementations.QuickTree;
import implementations.Segment;

import org.junit.BeforeClass;
import org.junit.Test;

public class QuickTreeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		for(int i = 0 ; i < 50 ; i++) {
			double x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			while((x1 == x2 && y1 == y2) || x1 < -10 || x2 < -10 || y1 < -10 || y2 < -10 || x1 > 10 || x2 > 10 || y1 > 10 || y2 > 10) {
				x1 = 10 * (Math.random() - Math.random());
				x2 = 10 * (Math.random() - Math.random());
				y1 = 10 * (Math.random() - Math.random());
				y2 = 10 * (Math.random() - Math.random());
			}
			Segment segment = new Segment(new Point(x1, y1), new Point(x2, y2), SceneTest.scene);
			SceneTest.scene.addSegment(segment);
		}
	}
	
	@Test
	public void testConstructor() {
		QuickTree tree = new QuickTree(SceneTest.scene);
	}

}
