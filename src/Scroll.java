/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries.
 */
import java.awt.Graphics;
import java.awt.Image;
/*
This class represents the background that is rendered when Level1, Level2 and Menu state are selected.
 */
public class Scroll {
    /*
    The next lines declare all the instance variables needed.
     */
    private Image im;
    private int width, height;
    private int pWidth, pHeight;
    private int moveSize;
    private boolean isMovingRight;
    private boolean isMovingLeft;
    private int xImHead;

    public Scroll(int w, int h, int moveSz){
        /*
        Constructor that receives the width and height of the JPanel.
        Also, receives the movement speed of the background.
         */
        pWidth = w;
        pHeight = h;
        im = ImageLoader.getInstance().getImage("scroll");
        width = im.getWidth(null);
        height = im.getHeight(null);
        moveSize = moveSz;
        isMovingRight = false;
        isMovingLeft = false;
        xImHead = 0;
    }

    public void moveRight(){
        /*
        When the player is moving to the right the background moves the right.
         */
        isMovingRight = true;
        isMovingLeft = false;
    }

    public void moveLeft(){
        /*
        When the player is moving to the left the background moves to the left.
         */
        isMovingRight = false;
        isMovingLeft = true;
    }

    public void stopMoving(){
        /*
        Stops the movement if the state changes to GameOver or Level2.
         */
        isMovingRight = false;
        isMovingLeft = false;
    }

    public void update(){
        /*
        Updates the movement position of the background.
         */
        if(isMovingRight){
            xImHead = (xImHead + moveSize) % width;
        }else if(isMovingLeft){
            xImHead = (xImHead - moveSize) % width;
        }
    }

    public void render(Graphics g){
        /*
        Calls the function draw which decides in which position the background will be rendered.
         */
        if(xImHead == 0)
            draw(g, im, 0, pWidth, 0, pWidth);
        else if((xImHead > 0) && (xImHead < pWidth)){
            draw(g, im, 0, xImHead, width - xImHead, width);
            draw(g, im, xImHead, pWidth, 0, pWidth - xImHead);
        }else if(xImHead >= pWidth){
            draw(g, im, 0, pWidth, width - xImHead, width - xImHead + pWidth);
        }else if((xImHead < 0) && (xImHead >= pWidth - width)){
            draw(g, im, 0, pWidth, -xImHead, pWidth - xImHead);
        }else if(xImHead < pWidth - width){
            draw(g, im, 0, width + xImHead, -xImHead, width);
            draw(g, im, width + xImHead, pWidth, 0, pWidth - width - xImHead);
        }

    }

    private void draw(Graphics g, Image im, int scrX1, int scrX2, int imX1, int imX2){
        /*
        Renders the background.
         */
        g.drawImage(im, scrX1, 0, scrX2, height,
                imX1, 0,  imX2, pHeight, null);
    }

}
