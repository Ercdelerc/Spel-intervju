package states;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import stuff.MenuButton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * This state represents the menu of the Game. The main responsibility of this
 * class is to allow the user to swap states, exit the game and check the high score.
 */
public class MenuState extends GameState {

	private StageOne stageOne;
	private Image tommy;
	private MenuButton button;
	private HighScoreMenu HSmenu;

	public MenuState(GameModel model) {
		super(model);
		stageOne = new StageOne(model);
		HSmenu = new HighScoreMenu(model);
		setButton();
		MenuButton butt = button.clone(700, 150, "PRESS ENTER FOR NEW GAME", model);
		button.addButton(butt);
		butt = button.clone(700, 300, "PRESS H FOR HIGH SCORE", model);
		button.addButton(butt);
		butt = button.clone(700, 450, "PRESS ESC FOR EXIT GAME", model);
		button.addButton(butt);
		
		try {
			tommy = new Image(new FileInputStream("TommyC.jpg"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}
	}

	@Override
	public void draw(GraphicsContext g) {
		
		g.drawImage(tommy, 0, 0);
		for (MenuButton butt : button.getContents()) {
			g.setFont(new Font(20));
			butt.draw(g);
		g.setFont(new Font(30));
		}
	}

	@Override
	public void keyPressed(KeyEvent key) {
		
		if (key.getCode() == KeyCode.ENTER) {
			model.switchState(stageOne);
		} else if (key.getCode() == KeyCode.ESCAPE) {
			System.exit(0);
		} else if (key.getCode() == KeyCode.H) {
			model.switchState(HSmenu);
		}
	}

	@Override
	public void update() {
	}
	
	public void setButton() {
		this.button = new MenuButton(0, 0, "hej", model);
	}

}