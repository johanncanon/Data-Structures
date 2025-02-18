package com.johanncanon.datastructures.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekTemperaturesTest {

    @Test
    void addingWeekTemperaturesAndTestingByIndex() {
        int[] temps = {16, 18, 9, 2, 14, 17, 14};
        WeekTemperatures weekTemperatures = new WeekTemperatures( temps );
        assertEquals( 18, weekTemperatures.getTemperaturesByIndex(1) );
        assertEquals( 16, weekTemperatures.getTemperaturesByIndex(0) );
        assertEquals( 14, weekTemperatures.getTemperaturesByIndex(6) );
        assertEquals( 14, weekTemperatures.getTemperaturesByIndex(4) );
        assertEquals( 9, weekTemperatures.getTemperaturesByIndex(2) );
    }

    @Test
    void getMessageWithAllWeekTemperatures() {
        int[] temps = {16, 18, 9, 2, 14, 17, 14};
        WeekTemperatures weekTemperatures = new WeekTemperatures();
        var message = weekTemperatures.weekTemperatures( temps );
        var expectedMessage = "Week temperatures: \n" +
                "Monday: " + temps[0] + "°\n" +
                "Tuesday: " + temps[1] + "°\n" +
                "Wednesday: " + temps[2] + "°\n" +
                "Thursday: " + temps[3] + "°\n" +
                "Friday: " + temps[4] + "°\n" +
                "Saturday: " + temps[5] + "°\n" +
                "Sunday: " + temps[6] + "°\n";
        assertEquals( expectedMessage, message );
    }
}