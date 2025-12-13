class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> list = new ArrayList<>();
        PriorityQueue<String[]> queue = new PriorityQueue<>((a,b) -> {
            int com = a[1].compareTo(b[1]);
            if(com!=0)return com;
            return a[0].compareTo(b[0]);
        }); 
        Set<String> set = new HashSet<>(Arrays.asList("electronics", "grocery", "pharmacy", "restaurant"));
        int n = code.length;
        for(int i=0;i<n;i++){
            if(isActive[i] && set.contains(businessLine[i])){
                boolean flag=false;
               for(char ch:code[i].toCharArray()){
                if(!((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9') || ch=='_')){
                    flag=true;
                    break;
                }
               }
               if(!flag)queue.offer(new String[]{code[i],businessLine[i]});
            }
        }

        while(!queue.isEmpty()){
            String s = queue.poll()[0];
            if(s.length()>0)list.add(s);
        }

        return list;
    }
}
