
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
 * @author f1110800661
 */
public class Member extends JFrame implements ActionListener {

    private JPanel  memberPanel;
    private JButton memberButton2;
    private JButton memberButton3;
    private JButton memberButton4;
    private JLabel  textMember;
    private boolean memberFlag;
    private int     numMember;
    
    Member()
    {
        memberFlag = true;

        memberPanel     = new JPanel();
        memberButton2   = new JButton("2人");
        memberButton3   = new JButton("3人");
        memberButton4   = new JButton("4人");
        textMember      = new JLabel("何人で遊びますか？(4人まで)");

        memberButton2.addActionListener(this);
        memberButton3.addActionListener(this);
        memberButton4.addActionListener(this);        
        
        setLayout(new GridLayout(2, 1));
        add(textMember);
        add(memberPanel);
        memberPanel.setLayout(new GridLayout(1, 3));
        memberPanel.add(memberButton2);
        memberPanel.add(memberButton3);
        memberPanel.add(memberButton4);
        
        setSize(200, 100);
        //setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == memberButton2) setNumMember(2);
        else if(e.getSource() == memberButton3) setNumMember(3);
        else if(e.getSource() == memberButton4) setNumMember(4);
        setMemberFlag(false);
    }
    
    public void setMemberFlag(boolean memberFlag)
    {
        this.memberFlag = memberFlag;
    }
    
    public boolean getMemberFlag()
    {
        return this.memberFlag;
    }
    
    private void setNumMember(int numMember)
    {
        this.numMember = numMember;
    }
    
    public int getNumMember()
    {
        return this.numMember;
    }
}
