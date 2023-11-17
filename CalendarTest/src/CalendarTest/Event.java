package CalendarTest;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event {
	
	public Event(LocalDateTime start, LocalDateTime end) {
		this.EventStart = start;
		this.EventEnd = end;
	}
	
	private LocalDateTime EventStart;
	private LocalDateTime EventEnd;
	
	/**
	 * Checks whether a set of events conflict or not.
	 * @param events The events to check.
	 * @return Whether the events conflict.
	 */
    public static boolean EventsConflict(ArrayList<Event> events) {
    	  // Check all event pairs
    	  for (int i = 0; i < events.size(); ++i) {
    		  Event event1 = events.get(i);
    		  for (int j = i + 1; j < events.size(); ++j) {
    			  Event event2 = events.get(j);
    			  // Events conflict if an event starts before another ends and ends after the other starts
    			  if (event1.EventStart.compareTo(event2.EventEnd) <= 0 && event1.EventEnd.compareTo(event2.EventStart) >= 0)
    				  return true;
    		  }
    	  }
    	  return false;
      }
} 