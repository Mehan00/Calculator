import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CalculatorClass extends JFrame implements ActionListener {
    private JPanel p;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bsum, bplus, bminus, bdziel, bmnoz, bc, bkropka ,bcofnij;
    private JTextField tf;
    private JLabel l;
    private String msg = "ERROR";
    private String foncik = "Arial";
    
    public CalculatorClass(String title)
    {
        super(title);
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setSize(250,380);
        setLocation(dim.width/4, dim.height/4);
        setResizable(false);
    
        p = new JPanel();
        setContentPane(p);
        
        tf = new JTextField(12);
        tf.setEditable(false);
        l = new JLabel();
        l.setVisible(false);
 
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
 
        bsum = new JButton("=");
 
        bplus = new JButton("+");
        bminus = new JButton("-");
        bdziel = new JButton("/");
        bmnoz = new JButton("*");
        bc = new JButton("C");
        bkropka = new JButton(".");
        bcofnij = new JButton("<-");
 
        p.add(tf);
        p.add(bcofnij);
        p.add(bc);
        p.add(bsum);

        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bdziel);
        
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bmnoz);
        
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bminus);
      
        p.add(b0);
        p.add(bkropka); 
        p.add(bplus);
        add(l);

        
        b0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText(tf.getText()+"0");
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText(tf.getText()+"1");
            }  
        });
        
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText(tf.getText()+"2");
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText(tf.getText()+"3");
            }
        });
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText(tf.getText()+"4");
            }
        });
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText(tf.getText()+"5");
            }
        });
        b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText(tf.getText()+"6");
            }
        });
        b7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText(tf.getText()+"7");
            }
        });
        b8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText(tf.getText()+"8");
            }
        });
        b9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText(tf.getText()+"9");
            }
        });

        bplus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                num = Double.parseDouble(tf.getText());
                temp = 1;
                tf.setText("");
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,msg);
                    tf.setText("");
                }
            }
        });
        bminus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                num = Double.parseDouble(tf.getText());
                temp = 2;
                tf.setText("");
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,msg);
                    tf.setText("");
                }
                
            }
        });
        bdziel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                num = Double.parseDouble(tf.getText());
                temp = 3;
                tf.setText("");
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,msg);
                    tf.setText("");
                }
            }
            
        });
        bmnoz.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                num = Double.parseDouble(tf.getText());
                temp = 4;
                tf.setText("");
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,msg);
                    tf.setText("");
                }
            }
        });
        bc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("");
            }
        });
        bkropka.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText(tf.getText()+".");
            }
        });
        bcofnij.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int dl = tf.getText().length();
                int number= tf.getText().length()-1;
                String bufor;
                if(dl > 0){
                    StringBuilder back = new StringBuilder(tf.getText());
                    back.deleteCharAt(number);
                    bufor=back.toString();
                    tf.setText(bufor);
                }
            }
        });
        bsum.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    operacje() ;
                } catch (arytmetycznyExcept e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null,"Dzielenie przez 0");
                    tf.setText("");
                }
                
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,msg);
                    tf.setText("");
                }
            }
        });
               
        //b0.setPreferredSize(new Dimension(85, 30));
        tf.setPreferredSize(new Dimension(85, 50));
        tf.setHorizontalAlignment(SwingConstants.RIGHT);
        tf.setFont(new Font(foncik, Font. PLAIN, 20));

        b0.setPreferredSize(new Dimension(104, 50));
        b0.setFont(new Font(foncik, Font. PLAIN, 20));

        b1.setPreferredSize(new Dimension(50, 50));
        b1.setFont(new Font(foncik, Font. PLAIN, 20));

        b2.setPreferredSize(new Dimension(50, 50));
        b2.setFont(new Font(foncik, Font. PLAIN, 20));

        b3.setPreferredSize(new Dimension(50, 50));
        b3.setFont(new Font(foncik, Font. PLAIN, 20));

        b4.setPreferredSize(new Dimension(50, 50));
        b4.setFont(new Font(foncik, Font. PLAIN, 20));

        b5.setPreferredSize(new Dimension(50, 50));
        b5.setFont(new Font(foncik, Font. PLAIN, 20));

        b6.setPreferredSize(new Dimension(50, 50));
        b6.setFont(new Font(foncik, Font. PLAIN, 20));

        b7.setPreferredSize(new Dimension(50, 50));
        b7.setFont(new Font(foncik, Font. PLAIN, 20));

        b8.setPreferredSize(new Dimension(50, 50));
        b8.setFont(new Font(foncik, Font. PLAIN, 20));

        b9.setPreferredSize(new Dimension(50, 50));
        b9.setFont(new Font(foncik, Font. PLAIN, 20));

        bplus.setPreferredSize(new Dimension(50, 50));
        bplus.setFont(new Font(foncik, Font. PLAIN, 20));

        bminus.setPreferredSize(new Dimension(50, 50));
        bminus.setFont(new Font(foncik, Font. PLAIN, 20));

        bdziel.setPreferredSize(new Dimension(50, 50));
        bdziel.setFont(new Font(foncik, Font. PLAIN, 20));

        bmnoz.setPreferredSize(new Dimension(50, 50));
        bmnoz.setFont(new Font(foncik, Font. PLAIN, 20));

        bc.setPreferredSize(new Dimension(50, 50));
        bc.setFont(new Font(foncik, Font. PLAIN, 20));

        bcofnij.setPreferredSize(new Dimension(50, 50));
        bcofnij.setFont(new Font(foncik, Font. PLAIN, 15));

        bsum.setPreferredSize(new Dimension(104, 50));
        bsum.setFont(new Font(foncik, Font. PLAIN, 20));

        bkropka.setPreferredSize(new Dimension(50, 50));
        bkropka.setFont(new Font(foncik, Font. PLAIN, 20));
        
    }

    double num,wynik;
    int temp ;
    Double num1 = num;
    double inf = 1.0/0.0;
    double inf1 = -1.0/0.0;
    double none= 0.0/0.0;
    
    public void operacje() throws arytmetycznyExcept
    {
        
        switch(temp)
        {
            case 1:
                try{
                    wynik = num + Double.parseDouble(tf.getText());
                    tf.setText(Double.toString(wynik));
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,msg);
                    tf.setText("");
                }
                break;

            case 2:
                try{
                    wynik = num - Double.parseDouble(tf.getText());
                    tf.setText(Double.toString(wynik));
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,msg);
                    tf.setText("");
                }
                break;

            case 3:
                    wynik = num / Double.parseDouble(tf.getText());
                    if(wynik == inf || wynik == inf1){
                        tf.setText("");
                        throw new arytmetycznyExcept();
                    }
                    else  tf.setText(Double.toString(wynik));
                break;

            case 4:
                try{
                    wynik = num * Double.parseDouble(tf.getText());
                    tf.setText(Double.toString(wynik));
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,msg);
                    tf.setText("");
                }
                break;
            default:
                break;   
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}

class arytmetycznyExcept extends Exception{
    public arytmetycznyExcept(){
        super("Dzielenie przez 0");
    }
}



    

    