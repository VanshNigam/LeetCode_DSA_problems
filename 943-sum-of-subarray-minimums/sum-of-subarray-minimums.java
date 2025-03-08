class Solution {
    public int[] previousSmaller(int arr[],int n){
        int ps[]=new int[n];
        Stack<Integer>st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])st.pop();
            if(st.isEmpty())ps[i]=n;
            else ps[i]=st.peek();
            st.push(i);
        }
        return ps;
    }
    public int[] nextSmaller(int arr[],int n){
        int ns[]=new int[n];
        Stack<Integer>st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i])st.pop();
            if(st.isEmpty())ns[i]=-1;
            else ns[i]=st.peek();
            st.push(i);
        }
        return ns;
    }
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int ps[]=previousSmaller(arr,n);
        int ns[]=nextSmaller(arr,n);
        
        long ans=0;
        long m=1000000007;
        for(int i=0;i<n;i++){
            ans=(ans+((i-ps[i])%m*(ns[i]-i)%m)%m*(arr[i]%m))%m;
        }
        return (int)ans;
    }
}