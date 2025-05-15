import java.util.*;

class Solution {
    List<Integer> table = new LinkedList<>();
    Deque<Integer> removed = new ArrayDeque<>();
    int current;

    public String solution(int n, int k, String[] cmd) {
        for (int i = 0; i < n; i++) {
            table.add(i);
        }

        current = k;

        for (String command : cmd) {
            execute(command);
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (idx < table.size()) {
                int val = table.get(idx);
                if (val == i) {
                    sb.append("O");
                    idx++;
                } else {
                    while (i < val) {
                        sb.append("X");
                        i++;
                    }
                    i--; // 마지막에 1 증가된 걸 보정
                }
            } else {
                sb.append("X");
            }
        }

        return sb.toString();
    }

    private void execute(String cmd) {
        String[] parts = cmd.split(" ");
        String cmdType = parts[0];

        if (cmdType.equals("U")) {
            int x = Integer.parseInt(parts[1]);
            current = (current - x + table.size()) % table.size();
        } else if (cmdType.equals("D")) {
            int x = Integer.parseInt(parts[1]);
            current = (current + x) % table.size();
        } else if (cmdType.equals("C")) {
            int removedValue = table.remove(current);
            removed.offerFirst(removedValue);
            if (current == table.size()) {
                current--;
            }
        } else if (cmdType.equals("Z")) {
            if (!removed.isEmpty()) {
                int restore = removed.poll();
                for (int i = 0; i < table.size(); i++) {
                    if (table.get(i) > restore) {
                        table.add(i, restore);
                        if (i <= current) current++;
                        return;
                    }
                }
                table.add(restore); // 마지막에 삽입
            }
        }
    }
}

