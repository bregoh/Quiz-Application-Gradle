
/**
 * Set the class object in the Core class
 * Loads the GUI objects * 
 * @author egua4
 
 Code reference: Assignment Document page 2 05/10/2018
 */
public class foodQuiz implements Quiz{
    
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
            Question q1 = sa.makeShortAnswerQuestion("Rice is what type of food "
                    + "group?", "carbohydrates");
            //q1.setTimer(10);
            
            Question q2 = mc.makeMultiChoiceQuestion("Milk is a source of?", 
                    new String[]{"protein", "fat", "vitamin", "carbohydrates"}, 
                    0);
            //q2.setTimer(10);
            
            Question q3 = mc.makeMultiChoiceQuestion("Parata is mostly made "
                    + "with?", new String[]{"rice flour", "wheat flour", 
                        "corn flour", "mayorka flour"}, 1);
            //q3.setTimer(15);
            
            Question q4 = sa.makeShortAnswerQuestion("What is the family of "
                    + "oranges", "Citrus");
            //q4.setTimer(10); 
            
            Question q5 = sa.makeShortAnswerQuestion("What is the color of "
                    + "water", "colorless");
            
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
