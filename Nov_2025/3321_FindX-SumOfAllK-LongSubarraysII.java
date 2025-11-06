class Solution {

    private int n,index;
    private long ans[];
    private long sum;
    private HashMap<Integer,Integer> map;
    //arr[]-> [freq,value]
    private TreeSet<int[]> main;
    private TreeSet<int[]> sec;

    public long[] findXSum(int[] nums, int k, int x) {

        // Intializing
        n = nums.length;
        index=0; // index for ans 
        ans = new long[n-k+1];
        map = new HashMap<>();

        //Comparator for set
        Comparator<int[]> comp = new Comparator<>(){
            public int compare(int a[],int b[]){
              if(a[0]!=b[0]) return Integer.compare(a[0], b[0]);
              else return Integer.compare(a[1], b[1]);
            }
        };

        main = new TreeSet<>(comp);
        sec = new TreeSet<>(comp);

        int i=0,j=0;
        sum=0;

        while(j<n){

          if(map.getOrDefault(nums[j],0)>0){
            removeFromSet(new int[]{map.get(nums[j]),nums[j]},x);
          }

          map.put(nums[j],map.getOrDefault(nums[j],0)+1);

          insertInSet(new int[]{map.get(nums[j]),nums[j]},x);

          if(j-i+1==k){
            ans[index]=sum;
            index++;

            removeFromSet(new int[]{map.get(nums[i]),nums[i]},x);
            map.put(nums[i],map.get(nums[i])-1);

            if(map.get(nums[i])==0){
                map.remove(nums[i]);
            }else{
                insertInSet(new int[]{map.get(nums[i]),nums[i]},x);
            }

            i++;
          }
          j++;
        }

        return ans;
    }

    void insertInSet(int arr[],int x){
       if(main.size()<x || comparePair(arr,main.first())>0){
         sum+=(long)arr[0]*arr[1];
         main.add(arr);
         if(main.size()>x){
            int[] smallest = main.first();
            sum -= 1L * smallest[0] * smallest[1];
            main.remove(smallest);
            sec.add(smallest);
         }
       }else{
        sec.add(arr);
       }
    }

    void removeFromSet(int arr[], int x){
        if(main.contains(arr)){
          sum-=(long)arr[0]*arr[1];
          main.remove(arr);

          if(!sec.isEmpty()){
            int newArr[]=sec.last();
            sec.remove(newArr);
            sum+=(long)newArr[0]*newArr[1];
            main.add(newArr);
          }
        }else{
            sec.remove(arr);
        }
    }

    int comparePair(int arr[], int p[]){
        if(p[0]!=arr[0]) return Integer.compare(arr[0],p[0]);
        return Integer.compare(arr[1],p[1]);
    }
}
