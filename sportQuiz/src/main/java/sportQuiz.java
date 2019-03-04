
/**
 * Set the class object in the Core class
 * Loads the GUI objects * 
 * @author egua4
 
 Code reference: Assignment Document page 2 05/10/2018
 */
public class sportQuiz implements Quiz{
    
    @Override
    public void runQuiz(Core loader) 
    {        
        try 
        {
            /*
            ** Create a class Object
            */
            ShortAnswer sa;
            MultiChoice mc;
            
            /*
            ** Load the reference of the GUI object
            ** Assign the object to the relevant class
            */
            sa = (ShortAnswer) loader.loadPlugin("shortanswerplugin");
            mc = (MultiChoice) loader.loadPlugin("multichoiceplugin");
            
            /**
             * Set GUI reference object Object in the Core class
             */
            loader.setObj(sa);
            loader.setObj(mc);
            
            /**
             * Questions to be displayed
             */
            Question q1 = sa.makeShortAnswerQuestion("What is the governing "
                    + "body of football called?", "fifa");
            q1.setTimer(10);
            
            Question q2 = mc.makeMultiChoiceQuestion("In what year is Japan and "
                    + "South Korea host the world cup?", new String[]{"1994", 
                        "2006", "2002", "1998"}, 2);
            q2.setTimer(10);
            
            Question q3 = mc.makeMultiChoiceQuestion("Who is the current "
                    + "footballer of the year?", new String[]{"C. Ronaldo", 
                        "Luka Modric", "Leo Messi", "Neymar"}, 1);
            q3.setTimer(15);
            
            Question q4 = sa.makeShortAnswerQuestion("Who is the current "
                    + "Manchester United manager", "Jose Mouriho");
            q4.setTimer(10);
            
            Question q5 = mc.makeMultiChoiceQuestion("Who cost liverpool the "
                    + "premier league title in 2014?", new String[]{"Xabi "
                            + "Alonso", "Luis Saurez", "Raheem Sterling", 
                            "Steven Gerrad"}, 3);
            
            /**
             * Set the question object in array
             * In order of display
             */
            Question [] quesArray = {q1, q2, q3, q4, q5};            
            Question.startTest(quesArray);
        } 
        catch (ClassNotFoundException | ClassCastException | NullPointerException | IllegalAccessError ex) 
        {
            System.out.println("Exception Caught \nClass Name : "+getClass().getName()+"\n \n Message : "+ex.getMessage());
        }
    } 
}
