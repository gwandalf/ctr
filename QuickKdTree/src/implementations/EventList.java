package implementations;

import interfaces.EventInterface;
import interfaces.EventListInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Event list
 * @author gwendal
 *
 */
public class EventList implements EventListInterface {

	private List<Event> eventList;
	
	public EventList() {
		this.eventList = new ArrayList<Event>();
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
	public EventListInterface[] split() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventListInterface[] strictSplit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventListInterface merge(EventListInterface e) {
		// TODO Auto-generated method stub
		return null;
	}

}
