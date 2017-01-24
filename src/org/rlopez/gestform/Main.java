/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.gestform;


import javax.swing.JFrame;
import org.rlopez.gestform.models.MainWindow;

/**
 *
 * @author rico
 */
public class Main {
    
    
public static void main(String[] args) throws InterruptedException {
    

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                JFrame frame= new JFrame();
               MainWindow mainwindow = new MainWindow();
                
                
                frame.getContentPane().add(mainwindow);
                frame.setVisible(true);
            }
        });
    }
		
		

}
