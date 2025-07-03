class Solution {
    public char kthCharacter(int k) {
        String s="a";
        while(s.length()<k){
         StringBuilder temp=new StringBuilder();
         for(char ch:s.toCharArray()){
            if(ch=='z')temp.append("a");
            else temp.append((char)(ch+1));
         }
         s=s+temp.toString();
        }

        return s.charAt(k-1);
    }
}
