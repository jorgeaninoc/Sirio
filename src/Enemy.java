/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries that are used.
 */
import java.awt.*;
import java.awt.Image;
/*
    This class represents the Enemy which appears in Level2 GameState.
    The Enemy shoots to the SpaceMan.
 */
public class Enemy {
    /*
    The next lines declare the instance variables.
    int x: holds the x position of the Bullet.
    int y: holds the y position of the Bullet.
    int moveX: holds the movement speed of the Enemy.
    Image enemyImage: holds the image of the Enemy.
    boolean state: holds a state which indicates the moving direction of the enemy (left or right)
    Bullet bullet: holds the bullet that is added to bullets when the enemy shoots.
    Bullets bullets: holds the list of bullets that the enemy has shooted.
     */
    private int x, y, moveX = 0;
    private Image enemyImage;
    private boolean state;
    private Bullet bullet;
    private Bullets bullets;

    public Enemy(int x, int y) {
        /*
        Constructor of the class Enemy which receives x and y as a parameter.
        Sets the instance variable x to x.
        Sets the instance variable y to y.
        Sets moveX to 0.
        Sets state to false.
        Sets enemyImage to hold the image of the enemy.
        Sets bullet to null
        Instantiates bullets which holds the bullet list.
         */
        this.x = x;
        this.y = y;
        this.moveX = 0;
        state = false;
        enemyImage = ImageLoader.getInstance().getImage("enemy");
        bullet = null;
        bullets = new Bullets();
    }

    public void tick() {
        /*
        This method moves the enemy from left to right and from right to left.
         */
        if(this.x > 720-100){
            state = true;
        }else if(this.x < 0){
            state = false;
        }
        if(state){
            moveX =-6;
        }else{
            moveX = 6;
        }
        this.x += moveX;
        bullets.enemyTick();
    }

    public void render(Graphics g) {
        /*
        This method renders the enemyImage and the bullets.
         */
        g.drawImage(enemyImage, x, y, 140, 60, null);
        bullets.render(g);
    }

    public void shoot(){
        /*
        This method adds a bullet to the bullets list if the Enemy has shot less than 100 bullets.
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
        This method returns the variable x.
         */
        return x;
    }

    public int getY() {
        /*
        This method returns the variable y.
         */
        return y;
    }

    public int getMoveX() {
        /*
        This method returns the variable moveX.
         */
        return moveX;
    }


    public void setX(int x) {
        /*
        This method sets the variable x to x.
         */
        this.x = x;
    }

    public void setY(int y) {
        /*
        This method sets the variable y to y.
         */
        this.y = y;
    }

    public void setMoveX(int move) {
        /*
        This method sets the variable moveX to move.
         */
        this.moveX = move;
    }

    public Bullets getBullets(){
        /*
        This method returns the list bullets.
         */
        return bullets;
    }

}