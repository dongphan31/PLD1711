/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seflgame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import pkg2dgamesframework.AFrameOnImage;
import pkg2dgamesframework.Animation;
import static pkg2dgamesframework.GameScreen.KEY_PRESSED;
import static pkg2dgamesframework.GameScreen.KEY_RELEASED;
import pkg2dgamesframework.Objects;

/**
 *
 * @author ASUS
 */
class character extends Objects{
    public static int STAGE = 0;
    private static final int IDLE_RIGHT = 0;
    private static final int IDLE_LEFT = 1;
    private static final int RUN_LEFT = 2;
    private static final int RUN_RIGHT = 3;
    private static final int UP_RIGHT = 4;
    private static final int DOWN_RIGHT = 5;
    private static final int UP_LEFT = 6;
    private static final int DOWN_LEFT = 7;
    private static final int KNIFE_RIGHT = 8;
//    private static final int FIRE_IDLE = 9;
//    private static final int JUMP = 10;
    private static final int KNIFE_LEFT = 11;
    private static final int RUN_UP_RIGHT = 12;
    private static final int RUN_DOWN_RIGHT = 13;
    private static final int RUN_UP_LEFT = 14;
    private static final int RUN_DOWN_LEFT = 15;
//    private static final int RUN_KNIFE_RIGHT = 16;    
    private static final float SPEED = (float) 20.0;
    private boolean up;
    private boolean right;
    private boolean left;
    private boolean down;
    private boolean knife;   
    private static int HP ;      
    private BufferedImage idle_right;
    private Animation idle_right_anim;
    private BufferedImage idle_left;
    private Animation idle_left_anim;
    private BufferedImage run_right;
    private Animation run_right_anim;
    private BufferedImage run_left;
    private Animation run_left_anim;
    private BufferedImage knife_right;
    private Animation knife_right_anim;
    private BufferedImage knife_left;
    private Animation knife_left_anim;
    private BufferedImage run_knife_right;
    private Animation run_knife_right_anim;
    
    
    public character(int x, int y){
        super(x, y , 430, 570);
        
        try {
            idle_right = ImageIO.read(new File("Assets/idle.png"));
            idle_left = ImageIO.read(new File("Assets/idle_left.png"));
            run_right = ImageIO.read(new File("Assets/run_right.png"));
            run_left = ImageIO.read(new File("Assets/run_left.png"));
            knife_right = ImageIO.read(new File("Assets/knife_right.png"));
            knife_left = ImageIO.read(new File("Assets/knife_left.png"));
            run_knife_right = ImageIO.read(new File("Assets/run_knife_right.png"));
        } catch (IOException ex) {}
        
        HP = 10;
        
        idle_right_anim = new Animation(25);
        idle_left_anim = new Animation(25);
        run_right_anim = new Animation(25);
        run_left_anim = new Animation(25);
        knife_right_anim = new Animation(10);
        knife_left_anim = new Animation(10);
        run_knife_right_anim = new Animation(10);
        
        
        for(int i = 0; i < 18; i++){
            AFrameOnImage f = new AFrameOnImage(i*920, 0, 920, 920);//sprite
            idle_right_anim.AddFrame(f);
        }
        for(int i = 17; i >= 0; i--){
            AFrameOnImage f = new AFrameOnImage(i*920, 0, 920, 920);
            idle_left_anim.AddFrame(f);
        }
        for(int i = 0; i < 12; i++){
            AFrameOnImage f = new AFrameOnImage(i*920, 0, 920, 920);
            run_right_anim.AddFrame(f);
        }
        for(int i = 11; i >= 0; i--){
            AFrameOnImage f = new AFrameOnImage(i*920, 0, 920, 920);
            run_left_anim.AddFrame(f);
        }
        for(int i = 0; i < 12; i++){
            AFrameOnImage f = new AFrameOnImage(i*920, 0, 920, 920);
            knife_right_anim.AddFrame(f);
        }
        for(int i = 11; i >= 0; i--){
            AFrameOnImage f = new AFrameOnImage(i*920, 0, 920, 920);
            knife_left_anim.AddFrame(f);
        }
        for(int i = 0; i < 12; i++){
            AFrameOnImage f = new AFrameOnImage(i*920, 0, 920, 920);
            run_knife_right_anim.AddFrame(f);
        }        
        
    }
    public void decreaseHP(int a){
        this.HP -= a;
    }
    public int get_HP()
    {
        return this.HP;
    }
    public boolean is_zero_HP(){
        if(this.HP == 0)
            return true;
        else return false;
    }
    public boolean is_knife(){
        return knife;
    }
    public void update_among(long deltaTime){
        idle_right_anim.Update_Me(deltaTime);
        idle_left_anim.Update_Me(deltaTime);
        run_right_anim.Update_Me(deltaTime);
        run_left_anim.Update_Me(deltaTime);
        knife_right_anim.Update_Me(deltaTime);
        knife_left_anim.Update_Me(deltaTime);
        run_knife_right_anim.Update_Me(deltaTime);
    }
    public void paint_among(Graphics2D g2){
        switch(STAGE){
            case IDLE_RIGHT:
                idle_right_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), idle_right, g2, 0, 0);
                break;
            case IDLE_LEFT:
                idle_left_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), idle_left, g2, 0, 0);
                break;
            case RUN_RIGHT:
                run_right_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), run_right, g2, 0,0);
                break;
            case RUN_LEFT:
                run_left_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), run_left, g2, 0,0);
                break;
            case UP_RIGHT:
                run_right_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), run_right, g2, 0,0);
                break;
            case UP_LEFT:
                run_left_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), run_left, g2, 0,0);
                break;
            case DOWN_RIGHT:
                run_right_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), run_right, g2, 0,0);
                break;
            case DOWN_LEFT:
                run_left_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), run_left, g2, 0,0);
                break;
            case KNIFE_RIGHT:
                knife_right_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), knife_right, g2, 0,0);
                break;
            case KNIFE_LEFT:
                knife_left_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), knife_left, g2, 0,0);
                break;
            case RUN_UP_RIGHT:
                run_right_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(),run_right, g2, 0,0);
                break;
            case RUN_DOWN_RIGHT:
                run_right_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), run_right, g2, 0,0);
                break;
            case RUN_UP_LEFT:
                run_left_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), run_left, g2, 0,0);
                break;
            case RUN_DOWN_LEFT:
                run_left_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), run_left, g2, 0,0);
                break; 
