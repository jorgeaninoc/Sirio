/*
 Authors: Team Orion
*/
/*
The next lines import the in-build libraries that are used.
 */
import java.awt.*;
import java.util.LinkedList;
/*
 This class contains a LinkedList that contains objects of the class Bullet.
 Each time the Enemy or the SpaceMan shoots a new bullet is added to the LinkedList.
 */
public class Bullets {
    /*
    The next lines declare the instance variables
    LinkedList<Bullet> bullets: holds a list of all the Bullet objects.
    Bullet bullet: stores the bullet that is added when the Enemy or SpaceMan shoots.
     */
    LinkedList<Bullet> bullets = new LinkedList<Bullet>();
    Bullet bullet;


    public Bullets(){
        /*
        Default constructor does nothing.
         */
    }

    public void tick(){
        /*
        Calls the method tick on each Bullet object in the bullets list.
        Each time the Bullet reaches the position 20 in y, it is removed from the Linked List.
         */
        for (int i = 0; i < bullets.size(); i++){
            bullet = bullets.get(i);
            bullet.tick();
            if(bullet.getY() < 20){
                bullets.remove(bullet);
            }
        }
    }

    public void enemyTick(){
        /*
        Calls the method enemyTick on each Bullet object in the bullets list.
        Each time the Bullet reaches the position 700 in y, it is removed from the Linked List.
         */
        for (int i = 0; i < bullets.size(); i++){
            bullet = bullets.get(i);
            bullet.enemyTick();
            if(bullet.getY() > 700){
                bullets.remove(bullet);
            }
        }
    }


    public void render(Graphics g){
        /*
        This method renders every Bullet object in the bullets LinkedList.
         */
        for (int i = 0; i < bullets.size(); i++){
            bullet = bullets.get(i);
            bullet.render(g);
        }
    }

    public boolean intersectsEnemy(Enemy e){
        /*
        This method checks if any Bullet object intersects the Enemy.
        First it gets the Bullet object at position i in the LinkedList.
        Second it creates a rectangle which contains the x, y, width and height of the Bullet.
        Third it creates a rectangle which contains the x, y, width and height of the Enemy.
        Finally it returns if the rectangle of the Bullet intersects the rectangle of the Enemy.
         */
        for (int i = 0; i < bullets.size(); i++){
            bullet = bullets.get(i);
            Rectangle rectB = new Rectangle(bullet.getX(), bullet.getY(), 40, 40);
            Rectangle rectE = new Rectangle(e.getX(), e.getY(), 5,1);

            if(rectB.intersects(rectE)) return true;

        }
        return false;
    }

    public boolean intersectsSpaceMan(SpaceMan spm){
        /*
        This method checks if any Bullet object intersects the SpaceMan.
        First it gets the Bullet object at position i in the LinkedList.
        Second it creates a rectangle which contains the x, y, width and height of the Bullet.
        Third it creates a rectangle which contains the x, y, width and height of the SpaceMan.
        Finally it returns if the rectangle of the Bullet intersects the rectangle of the SpaceMan.
         */
        for (int i = 0; i < bullets.size(); i++){
            bullet = bullets.get(i);
            Rectangle rectB = new Rectangle(bullet.getX(), bullet.getY(), 3, 1);
            Rectangle rectS = new Rectangle(spm.getX(), spm.getY(), 110,160);

            if(rectB.intersects(rectS)) return true;

        }
        return false;

    }

    public void addBullet(Bullet bullet){
        /*
            This method adds the Bullet object bullet to the bullets Linked List.
         */
        bullets.add(bullet);
    }

    public int getLength(){
        /*
        This method returns the length of the Linked List bullets.
         */
        return bullets.size();
    }


}
