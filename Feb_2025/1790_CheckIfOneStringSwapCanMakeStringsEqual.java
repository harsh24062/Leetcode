class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
     int misMatch=0;
   
    int p=0;
    int j=0;

     for(int i=0;i<s1.length();i++){

        if(s1.charAt(i)!=s2.charAt(i)){

        misMatch++;
    
        if(misMatch==1)p=i;
        else if(misMatch==2)j=i;
        
        if(misMatch>2)return false;
        }

     }   
     if(misMatch==1)return false;
     if(s1.charAt(p)!=s2.charAt(j) || s1.charAt(j)!=s2.charAt(p))return false;
     return true;
    }
}
