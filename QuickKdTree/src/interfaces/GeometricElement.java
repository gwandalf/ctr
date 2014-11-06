package interfaces;

public interface GeometricElement extends Delimitable {
	
	int getInnerCost();
	void setInnerCost(int innerCost);
	boolean isNextCrossed(RayInterface ray);

}
