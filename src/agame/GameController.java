package agame;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 3/31/16.
 */
public class GameController {

    public static Game getGameContainer(GameContainer g) {
        return g.getGame();
    }

    public static void main(String[] args) {
        Game gameContainer = getGameContainer(RedAlert.gameContainer);
        gameContainer.play();
        Game gameContainer1 = getGameContainer(AOE.AOEGame);
        gameContainer1.play();
    }
}
