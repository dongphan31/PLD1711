/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seflgame;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pkg2dgamesframework.GameScreen;
import pkg2dgamesframework.Objects;

/**
 *
 * @author ASUS
 */
class start extends GameScreen implements MouseListener{

    private BufferedImage background;
    private button play;
    private boolean start;
    public start(int x, int y){
        super(x,y);
        addMouseListener(this);
        play = new button(500, 600, 250, 74);
        start = false;
        try {
            background = ImageIO.read(new File("Assets/menu.jpg"));
                    
                    } catch (IOException ex) {
        }
        
    }
    public static void main(String[] args) {
        start start1 = new start(3800,2100);
        start1.start();
    }
    public void start()
    {
        BeginGame();
    }
    public boolean is_start(){
        return start;
    }
    public void paint(Graphics2D g2) {
        g2.drawImage(background,0, 0, (int)this.background.getWidth(), (int)this.background.getHeight(), null);
        play.paint_button(g2);
    }
    public void update(long deltaTime){
        return;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX()>= 265 && e.getX() <= 396 && e.getY() >= 333 && e.getY()<= 369)
        {   
            play.mouseClicked(e);
            start = true;
            this.setVisible(false);
            SeflGame A = new SeflGame();
            A.start();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getX()>= 265 && e.getX() <= 396 && e.getY() >= 333 && e.getY()<= 369)
            play.mousePressed(e);
    }   
    @Override
    public void GAME_UPDATE(long deltaTime) {
       
    }
    @Override
    public void GAME_PAINT(Graphics2D g2) {
        this.paint(g2);
    }

    @Override
    public void KEY_ACTION(KeyEvent e, int Event) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
