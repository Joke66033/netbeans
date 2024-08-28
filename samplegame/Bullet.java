package com.mycompany.samplegame;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.lang.System.Logger;
import java.util.Random;
import java.util.logging.Level;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Bullet extends Thread {
    int x,y;
    int width;
    boolean play =true;
    
    
    public Bullet (int width , int x){
        this.width = width;
//        Random random = new Random();
//        y = new Random().nextInt(width-50);
        y = width-50;
//        x = width-50/2;
        this.x=x;
        createSound();
        
    }
    
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x, y, 5, 10);
        
    }
    
    public void run(){
        while(y-10>=0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
            }
        y = y-10;
//        System.out.println(x+"  "+y);
        }
        play = false;
        
        
    }
    
    public void createSound(){
        try{
            File soundFile=new File("D:\\work Aj.Wijitra\\sound\\2.wav");
            AudioInputStream adioln=AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(adioln);
            clip.start();
        }
        catch(Exception ex){
        }
    }
    
}

