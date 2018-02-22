/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries that are used.
 */
import java.awt.*;
import java.awt.Image;
/*
 This class represents a Bullet which is rendered in the game when the SpaceMan or Enemy shoot.
 Used during Level1 and Level2 State by the SpaceMan and by the Enemy classes.
 */
public class Bullet {
    /*
    The next lines declare the instance variables.
    int x: holds the x position of the Bullet.
    int y: holds the y position of the Bullet.
    Image bullet: holds the Image of the bullet.
     */
    private int x, y;
    private Image bullet;


    public Bullet(int x, int y){
        /*
        Constructor of the class Bullet which receives x and y as a parameter.
        Sets the instance variable x to x.
        Sets the instance variable y to y.
        Loads the image of the bullet from the ImageLoader.
         */
        this.x= x+40;
        this.y= y+10;
        bullet = ImageLoader.getInstance().getImage("bullet");
    }


    public void tick(){
        /*
         Default movement of the bullet when is shooted by the SpaceMan.
         */
        y -= 6;
    }

    public void enemyTick(){
        /*
         Default movement of the bullet when is shooted by the Enemy.
         */
        y += 6;
    }

    public void render(Graphics g){
        /*
        This method renders the bullet image.
         */
        g.drawImage(bullet, x, y, 15, 50, null);
    }

    public int getX() {
        /*
        This function returns the instance variable x.
         */
        return x;
    }

    public void setX(int x) {
        /*
        This functions sets the value of the instance variable x to the value x.
         */
        this.x = x;
    }

    public int getY() {
        /*
        This function returns the value of the instance variable y.
         */
        return y;
    }

    public void setY(int y) {
        /*
        This method sets the instance variable y to y.
         */
        this.y = y;
    }
}