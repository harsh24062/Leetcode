class Solution {
    double helper(int p,int d){
        return (double)(p+1)/(d+1) - (double)(p)/d;
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // [difference ratio,cur numo,cur deno]
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));

        for(int a[]:classes){
          int p = a[0];
          int d = a[1];
          double diff = helper(p,d);
          pq.offer(new double[]{diff,p,d});
        }

        while(extraStudents-->0){
            double arr[] = pq.poll();
            double diff = helper((int)arr[1]+1,(int)arr[2]+1);
            pq.offer(new double[]{diff,arr[1]+1,arr[2]+1}); 
        }

        double count=0;
        while(!pq.isEmpty()){
            double arr[] = pq.poll();
            double a = arr[1];
            double b = arr[2];
            count+=(a/b);
        }

        return count/classes.length;
    }
}
