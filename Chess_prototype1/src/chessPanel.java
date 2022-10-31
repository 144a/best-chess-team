import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

//                      THIS WHERE THE GUI IS CREATED
public class chessPanel extends JPanel implements  ActionListener
{
    /*

     */

    static  int WIDTH = 512;
    static  int HEIGHT = 512;
    static  int DIMENTION = 8;
    static  int    TILE_SIZE = HEIGHT /DIMENTION ;
    static  int   MAX_FPS = 15;
    static String [] pieces = {"wR","wN","wB","wQ","wK","wp","bR","bN","bB","bQ","bK","bp"};
    static Graphics2D g2D;
     Timer timer;

    ImageIcon image;
chessPanel()
{
    /*

     */
    timer = new Timer(5000,this);  // this sets how fast the board .....
                                                // updates/shows the current state of the board
    //timer.start();  // turned off for now
   

    this.setPreferredSize(new Dimension(WIDTH,HEIGHT));   // size of the GUI window

}

    public void paint(Graphics g)
    {
        super.paintComponents(g);
         g2D = (Graphics2D) g;


        // This creates the  checkered pattern BACKGROUND
        for (int r = 0 ; r <DIMENTION;r++)
        {
            for (int c = 0 ; c <DIMENTION;c++)
                {
                    int x =c*TILE_SIZE;                         //
                    int y = r*TILE_SIZE;
                    if ((r + c) %2 == 0)
                    {
                        g2D.setPaint(Color.cyan);
                    }
                    else { g2D.setPaint(Color.PINK);}               //

                    g2D.fillRect(x,y,TILE_SIZE,TILE_SIZE);
                }
        }

        drawImages();







    }

    public void drawImages()                       // Draws the chess pieces...
    {                                               // on top of the board

        int p = 0;
        //String [][] b = chessEngine.board();
        String [][] b = Move.cE.board();
        String ptoS ;
        for (int r = 0 ; r <DIMENTION;r++)
        {
            for (int c = 0; c < DIMENTION; c++)
            {
                //String [][] b = chessEngine.board();
                String piece = b[r][c];
                if (piece != "--" )

                {
                  for (String p2 : pieces) {
                  ptoS = piece;
                        p += 1;
                        image = new ImageIcon("images/" + ptoS + ".png");
                        g2D.drawImage(image.getImage(), c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
                        repaint();
                    }
                }
            }
        }

    }


// this is meant of to redraw the current state of the board...
    // in the GUI window.
    // it is basically the same code as the drawImages() method
// but an instance of the board is used
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int p = 0;
        //chessEngine cE = new chessEngine();
        Move m = new Move();

        int x = Move.startRow;
        int y = Move.startCol;
        int[] sc = {x,y};

        int a =Move.endRow;
        int b = Move.startCol;
        int[] ec = {a,b};

        String[][] cE = m.map(sc,ec);
        String ptoS ;
        for( String r[]:(chessGameFrames.Thismap) )
        {
            System.out.println(Arrays.deepToString(r));
        }
        //System.out.println(Arrays.deepToString(chessGameFrames.Thismap));
        //String[][] cE = chessGameFrames.Thismap;
        for (int r = 0 ; r <DIMENTION;r++)
        {
            for (int c = 0; c < DIMENTION; c++)
            {
                String [][] xb = cE;
                String piece = xb[r][c];
                if (piece != "--" )

                {
                    // for (String p : pieces) {
                    ptoS = piece;
                    p += 1;
                    image = new ImageIcon("images/" + ptoS + ".png");
                    g2D.drawImage(image.getImage(), c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE, null);

                    // }
                }

            }

        }
        repaint();

    }
}
