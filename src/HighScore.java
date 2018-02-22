/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries.
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Image;
import java.io.*;
/*
This class represent the GameState in which the highest score reached in the game is showed.
 */
public class HighScore implements GameState {
    /*
    Next lines declare the instance variables.
     */
    private GameContext gc;
    private Image background;
    private Image highscores;
    private Image back;
    private BufferedReader reader;
    private String line;


    public HighScore() {
        /*
        Default constructor that instantiate the images, which are loaded by the ImageLoader class.
         */
        background = ImageLoader.getInstance().getImage("background");
        highscores = ImageLoader.getInstance().getImage("highscores");
        back = ImageLoader.getInstance().getImage("back");
    }


    public void setContext(GameContext gc){
        /*
        This method sets the gc instance variable to gc.
         */
        this.gc = gc;
    }

    @Override
    public void menu() {
        /*
        Does nothing.
         */
    }

    @Override
    public void pause() {
        /*
        Does nothing.
         */
    }


    @Override
    public void gameOver() {
        /*
        Does nothing.
         */
    }

    @Override
    public void render(Graphics g) {
        /*
        This method renders all the images and the highest score, with the user's name.
         */
        g.drawImage(background,0,0,500,740,null);
        g.drawImage(highscores,140,10,200,100,null);
        g.drawImage(back,10,10,100,100,null);
        g.setFont(new Font("TimesRoman", Font.PLAIN,40));
        g.drawString("1. " + line,30,380);
    }

    @Override
    public void update(int width, int height) {
        /*
        This method reads the highest score from a .txt file, for the state to show it.
         */
        try{
            reader = new BufferedReader(new FileReader("highscores.txt"));
            line = reader.readLine();
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void keyPressed(KeyEvent e){
        /*
        Does nothing.
         */
    }

    @Override
    public void mousePressed(MouseEvent e){
        /*
        This method checks if the back arrow is clicked, and if it is clicked it returns
        the GameState to menu.
         */
        if (e.getX() >= 25 && e.getY() >= 30 && e.getX() <= 95 && e.getY() <= 95)
            gc.menu();
    }

}
