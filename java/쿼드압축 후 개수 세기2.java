class Solution {
    int[] answer = new int[2]; 
    
    public int[] solution(int[][] arr) {
        apchuk(arr, 0, 0, arr.length);
        return answer;
    }
    

    void apchuk(int[][] arr, int x, int y, int size) {
        
        if (canCompress(arr, x, y, size)) {
            answer[arr[x][y]]++; 
            return;
        }
        
        int newSize = size / 2;
        
        apchuk(arr, x, y, newSize);                     
        apchuk(arr, x, y + newSize, newSize);          
        apchuk(arr, x + newSize, y, newSize);          
        apchuk(arr, x + newSize, y + newSize, newSize); 
    }
    
    boolean canCompress(int[][] arr, int x, int y, int size) {
        int startVal = arr[x][y]; // 첫 번째 값 기준
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != startVal) {
                    return false; 
                }
            }
        }
        return true; // 모두 같음
    }
}
