package blockemon;

public class Driver{
	public static void main(String[] args) {
		World ex = new World();
		new Thread(ex).start();	    
	}
}