import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button extends JButton implements ActionListener{
    private String tag;
    private String dec;

    public Button(String tag){
        super("Hehehehe");
        setVisible(true);
    this.setPreferredSize(new Dimension(50,20));
    setText(this.tag + "");
    addActionListener(this);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    for(int t = 0; t < Main.mainButtons.size(); t++){
        if((Main.mainButtons.get(t)).equals(this.tag)){
        //Main.choice(this.dec);
        }
    }
    
    }
}
