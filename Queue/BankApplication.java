import animatedapp.AnimatedApplication;
import animatedapp.ActionThread;
import java.awt.*;
import javax.swing.*;

/**
 * This is an animated application for a simulation of a bank line
 *  
 * @author Charles Hoot 
 * @version 5.0
 */
    
public class BankApplication 
{
    
    public static void main (String args[]) 
    {
        
        BankActionThread myThread = new BankActionThread();     //Change this line for different applications
        AnimatedApplication.startWith(myThread);
    }
    
    
 
}
