/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries.
 */
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
/*
This interface represent the Design-pattern GameStates, which contains all the methods that are used by the states of the game.
 */
interface GameState {
    /*
    This interface declares all the methods to set the GameContext, render, pause, menu, and all the important
    methods that are used by every state.
     */

    void menu();

    void pause();

    void gameOver();

    void render(Graphics g);

    void update(int width, int height);

    void setContext(GameContext gc);

    void mousePressed(MouseEvent e);

    void keyPressed(KeyEvent e);


}
