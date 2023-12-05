/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imaje_p;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author axel77755
 */
public class TestBuffer extends JPanel {

   public void paint(Graphics g) {
      //Image img = createImageWithText();
      Image img = dibujarFigura();      
      g.drawImage(img, 20,20,this);
   }

   private Image createImageWithText() {
      BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
      Graphics g = bufferedImage.getGraphics();

      g.drawString("www.tutorialspoint.com", 20,20);
      g.drawString("www.tutorialspoint.com", 20,40);
      g.drawString("www.tutorialspoint.com", 20,60);
      g.drawString("www.tutorialspoint.com", 20,80);
      g.drawString("www.tutorialspoint.com", 20,100);
      
      return bufferedImage;
   }
    private Image dibujarFigura(){
        BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
        
        
        for(int x=25; x<110;x++){
            int r=228,b=124;
            for(int y=15; y<100; y++){
                Color color = new Color(r,0,b);
                r--;
                b--;
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }
        return bufferedImage;
    }
}
