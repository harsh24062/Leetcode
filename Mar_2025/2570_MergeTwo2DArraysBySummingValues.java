class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num[]:nums1){
            map.put(num[0],map.getOrDefault(num[0],0)+num[1]);
        }
         for(int num[]:nums2){
            map.put(num[0],map.getOrDefault(num[0],0)+num[1]);
        }

        int n=map.size();
        int ans[][]=new int[n][2];
        int index=0;
         
        for(Map.Entry<Integer,Integer> k:map.entrySet()){
            ans[index][0]=k.getKey();
            ans[index][1]=k.getValue();
            index++;
         }

         return ans;
    }
}



class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int size=0;
        int freq[]=new int[1001];
        for(int num[]:nums1){
           if(freq[num[0]]==0)size++;
           freq[num[0]]+=num[1];
        }
         for(int num[]:nums2){
            if(freq[num[0]]==0)size++;
            freq[num[0]]+=num[1];
        }

        int ans[][]=new int[size][2];
        int index=0;
         
        for(int i=0;i<1001;i++){
            if(freq[i]>0){
                ans[index][0]=i;
                ans[index][1]=freq[i];
                index++;
            }
         }

         return ans;
    }
}
