/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import frames.JFramePrincipal;
import frames.JInternalFrameImagen;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/**
 *
 * @author artur
 */
public class ListenerInternalFrame implements InternalFrameListener
{
    private JFramePrincipal JFP;
    private JInternalFrameImagen JIFI;

    public ListenerInternalFrame(JFramePrincipal JFP, JInternalFrameImagen JIFI) 
    {
        this.JFP = JFP;
        this.JIFI = JIFI;
    }
    
    
    @Override
    public void internalFrameOpened(InternalFrameEvent ife) {}

    @Override
    public void internalFrameClosing(InternalFrameEvent ife) {}

    @Override
    public void internalFrameClosed(InternalFrameEvent ife) {}

    @Override
    public void internalFrameIconified(InternalFrameEvent ife) {}

    @Override
    public void internalFrameDeiconified(InternalFrameEvent ife) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent ife) 
    {
        if(JFP.getJIFM() != null)
        {
            JFP.getJIFM().setJFI(JIFI);
        }
        
        if(JFP.getJIFC() != null)
        {
            JFP.getJIFC().setJFI(JIFI);
        }
        
        if(JFP.getJIFGH() != null)
        {
            JFP.getJIFGH().setJFI(JIFI);
        }
        
        if(JFP.getJIFFEG() != null)
        {
            JFP.getJIFFEG().setJFI(JIFI);
        }
        
        if(JFP.getJIFFNG() != null)
        {
            JFP.getJIFFNG().setJFI(JIFI);
        }
        
        if(JFP.getJIFFBN()!= null)
        {
            JFP.getJIFFBN().setJFI(JIFI);
        }
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent ife){}
    
}
