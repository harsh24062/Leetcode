class Solution {
    public String sortVowels(String s) {
       
        PriorityQueue<Character> pq1 = new PriorityQueue<>((a,b)->Character.compare(a, b));
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b)->Integer.compare(a, b));
        
        for(int i=0;i<s.length();i++){
          char ch = s.charAt(i);
          if(ch=='a' || ch=='o' || ch=='e' || ch=='i' || ch=='u' || ch=='A' || ch=='O' || ch=='E' || ch=='I' || ch=='U'){
            pq1.offer(ch);
            pq2.offer(i);
          }
        }

        StringBuilder sb = new StringBuilder(s);
        
        while(!pq1.isEmpty()){
            sb.setCharAt(pq2.poll(),pq1.poll());
        }

        return sb.toString();
    }
}
