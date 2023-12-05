/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package imaje_p;

import GUI.CustomJFrame;
import herramientas.ColoresHitogrmas;
import GUI.JFrameImg;
import herramientas.HerramientasImagen;
import herramientas.Ruido;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author axel77755
 */
public class Imaje_P {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      /*JFrame frame = new JFrame();
      frame.getContentPane().add(new TestBuffer());

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(200, 200);
      frame.setVisible(true);
      
      Color p = new Color(0,0,0);
      //Color p = new Color(290,5,178);
      int aux = p.getRGB();
      System.out.println(aux);*/
      //ColoresHitogrmas ch = new ColoresHitogrmas();
      /*Image imagen = HerramientasImagen.abrirImagen();
      ColoresHitogrmas ch1 = new ColoresHitogrmas(imagen);
      JFrameImg imagenin = new JFrameImg(imagen);
      imagenin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
      //Image grises = OperacionesBasicas.escaladeGrises(imagen);
      //ColoresHitogrmas ch = new ColoresHitogrmas(grises);
      //JFrameImg imagenGrey = new JFrameImg(grises);
      //imagenGrey.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      //ColoresHitogrmas ch2 = new ColoresHitogrmas(grises);
      
      //Image iluminada = OperacionesBasicas.modificarIluminacion(imagen, -50);
      //Image iluminada = OperacionesBasicas.calido(imagen, -10);
      //Image iluminada = OperacionesBasicas.frio(imagen, -10);
      //Image iluminada = OperacionesBasicas.negativo(imagen);
      //JFrameImg imagenIlum = new JFrameImg(iluminada);
      //ColoresHitogrmas ch2 = new ColoresHitogrmas(iluminada);
      
      //System.out.println(Binarizacion.metodoIterativo(ch.getAzul()));
      //System.out.println(Binarizacion.otsu(histograma));      
      //Image bin = Binarizacion.binarizarImagen(grises, Binarizacion.metodoIterativo(ch.getAzul()));
      //Image bin = Iluminacion.iluminacion1(grises, 150, 10);
      //Image bin = Expansion.expansionLineal(grises);
      //Image bin = Expansion.expansionLogaritmica(grises);
      //Image bin = Expansion.expansionLinealRGB(imagen);
      //Image bin = Expansion.expansionLogaritmicaRGB(imagen);
      //JFrameImg imagen2 = new JFrameImg(bin);
      //ColoresHitogrmas ch2 = new ColoresHitogrmas(bin);
      
        //Image bin = convo.convolucionar(mascara, 7);
      Image bin = Ruido.agregarRuidoMezcla(imagen, 5,5);
      JFrameImg imagen2 = new JFrameImg(bin);
       
      BufferedImage buf= HerramientasImagen.toBufferedImage(bin);
      Convolucion convo = new Convolucion(buf);
      int[][] mascara = {
          {0, 0, 0, 0, 0},
          {0, -1, 0, 1, 0},
          {0, -1, 0, 1, 0},
          {0, -1, 0, 1, 0},
          {0, 0, 0, 0, 0}
      };
      /*int[][] mascara = {
         
          {-1, -1, -1},
          {-1, 1, -1},
          {-1, -1, -1},
          
      };*/
      /*Image bin2 = convo.convolucionar(mascara, 7);
      JFrameImg imagen3 = new JFrameImg(bin2);
      ColoresHitogrmas ch2 = new ColoresHitogrmas(bin2);*/
      
       CustomJFrame cut = new CustomJFrame();
       cut.setVisible(true);
        
    }
    
}
