/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herramientas;

import GUI.JFrameImg;
import herramientas.HerramientasImagen;
import imaje_p.Graficador;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author axel77755
 */
public class ColoresHitogrmas {
    private double rojo[] = new double[256];
    private double verde[] = new double[256];
    private double azul[] = new double[256];
    Image imagen ;
    BufferedImage bufim;
    Graficador graf = new Graficador("Tono","Frecuencia","Hitograma de color");
    
    public ColoresHitogrmas(){
        this.imagen = HerramientasImagen.abrirImagen();
        this.bufim = HerramientasImagen.toBufferedImage(imagen);
        histogramas();        
    }
    
    public ColoresHitogrmas(Image imagen){
        this.imagen = imagen;
        this.bufim = HerramientasImagen.toBufferedImage(imagen);
        histogramas();
    }
    
    public void histogramas(){
        for(int x=0; x < bufim.getWidth(null);x++){
            for(int y=0; y<bufim.getHeight(null);y++){
                Color col = new Color(bufim.getRGB(x, y));
                rojo[col.getRed()]=rojo[col.getRed()]+1;
                verde[col.getGreen()]=verde[col.getGreen()]+1;
                azul[col.getBlue()]=azul[col.getBlue()]+1;
            }
        }
        graf.agregarSerie("Rojo", rojo);
        graf.agregarSerie("Verde", verde);
        graf.agregarSerie("Azul", azul);
        graf.crearGrafica();
        graf.muestraGrafica();
    }
    
    public double[] getRojo(){
        return rojo;
    }
    public double[] getVerde(){
        return verde;
    }
    public double[] getAzul(){
        return azul;
    }
}
