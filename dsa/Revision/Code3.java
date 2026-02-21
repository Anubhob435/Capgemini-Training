package dsa.Revision;

import java.util.HashSet;

public class Code3 {
    public static int subArrayRemoval(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

      int l = 0;
      int maxLength = 0;
      for(int r = 0;r<nums.length;r++){
          while(set.contains(nums[r])){
              set.remove(nums[l]);
              l++;
          }
          set.add(nums[r]);
          maxLength = Math.max(maxLength,r-l+1);
      }
   return nums.length- maxLength;
   }
    public static void main(String[] args) {
    	int[] arr = {1, 7, 2, 3, 3, 9, 7, 10, 2, 7};
    	int [] arr2 = {2, 3, 4,5,4,3,2,1,2};
    	System.out.println(subArrayRemoval(arr));
    	System.out.println(subArrayRemoval(arr2));

	}
}
