package tests;

import implementations.Affine;
import implementations.Point;

import org.junit.Assert;
import org.junit.Test;

public class AffineTest {

	Point p1 = new Point(1, 2);
	Point p2 = new Point(3, 4);
	Affine affine = new Affine(p1, p2);
	
	@Test
	public void testGetM() {
		double a = affine.getM();
		Assert.assertEquals(1.0, a, 0);
	}
	
	@Test
	public void testGetP() {
		double b = affine.getP();
		Assert.assertEquals(1.0, b, 0);
	}
	
	@Test
	public void testImage() {
		double a = affine.image(3);
		Assert.assertEquals(4, a, 0);
	}
	
	@Test
	public void testAntecedent() {
		double a = affine.antecedent(5);
		Assert.assertEquals(4, a, 0);
	}

	@Test
	public void testCrossX() {
		Point pa = new Point(0, 0);
		Point pb = new Point(5, 10);
		Affine a2 = new Affine(pa, pb);
		double a = affine.crossX(a2);
		Assert.assertEquals(1.0, a, 0);
	}
	
	@Test
	public void testCrossY() {
		Point pa = new Point(0, 0);
		Point pb = new Point(5, 10);
		Affine a2 = new Affine(pa, pb);
		double a = affine.crossX(a2);
		Assert.assertEquals(1.0, a, 0);
	}
	
}
