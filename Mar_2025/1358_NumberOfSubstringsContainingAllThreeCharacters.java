class Solution {
    public int numberOfSubstrings(String s) {

        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        int ans=0;
        int left=0;

        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

            while(map.size()==3){
                ans+=n-i;
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0)map.remove(s.charAt(left));
                left++;
            }
        }
        return ans;
    }
}
