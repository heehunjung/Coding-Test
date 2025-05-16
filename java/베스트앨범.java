import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> all = new HashMap<>();
        Map<String, List<int[]>> inGenres = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0;i<plays.length;i++) {
            if (!all.containsKey(genres[i])) {
                all.put(genres[i], plays[i]);
                List<int[]> li = new ArrayList<>();
                li.add(new int[]{i, plays[i]});
                inGenres.put(genres[i], li);
            } else {
                all.put(genres[i], all.get(genres[i]) + plays[i]);
                inGenres.get(genres[i]).add(new int[]{i,plays[i]});
            }
        }        
        
        List<String> sortedGenres = new ArrayList<>(all.keySet());
        sortedGenres.sort((a, b) -> all.get(b) - all.get(a));
        
        for(String name: sortedGenres) {
            System.out.println(name);
            List<int[]> li = inGenres.get(name);
            li.sort((a, b) -> {
                if (b[1] != a[1]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];  
            });
            
            for(int i=0;i<li.size();i++) {
                answer.add(li.get(i)[0]);
                if(i==1) break;
            }
        }
        int[] result = new int[answer.size()];
        for(int i=0;i<answer.size();i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
