package characters;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/* this class is used by every object that is drawn on the screen. It has some methods to interact with other objects as well as methods that
 * draw itself and keeps track of everything needed to keep track of. 
 */
public abstract class Sprite {

	protected Image image;
	protected int x;
	protected int y;
	protected double width;
	protected double height;
	protected boolean visible = true;
	private ArrayList<Sprite> tommy;

	public Sprite(int xc, int yc) {
		this.x = xc;
		this.y = yc;
		tommy = new ArrayList<>();
	}

	public void getDimensions() {
		width = image.getWidth();
		height = image.getHeight();
	}

	public int getX() {
		return x;
	}
	
	public void fire(Sprite gunner) {
		tommy.add(gunner);
	}
	
	public abstract Sprite clone(int x, int y);

	public ArrayList<Sprite> getGun() {
		return tommy;
	}
	
	public abstract void delegate(int xa, int ya, Sprite gun1);
	
	public void draw(GraphicsContext context) {
		context.drawImage(image, x, y);
	}
	
	public void collide(int x1, int width1, int y1, int height1) {
		if ((x1 - width1 / 2) < (x + width / 2) && (x1 + width1 / 2) > (x - width / 2)
				&& (y1 - height1 / 2) < (y + height / 2) && (y1 + height1 / 2) > (y - height / 2)) {
			visible = false;
		}
	}

	public boolean bolCollide(int x1, int width1, int y1, int height1) {
		if ((x1 - width1 / 2) < (x + width / 2) && (x1 + width1 / 2) > (x - width / 2) && (y1 - height1 / 2) < (y + height / 2) && (y1 + height1 / 2) > (y - height / 2)) {
			return true;
		} else {
			return false;
		}
	}

	public int getY() {
		return y;
	}
	
	public abstract void update();
	

	

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public void death() {
		visible = false;
	}

	public boolean isVisible() {
		return visible;
	}
	
	
}