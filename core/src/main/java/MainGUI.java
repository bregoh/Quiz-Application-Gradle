
import javax.swing.JFrame;


/**
 * This class creates the first GUI
 * Requests the pluginName
 * Validate the pluginName/Show error messages
 * Call the runQuiz method of the plugin App
 * @author egua4
 */
public class MainGUI 
{
    static JFrame mainframe;
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton continueBtn;
    public javax.swing.JLabel errorLabel;
    private javax.swing.JLabel pluginNameLabel;
    private javax.swing.JTextField pluginNameTF;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration  
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {

        titleLabel = new javax.swing.JLabel();
        pluginNameLabel = new javax.swing.JLabel();
        pluginNameTF = new javax.swing.JTextField();
        continueBtn = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        
        mainframe = new JFrame();

        mainframe.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Lucida Fax", 1, 48)); // NOI18N
        titleLabel.setText("QUIZ APP");
        titleLabel.setToolTipText("");

        pluginNameLabel.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        pluginNameLabel.setText("Plugin Name");

        continueBtn.setText("Continue");
        continueBtn.addActionListener(this::continueBtnActionPerformed);

        errorLabel.setFont(new java.awt.Font("Lucida Fax", 3, 10)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("If plugin is a subproject, enter subproject/folder name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainframe.getContentPane());
        mainframe.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pluginNameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(continueBtn)
                        .addGap(279, 279, 279))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pluginNameLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(322, 322, 322))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(pluginNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(continueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pluginNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        mainframe.pack();
        //mainframe.setVisible(true);
    }// </editor-fold>  
    
    
    private void continueBtnActionPerformed(java.awt.event.ActionEvent evt) 
    {                                        
        runPlugin(pluginNameTF.getText());
    }
    
    /**
     * Get the class file path of the pluginName
     * Call the runQuiz() method
     * @param path 
     */
    public void runPlugin(String path)
    {
        try
        {   
            Core core = new Core();
            
            Quiz quiz = (Quiz) core.loadPlugin(path);
            
            mainframe.dispose();
            quiz.runQuiz(core);
            
        }
        catch(ClassCastException | ClassNotFoundException e)
        {
            errorLabel.setText("<html><p>"+path+" not found in the App</p></html>");
            System.out.println("Exception Caught \nClass Name : "+getClass().getName()+"\n \n Message : "+e.getMessage());
        }
    }
}
