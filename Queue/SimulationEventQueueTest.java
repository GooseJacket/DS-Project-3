/**
 * This class performs tests on the SimulationEventQueue class.
 *
 * @author Charles Hoot
 * @version 5.0
 */

import QueuePackage.*;

public class SimulationEventQueueTest {



    
    private static SimulationEventQueue testEventQueue0 = new SimulationEventQueue();
    private static SimulationEventQueue testEventQueue1 = new SimulationEventQueue();
    private static SimulationEventQueue testEventQueue2 = new SimulationEventQueue();
    private static SimulationEventQueue testEventQueue3 = new SimulationEventQueue();
    private static SimulationEventQueue testEventQueue4 = new SimulationEventQueue();

    
    static DummyEvent event1 = new DummyEvent(1.0, "Event at time 1");
    static DummyEvent event2 = new DummyEvent(2.0, "Event at time 2");
    static DummyEvent event3 = new DummyEvent(3.0, "Event at time 3");
    static DummyEvent event4 = new DummyEvent(4.0, "Event at time 4");
    static DummyEvent event1b = new DummyEvent(1.0, "Alternate Event at time 1");
    static DummyEvent event2b = new DummyEvent(2.0, "Alternate Event at time 2");
    static DummyEvent event3b = new DummyEvent(3.0, "Alternate Event at time 3");
    static DummyEvent event4b = new DummyEvent(4.0, "Alternate Event at time 4");

    static DummyEvent event5 = new DummyEvent(5.0, "Event at time 5");
    static DummyEvent event6 = new DummyEvent(6.0, "Event at time 6");
    static DummyEvent event7 = new DummyEvent(7.0, "Event at time 7");
    static DummyEvent event8 = new DummyEvent(8.0, "Event at time 8");


    /**
     * @param args the command line arguments
     */

    public static void main(String args[]) {
    System.out.println("BASIC TESTING OF THE SIMULATION EVENT QUEUE");
    System.out.println();

        checkGetSize();
        checkClear();
        checkIsEmpty();
        checkPeek();
        checkRemove();
        checkAdd();
    
    }
    
