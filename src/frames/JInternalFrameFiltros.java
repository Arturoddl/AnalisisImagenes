/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import static herramientas.herramientas.toBufferedImage;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author artur
 */
public class JInternalFrameFiltros extends javax.swing.JInternalFrame 
{
    /**
     * Creates new form JInternalFrameFiltros
     */
    
    private JInternalFrameImagen JFI;
    private BufferedImage bufferimagen;
    private Image preImagen;
    private JFramePrincipal JFP;
    
    public JInternalFrameFiltros(JFramePrincipal JFP,String metodo, JInternalFrameImagen JFI) 
    {
        this.JFP = JFP;
        initComponents();
        this.preImagen = null;
        switch (metodo)
        {
            case "Escala Grises":
            {
                jButton_Filtro.setText("Escala Grises");
                jButton_Filtro.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        listenerEG();
                    }
                });
                break;
            }
            case "Negativo":
            {
                jButton_Filtro.setText("Negativo");
                jButton_Filtro.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        listenerN();
                    }
                });
                break;
            }
            case "Blanco y negro":
            {
                jButton_Filtro.setText("Blanco y negro");
                jButton_Filtro.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        listenerBN();
                    }
                });
                break;
            }
            default:
            {
                break;
            }
        }
        
        this.jButton_Generar.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                generarVentana();
            }
        });
    }
    
    public void generarVentana()
    {
        if(this.preImagen !=  null)
        {
            JInternalFrameImagen JFINew = new JInternalFrameImagen(preImagen);
            JFINew.setVisible(true);
            this.JFP.getjDesktopPanePrincipal().add(JFINew);
        }
    }
    
    public void listenerEG()
    {
        Image aux = JFI.getImagenSecundaria();
        BufferedImage aux2 = herramientas.herramientas.toBufferedImage(aux);
        int w = aux.getWidth(this);
        int h = aux.getHeight(this);
        BufferedImage aux1 = new BufferedImage (w, h,BufferedImage.TYPE_BYTE_GRAY);
        
        for(int x = 0; x < w; x++)
        {
            for(int y = 0; y < h; y++)
            {
                aux1.setRGB(x, y, aux2.getRGB(x, y));
            } 
        }
        
        setImagen(herramientas.herramientas.toImage(aux1));
    }
    
    public void listenerN()
    {
        Image aux = JFI.getImagenSecundaria();
        BufferedImage aux2 = herramientas.herramientas.toBufferedImage(aux);
        int w = aux.getWidth(this);
        int h = aux.getHeight(this);
        BufferedImage aux1 = herramientas.herramientas.toBufferedImage(aux);
        Color color;
        int r,g,b;
        
        for(int x = 0; x < w; x++)
        {
            for(int y = 0; y < h; y++)
            {
                //se obtiene el color del pixel
                color = new Color(aux2.getRGB(x, y));
                //se extraen los valores RGB
                r = color.getRed();
                g = color.getGreen();
                b = color.getBlue();
                //se coloca en la nueva imagen con los valores invertidos
                aux1.setRGB(x, y, new Color(255-r,255-g,255-b).getRGB());
            } 
        }
        
        setImagen(herramientas.herramientas.toImage(aux1));
    }
    
    public void listenerBN()
    {
        Image aux = JFI.getImagenSecundaria();
        BufferedImage aux2 = herramientas.herramientas.toBufferedImage(aux);
        int w = aux.getWidth(this);
        int h = aux.getHeight(this);
        BufferedImage aux1 = new BufferedImage (w, h,BufferedImage.TYPE_BYTE_BINARY);
        
        Color color;
        int r,g,b;
        for(int x = 0; x < w; x++)
        {
            for(int y = 0; y < h; y++)
            {
                //se obtiene el color del pixel
                color = new Color(aux2.getRGB(x, y));
                //se extraen los valores RGB
                if(color.getRed() < 127)
                {
                    r = 0; 
                }
                else
                {
                    r = 255;
                }
                
                if(color.getGreen() < 127)
                {
                    g = 0; 
                }
                else
                {
                    g = 255;
                }
                
                if(color.getBlue() < 127)
                {
                    b = 0; 
                }
                else
                {
                    b = 255;
                }
                //se coloca en la nueva imagen con los valores invertidos
                aux1.setRGB(x, y, new Color(r,g,b).getRGB());
            } 
        }
        
        setImagen(herramientas.herramientas.toImage(aux1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Imagen = new javax.swing.JLabel();
        jButton_Filtro = new javax.swing.JButton();
        jButton_Generar = new javax.swing.JButton();
        jLabel_PreImagen = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jButton_Filtro.setText("Filtro");
        jButton_Filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FiltroActionPerformed(evt);
            }
        });

        jButton_Generar.setText("Generar ventana");
        jButton_Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_PreImagen)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel_Imagen))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Generar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Generar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel_Imagen))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_PreImagen)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_FiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_FiltroActionPerformed

    private void jButton_GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GenerarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_GenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Filtro;
    private javax.swing.JButton jButton_Generar;
    private javax.swing.JLabel jLabel_Imagen;
    private javax.swing.JLabel jLabel_PreImagen;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the JFI
     */
    public JInternalFrameImagen getJFI() 
    {
        return JFI;
    }

    /**
     * @param JFI the JFI to set
     */
    public void setJFI(JInternalFrameImagen JFI) 
    {
        this.JFI = JFI;
        bufferimagen = toBufferedImage(getJFI().getImagenSecundaria());
    }
    
    public void setImagen(Image nuevaImagen)
    {
        preImagen = nuevaImagen;
        jLabel_PreImagen.removeAll();
        jLabel_PreImagen.setIcon(new ImageIcon(nuevaImagen));
        setSize(nuevaImagen.getWidth(null),(nuevaImagen.getHeight(null) + 100));
    }
}
