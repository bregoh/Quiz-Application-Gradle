
import javax.swing.JFrame;

import javax.swing.Timer;

/**
 * GUI for multi choice Quiz
 * @author egua4
 */
public class multichoiceplugin extends MultiChoice
{
    public static String MCquestions;
    public static String MCanswers;
    public static String[] MCoptions;
    public static String pQuestion;
    public static int timerInSec;
    static JFrame mainFrame;
    
    public static Timer timerThread;
    
    public static String option1;
    public static String option2;
    public static String option3;
    public static String option4;
    
    // Variables declaration                    
    private javax.swing.JButton endBtn;
    private javax.swing.JRadioButton option1JRB;
    private javax.swing.JRadioButton option2JRB;
    private javax.swing.JRadioButton option3JRB;
    private javax.swing.JRadioButton option4JRB;
    private javax.swing.JButton nextBtn;
    private javax.swing.ButtonGroup optionGroup;
    public javax.swing.JLabel questionLabel;
    private javax.swing.JButton reloadBtn;
    private javax.swing.JButton restartBtn;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel nextLabel;
    private javax.swing.JLabel previewLabel;
    // End of variables declaration     
    
     // <editor-fold defaultstate="collapsed" desc="GUI Components">                         
    private void initComponents() {

        optionGroup = new javax.swing.ButtonGroup();
        reloadBtn = new javax.swing.JButton();
        restartBtn = new javax.swing.JButton();
        timerLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        nextLabel = new javax.swing.JLabel();
        previewLabel = new javax.swing.JLabel();
        nextBtn = new javax.swing.JButton();
        endBtn = new javax.swing.JButton();
        option1JRB = new javax.swing.JRadioButton(option1);
        option2JRB = new javax.swing.JRadioButton(option2);
        option3JRB = new javax.swing.JRadioButton(option3);
        option4JRB = new javax.swing.JRadioButton(option4);
        
        mainFrame = new JFrame();

        mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setPreferredSize(new java.awt.Dimension(907, 547));

        reloadBtn.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        reloadBtn.setText("Reload New Quiz");
        reloadBtn.addActionListener(this::reloadBtnActionPerformed);

        restartBtn.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        restartBtn.setText("Restart Quiz");
        restartBtn.addActionListener(this::restartBtnActionPerformed);

        timerLabel.setFont(new java.awt.Font("Lucida Fax", 0, 16)); // NOI18N
        startTimer();
        
        nextLabel.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        nextLabel.setText("Next Question: ");

        previewLabel.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        previewLabel.setText("<html><p>"+pQuestion+"</p></html>");

        questionLabel.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        questionLabel.setText(MCquestions);
        
        nextBtn.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        nextBtn.setText("Next");
        nextBtn.addActionListener(this::nextBtnActionPerformed);

        endBtn.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        endBtn.setText("End Quiz");
        endBtn.addActionListener(this::endBtnActionPerformed);

        optionGroup.add(option1JRB);
        option1JRB.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        option1JRB.setActionCommand(option1);

        optionGroup.add(option2JRB);
        option2JRB.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        option2JRB.setActionCommand(option2);

        optionGroup.add(option3JRB);
        option3JRB.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        option3JRB.setActionCommand(option3);
        optionGroup.add(option4JRB);
        option4JRB.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        option4JRB.setActionCommand(option4);        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainFrame.getContentPane());
        mainFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nextLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(previewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(option1JRB)
                    .addComponent(option2JRB)
                    .addComponent(option3JRB)
                    .addComponent(option4JRB))
                .addContainerGap(679, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(reloadBtn)
                            .addGap(209, 209, 209)
                            .addComponent(restartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(endBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(questionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(107, 107, 107)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(option1JRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option2JRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option3JRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option4JRB)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextLabel)
                    .addComponent(previewLabel))
                .addGap(51, 51, 51))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(restartBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(reloadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(timerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(73, 73, 73)
                    .addComponent(questionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(181, 181, 181)
                    .addComponent(endBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(51, 51, 51)))
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
        multichoiceplugin.MCquestions = "<html><p>"+questions+"</p></html>";
        //multichoiceplugin.MCanswers = answers;
        multichoiceplugin.timerInSec = timerInSeconds;
        
        multichoiceplugin.option1 = options[0];
        multichoiceplugin.option2 = options[1];
        multichoiceplugin.option3 = options[2];
        multichoiceplugin.option4 = options[3];
        
        multichoiceplugin.pQuestion = Question.previewQuestion;
        new multichoiceplugin().initComponents();
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
                    timerThread.stop();
                    nextQuestion();
                }
            });

            timerThread.start();
        }
    }
    
        
    /**
     * get the next question
     */
    void nextQuestion()
    {
        if(optionGroup.getSelection() != null)
        {
            Question.checkAnswer(optionGroup.getSelection().getActionCommand());
        }
        
        if(timerThread != null)
        {
            timerThread.stop();
        }
        
        mainFrame.dispose();
        Question.next();
    }
    
}
