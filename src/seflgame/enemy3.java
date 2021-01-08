/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seflgame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import pkg2dgamesframework.AFrameOnImage;
import pkg2dgamesframework.Animation;
import pkg2dgamesframework.Objects;

/**
 *
 * @author ASUS
 */
class enemy3 extends Objects{
    
    public static int STAGE = 0;
    private static final int ALIVE = 0;
    private static final int DEAD = 1;
    
    private BufferedImage left;
    private final Animation left_anim;
//    private BufferedImage die;
//    private final Animation die_anim;
    private static final float SPEED = (float) 10.0;
    private int time_dead;
    
    private boolean dead;
    
    enemy3(int x, int y){
        super(x,y,220,300);
        time_dead = 0;
        try {
            left = ImageIO.read(new File("Assets/enemy3.png"));
            //die = ImageIO.read(new File("Assets/enemy_die.png"));
        } catch (IOException ex) {}
        STAGE = ALIVE;
        left_anim = new Animation(25);
        //die_anim = new Animation(50);
        dead = false;
        
        for(int i = 11; i >= 0; i--){
            AFrameOnImage f = new AFrameOnImage(i*540, 0, 540, 439);
            left_anim.AddFrame(f);
        }
        for(int i = 15; i >= 0; i--){
            AFrameOnImage f = new AFrameOnImage(i*540, 0, 540, 439);
            //die_anim.AddFrame(f);
        }
//        System.out.print("X = ");
//        System.out.print(this.getPosX());
//        System.out.print("Y = ");
//        System.out.print(this.getPosY());
//        System.out.print("\n");
    }
    public void is_dead()
    {
        this.dead = true;
    }
    public int getx(){
        return (int)this.getPosX() + 60;
    }
    public int gety(){
        return (int)this.getPosY() + 150;
    }
    public void update_enemy(long deltaTime){
        left_anim.Update_Me(deltaTime);
        //die_anim.Update_Me(deltaTime);
        this.decreasePosX(SPEED);
    }
    public void paint_enemy(Graphics2D g2){
        left_anim.PaintAnims((int)this.getx(),(int)this.gety(), left, g2, 0, 0);
//        g2.setColor(Color.red);
//        g2.setStroke(new BasicStroke(4));
//        g2.drawRect((int)this.getPosX()+240, (int)this.getPosY()+190, (int)this.getW(), (int)this.getH());
    }
    
}
