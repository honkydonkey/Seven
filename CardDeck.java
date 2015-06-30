
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f1110801045
 */
public class CardDeck {
    private ArrayList<Card> deck;
    private Card card;
    public CardDeck(){
        card = new Card();
        deck = new ArrayList<Card>();
        for(int i=0;i<52;i++){
            deck.add( new Card());
            if(0 <= i && i < 13){
                deck.get(i).setColor(0);
                deck.get(i).setValue(i+1);
                deck.get(i).setImage(new ImageIcon(".\\src\\images\\1-" + Integer.toString(i+1) + ".gif"));
            }else if(13 <= i && i < 26){
                deck.get(i).setColor(1);
                deck.get(i).setValue(i-12);
                deck.get(i).setImage(new ImageIcon(".\\src\\images\\2-" + Integer.toString(i-12) + ".gif"));
            }else if(26 <= i && i < 39){
                deck.get(i).setColor(2);
                deck.get(i).setValue(i-25);
                deck.get(i).setImage(new ImageIcon(".\\src\\images.\\3-" + Integer.toString(i-25) + ".gif"));
            }else{
                deck.get(i).setColor(3);
                deck.get(i).setValue(i-38);
                //System.out.println("/images/4-" + Integer.toString(i-38) + ".gif");
                deck.get(i).setImage(new ImageIcon(".\\src\\images\\4-" + Integer.toString(i-38) + ".gif"));
            }
            
        }
        deck.remove(45);
        deck.remove(32);
        deck.remove(19);
        deck.remove(6);  
        Collections.shuffle(deck);
        
    }
    public Card getCard(){
        if(deck.size() == 0) return new Card();
        
        Card c = deck.get(0);
        deck.remove(0);
        return c;
    }
}
