package characters;

public class Gunner {
	/* This class is used to represent the current gun of use, mostly to make it easier to code the swapping of guns. It has a Sprite which can be
	 * used to swap in between different guns. The guns are TommyGun, TripleGun och BigTommy.*/
	
	public Sprite currentGun;
	
	public Gunner() {
		this.currentGun = new TommyGun(0, 0);
	}
	
	public void switchGun(Sprite powerup) {
		setCurrentGun(powerup);
	}

	public Sprite getCurrentGun() {
		return currentGun;
	}

	public void setCurrentGun(Sprite currentGun) {
		this.currentGun = currentGun;
	}
}