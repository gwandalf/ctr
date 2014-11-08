package implementations;

import interfaces.SegmentInterface;

import java.util.List;
import java.util.Set;

public abstract class ClassicNode extends Node {

	public ClassicNode(Point origin, Point end) {
		super(origin, end);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buildChildren() {
		this.plane = (Plane)this.findPlane();
		List<Set<SegmentInterface>> segmentsTab = this.split();
		Point p1, p2;
		if(this.plane.getDim() == 1) {
			p1 = new Point(this.plane.getValue(), this.end.getY());
			p2 = new Point(this.plane.getValue(), this.origin.getY());
		} else {
			p1 = new Point(this.end.getX(), this.plane.getValue());
			p2 = new Point(this.getOrigin().getX(), this.plane.getValue());
		}
		if((this.end.getX() - this.origin.getX()) * (this.end.getY() - this.origin.getY()) <= 50 || this.segments.size() <= 20)
			this.leftChild = new Leaf(this.origin, p1);
		else
			this.leftChild = this.makeClassicNode(this.origin, p1, segmentsTab.get(0));
		if((this.end.getX() - this.origin.getX()) * (this.end.getY() - this.origin.getY()) <= 50 || this.segments.size() <= 20)
			this.rightChild = new Leaf(p2, this.end);
		else
			this.rightChild = this.makeClassicNode(p2, this.end, segmentsTab.get(1));
		this.leftChild.buildChildren();
		this.rightChild.buildChildren();
	}
	
	public abstract ClassicNode makeClassicNode(Point p1, Point p2, Set<SegmentInterface> segments);
	
	public abstract List<Set<SegmentInterface>> split();

}
