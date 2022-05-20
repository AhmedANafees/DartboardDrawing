
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;

/**
 *
 * @author nafea8846
 */
public class DartBoardDrawing extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 600;
    static final int HEIGHT = 600;

    //Title of the window
    String title = "DardBoard";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));

    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public DartBoardDrawing() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);

        // Set things up for the game at startup
        setup();

        // Start the game loop
        gameTimer = new Timer(desiredTime, this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)

    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //Variables
        int x;
        int y;
        int length;
        int width;
        int counterInt;
        boolean blackColor = false;
        // GAME DRAWING GOES HERE
        //Draws each of the circles
        for (int i = 0; i < 4; i++) {
            counterInt = i;
            //set parameters for each circle to be drawn
            switch (counterInt) {
                case 1:
                    x = 25;
                    y = 25;
                    length = 550;
                    width = 550;
                    break;
                case 2:
                    x = 100;
                    y = 100;
                    length = 400;
                    width = 400;
                    break;
                case 3:
                    x = 125;
                    y = 125;
                    length = 350;
                    width = 350;
                    break;
                case 4:
                    x = 200;
                    y = 200;
                    length = 200;
                    width = 200;
                    break;
                default:
                    x = 0;
                    y = 0;
                    length = 600;
                    width = 600;
            }
            //draws ceach section of a circle
            for (int j = 0; j < 360; j = j + 18) {
                //set color to to BLACK or RED depending on value of blackColor
                if (blackColor) {
                    g.setColor(Color.BLACK);
                    blackColor = false;
                } else {
                    g.setColor(Color.RED);
                    blackColor = true;
                }
                
                g.fillArc(x, y, length, width, j, 18);
            }
            blackColor = !blackColor;
        }
        //draw final two solid colord circles in the middle
        g.setColor(Color.RED);
        g.fillOval(260, 260, 80, 80);
        g.setColor(Color.BLACK);
        g.fillOval(275, 275, 50, 50);
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void setup() {
        // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    /**
     *
     */
    public void loop() {

    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {

        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {

        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        loop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        DartBoardDrawing game = new DartBoardDrawing();
    }
}
