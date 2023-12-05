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
public class Expansion {
    public static Image expansionLineal(Image gris){
        
        ColoresHitogrmas ch = new ColoresHitogrmas(gris);
        BufferedImage bufim = HerramientasImagen.toBufferedImage(gris);
        int minimo = minimo(ch.getAzul());
        int maximo = maximo(ch.getAzul());
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                int I = col.getBlue();
                I=((I-minimo)*(255/(maximo-minimo)));
                col = new Color(validar(I),validar(I),validar(I));
                bufim.setRGB(x, y, col.getRGB());
            }
        }
        gris = HerramientasImagen.toImage(bufim);
        return gris;
    }
    
    public static Image expansionLinealRGB(Image gris){
        
        ColoresHitogrmas ch = new ColoresHitogrmas(gris);
        BufferedImage bufim = HerramientasImagen.toBufferedImage(gris);
        int minr = minimo(ch.getRojo());
        int maxr = maximo(ch.getRojo());
        int ming = minimo(ch.getVerde());
        int maxg = maximo(ch.getVerde());
        int minb = minimo(ch.getAzul());
        int maxb = maximo(ch.getAzul());
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                int Ir = col.getRed();
                int Ig = col.getGreen();
                int Ib = col.getBlue();
                Ir=((Ir-minr)*(255/(maxr-minr)));
                Ig=((Ig-ming)*(255/(maxg-ming)));
                Ib=((Ib-minb)*(255/(maxb-minb)));
                col = new Color(validar(Ir),validar(Ig),validar(Ib));
                bufim.setRGB(x, y, col.getRGB());
            }
        }
        gris = HerramientasImagen.toImage(bufim);
        return gris;
    }
    
    public static Image expansionLogaritmica(Image gris){
        
        ColoresHitogrmas ch = new ColoresHitogrmas(gris);
        BufferedImage bufim = HerramientasImagen.toBufferedImage(gris);
        int minimo = minimo(ch.getAzul());
        int maximo = maximo(ch.getAzul());
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                int I = col.getBlue();
                I=(int)((maximo*Math.log(1+I))/(Math.log(1+maximo)));
                col = new Color(validar(I),validar(I),validar(I));
                bufim.setRGB(x, y, col.getRGB());
            }
        }
        gris = HerramientasImagen.toImage(bufim);
        return gris;
    }
    
    public static Image expansionLogaritmicaRGB(Image gris){
        
        ColoresHitogrmas ch = new ColoresHitogrmas(gris);
        BufferedImage bufim = HerramientasImagen.toBufferedImage(gris);
        int minr = minimo(ch.getRojo());
        int maxr = maximo(ch.getRojo());
        int ming = minimo(ch.getVerde());
        int maxg = maximo(ch.getVerde());
        int minb = minimo(ch.getAzul());
        int maxb = maximo(ch.getAzul());
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                int Ir = col.getRed();
                int Ig = col.getGreen();
                int Ib = col.getBlue();
                Ir=(int)((maxr*Math.log(1+Ir))/(Math.log(1+maxr)));
                Ig=(int)((maxg*Math.log(1+Ig))/(Math.log(1+maxg)));
                Ib=(int)((maxb*Math.log(1+Ib))/(Math.log(1+maxb)));
                col = new Color(validar(Ir),validar(Ig),validar(Ib));
                bufim.setRGB(x, y, col.getRGB());
            }
        }
        gris = HerramientasImagen.toImage(bufim);
        return gris;
    }
    public static Image expansionLineal(Image gris, int r1, int r2){
        
        ColoresHitogrmas ch = new ColoresHitogrmas(gris);
        BufferedImage bufim = HerramientasImagen.toBufferedImage(gris);
        int minimo = 0;
        int maximo = 0;
        if(r2>r1){
            maximo=r2;
            minimo=r1;            
        }else{
            maximo=r1;
            minimo=r2;
        }
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                int I = col.getBlue();
                I=((I-minimo)*(255/(maximo-minimo)));
                col = new Color(validar(I),validar(I),validar(I));
                bufim.setRGB(x, y, col.getRGB());
            }
        }
        gris = HerramientasImagen.toImage(bufim);
        return gris;
    }
    
    public static Image expansionLinealRGB(Image gris,int rr1, int rr2,int rg1, int rg2,int rb1, int rb2){
        
        ColoresHitogrmas ch = new ColoresHitogrmas(gris);
        BufferedImage bufim = HerramientasImagen.toBufferedImage(gris);
        int minr = 0;
        int maxr = 0;
        int ming = 0;
        int maxg = 0;
        int minb = 0;
        int maxb = 0;
        if(rr2>rr1){
            maxr=rr2;
            minr=rr1;            
        }else{
            maxr=rr1;
            minr=rr2;
        }
        if(rg2>rg1){
            maxg=rg2;
            ming=rg1;            
        }else{
            maxg=rg1;
            ming=rg2;
        }
        if(rb2>rb1){
            maxb=rb2;
            minb=rb1;            
        }else{
            maxb=rb1;
            minb=rb2;
        }
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                int Ir = col.getRed();
                int Ig = col.getGreen();
                int Ib = col.getBlue();
                Ir=((Ir-minr)*(255/(maxr-minr)));
                Ig=((Ig-ming)*(255/(maxg-ming)));
                Ib=((Ib-minb)*(255/(maxb-minb)));
                col = new Color(validar(Ir),validar(Ig),validar(Ib));
                bufim.setRGB(x, y, col.getRGB());
            }
        }
        gris = HerramientasImagen.toImage(bufim);
        return gris;
    }
    
    public static Image expansionLogaritmica(Image gris,int r){
        
        ColoresHitogrmas ch = new ColoresHitogrmas(gris);
        BufferedImage bufim = HerramientasImagen.toBufferedImage(gris);
        int maximo = r;
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                int I = col.getBlue();
                I=(int)((maximo*Math.log(1+I))/(Math.log(1+maximo)));
                col = new Color(validar(I),validar(I),validar(I));
                bufim.setRGB(x, y, col.getRGB());
            }
        }
        gris = HerramientasImagen.toImage(bufim);
        return gris;
    }
    
    public static Image expansionLogaritmicaRGB(Image gris, int rr, int rg, int rb){
        
        ColoresHitogrmas ch = new ColoresHitogrmas(gris);
        BufferedImage bufim = HerramientasImagen.toBufferedImage(gris);
        int maxr = rr;
        int maxg = rg;
        int maxb = rb;
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                int Ir = col.getRed();
                int Ig = col.getGreen();
                int Ib = col.getBlue();
                Ir=(int)((maxr*Math.log(1+Ir))/(Math.log(1+maxr)));
                Ig=(int)((maxg*Math.log(1+Ig))/(Math.log(1+maxg)));
                Ib=(int)((maxb*Math.log(1+Ib))/(Math.log(1+maxb)));
                col = new Color(validar(Ir),validar(Ig),validar(Ib));
                bufim.setRGB(x, y, col.getRGB());
            }
        }
        gris = HerramientasImagen.toImage(bufim);
        return gris;
    }
    
    public static int minimo(double[] r){
        for(int x=0;x<r.length;x++){ 
            if (r[x]!=0)return x;
        }
        return -1;
    }
    
    public static int maximo(double[] r){
        for(int x=r.length-1;x>=0;x--){ 
            if (r[x]!=0)return x;
        }
        return -1;
    }
    private static int validar(int color) {
        if (color > 255)
        { 
            return 255;
        }
        if (color < 0){ 
            return 0;
        }
        return color;
    }
    
}
