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
/*
This class represents the GameState Settings which can be called from the menu.
 */
public class Settings implements GameState {
    /*
    The next lines declare the instance variables.
     */
    private GameContext gc;
    private Image background;
    private Image back;
    private Image up;
    private Image down;
    private Image difficulty;
    private Image settings;
    private Image volume;
    private Image mute;
    private Image muted;
    private int dif;

    public Settings() {
        /*
        This method instantiates all the images by loading them using the ImageLoader.
        Also instantiates the variable used for changing the difficulty.
         */
        background = ImageLoader.getInstance().getImage("background");
        back = ImageLoader.getInstance().getImage("back");
        up = ImageLoader.getInstance().getImage("up");
        down = ImageLoader.getInstance().getImage("down");
        difficulty = ImageLoader.getInstance().getImage("difficulty");
        settings = ImageLoader.getInstance().getImage("settings");
        volume = ImageLoader.getInstance().getImage("volume");
        mute = ImageLoader.getInstance().getImage("mute");
        muted = ImageLoader.getInstance().getImage("muted-false");
        dif = 2;

    }


    public void setContext(GameContext gc){
        /*
        Sets the gamecontext gc to gc.
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
        Renders all the images in the game and the string variable responsible for changing the difficulty.
         */
        g.drawImage(background,0,0,500,740,null);
        g.drawImage(back,10,10,100,100,null);
        g.drawImage(settings,115,3,300,150,null);
        g.drawImage(difficulty,115,200,250,125,null);
        g.drawImage(down,110,300,100,100,null);
        g.setFont(new Font("TimesRoman", Font.PLAIN,40));
        g.drawString("" + this.dif,230,360);
        g.drawImage(up,260,300,100,100,null);
        g.drawImage(volume,115,400,250,115,null);
        g.drawImage(mute,75,500,200,115,null);
        g.drawImage(muted,260,520,100,75,null);
    }

    @Override
    public void update(int width, int height) {
        /*
        Does nothing
         */
        if(gc.isMuted() == false){
            muted = ImageLoader.getInstance().getImage("muted-false");
        }else{
            muted = ImageLoader.getInstance().getImage("muted-true");
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        /*
        Does nothing
         */
    }

    @Override
    public void mousePressed(MouseEvent e){
        /*
        Checks if the user clicks "+" or "-" to change the difficulty of the game.
        The difficulty on the GameContext changes depending of the variable stored here.
        If the user clicks the <- back arrow it returns the state to the menu.
         */
        if(e.getX()>=123 && e.getY() >= 326 && e.getX() <= 193 && e.getY() <= 373)
            if(this.dif > 1){
                this.dif -=1;
            }
            if(this.dif == 1){
                this.gc.setDifficulty(65);
            }
            if(this.dif == 2){
                this.gc.setDifficulty(45);
            }
            if(this.dif == 3){
                this.gc.setDifficulty(25);
            }
        if(e.getX()>=279 && e.getY() >= 319 && e.getX() <= 341 && e.getY() <= 382)
            if(this.dif < 3){
                this.dif +=1;
            }
            if(this.dif == 1){
                this.gc.setDifficulty(65);
            }
            if(this.dif == 2){
                this.gc.setDifficulty(45);
            }
            if(this.dif == 3){
                this.gc.setDifficulty(25);
            }
        if (e.getX() >= 25 && e.getY() >= 30 && e.getX() <= 95 && e.getY() <= 95)
            gc.menu();
        if (e.getX() >= 289 && e.getY() >= 547 && e.getX() <= 326 && e.getY() <= 575)
            gc.setMuted(!gc.isMuted());
    }


}
