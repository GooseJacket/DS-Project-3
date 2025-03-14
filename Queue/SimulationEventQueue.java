//> Created for the solution
//Final solution for Lab 6, should be in queue package 
import QueuePackage.*;
import java.util.*;

/**
 * A class that will implement the event queue.  
 * 
 * 
 * @author Charles Hoot 
 * @version 5.0
 */

public class SimulationEventQueue implements SimulationEventQueueInterface{
    EventNode startNode = null;
    int numNodes = 0;
    private double lastTime = 0.0;

    private class EventNode{
        SimulationEvent data = null;
        EventNode next = null;
        
        EventNode(){}
        EventNode(SimulationEvent e){
            data = e;
        }
        double time(){
        	return data.getTime();
		}
    }


    /** Adds a new event to this event queue.  If the time of the event to be added
     * is earlier the the time for this event queue, do not add the event.
     * @param newEntry An event.
        */
	public void add(SimulationEvent newEntry){
		double newEntryTime = newEntry.getTime(); //shorthand for newEntry's time
		
		if(newEntryTime >= lastTime) { //if newEntry is a after current time and a valid event to add:
			
			if(isEmpty()) { //if it's the first ever node:
				startNode = new EventNode(newEntry);
				numNodes = 1;
				this.print("DEBUGGING ADD: net>lt and isE."); //debugging, usually prints out full list
			}
			
			else { //if there are preexisting nodes:
				EventNode added = new EventNode(newEntry); //make a node for newEntry
				
				if (newEntryTime < startNode.time()) {//if newEntry should go first, put it first:
					added.next = startNode;
					startNode = added;
					this.print("DEBUGGING ADD: net>lt, net<sn and !isE.");
				}

				else {//if newEntry should go btw other things:
					EventNode before = null; //before.next will = newEntry
					EventNode after = startNode; //newEntry.next will = after

					while (after != null && newEntryTime >= after.time()) {
						//keep traversing until the next time is bigger OR next node is null
						before = after;
						after = after.next;
					}
					
					//stick newEntry in the right spot:
					added.next = after;
					if (before != null) {//avoid NullPointerException (shouldn't happen...but could)
						before.next = added;
					}
					this.print("DEBUGGING ADD: net>lt, net>sn and !isE.");
				}

				numNodes++;
			}//end if(!isEmpty)
		}
		else{ //if not a valid event to add, do nothing
			this.print("DEBUGGING ADD: net<lt. Did not add.");
		}
    } //end add()

	/** Removes and returns the item with the earliest time.
	 * @return The event with the earliest time or,
	 * if the event queue was empty before the operation, null.
         */
	public SimulationEvent remove(){
		if(isEmpty()){
			return null;
		}
		else { //earliest time item is at start
			EventNode ret = startNode; 
			lastTime = ret.data.getTime(); //change time
			startNode = startNode.next;
			numNodes--;
			return ret.data;
		}
    }

	/** Retrieves the item with the earliest time.
	 * @return The event with the earliest time or,
	 * if the event queue was empty was empty before the operation, null.
         */
	public SimulationEvent peek(){
	    return startNode.data; //earliest time is at start
    }

	/** Detects whether this event queue is empty.
	 * @return True if the event queue is empty.
         */
	public boolean isEmpty(){
	    return(startNode == null); //controversial but if it works it works
    }

	/** Gets the size of this event queue.
	 * @return The number of entries currently in the event queue.
         */
	public int getSize(){
	    return numNodes; //this is why we have numNodes
    }

	/** Removes all entries from this event queue.
         */
	public void clear(){
	    while(startNode != null){ //go through and delete each entry
	        EventNode n = startNode.next;
	        startNode = null;
	        startNode = n;
	        numNodes--;
        }
	    this.print("DEBUGGING CLEAR (numNodes = " + numNodes +"):");
    }

	/**
	 * The current time of the simulation
	 *
	 * @return The time for the first event on the queue.
	 */
	public double getCurrentTime(){
	    return lastTime;
    }

    //DEBUGGING -- prints out entire list with info on operations 
    private void print(String desc){
		String ret = desc + " ";
		EventNode e = startNode;
		if(e == null){
			ret += "null";
		}
		while(e != null){
			ret += e.data.getDescription().substring(0, 5) + " " + e.data.getTime() + ", ";
			e = e.next;
		}
		//System.out.println(ret);
	}


}
//PROVIDED VERSION OF SIMULATIONEVENTQUEUE: 

/*public class SimulationEventQueue implements SimulationEventQueueInterface
{
    private Vector<SimulationEvent> queue;// queue front is first in the vector
    private double theCurrentTime;

    /**
     * Constructor for objects of class BankLine
     *
    public SimulationEventQueue()
    {
        queue = new Vector<SimulationEvent>();
        theCurrentTime = 0.0;
    } // end constructor
    
    public void add(SimulationEvent newEvent)
    {
        if(newEvent.getTime() < theCurrentTime)
        {
            //System.out.println("Fails to add event... before the current time");
        }
        else if(queue.isEmpty())
        {
            // Just add it in
            queue.add(newEvent);
            //System.out.println("   added to empty queue");
        }
        else
        {
            // Iterate over the queue to find the position to add the item.
            System.out.println("Adding an event " + newEvent + " at time " + newEvent.getTime());
            int pos = -1;
            boolean foundLarger = false;
            Iterator<SimulationEvent> iter = queue.iterator();
            while(iter.hasNext() && !foundLarger)
            {
                pos++;
                SimulationEvent check = iter.next();
                //System.out.println("  checked against time " + check.getTime() );
                
                // Events at the same time should go in the order that they were
                // created, so we want to find the position of the first event with
                // a time greater than our time.
                foundLarger = check.getTime() > newEvent.getTime();
            }
            
            System.out.println("   pos is " + (pos));
            System.out.println("   foundLarger is " + (foundLarger));
            
            if(!foundLarger)
            {
                queue.add(newEvent);        // add to end
                System.out.println("   added to end ");
            }
            else 
            {
                queue.add(pos,newEvent);        // legal to add
                System.out.println("   added to position " + (pos));
            }
         }       
    } // end add

    public SimulationEvent peek()
    {
        SimulationEvent front = null;
        if (isEmpty())
            throw new EmptyQueueException("Attempting to access entries on an empty queue.");
        else
            front = queue.get(0);
        return front;
    } // end get
    

    public SimulationEvent remove() {
        SimulationEvent front = null;
        if (isEmpty()) {
            throw new EmptyQueueException("Attempting to access entries on an empty queue.");
        } else {
            front = queue.get(0);
            queue.remove(0);
            theCurrentTime = front.getTime();
            //System.out.println("Removed the first event " + front + " time is now " + theCurrentTime);
        } // end if
        return front;
    } // end remove

    public boolean isEmpty()
    {
        return queue.isEmpty();
    } // end isEmpty
    
    public void clear()
    {
        queue.clear();
    } // end clear

	/** Gets the size of the event queue.
        * @return The number of entries currently in the event queue.
        *
	public int getSize()
	{
	   return queue.size();
	}
	
	/**
	 * Get the current time of the simulation
	 * 
	 * @return The time for the first event on the queue.
	 *
	public double getCurrentTime()
	{
	   return theCurrentTime;
	}

}
*/
