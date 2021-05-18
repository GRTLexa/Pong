/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.util.logging.Level;
import java.util.logging.Logger;
import pong.Ball;
/**
 *
 * @author Williams
 */
public class Hilo {
    Lamina tablero;
    public Hilo(Lamina tablero){
        this.tablero=tablero;
    }   
    public void run(){      
        while(!Ball.fin()){
            tablero.repaint();
            try {
                Thread.sleep(1);               
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
