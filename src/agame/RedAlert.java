package agame;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 3/31/16.
 */
public class RedAlert implements Game {
    private RedAlert() {
    }

    @Override
    public void play() {
        System.out.println("RedAlert");
    }

    public static GameContainer gameContainer = new GameContainer() {
        @Override
        public Game getGame() {
            return new RedAlert();
        }
    };
}
