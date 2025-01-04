
// done by shashcode spproach
// https://youtu.be/LXFdpSm_T10?si=Eaq-Za05rRP21Z_x

// using sets
class Solution {
    public int countPalindromicSubsequence(String s) {


        Set<Character> set=new HashSet<>();
        for(char i:s.toCharArray()){
            set.add(i);
        }

        int count=0;

        for(char ch : set){
          int first=-1;
          int last=-1;

          for(int i=0;i<s.length();i++){
            if(s.charAt(i)==ch){
                if(first==-1) first=i;
                last=i;
            }
          }

           Set<Character> set1=new HashSet<>();

          for(int i=first+1;i<last;i++){
            set1.add(s.charAt(i));
          }

          count+=set1.size();
        }

      return count;
    }
}









//Another approach using maps


class Solution {
    public int countPalindromicSubsequence(String s) {
        // find unique chars
        HashMap<Character,Integer> firstOcc = new HashMap<Character,Integer>();
        HashMap<Character,Integer> lastOcc = new HashMap<Character,Integer>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(!firstOcc.containsKey(ch)){
                firstOcc.put(ch,i);
            }
            lastOcc.put(ch,i);
        }

        int count=0;
        for(char ch : firstOcc.keySet()){
            int first=firstOcc.get(ch);
            int last = lastOcc.get(ch);
            if(first == last) continue;
            HashSet<Character> set1 = new HashSet<>();
            for(int i=first+1;i<last;i++){
                set1.add(s.charAt(i));
            }
            count += set1.size();
        }
        return count;
    }
    
    }
