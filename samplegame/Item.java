package com.mycompany.samplegame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Item extends Thread {
    int x,y;
    int width;
    
    public Item (int width){
        this.width = width;
        y = new Random().nextInt(width-50);
        x = width-50;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
    }
    
    public void run(boolean play){
        while(x-10>=0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            }
        x = x-10;
        }
        play=false;
    }
}