    public static void checkGetSize() {
        System.out.println("TESTING GETSIZE");

        System.out.println("Checking to see if testEventQueue0 has 0 items");
        if (testEventQueue0.getSize() == 0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();


        System.out.println("Add 1 item and see if the size is now 1");
        testEventQueue0.add(event1);
        System.out.println("Checking to see if testEventQueue0 has 1 items");
        if (testEventQueue0.getSize() == 1) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
        
        
        System.out.println("Add 1 item and see if the size is now 2");
        testEventQueue0.add(event2);
        System.out.println("Checking to see if testEventQueue0 has 2 items");
        if (testEventQueue0.getSize() == 2) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();

    }
    
    public static void checkClear() {
        System.out.println("TESTING CLEAR");

        System.out.println("Add 1 item");
        testEventQueue1.add(event1);
        System.out.println("Add another item");
        testEventQueue1.add(event1);


        System.out.println("Checking to see if testEventQueue1 has 0 items after clear");
        testEventQueue1.clear();

        if (testEventQueue1.getSize() == 0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
       
    }
        public static void checkIsEmpty() {
        System.out.println("TESTING ISEMPTY");

        System.out.println("Checking to see if testEventQueue2 is empty to start");
        if (testEventQueue2.isEmpty() == true) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        
        
        System.out.println("Add 1 item and check to see if testEventQueue2 is not empty");
        testEventQueue2.add(event1);
        if (testEventQueue2.isEmpty() == false) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
    
        System.out.println("Add 1 item and check to see if testEventQueue2 is not empty");
        testEventQueue2.add(event2);
        if (testEventQueue2.isEmpty() == false) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
    

        System.out.println("Checking to see if testEventQueue2 is empty after clear");
        testEventQueue2.clear();

        if (testEventQueue2.isEmpty() == true) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }

        System.out.println();
       
    }
        
    public static void checkPeek() {
        System.out.println("TESTING PEEK");

        System.out.println("Add two events to eventQueue1");
        testEventQueue1.clear();
        testEventQueue1.add(event1);
        testEventQueue1.add(event2);


        System.out.println("Checking to see if testEventQueue1 has the item at time 1 at front");

        if (testEventQueue1.peek() == event1) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
        
                System.out.println("Add two events to eventQueue2 in opposite order");
        testEventQueue2.clear();
        testEventQueue2.add(event2);
        testEventQueue2.add(event1);


        System.out.println("Checking to see if testEventQueue2 has the item at time 1 at front");

        if (testEventQueue1.peek() == event1) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();

       
    }    
        
    public static void checkRemove() {
        System.out.println("TESTING REMOVE");

        System.out.println("Add two events to eventQueue3");
        testEventQueue3.add(event1);
        testEventQueue3.add(event2);


        System.out.println("Checking to see if remove gets the item at time 1 at front");
        DummyEvent de = (DummyEvent) testEventQueue3.remove();

        if (de == event1) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
        
        System.out.println("Checking to see if the size is now 1");
        if (testEventQueue3.getSize() == 1) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }

        System.out.println("Checking to see if the current time is now 1.0");
        if (testEventQueue3.getCurrentTime() == 1.0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();

        
        System.out.println("Checking to see if remove gets the item at time 2 at front");
        de = (DummyEvent) testEventQueue3.remove();

        if (de == event2) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
        
        System.out.println("Checking to see if the size is now 0");
        if (testEventQueue3.getSize() == 0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }

        System.out.println("Checking to see if the current time is now 2.0");
        if (testEventQueue3.getCurrentTime() == 2.0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
        
        System.out.println("Add an item at time 5, then clear");
        testEventQueue3.add(event5);
        testEventQueue3.clear();

        System.out.println("Checking to see if the size is now 0");
        if (testEventQueue3.getSize() == 0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }

        System.out.println("Checking to see if the current time is still 2.0");
        if (testEventQueue3.getCurrentTime() == 2.0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();


    }
        



    public static void checkAdd() {
        System.out.println("TESTING ADD");

        System.out.println("Add two events to eventQueue4");
        testEventQueue4.clear();
        testEventQueue4.add(event1);
        testEventQueue4.add(event2);
        
        System.out.println("Remove the first event at time 1");
        DummyEvent de = (DummyEvent) testEventQueue4.remove();
        System.out.println("Add a new event at time 1");
        testEventQueue4.add(event1b);

        System.out.println("Checking to see if first item is at time 1 at front");

        if (testEventQueue4.peek() == event1b) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
        
        System.out.println("Checking to see if the size is now 2");
        if (testEventQueue4.getSize() == 2) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }

        System.out.println("Checking to see if the current time is now 1.0");
        if (testEventQueue4.getCurrentTime() == 1.0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
        
        System.out.println("Remove both events");
        de = (DummyEvent) testEventQueue4.remove();
        de = (DummyEvent) testEventQueue4.remove();

        
        System.out.println("Checking to see if the size is now 0");
        if (testEventQueue4.getSize() == 0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }

        System.out.println("Checking to see if the current time is now 2.0");
        if (testEventQueue4.getCurrentTime() == 2.0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
        
        System.out.println("Try to add an event to eventQueue1 at time 1 (should fail)");
        testEventQueue4.add(event1b);
        
         System.out.println("Checking to see if the size is still 0");
        if (testEventQueue4.getSize() == 0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }

        System.out.println("Checking to see if the current time is still 2.0");
        if (testEventQueue4.getCurrentTime() == 2.0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
 
        System.out.println("Try to add an event to eventQueue1 at time 2 (should work)");
        testEventQueue4.add(event2b);
        
         System.out.println("Checking to see if the size is now 1");
        if (testEventQueue4.getSize() == 1) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }

        System.out.println("Checking to see if the current time is still 2.0");
        if (testEventQueue4.getCurrentTime() == 2.0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
        
        System.out.println("Remove the item at time 2 ");
        de = (DummyEvent) testEventQueue4.remove();

        if (testEventQueue4.getCurrentTime() == 2.0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
 
        System.out.println("Add 8 events to queue (all but one should get added)");
        testEventQueue4.add(event4);
        testEventQueue4.add(event7);
        testEventQueue4.add(event3);
        testEventQueue4.add(event8);
        testEventQueue4.add(event2);
        testEventQueue4.add(event1);
        testEventQueue4.add(event6);
        testEventQueue4.add(event5);
        
        System.out.println("Checking to see if the size is now 7");
        if (testEventQueue4.getSize() == 7) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }

        System.out.println("Checking to see if the current time is still 2.0");
        if (testEventQueue4.getCurrentTime() == 2.0) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();
 
        System.out.println("Remove events from queue one at a time");
        
        double time = testEventQueue4.getCurrentTime();
        boolean ordered = true;
        boolean timeUpdated = true;
        int count = 0;
        while(!testEventQueue4.isEmpty()){
            de = (DummyEvent) testEventQueue4.remove();
            count++;
            if (de.getTime() != testEventQueue4.getCurrentTime())
                timeUpdated = false;
            if(de.getTime() < time)
                ordered = false;
            time = testEventQueue4.getCurrentTime();
        }
    
        System.out.println("Did we remove 7 items?");
        if (count == 7) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println("Were the items in the corrent order?");
        if (ordered) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println("Did the time update correctly?");
        if (timeUpdated) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");
        }
        System.out.println();

        



    }
    

    
}
