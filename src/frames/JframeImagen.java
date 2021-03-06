/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author artur
 */

public class JframeImagen extends JFrame
{

    private Image imagenOriginal;
    public BufferedImage bufferimagen;
    public Image imagenSecundaria;
    
    JLabel etiqueta = new JLabel();

    public JframeImagen()
    {
        Image aux = openImage();
        this.imagenOriginal = aux;
        this.imagenSecundaria = aux;
        this.etiqueta = new JLabel();
        this.etiqueta.setIcon(new ImageIcon(this.imagenSecundaria));
        add(this.etiqueta);
        setSize(this.imagenSecundaria.getWidth(null),this.imagenSecundaria.getHeight(null));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.bufferimagen = toBufferedImage(imagenSecundaria);
    }
    
    public void cambiarPixel(Color pixel, int x, int y)
    {
        bufferimagen.setRGB(x, y, pixel.getRGB());
        imagenSecundaria = toImage(bufferimagen);
        
        etiqueta.removeAll();
        etiqueta.setIcon(new ImageIcon(this.imagenSecundaria));
    }
    
    public Image getImagenOriginal()
    {
        return this.imagenOriginal;
    }
    public void setImagenOriginal(Image aux)
    {
        this.imagenOriginal = aux;
    }
    
    public static Image openImage ()
    {
        try 
        {
            // definir los filtros para lectura
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter("Imagenes","jpg","jpeg","png","bmp");
            // crear un selector de archivos
            JFileChooser selector = new JFileChooser();
            // agregar el filtro al selector
            selector.addChoosableFileFilter(filtro);
            // especificar que solo se puedan abrir archivos
            selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            //ejecutar el selector de imagenes
            
            int res = selector.showOpenDialog(null);
            
            if (res == 1 ){
                
                return null;
                
            }
            
            File archivo = selector.getSelectedFile();
            
            BufferedImage  bi = ImageIO.read(archivo);
            
            return toImage(bi);
        } catch (IOException ex) {
            //Logger.getLogger(ImageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static BufferedImage toBufferedImage (Image imagen)
    {
         // imagen es un objeto de tipo BufferedImage
        if (imagen instanceof BufferedImage)
        {
          return (BufferedImage)imagen;
        }
        
        BufferedImage bi = new BufferedImage(
                                            imagen.getWidth(null), 
                                            imagen.getHeight(null), 
                                            BufferedImage.TYPE_INT_RGB
                                            );
        
        Graphics2D nueva = bi.createGraphics();
        nueva.drawImage(imagen, 0, 0,null);
        nueva.dispose();
        
        return bi;
    }
    
    public static Image toImage(BufferedImage bi)
    {
        return bi.getScaledInstance(bi.getWidth(),bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }
}