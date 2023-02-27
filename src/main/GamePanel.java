package main;

import states.GameModel;

import javafx.scene.canvas.Canvas;

/*
 * The GamePanel wraps a Canvas. The responsibilities of this class is to make sure the game has a GraphicsContext to draw everything needed.
 * It also controls the size of the playing area.
 */
public class GamePanel extends Canvas {

	private GameModel model;

    public GamePanel(final GameModel model, int width, int height) {
        this.model = model;
        this.setWidth(width);
        this.setHeight(height);
    }

    public void repaint() {
    	model.draw(getGraphicsContext2D());
    }
}