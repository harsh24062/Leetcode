class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");

        Set<Character> set = new HashSet<>();
        for(char c: brokenLetters.toCharArray())set.add(c);

        int count=0;
        
        for(String s:words){
            boolean flag=false;
            for(char c:s.toCharArray()){
                if(set.contains(c)){
                    flag=true;
                    break;
                }
            }
            if(flag)continue;
            count++;
        }

        return count;
    }
}
