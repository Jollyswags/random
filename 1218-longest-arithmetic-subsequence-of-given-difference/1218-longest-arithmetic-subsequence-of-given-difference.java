class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        if(arr == null || arr.length == 0) return 0;
       
        /*
            Map will store key value pair,
            Key will be an element of the array
            and value will indicate longest AP finishing at 
            that element of array
            
            for example :  map(8) = 4 means there is AP of length 4
            ends at element 8 (not index 8, but the element 8)
        */
        Map<Integer, Integer> map = new HashMap<>();
        
        //First element is part of it's own AP with itself in it
        map.put(arr[0],1);
        int max = 1;
        
        for(int i=1; i<arr.length; i++){
            /* 
                Check if there is an AP ending at current element - difference
                if yes, we can add current element to that list 
                and length increases by 1
            */
            int prev = map.getOrDefault(arr[i] - difference, 0);
            
            map.put(arr[i], prev + 1);
            max = Math.max(max, prev+1);
        }
        
        return max;
    }
}