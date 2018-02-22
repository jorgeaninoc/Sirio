/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries.
 */
import java.awt.*;
import java.awt.event.*;
/*
This class represents the GameContext which contains the GameStates which the user can traverse.
 */
public class GameContext {
    /*
    The next lines declare all of the GameStates.
     */
    private GameState menu;
    private GameState pause;
    private GameState gameover;
    private GameState current;
    private GameState level1;
    private GameState level2;
    private GameState settings;
    private GameState highscore;
    private GameState instructions;
    /*
    The next lines declare instance variables that are shared through states.
     */
    private SpaceMan spm;
    private int score, difficulty, level;
    private boolean muted;

    public GameContext(){
        /*
        Default constructor which instantiates all of the GameStates.
         */
        muted = false;
        pause = Factory.getInstance().createState("pause");
        gameover = Factory.getInstance().createState("gameover");
        menu = Factory.getInstance().createState("menu");
        level1 = Factory.getInstance().createState("level1");
        level2 = Factory.getInstance().createState("level2");
        settings = Factory.getInstance().createState("settings");
        highscore = Factory.getInstance().createState("highscores");
        instructions = Factory.getInstance().createState("instructions");
        /*
        The next lines sets the context of all the GameStates to this.
         */
        pause.setContext(this);
        gameover.setContext(this);
        menu.setContext(this);
        level1.setContext(this);
        level2.setContext(this);
        settings.setContext(this);
        highscore.setContext(this);
        instructions.setContext(this);
        /*
        The next lines instantiate the SpaceMan, sets the initial score to 0 and the difficulty to 45.
        The difficulty is a number to generate Asteroid objects.
         */
        spm = new SpaceMan(480 / 2, 720 - 830 / 5);
        score = 0;
        difficulty = 45;
        /*
        Next line sets the current state to menu, which is the initial state.
         */
        current = menu;
    }
    public GameState getMenu(){
        /*
        This method returns the menu state.
         */
        return menu;
    }

    public GameState getPause() {
        /*
        This method returns the pause state.
         */
        return pause;
    }

    public GameState getGameOver(){
        /*
        This method returns the gameover state.
         */
        return gameover;
    }

    public void setCurrent(GameState gamestate){
        /*
        This method sets current to gamestate.
         */
        current = gamestate;
    }


    public void update(int width, int height){
        /*
        This method updates the current state to the width and height parameters received.
         */
        current.update(width, height);
    }

    public void render(Graphics g){
        /*
        This method renders the current state.
         */
        current.render(g);
    }

    public void settings(){
        /*
        This method sets the current state to settings.
         */
        current = settings;
    }

    public void highscore(){
        /*
        This method sets the current state to highscore.
         */
        current = highscore;
    }

    public void level2(){
        /*
        This method sets the current state to level2.
         */
        current = level2;
    }

    public void level1(){
        /*
        This method sets the current state to level1.
         */
        if(!isMuted()){
            SoundLoader.getInstance().play("media/sounds/music.wav");
        }
        current = level1;
    }

    public void pause(int level){
        /*
        This method sets the variable level to level and sets the current state to pause.
         */
        this.level = level;
        current = pause;

    }

    public void gameOver(){
        /*
        This method sets the current state to gameover.
         */
        current = gameover;
    }

    public void menu(){
        /*
        This method sets the current state to menu.
         */
        current = menu;
    }

    public void instructions() {
        current = instructions;
    }
    public GameState getCurrent() {
        /*
        This method returns the current state.
         */
        return current;
    }

    public SpaceMan getSpaceMan(){
        /*
        This method returns the SpaceMan.
         */
        return spm;
    }


    public void keyPressed(KeyEvent e){
        /*
        This method passes a KeyEvent into the current state, depending on the state has a different result.
         */
        current.keyPressed(e);
    }

    public void mousePressed(MouseEvent e){
        /*
        This method passes a MouseEvent into the current state, depending on the state has a different result.
         */
        current.mousePressed(e);
    }

    public int getScore(){
        /*
        This method returns the score.
         */
        return score;
    }

    public void setScore(int sc){
        /*
        This method sets the score to sc.
         */
        this.score = sc;
    }

    public int getDifficulty(){
        /*
        This method returns the difficulty of the game.
         */
        return this.difficulty;
    }

    public void setDifficulty(int difficulty){
        /*
        This method sets the difficulty of the game to difficulty parameter.
         */
        this.difficulty = difficulty;
    }

    public int getLevel(){
        /*
        This method returns the variable level.
         */
        return this.level;
    }

    public boolean isMuted(){
        /*
        Returns if the sound is muted.
         */
        return muted;
    }

    public void setMuted(boolean muted){
        /*
        Sets the variable muted to muted.
         */
        this.muted = muted;
    }

    public void restart(){
        muted = false;
        pause = Factory.getInstance().createState("pause");
        gameover = Factory.getInstance().createState("gameover");
        menu = Factory.getInstance().createState("menu");
        level1 = Factory.getInstance().createState("level1");
        level2 = Factory.getInstance().createState("level2");
        settings = Factory.getInstance().createState("settings");
        highscore = Factory.getInstance().createState("highscores");
        instructions = Factory.getInstance().createState("instructions");
        /*
        The next lines sets the context of all the GameStates to this.
         */
        pause.setContext(this);
        gameover.setContext(this);
        menu.setContext(this);
        level1.setContext(this);
        level2.setContext(this);
        settings.setContext(this);
        highscore.setContext(this);
        instructions.setContext(this);
        /*
        The next lines instantiate the SpaceMan, sets the initial score to 0 and the difficulty to 45.
        The difficulty is a number to generate Asteroid objects.
         */
        spm = new SpaceMan(480 / 2, 720 - 830 / 5);
        score = 0;
        difficulty = 45;
        /*
        Next line sets the current state to menu, which is the initial state.
         */
        current = menu;
    }

}
