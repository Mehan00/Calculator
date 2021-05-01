
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

;public class MainClass {
    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable(){
            public void run(){
                CalculatorClass cc =new CalculatorClass("Calculator");
                cc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
                cc.setVisible(true);
                
                
            }
        });
    }
    
}
