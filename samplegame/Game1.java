package com.mycompany.samplegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Game1 extends javax.swing.JFrame implements KeyListener,Runnable {
     Image img;
    int size = 50;
    int x=10;
    int y= 640;
    int x2,y2=30,x4,y4=30;
    Clip clip,clip1,clip2,clip3,clip4;
    int score=0;
    String game="", over="";
    int x3,y3;
    Ball[] ball=new Ball[10];
    Item item;
    Bullet[] bullet = new Bullet[10];

    public Game1() {
        initComponents();
        setSize(700,700);
        setTitle("Play Game");
        img=Toolkit.getDefaultToolkit().createImage("D:\\661463033\\img\\spongbob.png");
        this.addKeyListener(this);
        new Thread(this).start();
        createSound();
        createSound2();
        createSoundwin();
        for(int i=0;i<ball.length;i++){
             ball[i]=new Ball(getWidth());
             new Thread(ball[i]).start();
        }
        item = new Item(getWidth());
        new Thread(item).start();
        
        
    }
    
    public void paint (Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(), getHeight());
        g.drawImage(img,x,y,size,size,this);
        g.setColor(Color.green);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Angsana new",Font.BOLD,50));
        g.drawString(score+"",80, 400);
        g.setColor(Color.green);
        g.setFont(new Font("Angsana new",Font.BOLD,100));
        g.drawString(game,220,400);
        g.setColor(Color.red);
        g.setFont(new Font("Angsana new",Font.BOLD,100));
        g.drawString(over,220,400);
        for(int i=0;i<ball.length;i++){
             ball[i].paint(g);
        }
        item.paint(g);
        for(int i=0;i<bullet.length;i++){
            if(bullet[i] != null) bullet[i].paint(g);
        }
    }
    
    public void createSound(){
        try{
            File soundFile=new File("D:\\work Aj.Wijitra\\sound\\1.wav");
            AudioInputStream adioIn=AudioSystem.getAudioInputStream(soundFile);
            clip1=AudioSystem.getClip();
            clip1.open(adioIn);
        }
        catch(Exception ex){
        }
    }
    
        public void createSoundwin(){
        try{
            File soundFile=new File("D:\\work Aj.Wijitra\\sound\\win.wav");
            AudioInputStream win=AudioSystem.getAudioInputStream(soundFile);
            clip2=AudioSystem.getClip();
            clip2.open(win);
        }
        catch(Exception ex){
        }
    }
        
        public void createSound2(){
        try{
            File soundFile=new File("D:\\work Aj.Wijitra\\sound\\2.wav");
            AudioInputStream win=AudioSystem.getAudioInputStream(soundFile);
            clip4=AudioSystem.getClip();
            clip4.open(win);
        }
        catch(Exception ex){
        }
    }
        
        public void createSoundlost(){
        try{
            File soundFile=new File("D:\\work Aj.Wijitra\\sound\\lost.wav");
            AudioInputStream lost=AudioSystem.getAudioInputStream(soundFile);
            clip3=AudioSystem.getClip();
            clip3.open(lost);
        }
        catch(Exception ex){
        }
    }
        
    public void checkCollission(){
        for(int i=0;i<ball.length;i++){
        if(ball[i] == null) continue;
        Rectangle rPlayer=new Rectangle(x,y,size,size);
        Rectangle rBall=new Rectangle(ball[i].x,ball[i].y,50,50);
        if (rPlayer.intersects(rBall)){
            clip1.loop(1);
            score=score+1;
            size=size+5;
            ball[i] = new Ball(getWidth());
            new Thread(ball[i]).start();
//            repaint();
//            checkBall();
            }
        }
    }
    
    public void createBox1(){
        Random random=new Random();
        x2=random.nextInt(getWidth()-50);
        y2=random.nextInt(getHeight()-50);
    }
    
     public void checkCollission1(){
        Rectangle rPlayer=new Rectangle(x,y,size,size);
        Rectangle rBoxred=new Rectangle(x4,y4,25,25);
        if (rPlayer.intersects(rBoxred)){
            clip4.loop(1);
            score=score-1;
            size=size-5;
            y4=30;
            repaint();
            createBox2();
        }
    }
    
    public void createBox2(){
        Random random=new Random();
        x4=random.nextInt(getWidth()-50);
        y4=random.nextInt(getHeight()-50);
    }
    
    public void checkBall(){
     for(int i=0;i<ball.length;i++){
         if(ball[i].play==false){
             ball[i]=new Ball(getWidth());
             new Thread(ball[i]).start();
         }
     }
 }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game1().setVisible(true);
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    public void createBullet(){
        for(int i=0;i<bullet.length;i++){
            if(bullet[i] == null ){
                 bullet[i] = new Bullet(getWidth(),x+50/2);
                 new Thread(bullet[i]).start();
                 break;
            }
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case 37 : if(x-10>0) {x=x-10;repaint();} break;
            case 38 : if(y-10>30) {y=y-10;repaint();} break;
            case 39 : if(x+10<getWidth()-50) {x=x+10;repaint();} break;
            case 40 : if(y+10<getWidth()-50) {y=y+10;repaint();} break;
            case 32 : createBullet(); break;
        }
//        System.out.println(e.getKeyCode());
//        if(e.getKeyCode()==37)
//            if(x>=20){
//                x=x-10;
//                repaint();
//            }
//        
//        if(e.getKeyCode()==39)
//            if(x<=630){
//                x=x+10;
//                repaint();
//            }
//        
//         checkCollission();
//         checkCollission1();
//          if(score==10){
//                game="You Win";
//                clip2.loop(0);
//          }
//          
//          if(score<=-5){
//                over="Game Over";
//                clip3.loop(0);
//          }
//          
//          if(e.getKeyCode() == 32){
//              createBullet();
//          }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void run() {
         while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game1.class.getName()).log(Level.SEVERE, null, ex);
            }
            checkBall();
            repaint();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
