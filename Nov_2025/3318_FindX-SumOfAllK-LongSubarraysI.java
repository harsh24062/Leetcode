class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        int ans_index=0;

        Map<Integer,Integer> map = new HashMap<>();
        int left=0,right=0;
         
        //arr[value,freq]
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(int a[],int b[]){
               if(a[1]!=b[1])return b[1]-a[1];
               else return b[0]-a[0];
            }
        });

        while(right<k){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            right++;
        }
        //System.out.println(right);
        right--;

        while(right<n){

           pq.clear();
           for(Map.Entry<Integer,Integer> m:map.entrySet()){
             pq.offer(new int[]{m.getKey(),m.getValue()});
           }
           
           int steps = Math.min(pq.size(),x);
           for(int i=0;i<steps;i++){
            int arr[] = pq.poll();
            ans[ans_index]+=arr[0]*arr[1];
           }
           ans_index++;

         map.put(nums[left],map.get(nums[left])-1);
         if(map.get(nums[left])==0)map.remove(nums[left]);
         left++;
         right++;
         if(right<n){
             map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            }
        }

        return ans;
    }
}
