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
import pkg2dgamesframework.Objects;

/**
 *
 * @author ASUS
 */
class HP extends Objects {
    private BufferedImage HP_bar;
    private BufferedImage HP_in[];
    private int temp;
    
    public HP(int x, int y){
        super(x,y,512,128);
        HP_in = new BufferedImage[11]; 
        try {
            HP_bar = ImageIO.read(new File("Assets/HP_bar.png"));
            
            HP_in[0] = ImageIO.read(new File("Assets/HP0.png"));
            HP_in[1] = ImageIO.read(new File("Assets/HP1.png"));
            HP_in[2] = ImageIO.read(new File("Assets/HP2.png"));
            HP_in[3] = ImageIO.read(new File("Assets/HP3.png"));
            HP_in[4] = ImageIO.read(new File("Assets/HP4.png"));
            HP_in[5] = ImageIO.read(new File("Assets/HP5.png"));
            HP_in[6] = ImageIO.read(new File("Assets/HP6.png"));
            HP_in[7] = ImageIO.read(new File("Assets/HP7.png"));
            HP_in[8] = ImageIO.read(new File("Assets/HP8.png"));
            HP_in[9] = ImageIO.read(new File("Assets/HP9.png"));
            HP_in[10] = ImageIO.read(new File("Assets/HP10.png"));
        } catch (IOException ex) {}
    }
    public void update_among(long deltaTime){
        
    }
    public void paint_among(Graphics2D g2 , int x, int y , int hp){
       // System.out.println(hp);
        g2.drawImage(HP_in[hp], x , y, this.HP_in[hp].getWidth(), this.HP_in[hp].getHeight()-50, null);
        g2.drawImage(HP_bar, x, y, this.HP_bar.getWidth(), this.HP_bar.getHeight()-50, null);
    }
}
