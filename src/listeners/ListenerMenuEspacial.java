/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import frames.JFramePrincipal;
import frames.JInternalFrameCopiar;
import frames.JInternalFrameFiltros;
import frames.JInternalFrameImagen;
import frames.JInternalFrameModificar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author artur
 */
public class ListenerMenuEspacial implements ActionListener
{
    private JFramePrincipal JFP;

    public ListenerMenuEspacial(JFramePrincipal JFP) 
    {
        this.JFP = JFP;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        JMenuItem item = (JMenuItem) ae.getSource();
        switch (item.getText())
        {
            case "Modificar":
            {
                if(JFP.getJIFM() == null)
                {
                    JInternalFrameImagen frameImagen = JFP.getJIFI();
                    JInternalFrameModificar frameModificar = new JInternalFrameModificar(frameImagen);
                    frameModificar.setVisible(true);
                    this.JFP.getjDesktopPanePrincipal().add(frameModificar);
                    this.JFP.setJIFM(frameModificar);
                }
                break;
            }
            case "Copiar pixeles":
            {
                if(JFP.getJIFC() == null)
                {
                    JInternalFrameImagen frameImagen = JFP.getJIFI();
                    JInternalFrameCopiar frameCopear = new JInternalFrameCopiar(frameImagen);
                    frameCopear.setVisible(true);
                    this.JFP.getjDesktopPanePrincipal().add(frameCopear);
                    this.JFP.setJIFC(frameCopear);
                }
                break;
            }
            case "Escala Grises":
            {
                if(JFP.getJIFFEG() == null)
                {
                    JInternalFrameImagen frameImagen = JFP.getJIFI();
                    JInternalFrameFiltros frameFiltrosEG = new JInternalFrameFiltros(this.JFP,"Escala Grises",frameImagen);
                    frameFiltrosEG.setVisible(true);
                    this.JFP.getjDesktopPanePrincipal().add(frameFiltrosEG);
                    this.JFP.setJIFFEG(frameFiltrosEG);
                }
                break;
            }
            case "Negativo":
            {
                if(JFP.getJIFFNG() == null)
                {
                    JInternalFrameImagen frameImagen = JFP.getJIFI();
                    JInternalFrameFiltros frameFiltrosNG = new JInternalFrameFiltros(this.JFP,"Negativo",frameImagen);
                    frameFiltrosNG.setVisible(true);
                    this.JFP.getjDesktopPanePrincipal().add(frameFiltrosNG);
                    this.JFP.setJIFFNG(frameFiltrosNG);
                }
                break;
            }
            case "Blanco y negro":
            {
                if(JFP.getJIFFBN() == null)
                {
                    JInternalFrameImagen frameImagen = JFP.getJIFI();
                    JInternalFrameFiltros frameFiltrosBN = new JInternalFrameFiltros(this.JFP,"Blanco y negro",frameImagen);
                    frameFiltrosBN.setVisible(true);
                    this.JFP.getjDesktopPanePrincipal().add(frameFiltrosBN);
                    this.JFP.setJIFFNG(frameFiltrosBN);
                }
                break;
            }
            default:
            {
                break;
            }
        }
    }
}
