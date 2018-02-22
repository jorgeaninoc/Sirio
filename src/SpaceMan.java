/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries.
 */
import java.awt.Graphics;
import java.awt.Image;
/*
This class represents the SpaceMan which is the class controlled by the user.
 */
public class SpaceMan {
    /*
    The next lines declare the instance variables.
     */
    private int x, y, moveX = 0, moveY = 0;
    private Image spaceManImage;
    private Bullet bullet;
    private Bullets bullets;

    public SpaceMan(int x, int y){
        /*
        Constructor that receives x and y as parameter.
        This method instantiate the instance variables x, y to the parameters x,y.
        Also, it loads the image of the SpaceMan using the ImageLoader.
        Creates a Bullets object which holds a list of bullets that can be shot by the player.
         */
        this.x = x;
        this.y = y;
        spaceManImage = ImageLoader.getInstance().getImage("spaceman");
        bullet = null;
        bullets = new Bullets();
    }

    public void update(){
        /*
        This method updates the position of the SpaceMan and the bullets positions.
         */
        this.x+=moveX;
        this.y+=getMoveY();
        if(x> 430) x = 10;
        if(x<0) x = 410;
        bullets.tick();
    }

    public void render(Graphics g){
        /*
        This method renders the SpaceMan and all of his bullets.
         */
        g.drawImage(spaceManImage, x, y, 113, 179, null);
        bullets.render(g);
    }

    public void shoot(){
        /*
        This method adds a bullet to the bullets linked list if the player has shot less
        than 100 times.
         */
        if(bullets.getLength() < 100){
            bullet = new Bullet(this.x, this.y);
            bullets.addBullet(new Bullet(this.x, this.y));
        }else{
            System.out.println("Ya no tienes balas.");
        }

    }

    public int getX() {
        /*
        Returns the variable x.
         */
        return x;
    }

    public int getY() {
        /*
        Returns the variable y.
         */
        return y;
    }

    public int getMoveY() {
        /*
        Returns the movement speed in Y.
         */
        return moveY;
    }


    public void setMoveX(int move) {
        /*
        This method sets the moveX variable to move.
         */
        this.moveX = move;
    }


    public Bullets getBullets(){
        /*
        This method returns the bullets LinkedList.
         */
        return bullets;
    }
}
