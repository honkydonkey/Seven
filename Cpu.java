
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f1110801045
 */
public class Cpu {
    private ArrayList<Card> cpuCard;
    private int cpuNumCard;
    private int cpuPass;
    public Cpu(){
        cpuNumCard = 0;
        cpuPass = 0;
        cpuCard = new ArrayList<Card>();
    }
    public void setPass(){
        cpuPass++;
    }
    public void setCpuNumCard(){
        cpuNumCard--;
    }
    public void setCpuHand(Card c){
        cpuCard.add(c);
        cpuNumCard++;
    }
    public int getPass(){
        return cpuPass;
    }
    public int getCpuNumCard(){
        return cpuNumCard;
    }
    public ArrayList<Card> getCpuHandCard(){
        return cpuCard;
    }
    
}
