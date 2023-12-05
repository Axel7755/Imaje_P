/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author axel77755
 */
public class Ruido {
    public static Image agregarRuidoAditivo(Image original, double por){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(original);
        
        int cp = (int)((por/100)*(bi.getHeight()*bi.getWidth()));
        Color aditivo = new Color(255,255,255);
        
        Random ran = new Random();
        int x,y;
        for(int j=0; j<cp; j++){
            x = ran.nextInt(bi.getWidth()-1);
            y = ran.nextInt(bi.getHeight()-1);
            bi.setRGB(x, y, aditivo.getRGB());
        }
        original = herramientas.HerramientasImagen.toImage(bi);
        return original;
    }
    public static Image agregarRuidoSustrativo(Image original, double por){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(original);
        int cp = (int)((por/100)*(bi.getHeight()*bi.getWidth()));
        
        Color sustrativo = new Color(0,0,0);
        
        Random ran = new Random();
        int x,y;
        for(int j=0; j<cp; j++){
            x = ran.nextInt(bi.getWidth()-1);
            y = ran.nextInt(bi.getHeight()-1);
            bi.setRGB(x, y, sustrativo.getRGB());
        }
        original = herramientas.HerramientasImagen.toImage(bi);
        return original;
    }
    public static Image agregarRuidoMezcla(Image original, double porS, double porA){
        BufferedImage bi = herramientas.HerramientasImagen.toBufferedImage(original);
        int cpS = (int)((porS/100)*(bi.getHeight()*bi.getWidth()));
        int cpA = (int)((porA/100)*(bi.getHeight()*bi.getWidth()));
        
        Color adsus = new Color(255,255,255);
        
        Random ran = new Random();
        int x,y;
        for(int j=0; j<cpS; j++){
            x = ran.nextInt(bi.getWidth()-1);
            y = ran.nextInt(bi.getHeight()-1);
            bi.setRGB(x, y, adsus.getRGB());
        }
        adsus = new Color(0,0,0);
        for(int j=0; j<cpA; j++){
            x = ran.nextInt(bi.getWidth()-1);
            y = ran.nextInt(bi.getHeight()-1);
            bi.setRGB(x, y, adsus.getRGB());
        }
        original = herramientas.HerramientasImagen.toImage(bi);
        return original;
    }
}
