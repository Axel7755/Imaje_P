/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author axel77755
 */
public class JFrameImg extends JFrame {
     private JLabel lbImagen;

    public JFrameImg(Image imagen) {
        super("imagen");
        inicializarComponentes(imagen);
    }

    


    private void inicializarComponentes(Image imagen) {
        this.lbImagen = new JLabel();
        add(this.lbImagen);
        this.lbImagen.setIcon(new ImageIcon(imagen));
        setSize(imagen.getWidth(this),imagen.getHeight(this));
        setVisible(true);
        
    }
}
