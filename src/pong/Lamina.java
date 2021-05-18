/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import pong.Ball;

/**
 *
 * @author Williams
 */
public class Lamina extends JPanel implements KeyListener {
    Ball pelota = new Ball(500, 290);
    Padel padel = new Padel(990,220);
    Padel padel2 = new Padel(0,220);
    
    public Lamina (){
        setBackground(Color.BLACK);

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;  
        g2.setColor(Color.WHITE);
        dibujarpuntaje(g2);
        dibujar(g2);
        actualizar();
        
    }  
    
    public void dibujar(Graphics2D g){
        g.fill(pelota.getPelota());
        g.fill(padel.getPadel());
        g.fill(padel2.getPadel());
        g.fillRect(500,0, 3, 600);
    }
    public void dibujarpuntaje(Graphics2D g){
        Font score=new Font("Arial", Font.BOLD,35); 
        g.setFont(score);
        g.drawString(String.valueOf(Ball.getScore1()), 400, 30);
        g.drawString(String.valueOf(Ball.getScore2()), 590, 30);
        if(Ball.getScore2()==5){
            g.drawString("Player  2 Win", 390,150);
            Ball.finjuego(true);
        }
        if(Ball.getScore1()==5){
            g.drawString("Player  1 Win", 390,150);
            Ball.finjuego(true);
        } 
    }
    public void actualizar(){
        pelota.Mover(getBounds(),impacto(padel.getPadel()),impacto(padel2.getPadel()));
        padel.MoverPadel(getBounds());
        padel2.MoverPadel2(getBounds());   
    }
    private boolean impacto(Rectangle2D r){
        return pelota.getPelota().intersects(r);
    }

    @Override
    public void keyTyped(KeyEvent e) {    
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if(e.getKeyCode()==83){
             padel2.sets(true);
         }
         if(e.getKeyCode()==87){
             padel2.setW(true);
         }
         if(e.getKeyCode()==38){
             padel.setUp(true);
         }
          if(e.getKeyCode()==40){
             padel.setDown(true);
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==83){
             padel2.sets(false);
         }
         if(e.getKeyCode()==87){
             padel2.setW(false);
         }
         if(e.getKeyCode()==38){
             padel.setUp(false);
         }
          if(e.getKeyCode()==40){
             padel.setDown(false);
         }
    }
       
}
