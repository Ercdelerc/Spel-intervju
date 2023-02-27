package states;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import characters.BigTommy;
import characters.Enemy;
import characters.Gunner;
import characters.Player;
import characters.Sprite;

import characters.TripleGun;
import highScore.Score;

/* this class is the stage after game one and extends the gamestate. 
 * It's supposed to be the ultimate display of skill
 * and if you complete it your score will be added to the highscore. 
 * */
public class StageTwo extends GameState {

	private Enemy enemy;
	private int y = 0;
	private ArrayList<Enemy> enemies;
	private Color bgColor;
	private Player player;
	private Gunner gun;
	private GameOver GO;
	private Score score;

	public StageTwo(GameModel model) {
		super(model);
		GO = new GameOver(model);
		bgColor = Color.BLACK;
		this.gun = new Gunner();

		player = new Player(900, 900);
		enemies = new ArrayList<>();
		for (int i = 0; i <= 1800; i += 200) {
			enemy = new Enemy(i, y);
			enemy.getDimensions();
			enemies.add(enemy);
			if (i == 1800) {
				i = -100;
				y = 100;
			}
		}
	}

	@Override
	public void draw(GraphicsContext context) {
		context.setFill(bgColor);
		context.fillRect(0, 0, 1920, 1080);
		score.compareScores();
		score.drawScore(context);
		score.drawHighScore(context);
		if (player.isVisible()) {
			player.delegate(context);
		}
		if (context != null) {
			for (Enemy enemylist : enemies) {
				if (enemylist.isVisible()) {
					enemylist.draw(context);
				}
			}
		}

		if (gun.getCurrentGun().getGun() != null) {
			for (Sprite tommy : gun.getCurrentGun().getGun()) {
				tommy.draw(context);
			}
		}

		if (gun.getCurrentGun().getGun() != null) {
			for (Enemy enemylist : enemies) {
				if (enemylist.isVisible()) {
					for (Sprite tommy : gun.getCurrentGun().getGun()) {
						tommy.collide(enemylist.getX(), (int) enemylist.getWidth(), enemylist.getY(),
								(int) enemylist.getHeight());
						enemylist.collide(tommy.getX(), (int) tommy.getWidth(), tommy.getY(), (int) tommy.getHeight());
						if (enemylist.bolCollide(tommy.getX(), (int) tommy.getWidth(), tommy.getY(),
								(int) tommy.getHeight())) {
							score.addScore();
						}
					}
				}
			}

			for (Enemy enemy : enemies) {
				if (enemy.isVisible()) {
					player.collide(enemy.getX(), (int) enemy.getWidth(), enemy.getY(), (int) enemy.getHeight());
					for (Sprite gun : enemy.gun().getGun()) {
						player.collide(gun.getX(), (int) gun.getWidth(), gun.getY(), (int) gun.getHeight());
					}
				}
			}

			if (!player.isVisible()) {
				model.switchState(GO);
			}

			if (clear()) {
				model.switchState(GO);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent key) {
		player.move(key);
		if (key.getCode() == KeyCode.SPACE) {
			gun.getCurrentGun().delegate(player.getX(), player.getY(), gun.getCurrentGun());
		} else if (key.getCode() == KeyCode.P) {
			this.gun.switchGun(new TripleGun(player.getX(), player.getY()));
		} else if (key.getCode() == KeyCode.M) {
			this.gun.switchGun(new BigTommy(player.getX(), player.getY()));
		} else if (key.getCode() == KeyCode.ESCAPE) {
			model.switchState(new MenuState(model));
		}
	}

	@Override
	public void update() {

		if (gun.getCurrentGun().getClass() == BigTommy.class) {
			for (Sprite tommy : gun.getCurrentGun().getGun()) {
				tommy.update();
				tommy.update();
			}
		}

		if (gun != null) {
			for (Sprite tommy : gun.getCurrentGun().getGun()) {
				tommy.update();
			}

			for (Enemy enemylist : enemies) {
				if (enemylist.isVisible()) {
					enemylist.update();
				}
			}
		}
	}

	public boolean clear() {
		for (Enemy enemy : enemies) {
			if (enemy.isVisible() == true) {
				return false;
			}
		}
		return true;
	}

	public void getScore(Score score1) {
		this.score = score1;
	}
}
