/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import herramientas.HerramientasImagen;
import imaje_p.Convolucion;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author axel77755
 */
public class CustomJFrame extends JFrame {
    public CustomJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Two Panels, Textfields, and Button");

        // Crear dos paneles con imágenes de fondo
        Image original = HerramientasImagen.abrirImagen();
        JPanel panel1 = createImagePanel(original); // Reemplaza con la ruta de tu imagen
        ImagenConvolucion panel2 = new ImagenConvolucion(""); // Reemplaza con la ruta de tu imagen
        
        panel2.setPreferredSize(new Dimension(400, 200));
        // Crear una matriz de 5x5 de JTextFields
        JPanel textFieldPanel = new JPanel(new GridLayout(5, 5, 5, 5));
        JTextField[][] textFields = new JTextField[5][5];
        
        int id=0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                textFields[i][j] = new JTextField();
                textFields[i][j].setHorizontalAlignment(JTextField.CENTER);
                textFields[i][j].setText("0");
                textFields[i][j].addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || Character.valueOf(c).equals('-'))) {
                            e.consume();
                        }
                    }
                });
                textFieldPanel.add(textFields[i][j]);
            }
        }

        // Crear un JTextField adicional a la derecha
        JTextField extraTextField = new JTextField();
        extraTextField.setHorizontalAlignment(JTextField.CENTER);
        extraTextField.setText("1");

        // Crear un botón "Calcular"
        JButton calculateButton = new JButton("Calcular");

        // Configurar el layout del JFrame
        setLayout(new BorderLayout());
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(textFieldPanel, BorderLayout.CENTER);
        bottomPanel.add(extraTextField, BorderLayout.EAST);
        bottomPanel.add(calculateButton, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        calculateButton.addActionListener(new ActionListener() {
        // Sobrescribimos el método actionPerformed
            @Override
            public void actionPerformed(ActionEvent e) {
            // Aquí el código que queremos ejecutar cuando el botón sea presionado
                int[][] mascara = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        String valor = textFields[i][j].getText();
                        mascara[i][j]= Integer.parseInt (valor);                     
                    }
                }
                int div = Integer.parseInt(extraTextField.getText());
                BufferedImage buf= HerramientasImagen.toBufferedImage(original);
                Convolucion convo = new Convolucion(buf);
                Image bin2 = convo.convolucionar(mascara, div);
                panel2.setBackgroundImage(bin2);
            }
        });
    }

    // Método para crear un JPanel con una imagen de fondo
    private JPanel createImagePanel(Image imagePath) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    BufferedImage image = herramientas.HerramientasImagen.toBufferedImage(imagePath);
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        panel.setPreferredSize(new Dimension(400, 200)); // Establecer el tamaño según la imagen
        return panel;
    }
}
