
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f1110800661
 */
public class CpuPanel extends JPanel {
    
    private Cpu cpu[];
    private JLabel cpuLabel[];
    
    public CpuPanel()
    {
       cpuLabel = new JLabel[3];
       cpu = new Cpu[3];
       
       cpuLabel[0] = new JLabel("");
       cpuLabel[1] = new JLabel("");
       cpuLabel[2] = new JLabel("");
       
       cpu[0] = new Cpu();
       cpu[1] = new Cpu();
       cpu[2] = new Cpu();
       
       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       add(cpuLabel[0]);
       add(cpuLabel[1]);
       add(cpuLabel[2]);
    }
    
    public void setLabel1(int cpuPass, int cpuNumCard)
    {
        cpuLabel[0].setText("CPU1   Pass:" + cpuPass + "回　残り:" + cpuNumCard + "枚");
    }

    public void setLabel2(int cpuPass, int cpuNumCard)
    {
        cpuLabel[1].setText("CPU2   Pass:" + cpuPass + "回　残り:" + cpuNumCard + "枚");
    }

    public void setLabel3(int cpuPass, int cpuNumCard)
    {
        cpuLabel[2].setText("CPU3   Pass:" + cpuPass + "回　残り:" + cpuNumCard + "枚");
    }
    
    public void setCpu1(Card card)
    {
        cpu[0].setCpuHand(card);
    }
    
    public void setCpu2(Card card)
    {
        cpu[1].setCpuHand(card);
    }

    public void setCpu3(Card card)
    {
        cpu[2].setCpuHand(card);
    }
    
    public int getCpups(int num)
    {
        return cpu[num].getPass();
    }
    
    public void dispLabel(int num){
        //呼び出すだけでnum番目のCpuLabelが書き換わるメソッド
        switch(num){
            case 0:
                setLabel1(cpu[0].getPass(), cpu[0].getCpuNumCard());
                break;
            case 1:
                setLabel2(cpu[1].getPass(), cpu[1].getCpuNumCard());
                break;
            case 2:
                setLabel3(cpu[2].getPass(), cpu[2].getCpuNumCard());
                break;
            default:
        }
    }
    
    public Card putCard( int num, boolean fieldCard[][] )
    {
        int color=0, value=0;
        boolean a = true;
        Card tmp = new Card();

        if(cpu[num].getCpuHandCard().size() == 0){
            //手札がなくなったときは番号-1のカードを返す
            tmp.setValue(-1);
            return tmp;
        }
        
        for(int i=0; i<cpu[num].getCpuHandCard().size(); i++)
        {
            color = cpu[num].getCpuHandCard().get(i).getColor();
            value = cpu[num].getCpuHandCard().get(i).getValue() - 1;
            if( fieldCard[color][value] )
            {
                a = false;

                tmp = cpu[num].getCpuHandCard().get(i);
                //cpu[num].setCpuHand(cpu[num].getCpuHandCard().remove(i));
                cpu[num].getCpuHandCard().remove(i);
                cpu[num].setCpuNumCard();
                if(value == 0 || value == 12) break;
                else if(value >= 7)fieldCard[color][value + 1] = true;
                else fieldCard[color][value - 1] = true;
                break;
            }            
        }
        if( a )
        {
            cpu[num].setPass();
            return new Card();
            //return -1;
        }
        //return (color * 13 + value);
        return tmp;
    }
}
