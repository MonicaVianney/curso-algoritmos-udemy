package test;

import main.TwoSum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TwoSumTest {

    @Test
    public void twoSumTest() {
        int[] array = new int[] {9, 2, 5, 6};
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(array, 7);
        assertTrue((result[0] == 1 && result[1] == 2) || (result[0] == 2 && result[1] == 1));
        assertEquals(null, twoSum.twoSum(array, 50));
    }
}
