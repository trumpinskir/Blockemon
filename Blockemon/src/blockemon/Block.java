package blockemon;

public abstract class Block {
	
	int dimX;
	int dimY;
	String color;
	
	Block(){
		this.dimX=1;
		this.dimY=1;
		this.color="Black";
	}
	Block(int dimX, int dimY, String color){
		this.dimX=dimX;
		this.dimY=dimY;
		this.color=color;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
