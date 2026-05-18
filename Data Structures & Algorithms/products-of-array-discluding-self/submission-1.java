class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[] {};
        }
        int[] pPro = new int[nums.length];
        int[] sPro = new int[nums.length];

        pPro[0] = 1;
        sPro[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            pPro[i] = nums[i - 1] * pPro[i - 1];
            sPro[nums.length - i - 1] = nums[nums.length - i] * sPro[nums.length - i];
        }

        if (nums.length > 1) {
            sPro[0] = sPro[1] * nums[1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sPro[i] * pPro[i];
        }

        return nums;
    }
}  
