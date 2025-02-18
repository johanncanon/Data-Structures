package com.johanncanon.datastructures.arrays;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

@Log4j2
public class WeekTemperatures {

    private final int[] temperatures;
    public static final int WEEK_TEMPERATURES_LENGTH = 7;

    public WeekTemperatures() {
        temperatures = new int[WEEK_TEMPERATURES_LENGTH];
    }

    public WeekTemperatures(int[] temperatures) {
        this.temperatures = temperatures;
    }

    public String weekTemperatures(int[] userTemperatures) {

        log.info("User temperatures: {}", Arrays.toString(userTemperatures));
        for (int i = 0; i < WEEK_TEMPERATURES_LENGTH; i++) {
            temperatures[i] = userTemperatures[i];
        }

        var result = "Week temperatures: \n" +
                "Monday: " + temperatures[0] + "°\n" +
                "Tuesday: " + temperatures[1] + "°\n" +
                "Wednesday: " + temperatures[2] + "°\n" +
                "Thursday: " + temperatures[3] + "°\n" +
                "Friday: " + temperatures[4] + "°\n" +
                "Saturday: " + temperatures[5] + "°\n" +
                "Sunday: " + temperatures[6] + "°\n";
        log.info(result);

        return result;
    }

    /**
     * Time Complex: by index -> O( 1 )
     * @param indexOfArray int type
     */
    public int getTemperaturesByIndex(int indexOfArray) {
        log.info("indexOfArray: {}, value: {}", indexOfArray, temperatures[indexOfArray]);
        return temperatures[indexOfArray];
    }
}
