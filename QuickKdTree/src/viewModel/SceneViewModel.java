package viewModel;

import implementations.Point;
import implementations.Scene;
import implementations.Segment;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.HashSet;
import java.util.Set;

public class SceneViewModel {

	private Scene scene;
	private Set<Line2D> upSegments;
	private Rectangle upRectangle;
	private Set<Line2D> bottomSegments;
	private Rectangle bottomRectangle;
	
	public SceneViewModel(int nbSegments, int dimX, int dimY) {
		this.upSegments = new HashSet<Line2D>();
		this.bottomSegments = new HashSet<Line2D>();
		this.scene = new Scene(new Point(0, 0), new Point(dimX, dimY));
		this.upRectangle = new Rectangle((int)Transformations.xCoordinate(0, dimX),
				(int)Transformations.yCoordinate(dimY, dimY),
				(int)Transformations.xDimension(dimX, dimX),
				(int)Transformations.yDimension(dimY, dimY));
		this.bottomRectangle = new Rectangle((int)Transformations.xCoordinate(0, dimX),
				(int)Transformations.yCoordinate(dimY, dimY) + Transformations.OFFSET,
				(int)Transformations.xDimension(dimX, dimX),
				(int)Transformations.yDimension(dimY, dimY));
		System.out.println("Rectangle = " + bottomRectangle.getLocation().getX() + ',' + bottomRectangle.getLocation().getY() + ',' + bottomRectangle.getSize().getWidth() + ',' + bottomRectangle.getSize().getHeight());
		for(int i = 0 ; i < nbSegments ; i++) {
			double x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			while(x1 == x2 && y1 == y2) {
				x1 = dimX * Math.random();
				x2 = dimX * Math.random();
				y1 = dimY * Math.random();
				y2 = dimY * Math.random();
			}
			Segment segment = new Segment(new Point(x1, y1), new Point(x2, y2), this.scene);
			double x1t = Transformations.xCoordinate(x1, dimX);
			double x2t = Transformations.xCoordinate(x2, dimX);
			double y1t = Transformations.yCoordinate(y1, dimY);
			double y2t = Transformations.yCoordinate(y2, dimY);
			Line2D.Double upLine = new Line2D.Double(x1t, y1t, x2t, y2t);
			Line2D.Double bottomLine = new Line2D.Double(x1t, y1t + Transformations.OFFSET, x2t, y2t + Transformations.OFFSET);
			this.scene.addSegment(segment);
			this.upSegments.add(upLine);
			this.bottomSegments.add(bottomLine);
		}
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Set<Line2D> getUpSegments() {
		return upSegments;
	}

	public void setUpSegments(Set<Line2D> upSegments) {
		this.upSegments = upSegments;
	}

	public Rectangle getUpRectangle() {
		return upRectangle;
	}

	public void setUpRectangle(Rectangle upRectangle) {
		this.upRectangle = upRectangle;
	}

	public Set<Line2D> getBottomSegments() {
		return bottomSegments;
	}

	public void setBottomSegments(Set<Line2D> bottomSegments) {
		this.bottomSegments = bottomSegments;
	}

	public Rectangle getBottomRectangle() {
		return bottomRectangle;
	}

	public void setBottomRectangle(Rectangle bottomRectangle) {
		this.bottomRectangle = bottomRectangle;
	}
	
}
