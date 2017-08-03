package blockemon;

public class People extends Block{
	private int numBalls;
	private int numBlockemon;
	static int MAX_BALLS;
	static int MAX_BLOCKEMON;
	
	People(){
		this.numBalls=0;
		this.numBlockemon=0;
	}
	
	People(int numBalls, int numBlockemon){
		this.numBalls=numBalls;
		this.numBlockemon=numBlockemon;
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
}
