
import javax.swing.JFrame;

import javax.swing.Timer;

/**
 * GUI for short answers Quiz
 * @author egua4
 */
public class shortanswerplugin extends ShortAnswer
{
    public static String SAquestions;
    public static String SAanswers;
    public static String pQuestion;
    public static int timerInSec;
    static JFrame mainFrame;
    
    public static Timer timerThread;
    
    // Variables declaration - do not modify                     
    private javax.swing.JTextField answerTF;
    private javax.swing.JButton endBtn;
    private javax.swing.JButton nextBtn;
    public javax.swing.JLabel questionLabel;
    private javax.swing.JButton reloadBtn;
    private javax.swing.JButton restartBtn;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel nextLabel;
    private javax.swing.JLabel previewLabel;
    // End of variables declaration  
        
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        timerLabel = new javax.swing.JLabel();
        reloadBtn = new javax.swing.JButton();
        restartBtn = new javax.swing.JButton();
        answerTF = new javax.swing.JTextField();
        nextBtn = new javax.swing.JButton();
        endBtn = new javax.swing.JButton();
        questionLabel = new javax.swing.JLabel();
        nextLabel = new javax.swing.JLabel();
        previewLabel = new javax.swing.JLabel();
        
        mainFrame = new JFrame();

        mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setPreferredSize(new java.awt.Dimension(907, 547));
        

        timerLabel.setFont(new java.awt.Font("Lucida Fax", 0, 16)); // NOI18N
        startTimer();
        
        nextLabel.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        nextLabel.setText("Next Question: ");

        previewLabel.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        previewLabel.setText("<html><p>"+pQuestion+"</p></html>");

        reloadBtn.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        reloadBtn.setText("Reload New Quiz");
        reloadBtn.addActionListener(this::reloadBtnActionPerformed);

        restartBtn.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        restartBtn.setText("Restart Quiz");
        restartBtn.addActionListener(this::restartBtnActionPerformed);

        answerTF.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N

        nextBtn.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        nextBtn.setText("Next");
        nextBtn.addActionListener(this::nextBtnActionPerformed);

        endBtn.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        endBtn.setText("End Quiz");
        endBtn.addActionListener(this::endBtnActionPerformed);

        questionLabel.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        
        questionLabel.setText(SAquestions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainFrame.getContentPane());
        mainFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(reloadBtn)
                                .addGap(209, 209, 209)
                                .addComponent(restartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nextLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(previewLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(endBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(answerTF)
                                .addGap(18, 18, 18)
                                .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(169, 169, 169))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restartBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(reloadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73)
                .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerTF, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(181, 181, 181)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(endBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nextLabel)
                        .addComponent(previewLabel)))
                .addGap(85, 85, 85))
        );

        mainFrame.pack();
        
    }// </editor-fold>
    
    /**
     * Next Question action event
     * @param evt 
     */
    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {                                        
        // TODO add your handling code here:
        
        nextQuestion();
    }
    
    /**
     * Restart Quiz action event
     * @param evt 
     */
    private void restartBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {                                        
        // TODO add your handling code here:
        if(timerThread != null)
        {
            timerThread.stop();
        }
        mainFrame.dispose();
		Question.restart();
    }
    
    /**
     * Reload Quiz action event
     * @param evt 
     */
    private void reloadBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {                                        
        // TODO add your handling code here:
        if(timerThread != null)
        {
            timerThread.stop();
        }
        mainFrame.dispose();
        Question.reload();
    }
    
    /**
     * End Quiz action event
     * @param evt 
     */
    private void endBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {                                        
        // TODO add your handling code here:
        if(timerThread != null)
        {
            timerThread.stop();
        }
        mainFrame.dispose();
        new ResultUI().printResult("Your score is "+Question.scores+"/"+Question.questionObj.length);
    }
    
    /**
     * Overrides the inherited method
     * set the questions, answers and timer
     * set the next question on preview
     * set the GUI visibility
     */
    @Override
    public void UI()
    {
        shortanswerplugin.SAquestions = "<html><p>"+questions+"</p></html>";
        //shortanswerplugin.SAanswers = answers;
        shortanswerplugin.timerInSec = timerInSeconds;
        shortanswerplugin.pQuestion = Question.previewQuestion;
        
        new shortanswerplugin().initComponents();
        mainFrame.setVisible(true);
        
        
    }
    
    /**
     * Update the value of GUI timer at interval
     */
    private void runTimer() 
    {                                        
        timerLabel.setText("Time :"+Integer.toString(--timerInSec)+"sec");
    }
    
    /**
     * Start the timer thread
     * timer value should be > 0
     */
    private void startTimer()
    {
        if(timerInSec > 0)
        {
        timerThread = new Timer(1400,(e) -> {
            
            if(timerInSec > 1)
            {
                runTimer();
            }
            else
            {
                //timerInSec = timerInSeconds;
                timerThread.stop();
                nextQuestion();
            }
            //System.out.println(--interval);
        });

        timerThread.start();
        }
    }
    
    
    /**
     * get the next question
     */
    public void nextQuestion()
    {
        String a = answerTF.getText();
        if(!a.equalsIgnoreCase(""))
        {
            Question.checkAnswer(a);
            
        }
        if(timerThread != null)
        {
            timerThread.stop();
        }
        mainFrame.dispose();
        Question.next();
    }
    
    
}
