class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        Collections.sort(events, (a,b) -> {
            int time1 = Integer.parseInt(a.get(1));
            int time2 = Integer.parseInt(b.get(1));
            if(time1==time2)return b.get(0).compareTo(a.get(0));
            return Integer.compare(time1,time2);
        });

        int mentions[] = new int[numberOfUsers];
        
        int timer[] = new int[101]; // it hold the timer of Users

        for(List<String> event:events){
             int timeStamp = Integer.parseInt(event.get(1));

            if(event.get(0).equals("MESSAGE")){
               if(event.get(2).equals("ALL")){
                 for(int i=0;i<numberOfUsers;i++){
                    timer[i]=Math.max(timer[i],timeStamp);
                    mentions[i]++;
                 }
               }else if(event.get(2).equals("HERE")){
                 for(int i=0;i<numberOfUsers;i++){
                    if(timer[i]<=timeStamp)mentions[i]++;
                    timer[i]=Math.max(timer[i],timeStamp);
                 }
               }else{
                  String arr[] = event.get(2).split(" ");

                  for(int i=0;i<arr.length;i++){
                    int id = Integer.parseInt(arr[i].substring(2));
                   mentions[id]++;
                  }
                  for(int i=0;i<arr.length;i++){
                    int id = Integer.parseInt(arr[i].substring(2));
                    timer[id]=Math.max(timer[id],timeStamp);
                  }
               }
            }else{
                int user_No = Integer.parseInt(event.get(2));
                timer[user_No] = Math.max(timer[user_No],timeStamp+60); 
            }
        }

        return mentions;
    }
}
