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
import java.io.*;
/*
This class represents the GameState GameOver, which is used when the player loses the game.
 */
public class GameOver implements GameState {
    /*
    The next lines declare the instance variables.
     */
    private GameContext gc;
    private Image img;
    private Image background;
    private Image playagain;
    private Image menu;
    private String str;
    private BufferedWriter writer;
    private BufferedReader reader;

    public GameOver() {
        /*
        Default constructor of the GameState GameOver.
        Instantiate all of the images used in the state, and the string which holds the name of the player.
        The string is used to save the score of the player.
         */
        background = ImageLoader.getInstance().getImage("background");
        img = ImageLoader.getInstance().getImage("gameover");
        playagain = ImageLoader.getInstance().getImage("playagain");
        menu = ImageLoader.getInstance().getImage("menu");
        str = "ABCDEFGH";


    }
    public void setContext(GameContext gc){
        /*
        Sets the context of the state to gc.
         */
        this.gc = gc;
    }

    @Override
    public void menu() {
        /*
        Sets the GameState to menu.
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
        Does nothing.
         */
    }

    @Override
    public void render(Graphics g) {
        /*
        Renders all of the images loaded from the ImageLoader, also renders the name of the player.
         */
        g.drawImage(background,0,0,500,740,null);
        g.drawImage(img,100,30,300,130,null);
        g.drawImage(playagain,140,500,200,100,null);
        g.drawImage(menu,140,600,200,100,null);
        g.setFont(new Font("TimesRoman", Font.PLAIN,40));
        g.drawString("Insert your name.",100,300);
        g.setFont(new Font("TimesRoman", Font.PLAIN,40));
        g.drawString(str,140,400);
    }

    @Override
    public void update(int width, int height) {
        /*
        This method checks if the variable str which holds the name of the player has a length greater than 8.
        If it does it clears the string.
         */
        if(str.length() > 8){
            str = "";
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        /*
        This method checks which key is pressed and appends that key to the variable str which holds the name of the player.
         */
        if(e.getKeyCode() == KeyEvent.VK_A) {
            str += "A";
        }
        if(e.getKeyCode() == KeyEvent.VK_B) {
            str += "B";
        }
        if(e.getKeyCode() == KeyEvent.VK_C) {
            str += "C";
        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
            str += "D";
        }if(e.getKeyCode() == KeyEvent.VK_E) {
            str += "E";
        }
        if(e.getKeyCode() == KeyEvent.VK_F) {
            str += "F";
        }if(e.getKeyCode() == KeyEvent.VK_G) {
            str += "G";
        }if(e.getKeyCode() == KeyEvent.VK_H) {
            str += "H";
        }if(e.getKeyCode() == KeyEvent.VK_I) {
            str += "I";
        }if(e.getKeyCode() == KeyEvent.VK_J) {
            str += "J";
        }
        if(e.getKeyCode() == KeyEvent.VK_K) {
            str += "K";
        }if(e.getKeyCode() == KeyEvent.VK_L) {
            str += "L";
        }if(e.getKeyCode() == KeyEvent.VK_M) {
            str += "M";
        }if(e.getKeyCode() == KeyEvent.VK_N) {
            str += "N";
        }if(e.getKeyCode() == KeyEvent.VK_O) {
            str += "O";
        }if(e.getKeyCode() == KeyEvent.VK_P) {
            str += "P";
        }if(e.getKeyCode() == KeyEvent.VK_Q) {
            str += "Q";
        }if(e.getKeyCode() == KeyEvent.VK_R) {
            str += "R";
        }if(e.getKeyCode() == KeyEvent.VK_S) {
            str += "S";
        }if(e.getKeyCode() == KeyEvent.VK_T) {
            str += "T";
        }if(e.getKeyCode() == KeyEvent.VK_U) {
            str += "U";
        }if(e.getKeyCode() == KeyEvent.VK_V) {
            str += "V";
        }if(e.getKeyCode() == KeyEvent.VK_W) {
            str += "W";
        }if(e.getKeyCode() == KeyEvent.VK_X) {
            str += "X";
        }
        if(e.getKeyCode() == KeyEvent.VK_Y) {
            str += "Y";
        }
        if(e.getKeyCode() == KeyEvent.VK_Z) {
            str += "Z";
        }
        if(e.getKeyCode() == KeyEvent.VK_DELETE) {
            str ="";
        }
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            str ="";
        }
    }

    @Override
    public void mousePressed(MouseEvent e){
        /*
        This method checks if the player clicks "Play Again" or "End" if it does any of them, it saves the name of the
        player to a .txt file which holds the highest score obtained in the game. If the user clicks "End" the GameState
        is set to Menu and if the user clicks "Play Again" the game is restarted.
         */
        if(e.getX()>=159 && e.getY() >= 515 && e.getX() <= 332 && e.getY() <= 580){
            try {
                File f = new File("highscores.txt");
                if(f.exists() && !f.isDirectory()) {
                    reader = new BufferedReader(new FileReader("highscores.txt"));
                    String line = reader.readLine();
                    if (line != null) {
                        int score = Integer.parseInt(line.trim().replaceAll("[\\D]", ""));
                        if (gc.getScore() > score) {
                            writer = new BufferedWriter(new FileWriter("highscores.txt"));
                            writer.write(str + " --- " + gc.getScore());
                            writer.close();
                        }
                    } else {
                        writer = new BufferedWriter(new FileWriter("highscores.txt"));
                        writer.write(str + " --- " + gc.getScore());
                        writer.close();
                    }
                    reader.close();
                }else{
                    writer = new BufferedWriter(new FileWriter("highscores.txt"));
                    writer.write(str + " --- " + gc.getScore());
                    writer.close();
                }
            }catch (IOException x) {
                x.printStackTrace();
            }
            gc.restart();
            gc.level1();
        }
        if(e.getX()>=159 && e.getY() >= 619 && e.getX() <= 332 && e.getY() <= 678) {
            try {
                File f = new File("highscores.txt");
                if(f.exists() && !f.isDirectory()) {
                    reader = new BufferedReader(new FileReader("highscores.txt"));
                    String line = reader.readLine();
                    if (line != null) {
                        int score = Integer.parseInt(line.trim().replaceAll("[\\D]", ""));
                        if (gc.getScore() > score) {
                            writer = new BufferedWriter(new FileWriter("highscores.txt"));
                            writer.write(str + " --- " + gc.getScore());
                            writer.close();
                        }
                    } else {
                        writer = new BufferedWriter(new FileWriter("highscores.txt"));
                        writer.write(str + " --- " + gc.getScore());
                        writer.close();
                    }
                    reader.close();
                }else{
                    writer = new BufferedWriter(new FileWriter("highscores.txt"));
                    writer.write(str + " --- " + gc.getScore());
                    writer.close();
                }
                }catch (IOException x) {
                x.printStackTrace();
            }

            gc.restart();
            gc.menu();
        }
    }



}
