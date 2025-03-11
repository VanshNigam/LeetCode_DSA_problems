class Solution {
    public int minVal(int arr[]){
        int l=0,r=arr.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(arr[mid]>arr[r]) l=mid+1;
            else r=mid;
        }
        return r;
    }
    public int search(int[] nums, int target) {
        int pivot=minVal(nums);
        int l=0,r=nums.length-1;
        int n=nums.length;

        // System.out.println(pivot); //index of smallest element
        while(l<=r){
            int mid=(l+r)/2;
            int mid2=(mid+pivot)%n;
            if(nums[mid2]==target)return mid2; 
            if(nums[mid2]<target) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
}