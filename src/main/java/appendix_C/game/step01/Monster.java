package appendix_C.game.step01;

public abstract class Monster {
	private final int health;
	
	public Monster(int health) {
		this.health = health;
	}
	
	abstract public String getAttack();
}
