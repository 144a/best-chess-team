package Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public class Panel_manager  implements ActionListener , MouseListener
{
    String[] xy = new String[2];
    String[] newxy = {"A","1"};
    ActionEvent event;
    JTextArea textArea = new JTextArea();
    JFrame window = new JFrame("Mult Pan");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton click = new JButton("Click");
    JLabel text = new JLabel("Button is clicked ");
    JTextField textField = new JTextField();
    //JTextArea textArea = new JTextArea();
    //Button b = new Button("Sub");
    static Graphics2D g2D;

    Panel_manager()
    {
        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.GREEN);
        //panel2.add(click);
        textArea.setText("HEYY");
        textArea.setLocation(250,250);
        textArea.setPreferredSize(new Dimension(100,20));

        textField.setSize(100,100);
        textField.setPreferredSize( new Dimension(100,20));
        textField.setLocation(300,300);
        //panel2.add(textArea);
        //panel2.add(textField);

        //GUI1 gu = new GUI1();
        //panel1.add(gu);
        GU1 gu1 = new GU1();
        GU2 gu2 = new GU2();
        //mouse m = new mouse();
        panel1.add(gu1);
        //panel2.add(gu2);
        //panel2.add(gu2.textArea);
        //panel2.add(gu2.b);
        //panel1.add(m);
        panel1.addMouseListener(this);

        //b.addActionListener(this);

        window.add(panel1,BorderLayout.CENTER);
        window.add(panel2,BorderLayout.PAGE_END);

        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }


    public String[] reloc (int[] rawco)
    {

        Map<Integer, String> ht = new HashMap<Integer, String>();
        ht.put(1,"A");ht.put(2,"B");ht.put(3,"C");ht.put(4,"D");ht.put(5,"E");
        ht.put(6,"F");ht.put(7,"G");ht.put(8,"H");
        for (int key:ht.keySet())
        {
            if (key == rawco[0])
            {
                //System.out.println(" result of " + ht.get(key));
                xy[0] = ht.get(key).toString() ;
            }
        }

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(1,8);hm.put(2,7);hm.put(3,6);hm.put(4,5);
        hm.put(5,4);hm.put(6,3);hm.put(7,2);hm.put(8,1);


        for (int key:hm.keySet()) {
            if (key == (rawco[1]))
            {
                //System.out.println(" result of " + hm.get(key));
                xy[1] = hm.get(key).toString();
            }
        }

        //System.out.println(" the list "+Arrays.toString(xy));



        return xy;
    }
    public String[]  get_xy()
    {
        //System.out.println(Arrays.toString(xy));
        //System.out.println("rom get "+ String.valueOf(Arrays.toString(xy)).replace("[","")
        //        .replace(",","").replace("]","").replace(" ",""));
        if (xy != null) {
            newxy =  xy;
        }

        return newxy;
    }
String enters = "";
 public String enter()
 {
     return enters;
 }
    @Override
    public void actionPerformed(ActionEvent event)
    {


    }

    int count = 0 ;

    @Override
    public void mouseClicked(MouseEvent e)
    {
        count++;
        //System.out.println(e.getX());

        int x=e.getX(); // GETS X COORDINATE OF MOUSE-CLICK
        int y=e.getY();  // GETS Y COORDINATE OF MOUSE-CLICK
        int [] Location ={x,y};
        //System.out.println(x+","+y);

        int col = (Location[0])/40;// TRANSLATES X -COORDINATE .....
        // TO BOARD (TILE)COORDINATES
        int row =(Location[1])/40;
        //System.out.println("row: "+row+","+" col : "+col);

        int [] trun = {col,row};
        //System.out.println(Arrays.toString(trun));
        reloc (trun);
        Piece click1 = null;
        Square click2 = null;
        String click1s =  String.valueOf(Arrays.toString(get_xy())).replace("[","")
                .replace(",","").replace("]","").replace(" ","");;
        String click2s;

        humanPlayer hp = new humanPlayer(Engine.Color.WHITE);
        if (count ==1 )
        {

            String.valueOf(Arrays.toString(get_xy())).replace("[","")
                   .replace(",","").replace("]","").replace(" ","");
        }
        if (count == 2)
        {
             click2s =
            String.valueOf(Arrays.toString(get_xy())).replace("[","")
                    .replace(",","").replace("]","").replace(" ","");


            //hp.move(hp.smo(click1s),hp.smo2(click2s));
        }
        if (count < 2)
        {
            count = 0;
        }



    }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



}
