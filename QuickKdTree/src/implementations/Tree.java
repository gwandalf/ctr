package implementations;

import interfaces.NodeInterface;
import interfaces.TreeInterface;

/**
 * Kd-Tree
 * @author gwendal
 *
 */
public abstract class Tree implements TreeInterface {

	protected Node root;
	
	@Override
	public NodeInterface getRoot() {
		return this.root;
	}

	@Override
	public void setRoot(NodeInterface root) {
		this.root = (Node)root;
	}

}
