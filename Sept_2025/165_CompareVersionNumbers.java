class Solution {
    public int compareVersion(String version1, String version2) {
        String s1[] = version1.split("\\.");
        String s2[] = version2.split("\\.");
        
       int i=0,j=0;
       while(i<s1.length && j<s2.length){
         String first = s1[i];
         String second = s2[j];

         int firstNum = Integer.parseInt(first); 
         int secondNum = Integer.parseInt(second);
         
         if(firstNum>secondNum) return 1;
         if(firstNum<secondNum) return -1;

         i++;j++;
        }

       while(i<s1.length){
         if(Integer.parseInt(s1[i])>0)return 1;
         i++;
       }

       while(j<s2.length){
         if(Integer.parseInt(s2[j])>0)return -1;
         j++;
       }

        return 0;
    }
}
