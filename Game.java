
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f1110800151
 */
public class Game extends javax.swing.JFrame implements ActionListener{

    private JLabel[] labelCard;
    private int allNumCard;
    private int numMember;
    private boolean[][] fieldCard;
    private boolean gameFlag;
    private CardDeck carddeck;
    private int[] pass;
    /**
     * Creates new form Game
     */
    public Game(){};
    public Game(int numMember) {
        
        labelCard = new JLabel[12];
        for(int i = 0; i < 12; i++)labelCard[i] = new JLabel();
        
        this.numMember  = numMember;
        this.allNumCard = 48;
        this.pass = new int[4];
        for(int i = 0; i < 4; i++)this.pass[i]    = 0;
        
        this.carddeck = new CardDeck();
        
        this.fieldCard = new boolean[4][13];
        for(int i=0; i<4; i++)
        {
            for(int j=0; j<13; j++)
            {
                this.fieldCard[i][j] = false;
            }
        }
        for(int k=0; k<4; k++)
        {
            this.fieldCard[k][5] = true;
            this.fieldCard[k][6] = true;
            this.fieldCard[k][7] = true;
        }
        
        initComponents();
        
        drawCard(new Card());
        
        panelUser.setGame(this);
        panelUser.setLabel();
        panelUser.dispButtonImage();
        panelUser.setDasuButtonListener(this);
        
        for(int i = 0; i < numMember - 1; i++){
            panelCpu.dispLabel(i);
        }
        
        getContentPane().setPreferredSize(new Dimension(640,480));
        pack();
        
        gameFlag = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GamePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textLog = new javax.swing.JTextArea();
        panelUser = new UserPanel();
        labelCard11 = labelCard[11];
        labelCard0 = labelCard[0];
        labelCard1 = labelCard[1];
        labelCard2 = labelCard[2];
        labelCard3 = labelCard[3];
        labelCard4 = labelCard[4];
        labelCard5 = labelCard[5];
        labelCard6 = labelCard[6];
        labelCard7 = labelCard[7];
        labelCard8 = labelCard[8];
        labelCard9 = labelCard[9];
        labelCard10 = labelCard[10];
        panelCpu = new CpuPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(null);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        GamePanel.setMinimumSize(new java.awt.Dimension(640, 480));
        GamePanel.setLayout(null);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        textLog.setColumns(20);
        textLog.setLineWrap(true);
        textLog.setRows(5);
        textLog.setWrapStyleWord(true);
        textLog.setEditable(false);
        jScrollPane1.setViewportView(textLog);

        GamePanel.add(jScrollPane1);
        jScrollPane1.setBounds(450, 0, 190, 480);
        GamePanel.add(panelUser);
        panelUser.setBounds(0, 330, 450, 150);

        labelCard11.setPreferredSize(new java.awt.Dimension(71, 96));
        GamePanel.add(labelCard11);
        labelCard11.setBounds(370, 230, 71, 96);
        GamePanel.add(labelCard0);
        labelCard0.setBounds(10, 130, 71, 96);

        labelCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1-7.gif"))); // NOI18N
        GamePanel.add(labelCard1);
        labelCard1.setBounds(80, 130, 71, 96);
        GamePanel.add(labelCard2);
        labelCard2.setBounds(150, 130, 71, 96);
        GamePanel.add(labelCard3);
        labelCard3.setBounds(230, 130, 71, 96);

        labelCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2-7.gif"))); // NOI18N
        GamePanel.add(labelCard4);
        labelCard4.setBounds(300, 130, 71, 96);
        GamePanel.add(labelCard5);
        labelCard5.setBounds(370, 130, 71, 96);
        GamePanel.add(labelCard6);
        labelCard6.setBounds(10, 230, 71, 96);

        labelCard7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3-7.gif"))); // NOI18N
        GamePanel.add(labelCard7);
        labelCard7.setBounds(80, 230, 71, 96);
        GamePanel.add(labelCard8);
        labelCard8.setBounds(150, 230, 71, 96);
        GamePanel.add(labelCard9);
        labelCard9.setBounds(230, 230, 71, 96);

        labelCard10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4-7.gif"))); // NOI18N
        GamePanel.add(labelCard10);
        labelCard10.setBounds(300, 230, 71, 96);
        GamePanel.add(panelCpu);
        panelCpu.setBounds(110, 10, 270, 80);

        getContentPane().add(GamePanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * @param args the command line arguments
     */
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                //new Game(3).setVisible(true);
//            }
//        });
//    }
//    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GamePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCard0;
    private javax.swing.JLabel labelCard1;
    private javax.swing.JLabel labelCard10;
    private javax.swing.JLabel labelCard11;
    private javax.swing.JLabel labelCard2;
    private javax.swing.JLabel labelCard3;
    private javax.swing.JLabel labelCard4;
    private javax.swing.JLabel labelCard5;
    private javax.swing.JLabel labelCard6;
    private javax.swing.JLabel labelCard7;
    private javax.swing.JLabel labelCard8;
    private javax.swing.JLabel labelCard9;
    private CpuPanel panelCpu;
    private UserPanel panelUser;
    private javax.swing.JTextArea textLog;
    // End of variables declaration//GEN-END:variables

    public void setLog(Card card, int a)
    {
        String mark[] = {"スペード","ハート","クラブ","ダイヤ"};
        String ap = "";
        if(a == 0){
            ap = "・YOUは、";
        }else{
            ap = "CPU" + a + "は、";
        }
        
        if(card.getValue() == 0){
            ap += "パスしました。\n";
        }else{
            ap += "\"" + mark[card.getColor()] + "の" + card.getValue() + "\"を出しました。\n";
        }
        
        textLog.append(ap);
        /*
        while(panelUser.getPass() == true){
            
        }
        */
    }
    
    private void setLabel(Card card)
    {
        if(card.getValue() > 7){
            labelCard[card.getColor() * 3 + 2].setIcon(card.getImage());
        }else{
            labelCard[card.getColor() * 3].setIcon(card.getImage());
        }
    }
    
    public void doGame()
    {
        int goal;
        do{
            goal = 0;
            for(int i = 0; i < numMember-1; i++){
                Card result = panelCpu.putCard(i, fieldCard);
                panelCpu.dispLabel(i);
                if(result.getValue() == 0){
                    setLog(new Card(),i+1);
                }else if(result.getValue() == -1){
                    goal ++;
                }else{

                    setLog(result,i+1);
                    setLabel(result);

                }
            }
            if(goal == (numMember-1))break;//全員上がったら離脱する
                
        }while(panelUser.getUser().getUserNumCard() == 0);
        
        if(goal == (numMember-1) && panelUser.getUser().getUserNumCard() == 0){
            //全員上がった時に終了処理を行う
            pass = new int[numMember];
            for(int i = 0; i < numMember; i++){
                if(i == 0) pass[i] = panelUser.getUserps(0);
                else pass[i] = panelCpu.getCpups(i - 1);
            }
            gameFlag = false;
            //System.out.println("終了");
        }
        
    }
    
    public void setGameFlag(boolean gameFlag)
    {
        this.gameFlag = gameFlag;
    }
    
    public boolean getGameFlag()
    {
        return this.gameFlag;
    }
    
//    public int getPass(int n){
//        //各プレイヤーのパス回数を返すメソッド
//        //0ならユーザー、1～3なら対応するCPU
//        //対応するプレイヤーがいなければ-1を返す
//        if(n > numMember - 1)return -1;
//        
//        if(n == 0)return panelUser.getUserps(0);
//        else return panelCpu.getCpups(n - 1);
//    }
    
    public void drawCard(Card card)
    {
        //for(int i = 0; i < allNumCard; i++){
        for(int i = 0; ; i++){
            
            //テスト用の処理
            //if(i % numMember != 0)continue;
            
            
            Card tmp = carddeck.getCard();
            if(tmp.getValue() == 0)break;
            
            //テスト用の処理
            /*
            if(tmp.getColor() != 1)continue;
            if(tmp.getValue() >= 7)continue;
            System.out.println(tmp.getColor() + " " + tmp.getValue());
            */
            
            switch(i % numMember){
                case 0:
                    panelUser.setUser(tmp);
                    break;
                case 1:
                    panelCpu.setCpu1(tmp);
                    break;
                case 2:
                    panelCpu.setCpu2(tmp);
                    break;
                case 3:
                    panelCpu.setCpu3(tmp);
                    break;
            }
        }
    }
    
    public int[] getPass()
    {
        return this.pass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //if(panelUser.getCardNumber() > panelUser.getUser().getUserNumCard()){
        if(panelUser.getCardNumber() == -1){
            //手札を超えた位置のカードを選択しようとしていたとき
            return;
        }


        Card tmp = panelUser.getUser().getHandCard().get(panelUser.getCardNumber());
        int color=tmp.getColor();
        int value=tmp.getValue() - 1;

        if( fieldCard[color][value] )
        {
            setLabel(tmp);
            setLog(tmp,0);

            panelUser.adjScCount();
            panelUser.getUser().getHandCard().remove(tmp);
            panelUser.getUser().setUserNumCard();

            if(value >= 7 && value + 1 < 13)fieldCard[color][value + 1] = true;
            else if(value - 1 >= 0) fieldCard[color][value - 1] = true;

            panelUser.setCardNumber(-1);
            panelUser.setLabel();
            panelUser.dispButtonImage();

            //ここにCPUのための処理を書く
            doGame();

        }
    }
        
    
}
