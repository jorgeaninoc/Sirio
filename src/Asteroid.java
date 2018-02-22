/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries that are used.
 */
import java.awt.*;
import java.awt.Image;
import java.util.Random;
/*
 This class represents an Asteroid which is rendered in the game.
 Used during the Level1 state.
 Each time the user dodges one asteroid, 10 points are added to the player's score.
 Each asteroid position is generated randomly, and it has a constant movement which is also random.
 */
public class Asteroid {
    /*
    The next lines declare the instance variables.
    int x: which is the x position of the Asteroid.
    int y: which is the y position of the Asteroid.
    int moveAsteroid: which is the speed at which the Asteroid moves.
    Image asteroid: which is the image of the Asteroid.
     */
    private int x, y;
    private int moveAsteroid;
    private Image asteroid;


    public Asteroid(){
        /*
        Default constructor of the class Asteroid.
        Sets the x position to a random variable (so it appears in a random position)
        And the movement in y is constant (-64)
        The speed of the asteroid's movement is also set to random (from 5 to 8 pixels per second)
        The default constructor also sets the image of the asteroid.
         */
        Random  r = new Random();
        this.x= r.nextInt(480);
        this.y= (-64);
        this.moveAsteroid = r.nextInt(3)+5;
        asteroid = ImageLoader.getInstance().getImage("meteor");
    }


    public void tick(){
        /*
        This function moves the asteroid to the bottom of the screen.
         */
        y += moveAsteroid;
    }

    public void render(Graphics g){
        /*
        This function renders the asteroid image.
         */
        g.drawImage(asteroid, x, y, 100, 100, null);
    }

    public int getX() {
        /*
        Returns the position x of the asteroid.
         */
        return x;
    }

    public void setX(int x) {
        /*
        Sets the position x of the asteroid to x.
         */
        this.x = x;
    }

    public int getY() {
        /*
        Returns the position y of the asteroid.
         */
        return y;
    }

    public void setY(int y) {
        /*
       Sets the position y of the asteriod to y.
         */
        this.y = y;
    }
}
