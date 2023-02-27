package stuff;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import states.GameModel;

/* this class is used for creating the menu buttons that are displayed in the menu.*/

public class MenuButton extends Canvas {

	private int x;
	private int y;
	private String text;
	private ArrayList<MenuButton> buttons;

	public MenuButton(int xs, int ys, String texten, GameModel model) {
		buttons = new ArrayList<>();

		this.x = xs;
		this.y = ys;
		this.text = texten;

		
		

	}

	public void draw(GraphicsContext context) {
		context.setFill(Color.BLACK);
		context.fillRect(x, y, 500, 100);
		context.setFill(Color.WHITE);
		context.fillText(text, x + 20, y + 20);
	}

	

	public void addButton(MenuButton butt) {
		buttons.add(butt);
	}

	public String getText() {
		return text;
	}

	public MenuButton clone(int x, int y, String s, GameModel model) {
		return new MenuButton(x, y, s, model);
	}

	public ArrayList<MenuButton> getContents() {
		return buttons;
	}
}
