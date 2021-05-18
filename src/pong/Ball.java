/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Williams
 */
public class Ball {

    private int x;
    private int y;
    private int dx=1;
    private int dy=1;
    private static int score1,score2;
    private static boolean fin;

    public static void finjuego(boolean fin) {
        Ball.fin = fin;
    }
    public static boolean fin(){
        return fin;
    }
    public static int getScore1() {
        return score1;
    }

    public static int getScore2() {
        return score2;
    }
        
    public Ball(int x, int y){
        this.x=x;
        this.y=y; 
    }
    public Rectangle2D getPelota(){        
        return new Rectangle2D.Double(x,y,15,15);
    }

    public void Mover(Rectangle limites, boolean padel,boolean padel2){       
        x+=dx;
        y+=dy;
        if(padel){
            dx=-dx;
            x=(int) (limites.getMaxX()-26);
        }else{
            if(x>limites.getMaxX()-16){
                x=500;
                y=250; 
                score1++;
             }  
        }                                                    
        if(padel2){
            dx=-dx;
            x=(int) (limites.getMinX()+10);
        }else{
            if(x<0){
                x=500;
                y=250; 
                score2++;
             }  
        }                           
        if(y>limites.getMaxY()-20){
            dy-=1;
        }      
        if(y<0){
            dy=-dy;
        }
    }                
}
