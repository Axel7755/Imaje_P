/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author axel77755
 */
public class ImagenConvolucion extends JPanel{
    private BufferedImage backgroundImage;

    public ImagenConvolucion(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ImagenConvolucion(Image imagePath) {
        try {
            backgroundImage = herramientas.HerramientasImagen.toBufferedImage(imagePath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setBackgroundImage(Image imagePath) {
        try {
            backgroundImage = herramientas.HerramientasImagen.toBufferedImage(imagePath);
            repaint(); // Repintar el panel para mostrar la nueva imagen de fondo
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
