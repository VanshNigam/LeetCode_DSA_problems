int maximumCandies(int* candies, int n, long long k) {
 int l=1,r=candies[0],mid,i;
 long long res=0,t,sum=candies[0];
 for(i=1;i<n;i++){
  if(candies[i]>r)
   r=candies[i];
  sum+=candies[i];
 }
 if(sum<k)
  return 0;
 while(l<=r){
    mid=l+(r-l)/2;
    t=0;
    for(i=0;i<n;i++)
        t+=candies[i]/mid;
    if(t>=k){
     res=mid;
     l=mid+1;
    }
         else
         r=mid-1;
    
 }
 return res;
}