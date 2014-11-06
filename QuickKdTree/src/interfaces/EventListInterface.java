package interfaces;

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
	 * Splits the event list into two lists.
	 * @return two parts of the splitted list.
	 */
	EventListInterface[] split();
	
	/**
	 * Splits the event list into two lists with no co-occurences.
	 * @return
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
}
