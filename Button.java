import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button extends JButton implements ActionListener{
    private String tag;
    private String dec;
    public int instance;
    public Button(String tag, String dec, int instance){
    super("Hehehehe");
    this.instance = instance;
    
    this.tag = tag;
    setVisible(true);
    this.setPreferredSize(new Dimension(200,20));
    setText(this.tag + "");
    this.dec = dec;
    addActionListener(this);
    }

    @Override
public void actionPerformed(ActionEvent e) {
        
    
    
    if(instance == 0){
    Main.choice(this.dec);
        }
        else if(instance == 1){

        }
        else if(instance == 2){
            System.out.println("Instance 2");
        }
        else if(instance == 3){

        }
    }
}
