package blockemon;

public class Blockemon extends Block{
	
	private int HP;
	private int maxHP;
	private int numAttacks;
	private int level;
	static int MAX_LEVEL=100;
	
	
	Blockemon(){
		this.HP=10;
		this.maxHP=10;
		this.numAttacks=1;
		this.level=1;	
	}
	Blockemon(int HP, int maxHP, int numAttacks, int level){
		this.HP=HP;
		this.maxHP=maxHP;
		this.numAttacks=numAttacks;
		this.level=level;
	}
	
	
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int getNumAttacks() {
		return numAttacks;
	}
	public void setNumAttacks(int numAttacks) {
		this.numAttacks = numAttacks;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if (level<1){
			this.level=1;
		}
		if(level>=MAX_LEVEL){
			this.level=MAX_LEVEL;
		}
		else{
			this.level = level;
		}
	}
	
	/**
	 * Used to Level up a Blockemon
	 * Pass in the amount of level to increase by
	 * 
	 * @param Up
	 */
	public void levelUp(int Up){
		if (this.level>=MAX_LEVEL){
			this.level=MAX_LEVEL;
		}
		else{
			this.level+=Up;
		}
	}
	
	/**
	 * Adjust the HP up or down from attacks or potions
	 * Pass in a negative number to reduce HP
	 * Pass a positive number to increase HP
	 * 
	 * @param Adjust
	 */
	public void AdjustHP(int Adjust){
		if (this.HP+Adjust>this.getMaxHP()){
			this.HP=this.maxHP; 
		}
		else if(this.HP+Adjust<0){
			this.HP=0;
		}
		else{
			this.HP+=Adjust;
		}
	}
}
