class Solution {
    public int minimumIndex(List<Integer> nums) {

        int n=nums.size();

        Map<Integer,Integer> map=new HashMap<>();

        int element=-1;   //dominant element

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);

            if(element==-1){
            int freq=map.get(i);
            if(freq>n/2)element=i;
            }
        }
        
        if(element==-1 || n==1)return -1;  // array cant be divide for n==1

        //split the array now
        int freq=map.get(element);
        int curFreq=0;

        for(int i=0;i<n;i++){

          if(nums.get(i)==element){
            curFreq++;
          }
         
         if(curFreq>(i+1)/2 && (freq-curFreq)>(n-i-1)/2)
          return i;
        }

       return -1;
    }
}




// my majority element trick

class Solution {
    public int minimumIndex(List<Integer> nums) {

        int n=nums.size();
         if(n==1)return -1;  // array cant be divide for n==1
        
        // find majority element
         
        int count=0;
        int element=0;

        for(int i:nums){
         if(count==0)element=i;
         if(element==i)count++;
         else count--;
        }
        
        // find freq of majority element
        int freq=0;
        
        for(int i:nums){
            if(i==element)freq++;
        }

        //split the array now
        int curFreq=0;

        for(int i=0;i<n;i++){

          if(nums.get(i)==element){
            curFreq++;
          }
         
         if(curFreq*2>(i+1) && (freq-curFreq)*2>(n-i-1))
          return i;
        }

       return -1;
    }
}
