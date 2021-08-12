package com.elyse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TimeToTextConverterTest {

    private TimeToTextConverter tttConverter;

    @BeforeEach
    public void setup() {
        tttConverter = new TimeToTextConverter();
    }

    @Test
    public void canDoMidnight() {
        String timeAsText = tttConverter.convertTimeToText(LocalTime.MIDNIGHT); // this method doesn't exist either!
        assertEquals("midnight", timeAsText);
    }

    @Test
    public void canDoNoon() {
        String timeAsText = tttConverter.convertTimeToText(LocalTime.NOON); // this method doesn't exist either!
        assertEquals("noon", timeAsText);
    }

    @Test
    public void canDoOneAm() {
        String timeAsText = tttConverter.convertTimeToText(LocalTime.of(1,0));
        assertEquals("one AM", timeAsText);
    }

    @Test
    public void canDoTwoAm() {
        String timeAsText = tttConverter.convertTimeToText(LocalTime.of(2,0));
        assertEquals("two AM", timeAsText);
    }

    @Test
    public void canDoFivePm() {
        String timeAsText = tttConverter.convertTimeToText(LocalTime.of(17,0));
        assertEquals("five PM", timeAsText);
    }

    @Test
    public void canDoTwoThirtyAm() {
        String timeAsText = tttConverter.convertTimeToText(LocalTime.of(2,30));
        assertEquals("two thirty AM", timeAsText);
    }

    @Test
    public void canDoTwelveThirtyPM() {
        String timeAsText = tttConverter.convertTimeToText(LocalTime.of(12,30));
        assertEquals("twelve thirty PM", timeAsText);
    }

    @Test
    public void canDoFourThirtyPm() {
        String timeAsText = tttConverter.convertTimeToText(LocalTime.of(16,30));
        assertEquals("four thirty PM", timeAsText);
    }

    @Test
    public void canDoQuarterToFiveAm() {
        String timeAsText = tttConverter.convertTimeToText(LocalTime.of(4,45));
        assertEquals("quarter to five AM", timeAsText);
    }

    @Test
    public void canDoQuarterToNoon() {
        String timeAsText = tttConverter.convertTimeToText(LocalTime.of(11,45));
        assertEquals("quarter to noon", timeAsText);
    }

    @Test
    public void canDoQuarterToOnePm() {
        String timeAsText = tttConverter.convertTimeToText(LocalTime.of(12,45));
        assertEquals("quarter to one PM", timeAsText);
    }


}
