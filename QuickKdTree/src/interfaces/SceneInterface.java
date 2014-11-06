package interfaces;

public interface SceneInterface extends Delimitable {

	void addSegment(SegmentInterface segment);
	SegmentInterface getSegment(int i);
	
}
