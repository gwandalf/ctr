package interfaces;

import java.util.Collection;

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
	 * Splits the event list into two lists.
	 * @param node Node giving the splitting plane and segments to classify.
	 * @return two parts of the splitted list.
	 */
	EventListInterface[] split(NodeInterface node);
	
	/**
	 * Classifies the segment in the node according to the splitting plane.
	 * @param node
	 */
	void classifyLeftRightBoth(NodeInterface node);
	
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
	 * Clips all the segments marked as BOTH and generates the resulting events.
	 * @return two parts of the splitted list.
	 */
	EventListInterface[] clipSegments();
	
	/**
	 * Getter
	 * @return event list
	 */
	@SuppressWarnings("rawtypes")
	Collection getEventList();
}
