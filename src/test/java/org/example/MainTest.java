package org.example;

import org.apache.commons.lang3.ArrayUtils;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;


class MainTest {
    public static final int[][] teams = {
            {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
            {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
            {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
    };

    // result array length test
    @Test
    public void mergeArrayLength() {
        int expected = 10;
        //
        int actual = Main.mergeAll(teams).length;
        //
        Assertions.assertEquals(expected, actual);
    }

    // two any teams merge test
    @Test
    public void mergeAnyTwoTeams() {
        int[] testArray_1 = {90, 80, 70, 60, 50, 40, 30, 20, 10};
        int[] testArray_2 = {85, 75, 65, 55, 45, 35, 25, 15, 5};
        //
        int[] expected = {90, 85, 80, 75, 70, 65, 60, 55, 50, 45};
        //
        int[] actual = Main.merge(testArray_1, testArray_2);
        //
        Assertions.assertArrayEquals(expected, actual);
    }

    // Correct order result test
    @Test
    public void orderResultTest() {
        int[] rusult = Main.mergeAll(teams);
        for (int i = 0; i < rusult.length - 1; i++) {
            if (rusult[i] < rusult[i + 1]) {
                Assertions.fail();
            }
        }
    }

    // contains top 3 player from 3 teams
    @Test
    public void containsTop3Players() {
        int[] result = Main.mergeAll(teams);
        Integer[] objValues = ArrayUtils.toObject(result);
        MatcherAssert.assertThat(objValues, hasItemInArray(teams[0][0]));
        MatcherAssert.assertThat(objValues, hasItemInArray(teams[1][0]));
        MatcherAssert.assertThat(objValues, hasItemInArray(teams[2][0]));
    }
}