
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TAKUMI
 */
public class UserPanel extends javax.swing.JPanel implements ActionListener{

    private User user;
    private int cardNumber;
    private int scCount;
    private boolean pass;
    
    private Game ga;
    
    
    /**
     * Creates new form UserPanel
     */
    public UserPanel() {
        scCount = 0;
        pass = false;
        user = new User();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftscrollButton = new javax.swing.JButton();
        buttonHand1 = new javax.swing.JButton();
        buttonHand2 = new javax.swing.JButton();
        buttonHand3 = new javax.swing.JButton();
        buttonHand4 = new javax.swing.JButton();
        rightscrollButton = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        passButton = new javax.swing.JButton();

        setLayout(null);

        leftscrollButton.setText("<");
        leftscrollButton.addActionListener(this);
        add(leftscrollButton);
        leftscrollButton.setBounds(-3, 0, 44, 100);

        buttonHand1.addActionListener(this);
        add(buttonHand1);
        buttonHand1.setBounds(40, 0, 75, 100);

        buttonHand2.addActionListener(this);
        add(buttonHand2);
        buttonHand2.setBounds(110, 0, 75, 100);

        buttonHand3.addActionListener(this);
        add(buttonHand3);
        buttonHand3.setBounds(180, 0, 75, 100);

        buttonHand4.addActionListener(this);
        add(buttonHand4);
        buttonHand4.setBounds(250, 0, 75, 100);

        rightscrollButton.setText(">");
        rightscrollButton.addActionListener(this);
        add(rightscrollButton);
        rightscrollButton.setBounds(320, 0, 44, 100);

        userLabel.setText("<html>貴方の番です<br>Pass:0回<br>残り:0枚</html>");
        add(userLabel);
        userLabel.setBounds(370, 0, 80, 150);

        button.setText("出す");
        add(button);
        button.setBounds(30, 100, 140, 40);

        passButton.setText("パス");
        passButton.addActionListener(this);
        add(passButton);
        passButton.setBounds(180, 100, 140, 40);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button;
    private javax.swing.JButton buttonHand1;
    private javax.swing.JButton buttonHand2;
    private javax.swing.JButton buttonHand3;
    private javax.swing.JButton buttonHand4;
    private javax.swing.JButton leftscrollButton;
    private javax.swing.JButton passButton;
    private javax.swing.JButton rightscrollButton;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables

    
    public void setImage(Icon ic, int num){
        switch(num + 1){
            case 1:
                buttonHand1.setIcon(ic);
                break;
            case 2:
                buttonHand2.setIcon(ic);
                break;
            case 3:
                buttonHand3.setIcon(ic);
                break;
            case 4:
                buttonHand4.setIcon(ic);
                break;
            default:
                break;
        }
    }
    public void setLabel(){
        userLabel.setText("<html>貴方の番です<br>"
                + "Pass:" + user.getPass() + "回<br>"
                + "残り:" + user.getUserNumCard() + "枚</html>");
    }
    public void setUser(Card c){
        user.setUserHand(c);
    }
    private void setPass(boolean b){
        pass = b;
    }
    public void setCardNumber(int set){
        //cardNumberを外から書き換えたいことがあったので追加
        cardNumber = set;
    }
    public void setGame(Game set){
        //インチキメソッド
        this.ga = set;
    }
    public boolean getPass(){
        return pass;
    }
    public int getUserps(int i){
        return user.getPass();
    } 
    public int getCardNumber(){
        return cardNumber;
    }
    public User getUser(){
        return this.user;
    }
    public void dispButtonImage(){
         //左右スクロールの処理の中身を独立させたメソッド
        
//        if(scCount >= user.getUserNumCard()){
//            //scCount = user.getUserNumCard() - 1;
//        }
        
        //System.out.println(scCount);//テスト用の行
        
        for(int i = 0 ; i < 4; i++){
            if(i >= user.getUserNumCard()) setImage(null, i);
            //else setImage(user.getHandCard().get((scCount + i) % user.getUserNumCard()).getImage(),i);
            else setImage(user.getHandCard().get((scCount + i) % user.getUserNumCard()).getImage(), i);
            
            //System.out.print(((scCount + i) % user.getUserNumCard()) + " ");//テスト用の行
            
        }
        System.out.println();
    }
    public void adjScCount(){
        //出したカードに応じてscCountを補正するメソッド
        if(scCount > cardNumber) scCount--;
    }
    public void setDasuButtonListener(ActionListener a){
        //外からイベントを追加するためのセッター
        button.addActionListener(a);
    }
//    public void setPassButtonListener(ActionListener a){
//        //外からイベントを追加するためのセッター
//        passButton.addActionListener(a);
//    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rightscrollButton){
            cardNumber = -1;
            scCount = scCount + 1;
            if(scCount == user.getUserNumCard()){
                scCount = 0;
            }
            dispButtonImage();
            
        }else if(e.getSource() == leftscrollButton){
            cardNumber = -1;
            scCount = scCount -1;
            if(scCount < 0){
                scCount = user.getUserNumCard() -1 ;
            }
            dispButtonImage();
            
        }else if(e.getSource() == passButton){
            user.setPass();
            pass = false;
            cardNumber = -1;
            setLabel();
            this.ga.setLog(new Card(),0);
            
            
            //ここにCPUのための処理を書く
            this.ga.doGame();
            
        }else if(e.getSource() == buttonHand1){
            if(user.getUserNumCard() < 1){
                cardNumber = -1;
                return;
            }
            cardNumber = ((scCount+0) % user.getUserNumCard());
        }else if(e.getSource() == buttonHand2){
            if(user.getUserNumCard() < 2){
                cardNumber = -1;
                return;
            }
            cardNumber = ((scCount+1)  % user.getUserNumCard());
        }else if(e.getSource() == buttonHand3){
            if(user.getUserNumCard() < 3){
                cardNumber = -1;
                return;
            }
            cardNumber = ((scCount+2)  % user.getUserNumCard());
        }else if(e.getSource() == buttonHand4){
            if(user.getUserNumCard() < 4){
                cardNumber = -1;
                return;
            }
            cardNumber = (scCount+3)  % user.getUserNumCard();
        }
    }
}