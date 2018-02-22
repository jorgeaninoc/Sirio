/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries.
 */
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/*
The next class represent the SoundLoader which runs on another Thread.
This class is responsible for loading the sound clips used in the game.
This class also uses the Design-Pattern Singletone.
 */
public class SoundLoader implements Runnable{
    /*
    The next lines declare the instance variables.
     */
    private static SoundLoader instance;
    private Clip clip;
    private String path;

    private SoundLoader(){
        /*
        Instantiate the clip variable to a AudioSystem object.
         */
        try{
            clip = AudioSystem.getClip();
        }catch(Exception e){
        }
    }

    public void run(){
        /*
        Runs the sound on path.
         */
        playSound(path);
    }

    public void play(String path){
        /*
        Loads the sound in path and plays it.
         */
        Thread thread = new Thread(this);
        if(!thread.isAlive()){
            this.path = path;
            thread.start();
        }
    }

    public static SoundLoader getInstance(){
        /*
        This method checks if the instance of SoundLoader is null, if it is null it creates a new instance.
        This method returns the instance of SoundLoader.
         */
        if(instance == null){
            instance = new SoundLoader();
        }
        return instance;
    }

    public void playSound(String path){
        /*

        This method loads and plays the sound saved on the path parameter.
         */
        try{
            clip.close();
            clip.open(AudioSystem.getAudioInputStream(GamePanel.class.getResource(path)));
            clip.start();
        }catch(Exception e){
            clip.close();
            System.err.println(e.getMessage());
            System.err.println("Error");
        }

    }

}