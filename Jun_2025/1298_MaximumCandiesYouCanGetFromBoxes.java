class Solution {
    int candy;
    Set<Integer> visited;
    Set<Integer> foundedBox;

    int dfs(int box,int[] status, int[] candies, int[][] keys, int[][] containedBoxes){

       if(visited.contains(box)) return 0;

       if(status[box]==0){
        foundedBox.add(box);
        return 0;
       }

       visited.add(box);
       int candyCollect=candies[box];


       for(int  insideBox:containedBoxes[box]){
        candyCollect+=dfs(insideBox,status,candies,keys,containedBoxes);
       }


       for(int boxKey:keys[box]){
        status[boxKey]=1;

        if(foundedBox.contains(boxKey)){
             candyCollect+=dfs(boxKey,status,candies,keys,containedBoxes);
        }
       }
      
      return  candyCollect;
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        candy=0;
        visited = new HashSet<>();
        foundedBox = new HashSet<>();
        
        for(int box:initialBoxes){
            candy+=dfs(box,status,candies,keys,containedBoxes);
        }

        return candy;
    }
}
