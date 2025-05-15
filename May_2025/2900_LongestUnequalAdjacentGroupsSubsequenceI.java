class Solution {

    List<String> findList(String[] words, int[] groups, int cur){
       List<String> ans=new ArrayList<>();

       for(int i=0;i<groups.length;i++){
        if(groups[i]==cur){
            ans.add(words[i]);
            cur=(cur==1)?0:1;
        }
       }

       return ans;
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list1=findList(words,groups,1);      // start from 1
        List<String> list2=findList(words,groups,0);      // start from 0

        return (list1.size()>list2.size())?list1:list2;
    }
}
