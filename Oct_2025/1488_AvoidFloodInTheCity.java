class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
       int ans[] = new int[n];
       
       Map<Integer,Integer> map = new HashMap<>();
       PriorityQueue<Integer> queue = new PriorityQueue<>();
       Stack<Integer> stack = new Stack<>();
       int dry=1;

       for(int i=0;i<n;i++){
        if(rains[i]==0){
          queue.offer(i);
        }else{
            dry=rains[i];
          if(!map.containsKey(rains[i])){
             map.put(rains[i],i);
          }else{
             int index = map.get(rains[i]);
            
             while(!queue.isEmpty() && queue.peek()<index){
                stack.push(queue.poll());
             }
             if(queue.isEmpty())return new int[]{};
             ans[queue.poll()]=rains[i];
             while(!stack.isEmpty()){
              queue.offer(stack.pop());
             }
             map.put(rains[i],i);
           }
        }
       }

       for(int i=0;i<n;i++){
        if(rains[i]>0)ans[i]=-1;
        else if(rains[i]==0 && ans[i]==0)ans[i]=dry;
       }

       return ans;
    }
}  
