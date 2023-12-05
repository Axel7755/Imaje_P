/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imaje_p;

import GUI.JFrameImg;
import herramientas.HerramientasImagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author axel77755
 */
public class OperacionesBasicas {

    private static int validar(int color) {
        if (color > 255) return 255;
        if (color < 0) return 0;
        return color;
    }
    
    public OperacionesBasicas(){
        
    }
    public static Image escaladeGrises(Image imagen){
                
        BufferedImage bufim = HerramientasImagen.toBufferedImage(imagen);
        
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                int prom = (col.getRed()+col.getGreen()+col.getBlue())/3;
                Color nuevo = new Color(prom,prom,prom);
                bufim.setRGB(x, y, nuevo.getRGB());
            }
        }
        imagen = HerramientasImagen.toImage(bufim);
        return imagen;
    }
    
    public static Image modificarIluminacion(Image imagen, int m){
                
        BufferedImage bufim = HerramientasImagen.toBufferedImage(imagen);
        
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                
                col = new Color(validar(col.getRed()+m),validar(col.getGreen()+m),validar(col.getBlue()+m));
                bufim.setRGB(x, y, col.getRGB());
            }
        }
        imagen = HerramientasImagen.toImage(bufim);
        return imagen;
    }
    
    public static Image calido(Image imagen, int m){
                
        BufferedImage bufim = HerramientasImagen.toBufferedImage(imagen);
        
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                
                col = new Color(validar(col.getRed()+m),col.getGreen(),validar(col.getBlue()-m));
                bufim.setRGB(x, y, col.getRGB());
            }
        }
        imagen = HerramientasImagen.toImage(bufim);
        return imagen;
    }
    
    public static Image frio(Image imagen, int m){
                
        BufferedImage bufim = HerramientasImagen.toBufferedImage(imagen);
        
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                
                col = new Color(validar(col.getRed()-m),col.getGreen(),validar(col.getBlue()+m));
                bufim.setRGB(x, y, col.getRGB());
            }
        }
        imagen = HerramientasImagen.toImage(bufim);
        return imagen;
    }
    
    public static Image negativo(Image imagen){
        BufferedImage bufim = HerramientasImagen.toBufferedImage(imagen);
        
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                Color nuevo = new Color(255-col.getRed(),255-col.getGreen(),255-col.getBlue());
                bufim.setRGB(x, y, nuevo.getRGB());
            }
        }
        imagen = HerramientasImagen.toImage(bufim);
        return imagen;
    }
}
