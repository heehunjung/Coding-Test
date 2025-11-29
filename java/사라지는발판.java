class Solution {
    int[][] mvs = {{0,1},{0,-1},{1,0},{-1,0}};
    int N, M;

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
        return dfs(board, aloc, bloc).count;
    }

    class Result {
        boolean win; 
        int count;
        public Result(boolean win, int count){ this.win = win; this.count = count; }
    }

    public Result dfs(int[][] board, int[] cur, int[] next) {
        // 패배 
        if (board[cur[0]][cur[1]] == 0) return new Result(false, 0);

        int minWin = Integer.MAX_VALUE;
        int maxLose = 0;               
        boolean canWin = false;         
        boolean canMove = false;       

        for (int[] mv : mvs) {
            int nx = cur[0] + mv[0];
            int ny = cur[1] + mv[1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 1) {
                canMove = true;
                board[cur[0]][cur[1]] = 0; // 발판 삭제
                
                // 상대방 턴 호출
                Result res = dfs(board, next, new int[]{nx, ny});
                
                board[cur[0]][cur[1]] = 1; // 백트래킹

                // 상대가 졌다
                if (!res.win) {
                    canWin = true;
                    // 이기는 경우 중 가장 빨리 끝나는 것 선택
                    minWin = Math.min(minWin, res.count + 1);
                } 
                // 상대가 이겼다 
                else if (!canWin) {
                    // 아직 이기는 수를 못 찾았다면, 지더라도 최대한 늦게 지는 것 선택
                    maxLose = Math.max(maxLose, res.count + 1);
                }
            }
        }

        // 움직일 곳이 없으면 패배
        if (!canMove) return new Result(false, 0);

        // 이길 수 있는 경우가 하나라도 있으면 -> 최솟값 리턴 
        if (canWin) return new Result(true, minWin);
        
        // 어쩔 수 없이 다 지는 경우라면 -> 최댓값 리턴 
        return new Result(false, maxLose);
    }
}
