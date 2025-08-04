class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;

        int left=0,right=0;

        while(right<fruits.length){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            
            if(map.size()>2){
              map.put(fruits[left],map.getOrDefault(fruits[left],0)-1);
              if(map.get(fruits[left])==0)map.remove(fruits[left]);
              left++;
            }else{
              ans=Math.max(ans,right-left+1);
            }
            right++;
        }


        return ans;
    }
}
