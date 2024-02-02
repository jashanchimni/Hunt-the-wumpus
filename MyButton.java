import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.desktop.QuitStrategy;
import java.awt.event.*;
import javax.swing.ImageIcon;



class MyButton extends JButton implements ActionListener {

  //--------------------------- VARRISBLES ----------------------------\\
  String name;     
  public MyButton(String name) {
    this.addActionListener(this);
    this.name = name;
  }
  
  public void actionPerformed(ActionEvent e) {
    System.out.println("Button Clicked");

  }

  
  // ------------------------ imageBtn ------------------------ \\

  public static JButton imageBtn(String imgPathe, int widthe, int heighte){

    String imgPath = imgPathe;                                                                 // Delcaring vars
    int width = widthe;                                                                        // Delcaring vars
    int height = heighte;                                                                      // Delcaring vars
    ImageIcon icon = new ImageIcon(imgPath);                                                   // Load the image as an icon...
    Image img = icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // pull the image resource back out and scale it as an image..
    icon = new ImageIcon(img);                                                                 // put it back as an icon
    JButton b = new JButton(icon);                                                             // create a button from the resized icon
    b.setPreferredSize(new Dimension(width, height));                                          // set the button size to match
    return b;                                                                                  // Return the button
    
  }
  public void setIcon(String imgPath, int width, int height){
    ImageIcon icon = new ImageIcon(imgPath);
    Image img = icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    this.setIcon(icon);
    this.setPreferredSize(new Dimension(width, height));
  }

  
}
