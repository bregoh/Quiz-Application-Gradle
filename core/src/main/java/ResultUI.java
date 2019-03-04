
import javax.swing.JFrame;

/**
 * GUI to show the final result of the Quiz
 * @author egua4
 */
public class ResultUI 
{
    static JFrame mainframe;
    static String result;
    // Variables declaration - do not modify                     
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton startNewBtn;
    // End of variables declaration   
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        headerLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        startNewBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        
        mainframe = new JFrame();

        mainframe.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mainframe.setPreferredSize(new java.awt.Dimension(907, 547));

        headerLabel.setFont(new java.awt.Font("Lucida Fax", 1, 42)); // NOI18N
        headerLabel.setText("Your Result");

        scoreLabel.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        scoreLabel.setText(ResultUI.result);

        startNewBtn.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        startNewBtn.setText("Start Another Quiz");
        startNewBtn.addActionListener(this::startNewBtnActionPerformed);

        exitBtn.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        exitBtn.setText("Exit Quiz");
        exitBtn.addActionListener(this::exitBtnActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainframe.getContentPane());
        mainframe.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(startNewBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(336, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(headerLabel)
                        .addGap(297, 297, 297))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scoreLabel)
                        .addGap(412, 412, 412))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(headerLabel)
                .addGap(75, 75, 75)
                .addComponent(scoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(startNewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        mainframe.pack();
    }// </editor-fold> 
    
    /**
     * Button event to start a new quiz
     * @param evt 
     */
    private void startNewBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {                                        
        // TODO add your handling code here:
        mainframe.dispose();
        Question.reload();
    }
    
    /**
     * Button event to exit from the Quiz
     * @param evt 
     */
    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {                                        
        // TODO add your handling code here:
        System.exit(0);
    }
    
    /**
     * prints the final score from the Quiz
     * @param result 
     */
    public void printResult(String result)
    {
        ResultUI.result = result;
        initComponents();
        mainframe.setVisible(true);
    }
    
}
