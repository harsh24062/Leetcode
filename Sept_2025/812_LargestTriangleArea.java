class Solution {

    double sideLen(int point1[], int point2[]){
       int x = Math.abs(point1[0]-point2[0]);
       int y = Math.abs(point1[1]-point2[1]);

       int value = x*x + y*y;
       return Math.sqrt(value);
    }

    public double largestTriangleArea(int[][] points) {
        double ans=0.0;
        
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                for(int k=j+1;k<points.length;k++){
                    double a = sideLen(points[i],points[j]);
                    double b = sideLen(points[k],points[j]);
                    double c = sideLen(points[k],points[i]);

                    // using heron formula
                    double s = (a+b+c)/2;
                    double value = s*(s-a)*(s-b)*(s-c);
                    double newArea = Math.sqrt(Math.max(value, 0));
                    ans = Math.max(ans,newArea);
                }
            }
        }

        return ans;
    }
}

// Heron’s Formula

// a,b,c are side
//s=(a+b+c)/2​

// area = SquareRoot(s*(s-a)*(s-b)*(s-c))
