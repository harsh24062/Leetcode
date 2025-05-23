class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> used = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> past = new PriorityQueue<>();
         
        int j=0; 
        int count=0;
        for(int i=0;i<nums.length;i++){
         while(j<queries.length && queries[j][0]==i){
            used.offer(queries[j][1]);
            j++;
         }

         nums[i]-=past.size();
         
         while(nums[i]>0 && !used.isEmpty() && used.peek()>=i){
            nums[i]--;
            past.offer(used.poll());
            count++;
         }

         if(nums[i]>0)return -1;

         while(!past.isEmpty() && past.peek()==i){
            past.poll();
         }

        }
      
      return queries.length-count;
    }
}
