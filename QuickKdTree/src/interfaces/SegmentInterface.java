package interfaces;

/**
 * Segment (equivalent of the 3D triangle).
 * @author gwlemoul
 *
 */
public interface SegmentInterface extends GeometricElement {

	/**
	 * Getter
	 * @return owner scene
	 */
	SceneInterface getScene();
	
	/**
	 * Setter
	 * @param scene
	 */
	void setScene(SceneInterface scene);
	
}