//            case RUN_KNIFE_RIGHT:
//                run_knife_right_anim.PaintAnims((int)this.getPosX(), (int)this.getPosY(), run_knife_right, g2, 0,0);
//                break;
        }
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(4));
        g2.drawRect((int)this.getPosX()+240, (int)this.getPosY()+190, (int)this.getW(), (int)this.getH());
    }
    public boolean check_limit(){
        if(this.getx()>=-240 && this.getx() <= 3800-240 && this.gety() >= 250 && this.gety() <= 1210)
        {
            System.out.print("X = ");
            System.out.print(this.getx());
            System.out.print("Y = ");
            System.out.print(this.gety());
            System.out.print("\n");
           // System.out.println("END LEFT");
            return true;
        }
        else
        {
            System.out.print("NewX = ");
            System.out.println(this.getPosX());
            System.out.print("NewY = ");
            System.out.println(this.getPosY());
            if(this.getx() <= -240 && this.gety() <= 250)
            {   
                this.setPosX(- 480);
                this.setPosY(60);
            }
            else if(this.getx() <= -240 && this.gety() >= 1210)
            {
                this.setPosX(- 480);
                this.setPosY(1020);
            }
            else if(this.getx() >= 3800 -240 && this.gety() <= 250)
            {
                this.setPosX(3320);
                this.setPosY(60);
            }
            else if(this.getx() >= 3800 -240 && this.gety() >= 1210)
            {
                this.setPosX(3320);
                this.setPosY(1020);
            }
            else if(this.getx() >= 3800 -240)
                this.setPosX(3320);
            else if(this.gety() <= 250)
                this.setPosY(60);
            else if(this.gety() >= 1210)
                this.setPosY(1020);
            else if(this.getx() <= -240)
            {
                this.setPosX(- 480);
            }
                                        
        }
        return false;
    }
    public int getx(){
        return (int)this.getPosX() + 240;
    }
    public int gety(){
        return (int)this.getPosY() + 190;
    }
    public boolean CollisionHappenWith(float x, float y, float w, float h){
        if( x < this.getPosX() + this.getW() && x + w > this.getPosX() && y < this.getPosY() + 120 + this.getH() && h + y > this.getPosY() + 120)
            return true;
        return false;
    }
    
    public void key_among(KeyEvent e, int Event){
//        System.out.print("X = ");
//        System.out.print(this.getPosX());
//        System.out.print("Y = ");
//        System.out.print(this.getPosY());
//        System.out.print("\n");
        if(Event == KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = true;
        }
        if(Event == KEY_RELEASED && e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = false;
        }
        if(Event == KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_LEFT){
            left = true;
        }
        if(Event == KEY_RELEASED && e.getKeyCode() == KeyEvent.VK_LEFT){
            left = false;
        }
        if(Event == KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_UP){
            up = true;
        }
        if(Event == KEY_RELEASED && e.getKeyCode() == KeyEvent.VK_UP){
            up = false;
        }
        if(Event == KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_DOWN){
            down = true;
        }
        if(Event == KEY_RELEASED && e.getKeyCode() == KeyEvent.VK_DOWN){
            down = false;
        }
        if(Event == KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_SPACE){
            knife = true;
        }
        if(Event == KEY_RELEASED && e.getKeyCode() == KeyEvent.VK_SPACE){
            knife = false;
        }
        switch(STAGE){
            case IDLE_RIGHT:
                if(right == true && left == false && up ==false && down == false)
                    STAGE = RUN_RIGHT;
                if(right == true && left == false && up ==true && down == false)
                    STAGE = RUN_UP_RIGHT;
                if(right == true && left == false && up ==false && down == true)
                    STAGE = RUN_DOWN_RIGHT;    
                if(right == false && left == true && up ==false && down == false)
                    STAGE = IDLE_LEFT;
                if(right == false && left == false && up ==true && down == false)
                    STAGE = UP_RIGHT;
                if(right == false && left == false && up ==false && down == true)
                    STAGE = DOWN_RIGHT;
                if(knife == true)
                    STAGE = KNIFE_RIGHT;
                break;
            case IDLE_LEFT:
                if(right == true && left == false && up ==false && down == false)
                    STAGE = IDLE_RIGHT;
                if(right == false && left == true && up ==true && down == false)
                    STAGE = RUN_UP_LEFT;
                if(right == false && left == true && up ==false && down == true)
                    STAGE = RUN_DOWN_LEFT;    
                if(right == false && left == true && up ==false && down == false)
                    STAGE = RUN_LEFT;
                if(right == false && left == false && up ==true && down == false)
                    STAGE = UP_LEFT;
                if(right == false && left == false && up ==false && down == true)
                    STAGE = DOWN_LEFT;
                if(knife == true)
                    STAGE = KNIFE_LEFT;
                break;
            case RUN_RIGHT:
                if(check_limit()==true)
                    this.increasePosX(SPEED);
                if(right == false)
                    STAGE = IDLE_RIGHT;
                if(up == true)
                    STAGE = RUN_UP_RIGHT;
                if(down == true)
                    STAGE = RUN_DOWN_RIGHT;
//                if(knife == true)
//                    STAGE = RUN_KNIFE_RIGHT;
                break;
            case RUN_LEFT:
                if(check_limit())
                    this.decreasePosX(SPEED);
                if(left == false)
                    STAGE = IDLE_LEFT;
                if(up == true)
                    STAGE = RUN_UP_LEFT;
                if(down == true)
                    STAGE = RUN_DOWN_LEFT;
                break;
            case UP_RIGHT:
                if(check_limit())
                    this.decreasePosY(SPEED);
                if(up == false)
                    STAGE = IDLE_RIGHT;
                if(right == true)
                    STAGE = RUN_UP_RIGHT;
                break;
            case UP_LEFT:
                if(check_limit())
                    this.decreasePosY(SPEED);
                if(up == false)
                    STAGE = IDLE_LEFT;
                if(left == true)
                    STAGE = RUN_UP_LEFT;
                break;
            case DOWN_RIGHT:
                if(check_limit())
                    this.increasePosY(SPEED);
                if(down == false)
                    STAGE = IDLE_RIGHT;
                if(right == true)
                    STAGE = RUN_DOWN_RIGHT;
                break;
            case DOWN_LEFT:
                if(check_limit())
                    this.increasePosY(SPEED);
                if(down == false)
                    STAGE = IDLE_LEFT;     
                if(left == true)
                    STAGE = RUN_DOWN_LEFT;
                break;
            case KNIFE_RIGHT:
                if(knife == false)
                    STAGE = IDLE_RIGHT;
                break;
            case KNIFE_LEFT:
                if(knife == false)
                    STAGE = IDLE_LEFT;
                break;
            case RUN_UP_RIGHT:
                if(check_limit())
                {
                    this.increasePosX(SPEED/2);
                    this.decreasePosY(SPEED/2);
                }
                if(up == true && right == false)
                    STAGE = UP_RIGHT;
                if(up == false && right == true)
                    STAGE = RUN_RIGHT;
                if(up == false && right == false)
                    STAGE = IDLE_RIGHT;
                break;
            case RUN_DOWN_RIGHT:
                if(check_limit())
                {
                    this.increasePosX(SPEED/2);
                    this.increasePosY(SPEED/2);  
                }
                if(down == true && right == false)
                    STAGE = DOWN_RIGHT;
                if(down == false && right == true)
                    STAGE = RUN_RIGHT;
                if(down == false && right == false)
                    STAGE = IDLE_RIGHT;
                break;
            case RUN_UP_LEFT:
                if(check_limit())
                {
                    this.decreasePosX(SPEED/2);
                    this.decreasePosY(SPEED/2);
                }
                if(up == true && left == false)
                    STAGE = UP_LEFT;
                if(up == false && left == true)
                    STAGE = RUN_LEFT;
                if(up == false && left == false)
                    STAGE = IDLE_LEFT;                
                break;
            case RUN_DOWN_LEFT:
                if(check_limit())
                {
                    this.decreasePosX(SPEED/2);
                    this.increasePosY(SPEED/2);
                }
                if(down == true && left == false)
                    STAGE = DOWN_LEFT;
                if(down == false && left == true)
                    STAGE = RUN_LEFT;
                if(down == false && left == false)
                    STAGE = IDLE_LEFT;
                break;
        }
    }
}
