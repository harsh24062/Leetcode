class Solution {
    // using prefix sum approach
    public int[] vowelStrings(String[] words, int[][] queries) {

        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int freq[]=new int[words.length+1]; // will store prefix (index will be +1)
        
        for(int i=0;i<words.length;i++){
            int increment=0;

            String s=words[i];
            char firstChar = s.charAt(0);
            char lastChar  = s.charAt(s.length()-1);

            if(set.contains(firstChar) && set.contains(lastChar)){
                increment++;
            }
            freq[i+1] = increment + freq[i];
        }

        int ans[]=new int[queries.length];

       for(int i=0;i<queries.length;i++){
         int start = queries[i][0];
         int end = queries[i][1];
         ans[i] = freq[end+1] -freq[start];
       }

        return ans;
    }
}
