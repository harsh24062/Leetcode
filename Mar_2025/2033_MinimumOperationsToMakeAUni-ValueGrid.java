class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list =new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                list.add(grid[i][j]);
            }
        }

        Collections.sort(list);
        
        int index=list.size()/2;
        int median=list.get(index);
         
        int ans=0;

        for(int i=0;i<list.size();i++){
          if(Math.abs(median-list.get(i))%x!=0)return -1;
          ans+=Math.abs(median-list.get(i))/x;
        }
        return ans;
    }
}

//https://www.youtube.com/watch?v=NvdOTWO02ZI


// first store grid element in list
// then sort this list
// find median index in list by, index=list.size()/2
// median =list.get(index)


// a + k*x=median      , a is the number which we have to increase or decrease
             // k is constant
// k=(median-a)/x

// (median-a)%x must be =0 as it must return constant
