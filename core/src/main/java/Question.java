


/**
 * Question class 
 * 1. Determine how best to show the questions
 * 2. Calculate the user's score
 * 3. Show result
 * 4. Reset the Quiz if requested
 * 5. Sets the Quiz timer if necessary
 * @author egua4
 */
public class Question
{
    Object obj;
    public int timerInSeconds = 0; // Quiz timer in seconds
    public static int position = 0; //iterating position of the next Question 
    //object to invoke
    public static int scores = 0; //user's score
    
    public static boolean ispreview = false;
    public static String previewQuestion;
    public static int previewIteratior = 0;
    
    public static String Answer;
    
    public static Question[] questionObj; //Array of the question obj in order 
    //of display
    //public static ArrayList<Question> arraysObj;
    
    /**
     * Constructor
     * set the class object when a question is invoked
     * @param o 
     */
    public Question(Object o)
    {
        this.obj = o;
    }
    
    /**
     * determine the correct class object
     * set the class variables for questions, answers and options
     * call the appropriate GUI to show the question
     */
    public void invoke()
    {
        if(obj instanceof ShortAnswer)
        {
            ShortAnswer sa = ((ShortAnswer) obj);
            sa.timerInSeconds = timerInSeconds;
            sa.setQA();
            if(!ispreview)
            {
                sa.UI();
            }
        }
        else if(obj instanceof MultiChoice)
        {
            MultiChoice mc = ((MultiChoice) obj);
            mc.timerInSeconds = timerInSeconds;
            mc.setQA();
            if(!ispreview)
            {
                mc.UI();
            }
        }
    }
    
    /**
     * set the question timer in seconds
     * @param sec 
     */
    public void setTimer(int sec)
    {
        this.timerInSeconds = sec;
    }
    
    /**
     * Set the array of question object
     * call the run test object
     * @param arr 
     */
    public static void startTest(Question[] arr)
    {        
        questionObj = arr;
        runTest();
    }
    
    /**
     * Get the Question object from the Question array
     * invoke the object
     * set preview question
     * call the printResult() in Result class
     */
    public static void runTest()
    {
		// Show the result window if the question array is fully iterated
        if(position >= questionObj.length) 
        {
            new ResultUI().printResult("Your score is "+scores+"/"+questionObj.length);
        } 
        else 
        {
			//get the next question preview
            if(previewIteratior < questionObj.length)
            {
                preview();
                ispreview =  false;
            }
            questionObj[position].invoke();
        }
    }
    
    /**
	* Retrieves the next question
	**/
    public static void next()
    {
        Question.position++;
        Question.runTest();
    }
    
    /**
     * Validate the answer to each question
     * @param answer 
     */
    public static void checkAnswer(String answer)
    {
        if(Answer.equalsIgnoreCase(answer))
        {
            Question.setScore();
        }
    }
    
    /**
     * Record user scores for every correct answer
     * increments the score variable by 1
     */
    public static void setScore()
    {
        Question.scores++;
    }
    
    /**
     * Resets the quiz at the end of a session
	 * OR
	 * When the Quiz restarts
     */
    public static void reset()
    {
        Question.scores = 0;
        Question.previewIteratior = 0;
        Question.position = 0;
        ShortAnswer.iterator = 0;
        MultiChoice.iterator = 0;
        
        ShortAnswer.isSame = false;
        MultiChoice.isSame = false;
    }
	
	/**
	** Reloads a new Quiz
	**/
	public static void reload()
	{
		Question.reset();
		Core.main(new String[] {"a"});
	}
	
	/**
	** Restarts the Quiz
	**/
	public static void restart()
	{
		Question.reset();
        Question.runTest();
	}
    
    /**
     * Previews the next question on the current question GUI
     */
    public static void preview()
    {
        ispreview = true;
        previewIteratior = position + 1;
        if(previewIteratior != questionObj.length)
            questionObj[previewIteratior].invoke();
        else
            Question.previewQuestion = null;
    }
    
}
