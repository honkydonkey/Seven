
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f1110800661
 */
class Administar extends Thread {
    
    private DispRank dr;
    private Member me;
    private Game ge;
    
    public Administar()
    {
        me = new Member();
        me.setVisible(true);
    }
    
    @Override
    public void run()
    {
        int mode=0;
        boolean meF, drF, geF;
        while(true)
        {
            switch(mode)
            {
                case 0:
                    meF = me.getMemberFlag();
                    me.setVisible(meF);
                    if(!meF)
                    {
                        mode = 1;
                        ge = new Game(me.getNumMember());
                        
                        ge.setVisible(true);
                        me.setVisible(false);
                        
                        me.setMemberFlag(true);
                    }
                    break;
                case 1:
                    geF = ge.getGameFlag();
                    
                    if(!geF)
                    {
                        mode = 2;
                        dr = new DispRank();
                        
                        dr.setVisible(true);
                        //int[] result = new int[me.getNumMember()];
                        //for(int i = 0; i < me.getNumMember(); i++) result[i] = ge.getPass(i);
                        //dr.dispResult(result);
                        dr.dispResult(ge.getPass());
                        ge.setVisible(false);
                       
                        ge.setGameFlag(true);
                    }
                    break;
                case 2:
                    drF = dr.getRankFlag();
                    
                    if(!drF)
                    {
                        mode = 0;
                        dr.setRankFlag(true);
                        dr.setVisible(false);
                    }
                    break;
            }
        }
    }
}
