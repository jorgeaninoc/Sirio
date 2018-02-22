/*
 Authors: Team Orion
*/
/*
The next lines import the built-in libraries.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
This class represent the Main class.
It is a JPanel which is run in a thread.
It holds important variables and methods of the game, in order to be able to run it.
 */
public class GamePanel extends JPanel implements Runnable {
	/*
	The next lines declare all of the instance variables of the GamePanel.
	 */
	private static final long serialVersionUID = 1L;
	private int PWIDTH = 480; // Width of the panel
	private int PHEIGHT =  720; // Height of the panel

	private Thread animator; // Controls the animation
	private volatile boolean running = false;
	private volatile boolean gameOver = false;
	private volatile boolean isPaused = false;
	private GameContext context;

	public GamePanel(){
		/*
		Default constructor.
		Sets the background color, the size of the screen and sets focusable to true.
		Requests focus to the window.
		Adds a MouseListener to check the clicks on the screen, depending on the state.
		Adds a KeyListener to check the keyboard, depending on the state.
		Starts the music of the game.
		Instantiates the context of the game.
		 */
		setBackground(Color.black);
		setPreferredSize(new Dimension(PWIDTH,PHEIGHT));
		setFocusable(true);
		requestFocus();
		addMouseListener( new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				context.mousePressed(e);
			}
		});
		addKeyListener( new KeyAdapter() { // listen for esc, q, end, ctrl-c
			public void keyPressed(KeyEvent e) {
				context.keyPressed(e);
			}
		});
		context = new GameContext();

    }//GamePanel()

	public void addNotify()	{
		/*
		Overrides a method from the super class, and starts the game.
		 */
		super.addNotify();
		startGame();
	}//addNotify

	private void startGame(){
		/*
		Instantiate the thread for the animations and runs it.
		 */
		if(animator == null || !running){
			animator = new Thread(this);
			animator.start();
		}
	}//startGame()

	public void stopGame(){
		/*
		Stops the game.
		 */
		running = false;
	}//stopGame()

	public void run(){
		/*
		Run method which is used by the thread.
		 */
		running = true;
		while(running) {
			gameUpdate(PWIDTH, PHEIGHT);
			gameRender();
			paintScreen();
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
			}
		}

	}//run()

	private void gameUpdate(int width, int height){
		/*
		Updates the context to the width and height received in the parameters.
		 */
		context.update(width, height);
	}//gameUpdate()

	/*
	Next lines declare a Graphics object to render the game, and an Image object that will give us a Graphic object.
	 */
	private Graphics dbg;
	private Image dbImage = null;

	private void gameRender(){
		/*
		This method renders the game and the context.
		 */
		if(dbImage == null)
		{
			dbImage = createImage(PWIDTH,PHEIGHT);
			if(dbImage == null){
				System.out.println("dbImage is null");
				return;
			}else{
				dbg = dbImage.getGraphics();
			}

		}
		dbg.setColor(Color.white);
		dbg.fillRect(0,0,PWIDTH,PHEIGHT);
		context.render(dbg);
	}//gameRender()


	public void paintComponent(Graphics g){
		/*
		This method renders the Graphics object g.
		 */
		super.paintComponent(g);
		if(dbImage != null)
			g.drawImage(dbImage, 0, 0, null);
	}

	private void paintScreen(){
		/*
		This method renders the Graphics object to the screen.
		 */
		Graphics g;
		try{
			g = this.getGraphics();
			if((g != null) && (dbImage != null))
				g.drawImage(dbImage,0,0,null);
			Toolkit.getDefaultToolkit().sync();
		}catch(Exception e){
			System.out.println("Graphics context error: "+e);
		}
	}




	public static void main(String args[]){
		/*
		Main method which runs the game.
		 */
	 JFrame app = new JFrame("Sirio");
     app.getContentPane().add(new GamePanel(), BorderLayout.CENTER);
     app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     app.pack();
     app.setResizable(false);
     app.setVisible(true);
	}
}
