package interfaces;

/**
 * Kd-Tree
 * @author gwlemoul
 *
 */
public interface TreeInterface {

	/**
	 * Launches the actual tree building.
	 */
	void build();
	
	/**
	 * Getter
	 * @return root
	 */
	NodeInterface getRoot();
	
	/**
	 * Setter
	 * @param root
	 */
	void setRoot(NodeInterface root);
	
}
