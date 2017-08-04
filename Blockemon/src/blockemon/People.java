package blockemon;

public abstract class People extends Block{
	private int numBalls;
	private int numBlockemon;
	public int xCoordinate;
	public int yCoordinate;
	private String name;

	static int MAX_BALLS;
	static int MAX_BLOCKEMON;
	
	
	People(){
		this.numBalls=0;
		this.numBlockemon=0;
		this.xCoordinate=0;
		this.yCoordinate=0;
		this.name="";
	}
	
	People(int numBalls, int numBlockemon, int xCoordinate, int yCoordinate,String name){
		this.numBalls=numBalls;
		this.numBlockemon=numBlockemon;
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
		this.name=name;
	}
	
	public int getNumBlockemon() {
		return numBlockemon;
	}
	public void setNumBlockemon(int numBlockemon) {
		if (numBlockemon <0){
			this.numBlockemon=0;
		}
		else if (numBlockemon >=MAX_BLOCKEMON){
			this.numBlockemon=MAX_BLOCKEMON;
		}
		else{
			this.numBlockemon = numBlockemon;
		}
	}
	public int getNumBalls() {
		return numBalls;
	}
	public void setNumBalls(int numBalls) {

		if (numBalls<0){
			numBalls=0;
		}
		else if (numBalls>=MAX_BALLS){
			this.numBalls=MAX_BALLS;
		}
		else{
			this.numBalls = numBalls;
		}
	}
	public int getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public int getyCoordinate() {
		return this.yCoordinate;
	}
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
