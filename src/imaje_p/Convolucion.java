/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imaje_p;

import herramientas.HerramientasImagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author axel77755
 * Determinar el divisor 
 * offset: valor que se añade
 */
public class Convolucion {
    
    // Mascaras de deteccion de vorde
    BufferedImage imagenOriginal;
    
    public Convolucion(BufferedImage imagenOriginal){
        this.imagenOriginal = imagenOriginal;
    }
    
    public Image convolucionar(int[][] mascara, int div){
        if(div==0){
            div=1;
        }
        BufferedImage aux = new BufferedImage(imagenOriginal.getWidth(), imagenOriginal.getHeight(), imagenOriginal.getType());
        // masc2;

        for (int x = 0; x < imagenOriginal.getWidth(); x++) {
            for (int y = 0; y < imagenOriginal.getHeight(); y++) {
                int[][] masc2 = validarMascara2(x, y, mascara);
                aux.setRGB(x, y, convolucion(x, y, div, masc2));
            }
        }

    Image imagenconvolucionada = HerramientasImagen.toImage(aux);
    return imagenconvolucionada;
}
    
    public int[][] validarMascara(int x, int y, int[][] mascara){
        int[][] masc2 = mascara;
        if(x==0){
            for(int ym=0;ym<masc2.length;ym++){
                masc2[0][ym]=0;
            }
        }else{ 
            if(x==imagenOriginal.getWidth(null)-1){
                for(int ym=0;ym<masc2.length;ym++){
                    masc2[masc2.length-1][ym]=0;
                }
            }else{
                //masc2 = mascara;
            }
        }
        if(y==0){
            for(int ym=0;ym<masc2.length;ym++){
                masc2[ym][0]=0;
            }
        }else{ 
            if(y==(imagenOriginal.getHeight(null)-1)){
                for(int ym=0;ym<masc2.length;ym++){
                    masc2[ym][masc2.length-1]=0;
                }
            }else{
                        
            }
        }
        
        return masc2;
    }
    
    public int convolucion(int x, int y, int div,int[][] masc2){
        //convolucionar
        int auxx = ((masc2.length-1)/2)*-1;
        int aR=0, aG=0, aB=0;
        int rgbresul;
        Color temp;
        for(int mascx=0; mascx<masc2.length;mascx++){
            int auxy = ((masc2.length-1)/2)*-1;
            for(int mascy=0; mascy<masc2[mascx].length;mascy++){
                if((masc2[mascx][mascy])!=0){
                    //res=res+(masc2[mascx][mascy]*this.imagenOriginal.getRGB(x+auxx, y+auxy));
                    temp = new Color(this.imagenOriginal.getRGB(x+auxx, y+auxy));
                    //System.out.print("Original: "+temp);
                    aR+= temp.getRed()*(masc2[mascx][mascy]);
                    aG+= temp.getGreen()*(masc2[mascx][mascy]);
                    aB+= temp.getBlue()*(masc2[mascx][mascy]);
                }else{
                    
                }
                auxy++;
                //System.out.println(mascy+" y");
            }
            auxx++;
            //System.out.println(mascx+" x");
        }
        aR/=div;
        aG/=div;
        aB/=div;
        
        temp = new Color(validar(aR),validar(aG),validar(aB));
        rgbresul = temp.getRGB();
        //System.out.println(" Nuevo: "+temp);
        return rgbresul;
    }
    
    public int convolucion2(int x, int y, int div, int[][] masc2){
        int centerX = masc2.length / 2;
        int centerY = masc2[0].length / 2;

        int aR = 0, aG = 0, aB = 0;
        Color temp;

        for(int mascx = 0; mascx < masc2.length; mascx++){
            for(int mascy = 0; mascy < masc2[mascx].length; mascy++){
                int px = x + (mascx - centerX);
                int py = y + (mascy - centerY);

                if (px >= 0 && px < imagenOriginal.getWidth() && py >= 0 && py < imagenOriginal.getHeight()) {
                    temp = new Color(imagenOriginal.getRGB(px, py));
                    aR += temp.getRed() * masc2[mascx][mascy];
                    aG += temp.getGreen() * masc2[mascx][mascy];
                    aB += temp.getBlue() * masc2[mascx][mascy];
                }
            }
        }

        aR /= div;
        aG /= div;
        aB /= div;

        int rgbresul = new Color(validar(aR), validar(aG), validar(aB)).getRGB();
        return rgbresul;
    }
    
    private static int validar(int color) {
        if (color > 255)return 255;
        if (color < 0)return 0;
        return color;
    }
    
    public int[][] validarMascara2(int x, int y, int[][] mascara){
        int[][] masc2 = new int[mascara.length][mascara[0].length];

        for (int i = 0; i < mascara.length; i++) {
            for (int j = 0; j < mascara[i].length; j++) {
                int px = x + (i - (mascara.length / 2));
                int py = y + (j - (mascara[i].length / 2));

                if (px >= 0 && px < imagenOriginal.getWidth() && py >= 0 && py < imagenOriginal.getHeight()) {
                    masc2[i][j] = mascara[i][j];
                } else {
                    masc2[i][j] = 0; // Asignar cero a los valores fuera de la imagen
                }
            }
        }

        return masc2;
    }
    /*private static int validar(int color) {
        if (color > 255)return 255;
        if (color < 0)return 0;
        return color;
    }*/
}
