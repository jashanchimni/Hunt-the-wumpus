import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button extends JButton implements ActionListener{
    private String tag;
    private String dec;
    public int instance;
    public int shopTier;
    int Shops;
    int dec1;
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
    public Button(String tag, int dec1, int instance, int shopTier, int Shops){
        super("Hehehehe");
        this.instance = instance;
        this.shopTier = shopTier;
        this.Shops = Shops;
        this.tag = tag;
        setVisible(true);
        this.setPreferredSize(new Dimension(200,20));
        setText(this.tag + "");
        this.dec1 = dec1;
        addActionListener(this);
    }

    @Override
public void actionPerformed(ActionEvent e) {
        
    
    
    if(instance == 0){
    Main.choice(this.dec);
        }
        else if(instance == 1){
            Shop.buy(this.dec1, this.shopTier, this.Shops);
        }
        else if(instance == 2){
            Monster.turnTake(this.dec);
        }
        else if(instance == 3){

        }
    }
}
