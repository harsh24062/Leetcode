// https://www.youtube.com/watch?v=x19SmqQbhWk&t=5s

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double p[] = new double[n+1];
        p[0]=1.0;

        double curProbSum = k==0?0.0:1.0;

        for(int i=1;i<n+1;i++){
           p[i]=curProbSum/maxPts;

           if(i<k)curProbSum+=p[i];

           if(i-maxPts>=0 && i-maxPts<k){
            curProbSum-=p[i-maxPts];
           }
        }
       
       double count = 0.0;
       for(int i=k;i<n+1;i++){
        count+=p[i];
       }
       
       return count;
    }
}
