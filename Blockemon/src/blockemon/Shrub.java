package blockemon;
public class Shrub extends Block{
	String color = "76a912"; // plant color
	int dimX;
	int dimY;
	int defaultSize =5;
	
	Shrub(){
		this.dimX = defaultSize;
		this.dimY = defaultSize;
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

	public int getDefaultSize() {
		return defaultSize;
	}

	public void setDefaultSize(int defaultSize) {
		this.defaultSize = defaultSize;
	}
	
	
	
}