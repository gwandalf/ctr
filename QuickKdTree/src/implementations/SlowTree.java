package implementations;


/**
 * Kd-Tree built by SAH heuristic, but in O(N^2)
 * @author gwendal
 *
 */
public class SlowTree extends Tree {

	public SlowTree(Scene scene) {
		this.root = new SlowNode(scene.origin, scene.end, scene.getSegments());
	}
	
}
