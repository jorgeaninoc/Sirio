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
This class represents the GameState Instructions, which can be called from the menu.
 */
public class Instructions implements GameState {
    /*
    The next lines declare the instance variables.
     */
    private GameContext gc;
    private Image instructions;
    private Image background;
    private Image back;

    public Instructions() {
            /*
            The next line instantiates the images that are going to be rendered by using the ImageLoader.
             */
        instructions = ImageLoader.getInstance().getImage("instructions");
        background = ImageLoader.getInstance().getImage("background");
        back = ImageLoader.getInstance().getImage("back");
    }

    public void setContext(GameContext gc) {
        /*
        Sets the gc variable to gc.
         */
        this.gc = gc;
    }

    @Override
    public void menu() {
        /*
        Sets the current state to menu.
         */
        gc.setCurrent(gc.getMenu());
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
        Sets the current state to gameover.
         */
        gc.setCurrent(gc.getGameOver());
    }

    @Override
    public void render(Graphics g) {
        /*
        Renders the images and buttons, and renders the strings that indicate how to play the game.
         */
        g.drawImage(background,0,0,500,740,null);
        g.drawImage(instructions,140,10,200,100,null);
        g.drawImage(back,10,10,100,100,null);
        g.setFont(new Font("TimesRoman", Font.PLAIN,18));
        g.drawString("1. Dodge all the asteroids you can to set a new record!",0,150);
        g.drawString("2. Move using the keyboard LEFT <- and RIGHT -> arrows.",0,225);
        g.drawString("3. Shoot by pressing the SPACE bar.",0,300);
        g.drawString("4. Pause the game by pressing P.",0,375);
        g.drawString("5. Beat the Enemy!.",0,450);
        g.drawString("6. Change the difficulty in settings.",0,525);
    }

    @Override
    public void update(int width, int height) {
        /*
        Does nothing
         */
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
        Checks if the user presses the arrow to go back to the menu.
         */
        if (e.getX() >= 25 && e.getY() >= 30 && e.getX() <= 95 && e.getY() <= 95)
            gc.menu();

    }

}
