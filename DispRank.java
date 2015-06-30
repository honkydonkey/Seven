import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f1110880032
 */
public class DispRank extends JFrame implements ActionListener{
	private JButton buttonContinue;
        private JButton buttonEnd;
	private JLabel textContinue;
        private JLabel textRank;
        private JLabel textRanking[];
        private JPanel dispRankPanel;
        private boolean dispRankFlag = true;
        
        
    public DispRank(){
        setTitle("七並べプログラム");
        setSize(450,300);
        setLayout(null);

        textRanking = new JLabel[4];
        textRank = new JLabel();
        textRank.setText("<html>順位　　１位<br>　　　　２位<br>　　　　３位<br>　　　　４位</html>");
        textContinue = new JLabel("続けますか");
        buttonContinue = new JButton("続ける");
        buttonEnd = new JButton("終了");

        add(textRank);
        textRank.setBounds(10,0,100,150);
        
        dispRankPanel = new JPanel();       
        dispRankPanel.setLayout(new GridLayout(4,1));
        dispRankPanel.setBounds(100, 30, 100, 90);
        dispRankPanel.setBackground(Color.green);
        for(int i=0;i<4;i++){
            textRanking[i] = new JLabel();
            dispRankPanel.add(textRanking[i]);
        }
        add(dispRankPanel);
        
        add(textContinue);
        textContinue.setBounds(200,100,100,100);
        add(buttonContinue);
        buttonContinue.setBounds(50,200,100,50);
        add(buttonEnd);
        buttonEnd.setBounds(300,200, 100, 50);

        buttonContinue.addActionListener(this);
        buttonEnd.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

        @Override
    public void actionPerformed(ActionEvent e){
        JButton bt = (JButton) e.getSource();
        if( bt == buttonContinue )
            setRankFlag(false);    
        if( bt == buttonEnd )
            goTerminate();
    }
    public void dispResult(int[] pass){  
        for(int i=0;i<pass.length;i++){
            pass[i] = pass[i]+1;
        }
        int rank[] = {0,0,0,0};
        String s[] = {"User","Cpu1","Cpu2","Cpu3"};
        int ranking = pass.length-1;
        for(int j=ranking;j>=0;j--){
            int k = pass[0],p = 0;
            for(int i=0;i<=ranking;i++){
                if(pass[i]>=k){
                    k = pass[i];
                    p = i;
                }
            }
            rank[p] = p;
            textRanking[j].setText(s[p]);
            pass[p] = 0;
 
        }
        
    }
    private void goTerminate(){
        System.exit(0); 
    }
    public void setRankFlag(boolean b){
        dispRankFlag = b ;
    }
    public boolean getRankFlag(){
        return dispRankFlag;

    }
}
