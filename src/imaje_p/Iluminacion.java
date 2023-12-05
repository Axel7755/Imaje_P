/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imaje_p;

import herramientas.ColoresHitogrmas;
import herramientas.HerramientasImagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author axel77755
 */
public class Iluminacion {
    public static Image iluminacion1(Image gris, int j, int r){
        BufferedImage bufim = HerramientasImagen.toBufferedImage(gris);
        
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                if(col.getBlue()>=j){
                    col = new Color(validar(col.getRed()+r),validar(col.getRed()+r),validar(col.getRed()+r));
                    bufim.setRGB(x, y, col.getRGB());
                }
            }
        }
        gris = HerramientasImagen.toImage(bufim);
        return gris;
    }
    private static int validar(int color) {
        if (color > 255) return 255;
        return color;
    }
}
