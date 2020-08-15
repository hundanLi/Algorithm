package explore.algorithm.junior.design;


import java.util.Random;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-21 22:08
 **/
public class Shuffle {
    class Solution {
        private int[] original;
        private int[] array;
        private Random random = new Random();

        public Solution(int[] nums) {
            this.original = nums.clone();
            this.array = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            array = original;
            original = original.clone();
            return original;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = 0; i < array.length; i++) {
                swap(i, randomInt(i, array.length));
            }
            return array;
        }

        private int randomInt(int min, int max) {
            return random.nextInt(max - min) + min;
        }

        private void swap(int i, int j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

    }
}
