/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries.
 */
import javax.swing.ImageIcon;
import java.awt.Image;
/*
This class represent the ImageLoader which implements the Design-Pattern called Singleton.
This class is used to load the images used in the game.
 */
public class ImageLoader {
    /*
    Declare all the images that are going to be used.
     */
    private ImageIcon bullet;
    private ImageIcon background;
    private ImageIcon enemy;
    private ImageIcon gameover;
    private ImageIcon meteor;
    private ImageIcon spaceman;
    private ImageIcon pause;
    private ImageIcon topplayer;
    private ImageIcon end;
    private ImageIcon settings;
    private ImageIcon play;
    private ImageIcon header;
    private ImageIcon playagain;
    private ImageIcon back;
    private ImageIcon volume;
    private ImageIcon up;
    private ImageIcon down;
    private ImageIcon difficulty;
    private ImageIcon instructions;
    private ImageIcon mute;
    private ImageIcon mutedF;
    private ImageIcon mutedT;
    private ImageIcon scroll;
    private ImageIcon menu;
    private ImageIcon planet;
    private ImageIcon exit;
    private ImageIcon destroyed;

    public static ImageLoader instance;

    private ImageLoader(){
        /*
        Instantiate/loads all the images from the images folder.
         */
        scroll = new ImageIcon(getClass().getResource("media/images/fondo_2.png"));
        bullet = new ImageIcon(getClass().getResource("media/images/bullet.png"));
        enemy  = new ImageIcon(getClass().getResource("media/images/enemy.png"));
        background = new ImageIcon(getClass().getResource("media/images/fondo.png"));
        gameover = new ImageIcon(getClass().getResource("media/images/gameover.png"));
        meteor = new ImageIcon(getClass().getResource("media/images/meteor.png"));
        spaceman = new ImageIcon(getClass().getResource("media/images/monito.png"));
        pause = new ImageIcon(getClass().getResource("media/images/pause.png"));
        settings = new ImageIcon(getClass().getResource("media/images/settings.png"));
        end = new ImageIcon(getClass().getResource("media/images/end.png"));
        play = new ImageIcon(getClass().getResource("media/images/play.png"));
        header = new ImageIcon(getClass().getResource("media/images/header.png"));
        topplayer = new ImageIcon(getClass().getResource("media/images/topPlayer.png"));
        playagain = new ImageIcon(getClass().getResource("media/images/playAgain.png"));
        back = new ImageIcon(getClass().getResource("media/images/back.png"));
        volume = new ImageIcon(getClass().getResource("media/images/volume.png"));
        up = new ImageIcon(getClass().getResource("media/images/up.png"));
        down = new ImageIcon(getClass().getResource("media/images/down.png"));
        mute = new ImageIcon(getClass().getResource("media/images/mute.png"));
        mutedT = new ImageIcon(getClass().getResource("media/images/mute-true.png"));
        mutedF = new ImageIcon(getClass().getResource("media/images/mute-false.png"));
        difficulty = new ImageIcon(getClass().getResource("media/images/difficulty.png"));
        instructions = new ImageIcon(getClass().getResource("media/images/instructions.png"));
        menu = new ImageIcon(getClass().getResource("media/images/menu.png"));
        planet = new ImageIcon(getClass().getResource("media/images/planeta.png"));
        exit= new ImageIcon(getClass().getResource("media/images/exit.png"));
        destroyed = new ImageIcon(getClass().getResource("media/images/destroyed.png"));
    }

    public static ImageLoader getInstance(){
        /*
        This method checks if the instance of ImageLoader is null, if it is null it creates a new instance.
        This method returns the instance of ImageLoader.
         */
        if(instance == null){
            instance = new ImageLoader();
        }
        return instance;
    }

    public Image getImage(String key) {
        /*
        This method returns an Image depending on the String key received.
         */
        if (key.equalsIgnoreCase("bullet"))
            return bullet.getImage();
        if (key.equalsIgnoreCase("enemy"))
            return enemy.getImage();
        if (key.equalsIgnoreCase("background"))
            return background.getImage();
        if (key.equalsIgnoreCase("gameover"))
            return gameover.getImage();
        if (key.equalsIgnoreCase("meteor"))
            return meteor.getImage();
        if (key.equalsIgnoreCase("spaceman"))
            return spaceman.getImage();
        if (key.equalsIgnoreCase("pause"))
            return pause.getImage();
        if (key.equalsIgnoreCase("highscores"))
            return topplayer.getImage();
        if (key.equalsIgnoreCase("end"))
            return end.getImage();
        if (key.equalsIgnoreCase("settings"))
            return settings.getImage();
        if (key.equalsIgnoreCase("play"))
            return play.getImage();
        if (key.equalsIgnoreCase("header"))
            return header.getImage();
        if (key.equalsIgnoreCase("playagain"))
            return playagain.getImage();
        if (key.equalsIgnoreCase("back"))
            return back.getImage();
        if (key.equalsIgnoreCase("volume"))
            return volume.getImage();
        if (key.equalsIgnoreCase("up"))
            return up.getImage();
        if (key.equalsIgnoreCase("down"))
            return down.getImage();
        if (key.equalsIgnoreCase("difficulty"))
            return difficulty.getImage();
        if (key.equalsIgnoreCase("instructions"))
            return instructions.getImage();
        if (key.equalsIgnoreCase("mute"))
            return mute.getImage();
        if (key.equalsIgnoreCase("scroll"))
            return scroll.getImage();
        if (key.equalsIgnoreCase("muted-false"))
            return mutedF.getImage();
        if (key.equalsIgnoreCase("muted-true"))
            return mutedT.getImage();
        if (key.equalsIgnoreCase("menu"))
            return menu.getImage();
        if(key.equalsIgnoreCase("planet"))
            return planet.getImage();
        if (key.equalsIgnoreCase("exit"))
            return exit.getImage();
        if (key.equalsIgnoreCase("destroyed"))
            return destroyed.getImage();


        return null;
    }
}