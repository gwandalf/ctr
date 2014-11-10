package viewModel;

public class Transformations {

	public static final double XORIGIN = 20;
	public static final double XEND = 900;
	public static final double YORIGIN = 250;
	public static final double YEND = 20;
	public static final int OFFSET = 300;
	
	public static double xCoordinate(double x, double maxX) {
		return x*(XEND-XORIGIN)/maxX + XORIGIN;
	}
	
	public static double yCoordinate(double y, double maxY) {
		return y*(YEND-YORIGIN)/maxY + YORIGIN;
	}
	
	public static double xDimension(double xDim, double maxX) {
		return xDim*(XEND-XORIGIN)/maxX;
	}
	
	public static double yDimension(double yDim, double maxY) {
		return yDim*(YORIGIN - YEND)/maxY;
	}
	
}
