class NumberContainers {
    
    HashMap<Integer,TreeSet<Integer>> numberToIndex; // a number can have multiple index
    HashMap<Integer,Integer> indexToNumber; // a index can have only one number

    public NumberContainers() {
        numberToIndex=new HashMap<>();
        indexToNumber=new HashMap<>();
    }
    
    public void change(int index, int number) {
      // delete existing index
      if(indexToNumber.containsKey(index)){
        int prevNumber= indexToNumber.get(index);
        numberToIndex.get(prevNumber).remove(index);
        if(numberToIndex.get(prevNumber).size()==0)
        numberToIndex.remove(prevNumber);
      }
      
      //add new 
      indexToNumber.put(index,number);
      if(!numberToIndex.containsKey(number)) numberToIndex.put(number,new TreeSet<>());
      numberToIndex.get(number).add(index); 

    }
    
    public int find(int number) {
        if(!numberToIndex.containsKey(number)) return -1;
        return numberToIndex.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
