//https://www.youtube.com/watch?v=7tGM7XA06MI&t=438s

class Solution {

    boolean taskPossible(int mid,int[] tasks, int[] workers, int pills, int strength){
        int p=pills;
      TreeMap<Integer, Integer> ws = new TreeMap<>();
        for (int i = workers.length - mid; i < workers.length; ++i) {
            ws.put(workers[i], ws.getOrDefault(workers[i], 0) + 1);
        }

           for (int i = mid - 1; i >= 0; --i) {
            Integer key = ws.lastKey();
            if (key >= tasks[i]) {
                ws.put(key, ws.get(key) - 1);
                if (ws.get(key) == 0) {
                    ws.remove(key);
                }
            } else {
                if (p == 0) {
                    return false;
                }
                key = ws.ceilingKey(tasks[i] - strength);
             // ceilingKey(x) returns the smallest key in the map that is greater than or equal to x or null.
                if (key == null) {
                    return false;
                }
                ws.put(key, ws.get(key) - 1);
                if (ws.get(key) == 0) {
                    ws.remove(key);
                }
                --p;
            }
        }
        return true;
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int n=tasks.length;
        int m=workers.length;

        // binary search
        int low=0,high=Math.min(m,n);

        while(low<=high){
            int mid=low+(high-low)/2;
            if(taskPossible(mid,tasks,workers,pills,strength))low=mid+1;
            else high=mid-1;
        }
      return high;
    }
}
