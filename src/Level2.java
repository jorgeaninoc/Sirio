/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries.
 */
import java.awt.*;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
/*
This class represents the GameState Level2, which is the starting level.
 */
public class Level2 implements GameState{
    /*
    The next lines declare the instance variables.
     */
    private Scroll background;
    private Enemy enemy;
    private GameContext gc;
    private int cnt;
    private Image planet;

    public Level2() {
        /*
        Default constructor of the GameState Level2.
        Instantiate the background, a counter, and an Enemy object.
         */
        background = new Scroll(480,720,1);
        planet = ImageLoader.getInstance().getImage("planet");
        enemy = new Enemy(480 / 2, 50);
        cnt = 0;
    }

    public void render(Graphics g){
        /*
        This method renders the background, the enemy, the SpaceMan and the current score.
         */
        background.render(g);
        g.drawImage(planet,0,0,480,720,null);
        gc.getSpaceMan().render(g);
        enemy.render(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN,10));
        g.drawString("Score: " + gc.getScore(),400,10 );
    }

    public void update(int width, int height){
        /*
        This method updates the SpaceMan and the Enemy position.
        This method makes the Enemy shoot.
        This method plays a sound if the Enemy shoots the SpaceMan or if the SpaceMan shoots the Enemy.
        If the bullets of the SpaceMan intersects the Enemy the GameState is returned to level1.
        If the bullets of the Enemy intersects the SpaceMan the GameState is set to GameOver.
         */
        background.update();
        cnt+=1;
        if(gc.getSpaceMan().getBullets().intersectsEnemy(enemy)) {
            if(!gc.isMuted()){
                SoundLoader.getInstance().playSound("media/sounds/2.wav");
            }
            background.stopMoving();
            gc.setScore(gc.getScore() + 100);
            enemy = new Enemy(480 / 2, 50);
            gc.level1();
        }
        if(enemy.getBullets().intersectsSpaceMan(gc.getSpaceMan())){
            if(!gc.isMuted()){
                SoundLoader.getInstance().playSound("media/sounds/2.wav");
            }
            background.stopMoving();
            gc.gameOver();
        }
        if(cnt > 40){
            enemy.shoot();
            cnt = 0;
        }
        enemy.tick();
        gc.getSpaceMan().update();
    }


    public void setContext(GameContext context) {
        /*
        Sets the context gc to context.
         */
        this.gc = context;
    }

    @Override
    public void menu() {
        /*
        Sets the current GameState to menu.
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
        Sets the current GameState to gameover.
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
            gc.pause(2);
        }
    }

    @Override
    public void mousePressed(MouseEvent e){
        /*
        Does nothing.
         */
    }




}
