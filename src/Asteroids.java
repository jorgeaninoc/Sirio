/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries that are used.
 */
import java.awt.*;
import java.util.LinkedList;
/*
 This class contains a Linked List that constains objects of the class Asteroid.
 Each of Asteroid contained in the Linked List is rendered and updated.
 When an asteroid reaches a position higher than maxY (720) it is deleted from the Linked List.
 If an Asteroid intersects the SpaceMan the player loses.
 This class also contains a count of the Asteroid objects deleted from the Linked List.
 */
public class Asteroids {
    /*
    The next lines declare the instance variables.
    LinkedList<Asteroid> asteroids: which is a list that will contain all the Asteroid objects.
    int maxY: is the max position in Y that an Asteroid object can reach.
    int cnt: is the count of the Asteroid objects that are deleted, this is used for the player's score.
     */
    LinkedList<Asteroid> asteroids = new LinkedList<Asteroid>();
    Asteroid asteroid;
    private int maxY;
    private int cnt;

    public Asteroids(){
        /*
        This is the default constructor of the class Asteroids.
        Sets maxY to 720 (which is the height of the screen).
        Sets cnt to 0.
         */
        maxY = 720;
        cnt = 0;
    }

        public boolean intersectsStarShip(SpaceMan spm){
        /*
        This method checks if any Asteroid object intersects the SpaceMan.
        First it gets the Asteroid object at position i in the LinkedList.
        Second it creates a rectangle which contains the x, y, width and height of the Asteroid.
        Third it creates a rectangle which contains the x, y, width and height of the SpaceMan.
        Finally it returns if the rectangle of the Asteroid intersects the rectangle of the SpaceMan.
         */
        for (int i = 0; i < asteroids.size(); i++){
            asteroid = asteroids.get(i);
            Rectangle rectA = new Rectangle(asteroid.getX() + 10, asteroid.getY() + 11, 30, 20);
            Rectangle rectS = new Rectangle(spm.getX(), spm.getY(), 110,160);

            if(rectA.intersects(rectS)) return true;

        }
        return false;
    }

    public void render(Graphics g){
            /*
                This function calls the render function on each Asteroid stored in the LinkedList.
             */
        for (int i = 0; i < asteroids.size(); i++){
            asteroid = asteroids.get(i);
            asteroid.render(g);

        }
    }

    public void addAsteroid(Asteroid asteroid){
        /*
        This function adds asteroid to the LinkedList asteroids.
         */
        asteroids.add(asteroid);
    }

    public LinkedList getAsteroids(){
        /*
        This function returns the LinkedList asteroids.
         */
        return asteroids;
    }


    public void update() {
        /*
        This function calls the tick function in each Asteroid object contained in the Linked List asteroid.
        Also, this function removes each asteroid when it reaches maxY, and when this happens, 1 is added to cnt.
         */
        for (int i = 0; i < asteroids.size(); i++){
            asteroid = asteroids.get(i);
            asteroid.tick();
            if(asteroid.getY() > maxY){
                asteroids.remove(asteroid);
                cnt +=1;
            }
        }
    }

    public void clear(){
        /*
        This function clears the LinkedList asteroids.
         */
        asteroids.clear();
    }

    public int getCount(){
        /*
        This function returns cnt which is a variable that contains the number of Asteroid objects that have been removed.
         */
        return cnt;
    }

    public void setCount(int cnt){
        /*
        This method sets the instance variable cnt to cnt.
         */
        this.cnt = cnt;
    }
}
