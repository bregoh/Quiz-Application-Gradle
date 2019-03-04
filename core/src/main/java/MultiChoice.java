
import java.util.*;

/**
 * Sets the questions to be previewed by the GUI
 * @author egua4
 */
public class MultiChoice
{
    public String questions;
    public String[] options;
    //public String answers;
    public int timerInSeconds = 0; // set from Question class
    
    /**
     * Question array list for all MultiChoice question
     */
    public ArrayList<String> arrQues = new ArrayList<>();
    
    /**
     * Answer array list for all MultiChoice answers
     */
    public ArrayList<String> arrAns = new ArrayList<>();
    
    /**
     * Answer Option array list for all MultiChoice Options
     */
    public ArrayList<String[]> arrOptions = new ArrayList<>();
    
    public static int iterator = 0;
    public static boolean isSame = false;
    private final Object mutex = new Object();
    
    /**
     * Constructor
     * Sets the questions, options and answers
     * @param question
     * @param option
     * @param answer
     * @return Question object
     */
    public Question makeMultiChoiceQuestion(String question, String[] option, int answer)
    {
        arrQues.add(question);
        arrOptions.add(option);
        arrAns.add(option[answer]);
        
        return new Question(Core.mc);
    }
        
    
    public void UI()
    {
        System.out.println("This method calls the multichoice plugin to show "
                + "the question. It is overriden by the same method in "
                + "the gui plugin");
    }
    
    /**
     * Set the Questions, Options and Answers
     */
    public void setQA()
    {
        try
        {
            synchronized(mutex)
            {
                if(Question.ispreview)
                {
					// Check if the last question was retrieved from same class
					// if yes, take next question.
                    if(isSame)
                    {
                        Question.previewQuestion = arrQues.get(iterator + 1);
                    }
                    else
                    {
                        Question.previewQuestion = arrQues.get(iterator);
                    }
                    
                    isSame = true;
                    ShortAnswer.isSame = false;
                }
                else
                {
                    this.questions = arrQues.get(iterator);
                    Question.Answer = arrAns.get(iterator);
                    this.options = arrOptions.get(iterator);
                    iterator++;
                }
                
                
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Exception Caught \nClass Name : "+getClass().getName()+"\n \n Message : "+e.getMessage());
        }
    }
}
