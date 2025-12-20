class Solution {

    boolean lexo(String s){
        for(int i=1;i<s.length();i++){
          if(s.charAt(i-1)>s.charAt(i))return false;
        }
        return true;
    }

    public int minDeletionSize(String[] strs) {
        Map<Integer,StringBuilder> map  = new HashMap<>();

        for(String s:strs){
           for(int i=0;i<s.length();i++){
             map.computeIfAbsent(i, k -> new StringBuilder()).append(s.charAt(i));
           }
        }

        int count=0;

        for(Map.Entry<Integer,StringBuilder> k:map.entrySet()){
            String s = k.getValue().toString();
            if(!lexo(s))count++;
        }
     
     return count;

    }
}


// 2nd approach
class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();

        int count = 0;

        for(int i=0;i<n;i++){
          for(int j =1;j<m;j++){
            if(strs[j].charAt(i)<strs[j-1].charAt(i)){
                count++;
                break;
            }
          }
        }
        return count;
    }
}
