class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        
        //try two vertical cuts
        //sort rectangles 2d based of start value on x-axis

        Arrays.sort(rectangles,(a,b)->Integer.compare(a[0],b[0]));

        int endX=rectangles[0][2];
        int cutX=0;
        for(int i=1;i<rectangles.length;i++){
            if(rectangles[i][0]>=endX){
                cutX++;
                if(cutX==2)return true;
            }
            endX=Math.max(endX,rectangles[i][2]);
        }

        //if vertical cuts are not possible
        //try two horizontal cuts
        //sort rectangles 2d based of start value on y-axis
        Arrays.sort(rectangles,(a,b)->Integer.compare(a[1],b[1]));
        int endY=rectangles[0][3];
        int cutY=0;
        for(int i=1;i<rectangles.length;i++){
            if(rectangles[i][1]>=endY){
                cutY++;
                if(cutY==2)return true;
            }
            endY=Math.max(endY,rectangles[i][3]);
        }


        return false;
    }
}
