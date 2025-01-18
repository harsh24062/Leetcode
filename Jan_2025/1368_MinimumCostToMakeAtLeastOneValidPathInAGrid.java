// first approach
//shashcode youtube
class Solution {
    public int minCost(int[][] grid) {

        // by dijkstra algo

        int m=grid.length;
        int n=grid[0].length;


        // make this same in same seq. as given in question
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};

         // [cost,row,col]
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<>(){
          public int compare(int a[],int b[]){
            return a[0]-b[0];
          }
        });

        int minCostGrid[][]=new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(minCostGrid[i],Integer.MAX_VALUE);
        }

        pq.offer(new int[]{0,0,0});

      minCostGrid[0][0]=0;

      while(!pq.isEmpty()){
        int arr[]=pq.poll();

        int cost=arr[0];
        int row=arr[1];
        int col=arr[2];


        for(int d=0;d<4;d++){
           
           int newRow= row + dir[d][0];
           int newCol= col + dir[d][1];

           int newCost= (d+1==grid[row][col])?0:1;
           newCost+=cost;

           if(newRow>=0 && newRow<m && newCol>=0 && newCol<n){
                
                if(newCost<minCostGrid[newRow][newCol]){
                    minCostGrid[newRow][newCol]=newCost;

                    pq.offer(new int[]{newCost,newRow,newCol});
                }
           }

        }


      }

        return minCostGrid[m-1][n-1];
        
    }
}
