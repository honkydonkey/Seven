
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f1110880032
 */
public class Card {
    private Icon cardImage;
    private int cardValue;
    private int cardColor;
    
    public Card(){
        cardImage = new ImageIcon();
        cardValue = 0;
        cardColor = 0;
    }
    public int getColor(){     
        return cardColor;
    }
    public Icon getImage(){
        return cardImage;
    }
    public int getValue(){
        return cardValue;
    }
    public void setColor(int cardColor){ 
        this.cardColor = cardColor;
    }
    public void setImage(Icon cardImage){
        this.cardImage = cardImage;
    }
    public void setValue(int cardValue){
        this.cardValue = cardValue;
    }
}
