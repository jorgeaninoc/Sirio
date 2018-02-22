/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries.
 */
import java.awt.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
/*
This class represents the GameState Pause, which can be called when the user is playing.
 */
public class Pause implements GameState {
    /*
    The next lines declare the instance variables.
     */
    private GameContext gc;
    private Image pauseimg;
    private Image background;

    public Pause() {
            /*
            The next line instantiates the images that are going to be rendered by using the ImageLoader.
             */
            pauseimg = ImageLoader.getInstance().getImage("pause");
            background = ImageLoader.getInstance().getImage("background");
    }

    public void setContext(GameContext gc) {
        /*
        This method sets the variable gc to gc.
         */
        this.gc = gc;
    }

    @Override
    public void menu() {
        /*
        This method sets the current GameState to menu.
         */
        gc.setCurrent(gc.getMenu());
    }

    @Override
    public void pause(){
        /*
        This method does nothing.
         */
    }

    @Override
    public void gameOver() {
        /*
        This method sets the current GameState to gameover.
         */
        gc.setCurrent(gc.getGameOver());
    }

    @Override
    public void render(Graphics g) {
        /*
        This method renders the background and the pause image.
         */
        g.drawImage(background,0,0,500,740,null);
        g.drawImage(pauseimg, 150, 310, 200, 100, null);
    }

    @Override
    public void update(int width, int height) {
        /*
        Does nothing.
         */
    }

    @Override
    public void keyPressed(KeyEvent e){
        /*
        This method checks if the level who summoned this state was 1 or 2, and it sets the GameState to that method
        if the user presses P.
         */
        if(e.getKeyCode() == KeyEvent.VK_P && gc.getLevel() == 1) {
            gc.level1();
        }else if(e.getKeyCode() == KeyEvent.VK_P && gc.getLevel() == 2) {
            gc.level2();
        }

    }

    @Override
    public void mousePressed(MouseEvent e){
        /*
        Does nothing.
         */

    }

}
