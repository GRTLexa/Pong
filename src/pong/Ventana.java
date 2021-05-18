/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author Williams
 */
public class Ventana extends JFrame{
    public static void main(String[] args) {
        Ventana ventana=new Ventana();           
    }  
    private Lamina tablero;
    private Hilo hilo;
    
    public Ventana() {       
        try {
            setSize(1016,600);
            setTitle("Pong");
            setIconImage(new ImageIcon(getClass().getResource("/img/Icon.png")).getImage());
            setResizable(false);
            setLocationRelativeTo(null);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            tablero = new Lamina();
            addKeyListener(tablero);
            add(tablero);
            Thread.sleep(3000);
            hilo=new Hilo(tablero);
            hilo.run();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       
}


