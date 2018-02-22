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
This class represents the GameState Level1, which is the starting level.
 */
public class Level1 implements GameState{
    /*
    The next lines declare the instance variables.
     */
    private Scroll background;
    private Asteroids asteroids;
    private Asteroid asteroid;
    private boolean intersects;
    private int asteroidFlag, level2Flag;
    private boolean addAsteroid;
    private GameContext gc;
    private Image planet;

    public Level1() {
        /*
        Default constructor of the GameState Level1.
        Instantiate all of the images, flags and an Asteroids object which holds the asteroids
        created during the game.
         */
        background = new Scroll(480,720,1);
        planet = ImageLoader.getInstance().getImage("planet");
        asteroids = new Asteroids();
        asteroidFlag = 0;
        level2Flag = 0;
        addAsteroid = true;
    }

    public void render(Graphics g){
        /*
        This method renders the background, the SpaceMan, all the asteroids, and shows the score in the screen.
         */
        background.render(g);
        g.drawImage(planet,0,0,480,720,null);
        gc.getSpaceMan().render(g);
        asteroids.render(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN,10));
        g.drawString("Score: " + gc.getScore(),400,10 );

    }

    @Override
    public void update(int width, int height){
        /*
        This method adds Asteroid objects to the Asteroids object which holds a LinkedList
        with all the Asteroid objects.
        This method creates Asteroid objects depending on the difficulty of the game.
        Also, it calculates the player's score and checks if the SpaceMan intersects an Asteroid.
        If the SpaceMan intersects an asteroid it sets the current GameState to GameOver.
        This method updates the SpaceMan position and the Asteroid objects positions.
         */
        background.update();
        gc.setScore(gc.getScore() + asteroids.getCount()*10);
        asteroids.setCount(0);
        if (addAsteroid){
            asteroid = new Asteroid();
            asteroids.addAsteroid(asteroid);
            addAsteroid = false;
            asteroidFlag  = 0;
        }else{
            asteroidFlag++;
            level2Flag++;
            if(asteroidFlag == gc.getDifficulty()) addAsteroid = true;
        }
        if(asteroids.intersectsStarShip(gc.getSpaceMan())){
            if(!gc.isMuted()){
                SoundLoader.getInstance().playSound("media/sounds/2.wav");
            }
            background.stopMoving();
            gc.gameOver();
        }
        if(level2Flag == 1000){
            gc.setDifficulty(gc.getDifficulty()-1);
            asteroids.clear();
            gc.level2();
        }
        gc.getSpaceMan().update();
        asteroids.update();
    }

    public void setContext(GameContext context) {
        /*
        This method sets the gc instance variable to context.
         */
        this.gc = context;
    }

    @Override
    public void menu() {
        /*
        This method sets the current GameState in the context to menu.
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
        This method sets the current GameState in the context to GameOver.
         */
        gc.setCurrent(gc.getGameOver());
    }

    @Override
    public void keyPressed(KeyEvent e){
        /*
        This method checks the keyboard of the player, if the right arrow is pressed the SpaceMan moves to the right
        if the left arrow is pressed the SpaceMan moves to the left.
        If Space is pressed the SpaceMan shoots.
        If P is pressed the game pauses.
         */
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && gc.getSpaceMan().getX() < 416){
            gc.getSpaceMan().setMoveX(+3);
            background.moveRight();
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT && gc.getSpaceMan().getX() > 0){
            gc.getSpaceMan().setMoveX(-3);
            background.moveLeft();
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            gc.getSpaceMan().shoot();
        }
        if(e.getKeyCode() == KeyEvent.VK_P){
            gc.pause(1);
        }
    }

    @Override
    public void mousePressed(MouseEvent e){
        /*
        Does nothing.
         */
    }

}
