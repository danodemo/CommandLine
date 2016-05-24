package tiy.clinterpreter;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by danarchy on 5/24/16.
 */
public class CLBroBoardTest {

    CLBroBoard testBoard = new CLBroBoard();

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGreeting() throws Exception {
        testBoard.user = "Dan";
        assertEquals("Dan", testBoard.greeting(testBoard.user));
    }

    @Test
    public void testGetTime() throws Exception {
        LocalDateTime nowTest = LocalDateTime.now();
        DateTimeFormatter timeTestFormat = DateTimeFormatter.ofPattern("h:m:s a");
        String timeString = nowTest.format(timeTestFormat);
        assertEquals(timeString, testBoard.getTime(nowTest));
    }

    @Test
    public void testGetDate() throws Exception {
        LocalDateTime nowTest = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, y");
        String dateString = nowTest.format(dateFormat);
        assertEquals(dateString, testBoard.getDate(nowTest));

    }

    @Test
    public void testGetDay() throws Exception {
        LocalDateTime nowTest = LocalDateTime.now();
        DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("EEEE");
        String dayString =("Today is " + nowTest.format(dayFormat) + "!");
        assertEquals(dayString, testBoard.getDay(nowTest));
    }
}