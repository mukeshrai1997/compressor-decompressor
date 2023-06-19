
package GUI;

//import comp_decomp.Compressor;

import comp_decomp.Compressor;
import comp_decomp.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


/**
 *
 * @author mukesh rai
 */
public class AppFrame extends JFrame implements ActionListener{

    JButton compressButton;
    JButton decompressButton;
   // private Compressor com;


    @SuppressWarnings("LeakingThisInConstructor")
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        compressButton = new JButton("To Compress");
        compressButton.setBounds(200 ,200,200,30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("To Decompress");
        decompressButton.setBounds(450,200,200,30);
        decompressButton.addActionListener(this);

        //this.setLocation(100,200);
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(800, 600);
        this.getContentPane().setBackground(Color.blue);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response =filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response =filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
}