package blockemon;

public class Blockemon extends Block{
	
	private int HP;
	private int MaxHP;
	private int numAttacks;
	private int Level;
	static int MAX_LEVEL=100;
	
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public int getMaxHP() {
		return MaxHP;
	}
	public void setMaxHP(int maxHP) {
		MaxHP = maxHP;
	}
	public int getNumAttacks() {
		return numAttacks;
	}
	public void setNumAttacks(int numAttacks) {
		this.numAttacks = numAttacks;
	}
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		if (level<1){
			this.Level=1;
		}
		if(level>=MAX_LEVEL){
			this.Level=MAX_LEVEL;
		}
		else{
			Level = level;
		}
	}
	
	/**
	 * Used to Level up a Blockemon
	 * Pass in the amount of level to increase by
	 * 
	 * @param Up
	 */
	public void levelUp(int Up){
		if (this.Level>=MAX_LEVEL){
			this.Level=MAX_LEVEL;
		}
		else{
			this.Level+=Up;
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
			this.HP=this.MaxHP; 
		}
		else if(this.HP+Adjust<0){
			this.HP=0;
		}
		else{
			this.HP+=Adjust;
		}
	}
}
