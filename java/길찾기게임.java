import java.util.*;

class Node {
    int value;
    int level; // y
    int rl;    // x
    Node p;
    Node r;
    Node l;

    public Node(int value, int x, int y) {
        this.value = value;
        this.rl = x;
        this.level = y;
        p = null;
        r = null;
        l = null;
    }
    
    public void addNode(Node node) {
        Node cnt = this;
        while(true) {
            // 왼쪽에 있는 경우
            Node nxt = null;
            if(cnt.rl > node.rl) {
                nxt = cnt.l;
                if(nxt != null) {
                    // 삽입 
                    if(nxt.rl < node.rl) {
                        if(nxt.r != null) {
                            cnt = nxt.r;
                        } else {
                            // nxt.p = node;
                            // node.p = cnt;
                            // node.l = nxt;
                            nxt.r = node;
                            node.p = nxt;
                            return;   
                        }
                    } else cnt = nxt;
                }else {
                    node.p = cnt;
                    cnt.l = node;
                    return;
                }
            }
            // 오른쪽에 있는 경우 
            if(cnt.rl < node.rl) {
                nxt = cnt.r;
                if(nxt != null) {
                    // 삽입 
                    if(nxt.rl > node.rl) {
                        if(nxt.l != null) {
                            cnt = nxt.l;
                        } else {
                            // nxt.p = node;
                            // node.p = cnt;
                            // node.r = nxt;
                            nxt.l = node;
                            node.p = nxt;
                            return;
                        }
                    } else cnt = nxt;
                } else {
                    node.p = cnt;
                    cnt.r = node;
                    return;
                }                    
            }
        }    
    }
    
    public int[] getPreorder() {
        Deque<Node> r = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        Node cnt = this;
                
        while(true) {
            result.add(cnt.value);
            if(cnt.r != null) {
                r.push(cnt.r);
            }
            if(cnt.l != null) {
                cnt = cnt.l;
            } else {
                if(r.isEmpty()) break;
                cnt = r.pop();
            }
        }
        int[] arr = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            arr[i] = result.get(i);
        }
        
        return arr;
    } 
    
    public int[] getPostOrder() {
        List<Integer> result = new ArrayList<>();
        Deque<Node> dq = new ArrayDeque<>();
        Deque<Node> check = new ArrayDeque<>();
        Node cnt = this;
        dq.push(cnt);
        while(cnt != null) {
            if(cnt.l != null) {
                check.push(cnt.l);
            }
            if(cnt.r != null) {
                dq.push(cnt.r);
                cnt = cnt.r;
                continue;
            }
            cnt = check.poll();
            if(cnt !=null) {dq.push(cnt); }
        }
        
        while(!dq.isEmpty()) result.add(dq.pop().value);

        int[] arr = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            arr[i] = result.get(i);
        }
        
        return arr;        
    }
}
class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        HashMap<String,Integer> lvs = new HashMap<>();
        int value = 1;
        for (int[] nd : nodeinfo) lvs.put(nd[0] + "," + nd[1], value++);
        Arrays.sort(nodeinfo, (a, b) -> b[1] - a[1]);
        
        int[] first = nodeinfo[0];
        Node root = new Node(lvs.get(first[0]+","+first[1]), first[0], first[1]);
        
        //  level 순으로 제공함 
        for(int i=1;i<nodeinfo.length;i++) {
            int[] cnt = nodeinfo[i];
            int cx = cnt[0];
            int cy = cnt[1];
            Node cntNode = new Node(lvs.get(cx+","+cy), cx, cy);
            root.addNode(cntNode);
        }
        
        answer[0] = root.getPreorder();
        answer[1] = root.getPostOrder();
        return answer;
    }
}

