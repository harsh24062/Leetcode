class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int value=0;
        
        for(String s:operations){
            if(s.charAt(0)=='+' || s.charAt(2)=='+')value++;
            else value--;
        }

        return value;
    }
}
