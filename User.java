
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f1110801045
 */
public class User {
    private ArrayList<Card> userCard;
    private int userNumCard;
    private int userPass;
    public User(){
        userNumCard = 0;
        userPass = 0;
        userCard = new ArrayList<Card>();
    }
    public void setPass(){
        userPass++;
}
    public void setUserNumCard(){
        userNumCard--;
    }
    public void setUserHand(Card c){
        userCard.add(c);
        userNumCard++;
    }
    public int getPass(){
        return userPass;
    }
    public int getUserNumCard(){
        return userNumCard;
    }
    public ArrayList<Card> getHandCard(){
        return userCard;
    }
        
}
