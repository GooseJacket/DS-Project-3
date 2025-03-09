/**
 * This class will be used to perform tests on the SimulationEventQueue class.
 *
 * @author Charles Hoot
 * @version 5.0
 */

import QueuePackage.*;

    // Inherit from the abstract SimulationEvent.  Only the constructor and process will
    // be defined.

    public class DummyEvent extends SimulationEvent
    {
        public DummyEvent (double theTime, String action)
        {
            super(theTime,action);
        }
         	
    	/**
    	 * Process the event.
    	 */
    	public void process()
    	{
    	   System.out.print("Proccessing event with time " +
                   this.getTime() + 
                   " with action " + 
                   this.getDescription());
	}

    }  // end of DummyEvent
