package implementations;

import interfaces.EventInterface;
import interfaces.PlaneInterface;
import interfaces.EventInterface.EventType;
import interfaces.EventListInterface;
import interfaces.PlaneInterface.Side;
import interfaces.SegmentInterface;
import interfaces.SegmentInterface.StrictSide;

/**
 * Node buit with the O(NlogN) algorithm.
 * @author gwendal
 *
 */
public class QuickNode extends Node {

	private EventList events;
	
	public QuickNode(Point origin, Point end, EventList events) {
		super(origin, end);
		this.events = events;
		for(int i = 0 ; i < this.events.size() ; i++)
			this.segments.add((Segment)this.events.get(i).getSegment());
	}

	@Override
	public void buildChildren() {
		this.plane = (Plane)this.findPlane();
		EventListInterface[] eventsTab = this.split();
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
			this.leftChild = new QuickNode(this.origin, p1, (EventList)eventsTab[0]);
		if((this.end.getX() - this.origin.getX()) * (this.end.getY() - this.origin.getY()) <= 50 || this.segments.size() <= 20)
			this.rightChild = new Leaf(p2, this.end);
		else
			this.rightChild = new QuickNode(p2, this.end, (EventList)eventsTab[1]);
		this.leftChild.buildChildren();
		this.rightChild.buildChildren();
	}
	
	/**
	 * Split the event list of the current node.
	 * @return
	 */
	public EventListInterface[] split() {
		EventListInterface[] res = new EventListInterface[2];
		this.classifyLeftRightBoth();
		EventListInterface[] stricts = this.events.strictSplit();
		EventListInterface[] boths = this.clipSegments();
		boths[0].sort();
		boths[1].sort();
		res[0] = stricts[0].merge(boths[0]);
		res[1] = stricts[1].merge(boths[1]);
		return res;
	}
	
	@Override
	public void classifyLeftRightBoth() {
		for(SegmentInterface seg : this.segments)
			seg.setSide(StrictSide.BOTH);
		for(EventInterface e : this.events.getEventList()) {
			if(e.getType() == EventType.END &&
					e.getPlane().getDim() == this.getPlane().getDim() &&
					e.getPlane().getValue() <= this.getPlane().getValue())
				e.getSegment().setSide(StrictSide.LEFTONLY);
			else if(e.getType() == EventType.START &&
					e.getPlane().getDim() == this.getPlane().getDim() &&
					e.getPlane().getValue() >= this.getPlane().getValue())
				e.getSegment().setSide(StrictSide.RIGHTONLY);
			else if(e.getType() == EventType.PLANAR &&
					e.getPlane().getDim() == this.getPlane().getDim()) {
				if(e.getPlane().getValue() < this.getPlane().getValue() ||
						(e.getPlane().getValue() == this.getPlane().getValue() &&
						this.getPlane().getSide() == Side.LEFT))
					e.getSegment().setSide(StrictSide.LEFTONLY);
				if(e.getPlane().getValue() > this.getPlane().getValue() ||
						(e.getPlane().getValue() == this.getPlane().getValue() &&
						this.getPlane().getSide() == Side.RIGHT))
					e.getSegment().setSide(StrictSide.RIGHTONLY);
			}
		}
	}
	
	public EventListInterface[] clipSegments() {
		EventListInterface[] res = new EventListInterface[2];
		res[0] = new EventList();
		res[1] = new EventList();
		for(SegmentInterface seg : this.segments) {
			if(seg.getSide() == StrictSide.BOTH) {
				SegmentInterface[] segments = seg.split(this.plane);
				EventList leftEvt = (EventList)segments[0].generateEvents();
				EventList rightEvt = (EventList)segments[1].generateEvents();
				res[0].getEventList().addAll(leftEvt.getEventList());
				res[1].getEventList().addAll(rightEvt.getEventList());
			}
		}
		return res;
	}
	
	@Override
	public PlaneInterface findPlane() {
		PlaneInterface res = null;
		double cost = Double.MAX_VALUE;
		int[] nbLeft = new int[2];
		int[] nbPlanar = new int[2];
		int[] nbRight = new int[2];
		for(int i = 0 ; i < 2 ; i++) {
			nbLeft[i] = 0;
			nbPlanar[i] = 0;
			nbRight[i] = this.getSegments().size();
		}
		int i = 0;
		int size = this.events.size();
		while(i < size) {
			int nbStart = 0;
			int nbEnd = 0;
			int nbCop = 0;
			Event evt = (Event)this.events.get(i);
			Plane p = (Plane)evt.getPlane();
			Plane current = p;
			while(i < size &&
					p.getDim() == current.getDim() &&
					p.getValue() == current.getValue() &&
					evt.getType() == EventType.END) {
				nbEnd++;
				i++;
				if(i < size) {
					evt = (Event)this.events.get(i);
					current = (Plane)evt.getPlane();
				}
			}
			while(i < size &&
					p.getDim() == current.getDim() &&
					p.getValue() == current.getValue() &&
					evt.getType() == EventType.PLANAR) {
				nbCop++;
				i++;
				if(i < size) {
					evt = (Event)this.events.get(i);
					current = (Plane)evt.getPlane();
				}
			}
			while(i < size &&
					p.getDim() == current.getDim() &&
					p.getValue() == current.getValue() &&
					evt.getType() == EventType.START) {
				nbStart++;
				i++;
				if(i < size) {
					evt = (Event)this.events.get(i);
					current = (Plane)evt.getPlane();
				}
			}
			nbPlanar[p.getDim()-1] = nbCop;
			nbRight[p.getDim()-1] -= (nbCop + nbEnd);
			double newCost = this.sah(p, nbLeft[p.getDim()-1], nbRight[p.getDim()-1]);
			if(newCost < cost) {
				cost = newCost;
				res = p;
			}
			nbLeft[p.getDim()-1] += nbStart + nbCop;
			nbPlanar[p.getDim()-1] = 0;
		}
		return res;
	}

}
