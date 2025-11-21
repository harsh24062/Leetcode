class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character,Integer> firstIndex = new HashMap<>();
        Map<Character,Integer> lastIndex = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(!firstIndex.containsKey(s.charAt(i))){
                firstIndex.put(s.charAt(i),i);
            }
            lastIndex.put(s.charAt(i),i);
        }

        int result=0;
        for(char ch:firstIndex.keySet()){
          int first = firstIndex.get(ch);
          int last = lastIndex.get(ch);
          Set<Character> set = new HashSet<>();
          for(int i = first+1;i<last;i++){
            set.add(s.charAt(i));
          }
          result+=set.size();
        }
        return result;
    }
}
