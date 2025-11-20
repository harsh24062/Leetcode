class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        
        Arrays.sort(intervals, (arr1,arr2) -> {
            if(arr1[1]!=arr2[1])return Integer.compare(arr1[1],arr2[1]);
            return Integer.compare(arr2[0],arr1[0]);
        });

        int result=0;
        int left = -1;
        int right = -1;

        for(int i=0;i<intervals.length;i++){
            int l = intervals[i][0];
            int r = intervals[i][1];

            if(l<=left)continue; // left, right present in this

            if(l>right){
              result+=2;
              left=r-1;
              right=r;
            }else{
                result+=1;
                left=right;
                right=r;
            }
        }

        return result;
    }
}
