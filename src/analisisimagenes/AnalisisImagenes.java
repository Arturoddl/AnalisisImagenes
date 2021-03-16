/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisimagenes;

import frames.JframeImagen;
import java.awt.Color;

/**
 *
 * @author artur
 */
public class AnalisisImagenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        JframeImagen j = new JframeImagen();
        
        for(int x = 0; x < 498; x++)
        {
            for(int y = 0; y < 498; y++)
            {
               j.cambiarPixel(Color.red, x, y); 
            }
        }
        System.out.println("");
    }
    
}
