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
public class Padel{
    private double y;
    private int x;
    boolean s,w,up,down;
    
    public Padel(int x, int y){       
        this.x=x;
        this.y=y;
    }
    public void sets(boolean s){
        this.s=s;
    }

    public void setW(boolean w) {
        this.w = w;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public Rectangle2D getPadel(){        
        return new Rectangle2D.Double(x,y,10,70);
    }
    public void MoverPadel(Rectangle limites){
        if(down && y<limites.getMaxY()-70){
            y+=0.58;
        }
        if(up && y>0){
            y-=0.58;
        }
    }
    public void MoverPadel2(Rectangle limites){
        if(s && y<limites.getMaxY()-70){
            y+=0.58;
        }
        if(w && y>0){
            y-=0.58;
        }
    }

}
