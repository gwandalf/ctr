package implementations;

import interfaces.AffineInterface;

/**
 * Affine function.
 * @author gwendal
 *
 */
public class Affine implements AffineInterface {

	private double m;
	private double p;
	
	/**
	 * Constructor
	 * @param p1 point 1
	 * @param p2 point 2
	 */
	public Affine(Point p1, Point p2) {
		if(p2.getX() != p1.getX())
			this.m = (p2.getY() - p1.getY())/(p2.getX() - p1.getX());
		this.p = p1.getY() - this.m * p1.getX();
	}
	
	@Override
	public double image(double x) {
		return this.m * x + this.p;
	}

	@Override
	public double antecedent(double y) {
		if(this.m != 0)
			return (y - this.p)/this.m;
		else
			return Double.MAX_VALUE;
	}

	@Override
	public double crossX(AffineInterface a) {
		if(this.m != a.getM())
			return (a.getP() - this.p)/(this.m - a.getM());
		else
			return Double.MAX_VALUE;
	}

	@Override
	public double crossY(AffineInterface a) {
		if(this.m != a.getM())
			return this.image(this.crossX(a));
		else
			return Double.MAX_VALUE;
	}

	@Override
	public double getM() {
		return this.m;
	}

	@Override
	public double getP() {
		return this.p;
	}

}
