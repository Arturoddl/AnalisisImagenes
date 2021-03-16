/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import frames.JFramePrincipal;
import frames.JInternalFrameCopiar;
import frames.JInternalFrameGraficaHistograma;
import frames.JInternalFrameImagen;
import frames.JInternalFrameModificar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author artur
 */
public class ListenerMenuHistograma implements ActionListener
{
    private JFramePrincipal JFP;
    
    public ListenerMenuHistograma(JFramePrincipal JFP) 
    {
        this.JFP = JFP;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        JMenuItem item = (JMenuItem) ae.getSource();
        switch (item.getText())
        {
            case "Grafica Histograma":
            {
                if(JFP.getJIFGH() == null)
                {   
                    JInternalFrameImagen frameImagen = JFP.getJIFI();
                    JInternalFrameGraficaHistograma frameGrafica = new JInternalFrameGraficaHistograma(frameImagen);
                    frameGrafica.setVisible(true);
                    this.JFP.getjDesktopPanePrincipal().add(frameGrafica);
                    this.JFP.setJIFGH(frameGrafica);
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
