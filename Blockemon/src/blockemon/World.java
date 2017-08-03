package blockemon;

public class World extends Block {
	String color = "5C872D";
	int dimX;
	int dimY;
	
	World(int dimX, int dimY){
		this.dimX = dimX;
		this.dimY = dimY;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDimX() {
		return dimX;
	}

	public void setDimX(int dimX) {
		this.dimX = dimX;
	}

	public int getDimY() {
		return dimY;
	}

	public void setDimY(int dimY) {
		this.dimY = dimY;
	}
	
	
	
}