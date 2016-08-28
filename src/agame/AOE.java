package agame;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 3/31/16.
 */
public class AOE implements Game {

    private AOE() {
    }

    @Override
    public void play() {
        System.out.println("AOE");
    }

    public static GameContainer AOEGame = new GameContainer() {

        @Override
        public Game getGame() {
            return new AOE();
        }
    };
}
