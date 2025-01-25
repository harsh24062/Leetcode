class Solution {
    // shashcode approach - https://www.youtube.com/watch?v=57d-itN_QY0

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int n = nums.length;

        int temp[] = new int[n];

        for(int i=0;i<n;i++){
            temp[i]=nums[i];
        }

        Arrays.sort(temp);

        List<Queue<Integer>> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        //  <Element,group No>

       // add first element
        list.add(new LinkedList<>());
        list.get(0).offer(temp[0]);

        map.put(temp[0],0);

        int lastPick=temp[0];

        for(int i=1;i<n;i++){
            if( temp[i] - lastPick > limit ) list.add(new LinkedList<>());

            list.get(list.size()-1).offer(temp[i]);  
            map.put(temp[i],list.size()-1);
            lastPick=temp[i];
            
        } 

        for(int i=0;i<n;i++){
           int group=map.get(nums[i]);
           temp[i]=list.get(group).poll();
        }

        return temp;        
    }
}
