class Solution {
    public boolean isValid(String word) {
        if(word.length()<3)return false;
        Set<Character> set = Set.of('a','e','i','o','u','A','E','I','O','U');
        boolean vowels=false,consonant=false;

        for(char i:word.toCharArray()){
          if(i=='@'||i=='#'||i=='$')return false;
          if(set.contains(i))vowels=true;
          else if(i>58) consonant=true;
        }

        if(vowels && consonant)return true;
        return false;
    }
}
