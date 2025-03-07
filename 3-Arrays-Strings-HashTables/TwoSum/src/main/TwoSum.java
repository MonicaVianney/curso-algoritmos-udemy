package main;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
     * Dado un array de números enteros y un target, retorna los índices de dos
     * números para los que la suma de ambos sea igual al target.
     *
     * Puedes asumir que hay solamente una solución.
     *
     * Ejemplo 1:
     *  Input: nums = [9,2,5,6], target = 7
     *  Output: [1,2]
     *  Explicación: nums[1] + nums[2] == 7, devolvemos [1, 2].
     *
     * Ejemplo 2:
     *  Input: nums = [9,2,5,6], target = 100
     *  Output: null
     */
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> mapNums = new HashMap<>();

        if (nums == null || nums.length < 2) return null;

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (mapNums.containsKey(complement)) {
                return new int[]{mapNums.get(complement), i};
            }

            mapNums.put(nums[i], i);
        }
        return null;
    }
}
