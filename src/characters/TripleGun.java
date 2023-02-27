package characters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;


public class TripleGun extends Sprite {

 /* this is a weapon. For more info check TommyGun */

	public TripleGun(int xc, int yc) {
		super(xc, yc);
		

		try {
			image = new Image(new FileInputStream("tommygun.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Image not found");
		}
		getDimensions();
		
	}

	public Image getImage() {
		return image;
	}

	public void getDimensions() {
		width = 20;
		height = 20;
	}

	@Override
	public void fire(Sprite gunner) {
		this.getGun().add(gunner);
	}
	
	public void delegate(int xa, int ya, Sprite gun1) {
		gun1.fire(gun1.clone(xa, ya));
		gun1.fire(gun1.clone(xa + 80, ya));
		gun1.fire(gun1.clone(xa - 80, ya));
	}
	

	public void update() {
		y -= 20;

		if (y <= 0) {
			visible = false;
		}
	}
	
	@Override
	public TripleGun clone(int x, int y) {
		return new TripleGun(x, y);
	}
}
