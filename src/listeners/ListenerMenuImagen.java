/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import frames.JFramePrincipal;
import frames.JInternalFrameImagen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author artur
 */
public class ListenerMenuImagen implements ActionListener
{
    private JFramePrincipal JFP;

    public ListenerMenuImagen(JFramePrincipal JFP) 
    {
        this.JFP = JFP;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        JMenuItem item = (JMenuItem) ae.getSource();
        
        switch (item.getText())
        {
            case "Abrir Imagen":
            {
                JInternalFrameImagen frameImagen = new JInternalFrameImagen();
                frameImagen.setVisible(true);
                frameImagen.addInternalFrameListener(new ListenerInternalFrame(JFP,frameImagen));
                this.JFP.getjDesktopPanePrincipal().add(frameImagen);
                break;
            }
            default:
            {
                break;
            }
        }
    }
    
}
