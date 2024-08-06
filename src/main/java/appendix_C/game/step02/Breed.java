package appendix_C.game.step02;

public class Breed {
	private final String name;
	private final int health;
	private final String attack;

	public Breed(String name, int health, String attack) {
		this.name = name;
		this.health = health;
		this.attack = attack;
	}

	public int getHealth() {
		return health;
	}

	public String getAttack() {
		return attack;
	}
}
