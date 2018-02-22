/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries.
 */
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.Image;
/*
This class represents the GameState Menu which is the starting state.
 */
public class Menu implements GameState{
    /*
    The next lines declare the instance variables.
     */
    private GameContext gc;
    private Image playimg;
    private Image instructions;
    private Scroll background;
    private Image highimg;
    private Image settimg;
    private Image exit;
    private Image header;
    private Image planet;

    public Menu() {
        /*
        Default constructor, uses the ImageLoader to load all of the images of the menu.
         */
        background = new Scroll(480,720,1);
        playimg = ImageLoader.getInstance().getImage("play");
        highimg = ImageLoader.getInstance().getImage("highscores");
        settimg = ImageLoader.getInstance().getImage("settings");
        exit = ImageLoader.getInstance().getImage("exit");
        header = ImageLoader.getInstance().getImage("header");
        instructions = ImageLoader.getInstance().getImage("instructions");
        planet = ImageLoader.getInstance().getImage("planet");
    }


    public void setContext(GameContext gc){
        /*
        Sets the context gc to gc.
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
        Renders all the images used in the menu.
         */
        background.render(g);
        g.drawImage(planet,0,0,480,720,null);
        g.drawImage(playimg,140,270,200,100,null);
        g.drawImage(instructions,140,350,200,100,null);
        g.drawImage(settimg,140,430,200,100,null);
        g.drawImage(highimg,140,510,200,100,null);
        g.drawImage(exit,140,590,200,100,null);
        g.drawImage(header,0,-40,500,350,null);
    }

    @Override
    public void update(int width, int height) {
        /*
        Moves the background scroll image.
         */
        background.update();
        background.moveRight();
    }

    @Override
    public void keyPressed(KeyEvent e){
        /*
        If the user presses ENTER it starts the game in level1.
         */
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            gc.level1();
        }

    }

    @Override
    public void mousePressed(MouseEvent e){
        /*
        Depending on the click of the user changes the GameState.
        If the user clicks "Start" it starts the game in level1.
        If the user clicks "Settings" it allows the user to change the settings of the game.
        If the user clicks "High Score" it shows the user the highest score recorded.
        If the user click "Exit" it exits the game.
         */
        if(e.getX() >= 165 && e.getY() >= 291 && e.getX() <= 319 && e.getY() <= 351){
            gc.level1();
        }
        if(e.getX() >= 165 && e.getY() >= 371 && e.getX() <= 319 && e.getY() <= 431){
            gc.instructions();
        }
        if(e.getX() >= 165 && e.getY() >= 451 && e.getX() <= 319  && e.getY() <= 490){
            gc.settings();
        }
        if(e.getX() >= 165 && e.getY() >= 531 && e.getX() <= 319 && e.getY() <= 590) {
            gc.highscore();
        }
        if(e.getX() >= 165 && e.getY() >= 611 && e.getX() <= 319 && e.getY() <= 690){
            System.exit(0);
        }

    }


}
