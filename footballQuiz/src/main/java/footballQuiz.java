
import java.util.ArrayList;

/**
 * Set the class object in the Core class
 * Loads the GUI objects * 
 * @author egua4
 
 Code reference: Assignment Document page 2 05/10/2018
 */
public class footballQuiz implements Quiz{
    
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
            
            ArrayList<Question> arr = new ArrayList<>();
            
            Question q1 = mc.makeMultiChoiceQuestion("What is the first name of the longest serving manager of Manchester United", new String[] {"Alex", "Bright", "Jose", "Pep"}, 0);
            q1.setTimer(10);
            
            Question q2 = mc.makeMultiChoiceQuestion("What is the name of the team Cristiano Ronaldo plays for in 2018/2019 football season", new String[]{"Chelsea", "Manchester United", "Real Madrid ", "Juventus"}, 3);
            q2.setTimer(10);
            
            Question q3 = mc.makeMultiChoiceQuestion("What color does Liverpool wear in home matches", new String[]{"red", "yellow", "orange", "blue"}, 0);
            q3.setTimer(10);
            
            Question q4 = mc.makeMultiChoiceQuestion("What is the last name of the longest serving manager of Arsenal Football Club", new String []{"Arsene", "Kloop", "Jurgen", "Wenger"}, 3);
            q4.setTimer(10);
			
            Question q5 = mc.makeMultiChoiceQuestion("Which country won the 2016 uefa euros", new String[]{"france", "croatia", "belgium", "portugal"}, 3);
            q5.setTimer(10);

            Question q6 = mc.makeMultiChoiceQuestion("Which african country hosted the 2010 fifa world", new String[]{"ghana", "nigeria", "kenya", "south africa"}, 3);
            q6.setTimer(10);

            Question q7 = mc.makeMultiChoiceQuestion("Which country won the 2018 fifa worldcup", new String[]{"france", "croatia", "belgium", "germany"}, 0);
            q7.setTimer(10);

            Question q8 = mc.makeMultiChoiceQuestion("Which country hosted the 2018 fifa worldcup", new String[]{"france", "croatia", "belgium", "russia"}, 3);
            q8.setTimer(10);

            Question q9 = mc.makeMultiChoiceQuestion("Which team won the 2017/2018 english premier league", new String[]{"manchester city", "chelsea", "arsenal", "liverpool"}, 0);
            q9.setTimer(10);

            Question q10 = mc.makeMultiChoiceQuestion("Who is the manager of manchester united", new String[]{"unai emery", "alex ferguson", "david moyes", "jose mourinho"},  3);
            q10.setTimer(10);
            
            
            Question [] quesArray = {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};            
            Question.startTest(quesArray);
        } 
        catch (ClassNotFoundException | ClassCastException | NullPointerException | IllegalAccessError ex) 
        {
            System.out.println("Exception Caught \nClass Name : "+getClass().getName()+"\n \n Message : "+ex.getMessage());
        }
    }
}
