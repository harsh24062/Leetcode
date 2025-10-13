class Solution {

    boolean anagram(String s1, String s2){
        if(s1.length()!=s2.length())return false;

        char c1[]= s1.toCharArray();
        char c2[]= s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for(int i=0;i<c1.length;i++){
         if(c1[i]!=c2[i])return false;
        }
        return true;
    }

    public List<String> removeAnagrams(String[] words) {
      List<String> list = new ArrayList<>();
      list.add(words[0]);

      for(int i=1;i<words.length;i++){
        if(!anagram(list.get(list.size()-1),words[i])){
            list.add(words[i]);
        }
      }
      return list;  
    }
}
