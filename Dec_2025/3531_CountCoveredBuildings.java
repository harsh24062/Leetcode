class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer,int[]> rows = new HashMap<>();
        Map<Integer,int[]> cols = new HashMap<>();

        for(int a[]:buildings){

            rows.putIfAbsent(a[0],new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            cols.putIfAbsent(a[1],new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});

            int arr1[] = rows.get(a[0]);
            arr1[0]=Math.min(arr1[0],a[1]);
            arr1[1]=Math.max(arr1[1],a[1]);

            int arr2[] = cols.get(a[1]);
            arr2[0]=Math.min(arr2[0],a[0]);
            arr2[1]=Math.max(arr2[1],a[0]);
        }

        int result=0;

        for(int a[]:buildings){
            int arr1[] = rows.get(a[0]);
            int arr2[] = cols.get(a[1]);

            if((arr2[0]<a[0] && arr2[1]>a[0]) && (arr1[0]<a[1] && arr1[1]>a[1]))result++;
        }

        return result;
    }
}
