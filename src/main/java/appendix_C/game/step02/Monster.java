package appendix_C.game.step02;

public class Monster {
	private final int health;
	private final Breed breed;
	
	public Monster(Breed breed) {
		this.health = breed.getHealth();
        this.breed = breed;
	}
	
	public String getAttack() {
		return breed.getAttack();
	}
}
