class Solution {
public:
long long minSum(vector<int>& nums1, vector<int>& nums2) {

      int n=nums1.size(),m=nums2.size();
      int sum1=0,sum2=0;

      int count1=0,count2=0;
      for(int i=0;i<n;i++){
        sum1+=nums1[i];
        if(nums1[i]==0) count1++;
      }

      for(int i=0;i<m;i++){
        sum2+=nums2[i];
        if(nums2[i]==0) count2++;
      }

      int mnSum1=sum1+count1;
      int mnSum2=sum2+count2;
      
      if(mnSum1<mnSum2){
        if(count1==0) return -1;
        return mnSum2;
      }
      else if(mnSum1==mnSum2){
           return mnSum1;
      }
      else{
        if(count2==0) return -1;
        return mnSum1;
      }
       