
import java.io.IOException;
import java.nio.file.*;

/**
 * This is the super class of the app
 * every other class accesses this class
 * this class store the GUI object and pluginName
 * @author egua4
 */
public class Core extends ClassLoader 
{
     public static Object sa;
     public static Object mc;
     //public static String pluginName;
    
     /**
      * Get the class name
      * return an object of the class
      * @param className
      * @return
      * @throws ClassNotFoundException 
	  *
	  *
	  *
	  * This section of code was done in worksheet 4 during the lab section
      */
    public Object loadPlugin(String className) throws ClassNotFoundException
    {
        /**
         * Get the class name and construct a full path to the class file
         */
        String pluginPath = constructPath(className);
        try
        {
            /** 
             * Read all the bytes from the class file
             * Find and define the class from the given class file
             * return an instance of the class or class object
             * @param full path to the class file
             */
                        
            byte[] classData = Files.readAllBytes(Paths.get(pluginPath));
            Class<?> cls = defineClass(null, classData, 0, classData.length);
            
            return cls.newInstance();
        }
        catch(IOException | IllegalAccessException | InstantiationException e)
        {
            throw  new ClassNotFoundException(String.format("Could not load '%s' : %s", pluginPath, e.getMessage()),e);
        }
    }

    /**
     * Main method.
     * This start method of the application
     * Runs the GUI that access the Quiz pluginName
     * @param args 
     */
    public static void main(String[] args)
    {        
         MainGUI ui = new MainGUI();
         ui.initComponents();
         MainGUI.mainframe.setVisible(true);
    }
    
    /**
     * Set the GUI class object after loading it on runtime
     * @param obj 
     */
    public void setObj(Object obj)
    {
        /**
         * Determine the type of Class object
         */
        if(obj instanceof ShortAnswer)
        {
            Core.sa = obj;
        }
        else if(obj instanceof MultiChoice)
        {
            Core.mc = obj;
        }
    }
    
    /**
     * Create and returns the full class path to a given class name
     * @param className
     * @return class path
     */
    public String constructPath(String className)
    {
        return "../"+className+"/build/classes/java/main/"+className+".class";
    }
}
