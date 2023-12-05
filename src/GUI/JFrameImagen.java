/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import herramientas.HerramientasImagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author axel77755
 */
public class JFrameImagen extends javax.swing.JFrame {

    /**
     * Creates new form JFrameImagen
     */
    public JFrameImagen(Image imagen) {
        initComponents();
        // mandar imagen al label
        //this.jLabel1.setIcon(new ImageIcon(imagen));
        
        int w = imagen.getWidth(null);
        int h = imagen.getHeight(null);
        
        System.out.println("W: "+w+" H: "+h);
        
        Image escalada =HerramientasImagen.toBufferedImage(imagen).getScaledInstance(w/4, h/4, BufferedImage.TYPE_INT_RGB);
        //this.jLabel1.setIcon(new ImageIcon(escalada));
        
         Random ran = new Random();
        int posx = ran.nextInt(escalada.getWidth(null));
        int posy = ran.nextInt(escalada.getHeight(null));
        
        BufferedImage escB = HerramientasImagen.toBufferedImage(escalada);
        Color colorP = new Color(escB.getRGB(posx, posy));
        int rojo=colorP.getRed();
        int verde=colorP.getGreen();
        int azul=colorP.getBlue();
        System.out.println("Color del pixel: "+posx+","+posy);
        System.out.println("R: "+rojo+" G: "+verde+" B: "+azul);
        
        Mostrarcolor mc = new Mostrarcolor(colorP);
        mc.setVisible(true);
        
        int cont=0,total=0;
        for(int x=0; x<escalada.getWidth(null);x++){
            for(int y=0; y<escalada.getHeight(null);y++){
                Color tempc = new Color(escB.getRGB(x, y));
                Color muestra = new Color(88,111,7);
                //if(tempc.equals(colorP)){
                //if(colorP.getRGB()==tempc.getRGB()){
                if(muestra.getRGB()==tempc.getRGB()){
                    Color nuevo = new Color(228,0,124);
                    escB.setRGB(x, y, nuevo.getRGB());
                    escB.setRGB(x+1, y, nuevo.getRGB());
                    escB.setRGB(x, y+1, nuevo.getRGB());
                    escB.setRGB(x+1, y+1, nuevo.getRGB());
                    escB.setRGB(x, y+2, nuevo.getRGB());
                    escB.setRGB(x+2, y+2, nuevo.getRGB());
                    escB.setRGB(x+2, y, nuevo.getRGB());
                    cont++;
                }
                total++;
            }
        }
        this.jLabel1.setIcon(new ImageIcon(escB));
        double porciento = cont/total;
        System.out.println("El porcentaje de la imagen con este color es: "+porciento);
        System.out.println("El tono aperece : "+cont);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 400, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 300, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Image imagen = HerramientasImagen.abrirImagen();
                new JFrameImagen(imagen).setVisible(true);
                                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}