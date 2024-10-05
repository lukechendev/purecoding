class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = nums[(lo + (hi - lo) / 2)];
        int i = lo;
        int j = hi;
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }

            while (i <= j && nums[j] > pivot) {
                j--;
            }

            if (i <= j) {
                if (i < j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }

                i++;
                j--;
            }
        }

        quickSort(nums, lo, j);
        quickSort(nums, i, hi);
    }
}
