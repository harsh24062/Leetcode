class Solution {
    public boolean doesAliceWin(String s) {
       for(char ch:s.toCharArray()){
        if(ch=='a' || ch=='i' || ch=='o' || ch=='e'||ch=='u')return true;
       }
       return false; 
    }
}
