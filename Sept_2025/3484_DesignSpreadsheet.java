class Spreadsheet {
    int arr[][];
    public Spreadsheet(int rows) {
        arr = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1,cell.length()))-1;
        arr[row][col]=value;
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1,cell.length()))-1;
        arr[row][col]=0;
    }
    
    public int getValue(String formula) {
        int plus=formula.indexOf('+');
        int first=0;
        if(formula.charAt(1)>=65){
        int col1=formula.charAt(1)-'A';
        int row1=Integer.parseInt(formula.substring(2,plus))-1;
        first = arr[row1][col1];
        }else{
          first=Integer.parseInt(formula.substring(1,plus));
        }
         
        int second = 0;
        if(formula.charAt(plus+1)>=65){
        int col2=formula.charAt(plus+1)-'A';
        int row2=Integer.parseInt(formula.substring(plus+2,formula.length()))-1;
        second = arr[row2][col2];
        }else{
            second=Integer.parseInt(formula.substring(plus+1,formula.length()));
        }
        return first+second;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
