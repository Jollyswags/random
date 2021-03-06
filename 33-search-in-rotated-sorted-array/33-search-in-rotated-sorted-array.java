class Solution {
    public int search(int[] arr, int target) {
          int left=0,right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(target==arr[mid]) return mid;  // founded ;)
            if(arr[left]<=arr[mid]){  // left increasing monotonically
                if(arr[left]<=target && target<arr[mid]){  // inside this region
                    right=mid-1;
                }
                else left=mid+1;
            }else{                     // right increasing monotonically
                if(arr[mid]<target && target<=arr[right]){  // inside this region
                    left=mid+1;
                }
                else right=mid-1;
            }
        }
        return -1;
    }
}
//logn
//1