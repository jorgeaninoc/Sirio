/*
 Authors: Team Orion
*/
/*
This class represent the Factory which implements the Design-Pattern called Singleton.
This class is used to instantiate the GameStates which the player can go through.
 */
public class Factory {
    /*
    The next line declare an instance of Factory.
     */
    private static Factory instance;

    private Factory() {
        /*
        Default constructor does nothing.
         */
    }

    public static Factory getInstance() {
        /*
        This method checks if the instance of Factory is null, if it is null it creates a new instance.
        This method returns the instance of Factory.
         */
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public GameState createState(String state) {
        /*
        This method creates the GameState depending on the String state received.
         */
        if (state.equalsIgnoreCase("level1"))
            return new Level1();
        if (state.equalsIgnoreCase("level2"))
            return new Level2();
        if (state.equalsIgnoreCase("gameover"))
            return new GameOver();
        if (state.equalsIgnoreCase("pause"))
            return new Pause();
        if (state.equalsIgnoreCase("menu"))
            return new Menu();
        if (state.equalsIgnoreCase("settings"))
            return new Settings();
        if (state.equalsIgnoreCase("highscores"))
            return new HighScore();
        if (state.equalsIgnoreCase("instructions"))
            return new Instructions();

        return null;

    }
}
