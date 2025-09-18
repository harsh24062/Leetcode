class TaskManager {
  
    Map<Integer,int[]> map;
    TreeSet<int[]> set;
  
    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        set = new TreeSet<>(new Comparator<>(){
            public int compare(int a[],int b[]){
                if(a[2]==b[2])return a[1]-b[1];
                return a[2]-b[2];
            }
        });

        for(List<Integer> list:tasks){
            int userId=list.get(0);
            int taskId=list.get(1);
            int priority=list.get(2);
            map.put(taskId,new int[]{userId,priority});
            set.add(new int[]{userId,taskId,priority});
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        map.put(taskId,new int[]{userId,priority});
        set.add(new int[]{userId,taskId,priority});
    }
    
    public void edit(int taskId, int newPriority) {
        int arr[]=map.get(taskId);
        int oldArr[]=new int[]{arr[0],taskId,arr[1]};
        int newArr[]=new int[]{arr[0],taskId,newPriority};
        map.put(taskId,new int[]{arr[0],newPriority});
        set.remove(oldArr);
        set.add(newArr);
    }
    
    public void rmv(int taskId) {
        int arr[]=map.get(taskId);
        int oldArr[]=new int[]{arr[0],taskId,arr[1]};
        map.remove(taskId);
        set.remove(oldArr);
    }
    
    public int execTop() {
        if(set.isEmpty())return -1;
        int arr[] = set.last();
        set.remove(arr);
        map.remove(arr[1]);
        return arr[0];
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
