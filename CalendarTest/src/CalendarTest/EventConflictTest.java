package CalendarTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventConflictTest {
	@Test
	public void TestConflicting() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime fiveMinutesBeforeNow = now.minusMinutes(5);
		LocalDateTime twoMinutesFromNow = now.plusMinutes(2);
		LocalDateTime fiveMinutesFromNow = now.plusMinutes(5);
		
		ArrayList<Event> eventList = new ArrayList<Event>();
		
		Event event1 = new Event(now, fiveMinutesFromNow);
		Event event2 = new Event(fiveMinutesBeforeNow, twoMinutesFromNow);
		
		eventList.add(event1);
		eventList.add(event2);
		
		assertEquals("Here is the test for conflicting events", true, Event.EventsConflict(eventList));
	}
	
	@Test
	public void TestNonConflicting() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime fiveMinutesFromNow = now.plusMinutes(5);
		LocalDateTime tenMinutesFromNow = now.plusMinutes(10);
		LocalDateTime fifteenMinutesFromNow = now.plusMinutes(15);
		
		ArrayList<Event> eventList = new ArrayList<Event>();
		
		Event event1 = new Event(now, fiveMinutesFromNow);
		Event event2 = new Event(tenMinutesFromNow, fifteenMinutesFromNow);
		
		eventList.add(event1);
		eventList.add(event2);
		
		assertEquals("Here is the test for non-conflicting events", false, Event.EventsConflict(eventList));
	}
}
