
import java.util.*;

/**
 * Set the Questions to be previewed by the GUI
 * @author egua4
 */

public class ShortAnswer
{
    public String questions;
    //public String answers;
    public int timerInSeconds = 0; //set from Question class
    
    /**
     * Question array list for all MultiChoice question
     */
    public ArrayList<String> arrQues = new ArrayList<>();
    /**
     * Answer array list for all Short answers
     */
    public ArrayList<String> arrAns = new ArrayList<>();
    
    public Queue<String> queQuestion = new LinkedList<>();
    public Queue<String> queAnswer = new LinkedList<>();
    
    public static int iterator = 0;
    public static boolean isSame = false;
    private final Object mutex = new Object();
    
    /**
     * Constructor
     * Sets the questions and answers
     * @param question
     * @param answer
     * @return Question object
     */
    public Question makeShortAnswerQuestion(String question, String answer)
    {        
        arrQues.add(question);
        arrAns.add(answer);
        
        return new Question(Core.sa);
    }
        
    public void UI()
    {
        System.out.println("This method calls the shortanswer plugin to show "
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
                    MultiChoice.isSame = false;
                }
                else
                {
                    this.questions = arrQues.get(iterator);
                    Question.Answer = arrAns.get(iterator);
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
