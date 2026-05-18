class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroInd = -1;
        boolean multipleZeroes = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && !multipleZeroes) {
                if (zeroInd != -1) {
                    multipleZeroes = true;
                    break;
                } else {
                    zeroInd = i;
                }
            } else {
                product *= nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (multipleZeroes) {
                nums[i] = 0;
            } else if (zeroInd != -1) {
                if (i == zeroInd) {
                    nums[i] = product;
                } else {
                    nums[i] = 0;
                }
            } else {
                nums[i] = product / nums[i];
            }
        }

        return nums;
    }
}  
