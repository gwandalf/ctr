package implementations;

import interfaces.EventInterface;
import interfaces.EventInterface.EventType;
import interfaces.EventListInterface;
import interfaces.NodeInterface;
import interfaces.PlaneInterface.Side;
import interfaces.SegmentInterface;
import interfaces.SegmentInterface.StrictSide;

import java.util.ArrayList;
import java.util.List;

/**
 * Event list
 * @author gwendal
 *
 */
public class EventList implements EventListInterface {

	private List<EventInterface> eventList;
	
	/**
	 * Constructor
	 */
	public EventList() {
		this.eventList = new ArrayList<EventInterface>();
	}
	
	@Override
	public void add(EventInterface e) {
		this.eventList.add((Event)e);
	}

	@Override
	public EventInterface get(int i) {
		return this.eventList.get(i);
	}

	@Override
	public EventListInterface[] strictSplit() {
		EventList leftOnly = new EventList();
		EventList rightOnly = new EventList();
		EventListInterface[] res = new EventListInterface[2];
		res[0] = leftOnly;
		res[1] = rightOnly;
		for(EventInterface e : this.eventList) {
			if(e.getSegment().getSide() == StrictSide.LEFTONLY)
				leftOnly.add(e);
			if(e.getSegment().getSide() == StrictSide.RIGHTONLY)
				rightOnly.add(e);
		}
		return res;
	}

	@Override
	public EventListInterface merge(EventListInterface e) {
		EventList res = new EventList();
		Event e1;
		Event e2;
		int i = 0;
		int j = 0;
		while(i < this.size() && j < e.size()) {
			e1 = (Event)this.eventList.get(i);
			e2 = (Event)e.get(j);
			if(e1.inf(e2) || e1.equals(e2)) {
				res.add(e1);
				i++;
			}
			if(e2.inf(e1)) {
				res.add(e2);
				j++;
			}	
		}
		while(i < this.size()) {
			e1 = (Event)this.eventList.get(i);
			res.add(e1);
			i++;
		}
		while(j < e.size()) {
			e2 = (Event)e.get(j);
			res.add(e2);
			j++;
		}
		return res;
	}

	@Override
	public void sort() {
		if (this.eventList ==null || this.eventList.size()==0){
		      return;
		    }
		    quicksort(0, this.eventList.size() - 1);
	}
	
	  private void quicksort(int low, int high) {
		    int i = low, j = high;
		    // Get the pivot element from the middle of the list
		    Event pivot = (Event)this.eventList.get(low + (high-low)/2);

		    // Divide into two lists
		    while (i <= j) {
		      // If the current value from the left list is smaller then the pivot
		      // element then get the next element from the left list
		      while (this.eventList.get(i).inf(pivot)) {
		        i++;
		      }
		      // If the current value from the right list is larger then the pivot
		      // element then get the next element from the right list
		      while (pivot.inf(this.eventList.get(j))) {
		        j--;
		      }

		      // If we have found a values in the left list which is larger then
		      // the pivot element and if we have found a value in the right list
		      // which is smaller then the pivot element then we exchange the
		      // values.
		      // As we are done we can increase i and j
		      if (i <= j) {
		        exchange(i, j);
		        i++;
		        j--;
		      }
		    }
		    // Recursion
		    if (low < j)
		      quicksort(low, j);
		    if (i < high)
		      quicksort(i, high);
		  }

		  private void exchange(int i, int j) {
		    Event temp = (Event)this.eventList.get(i);
		    this.eventList.set(i, this.eventList.get(j));
		    this.eventList.set(j, temp);
		  }

	@Override
	public int size() {
		return this.eventList.size();
	}

	@Override
	public List<EventInterface> getEventList() {
		return eventList;
	}

}
