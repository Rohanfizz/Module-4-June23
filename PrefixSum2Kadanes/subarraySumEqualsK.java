class Solution {
    public int subarraySum(int[] nums, int k) {
        //prefix sum vs freq
        HashMap<Integer,Integer> hm = new HashMap<>(); 

        hm.put(0,1);
        int pref = 0;
        int ans = 0;

        for(int x: nums){
            pref+=x;

            if(hm.containsKey(pref-k)){
                ans += hm.get(pref-k);
            }

            hm.put(pref,hm.getOrDefault(pref,0)+1);
        }
        return ans;

    }
}