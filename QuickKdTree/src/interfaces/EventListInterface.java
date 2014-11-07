package interfaces;

import java.util.List;

/**
 * Event list.
 * @author gwendal
 *
 */
public interface EventListInterface {

	/**
	 * Adds the given event.
	 * @param e
	 */
	void add(EventInterface e);
	
	/**
	 * Getter
	 * @param i index of the event.
	 * @return event at index i.
	 */
	EventInterface get(int i);
	
	/**
	 * Size
	 * @return list size
	 */
	int size();
	
	/**
	 * Splits the event list into two lists with no co-occurences.
	 * @return two parts of the splitted list.
	 */
	EventListInterface[] strictSplit();
	
	/**
	 * Merges two lists into another one.
	 * @param e list to merge with the current one.
	 * @return merged list.
	 */
	EventListInterface merge(EventListInterface e);
	
	/**
	 * Sorts the list.
	 */
	void sort();
	
	/**
	 * Getter
	 * @return event list
	 */
	List<EventInterface> getEventList();
}
