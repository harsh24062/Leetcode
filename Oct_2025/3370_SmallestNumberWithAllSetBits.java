class Solution {
    public int smallestNumber(int n) {
        // find 2 powers - 1 
        int result[] = {1,3,7,15,31,63,127,255,511,1023};

        for(int i:result){
            if(i>=n)return i;
        }
        return 1;
    }
}
