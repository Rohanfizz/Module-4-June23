class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int  i  = 0;

        while(i<n){
            int j = i+1;
            while(j<n){
                //Here i have to do two pointers for the remaining values
                int l = j+1;
                int r = n-1;
                //new target = original target - (what we have covered already)
                long newTarget = target - 1L*(nums[i] + nums[j]);

                //2sum problem
                while(l<r){
                    long sum = nums[l] + nums[r];
                    if(sum == newTarget){
                        //push and move both pointers l and r
                        List<Integer> curr = new ArrayList<>();
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[l]);
                        curr.add(nums[r]);
                        res.add(curr);//curr quadruplet has been inserted into res
                        //move the  pointers
                        //By moving points just like the code below
                        //ensures that all the pointers l,r,i and j come on
                        //a new value rather than just goint to the next index
                        //this ensures the uniqness of the quadruplets
                        int prevL = nums[l];
                        while(l<r && nums[l] == prevL) l++;

                        int prevR = nums[r];
                        while(l<r && nums[r] == prevR) r--;
                    }else if(sum > newTarget){
                        int prevR = nums[r];
                        while(l<r && nums[r] == prevR) r--;
                    }else{
                        int prevL = nums[l];
                        while(l<r && nums[l] == prevL) l++;
                    }
                }
                int prevJ = nums[j];
                while(j<n && nums[j] == prevJ) j++;
            }
            int prevI = nums[i];
            while(i<n && nums[i] == prevI) i++;
        }
        return res;
    }
}
