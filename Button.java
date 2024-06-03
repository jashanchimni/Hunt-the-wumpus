import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button extends JButton implements ActionListener{
    private String tag;
    private String dec;

    public Button(String tag, String dec){
    
    super("Hehehehe");
    this.tag = tag;
    setVisible(true);
    this.setPreferredSize(new Dimension(200,20));
    setText(this.tag + "");
    this.dec = dec;
    addActionListener(this);
    }

    @Override
public void actionPerformed(ActionEvent e) {
        Main.choice(this.dec);
        }
}
