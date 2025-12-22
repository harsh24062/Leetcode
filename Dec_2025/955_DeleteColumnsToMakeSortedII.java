class Solution {
    public int minDeletionSize(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();

        boolean isSorted[] = new boolean[row];
        int count=0;

        for(int c = 0;c<col;c++){
            boolean isbreak=false;
            for(int r=0;r<row-1;r++){
                if(!isSorted[r] && strs[r].charAt(c)>strs[r+1].charAt(c)){
                    count++;
                    isbreak=true;
                    break;
                }
            }
            if(isbreak)continue;
            for(int r=0;r<row-1;r++){
                isSorted[r] = isSorted[r] || strs[r].charAt(c)<strs[r+1].charAt(c);
            }
        }

        return count;
    }
}
