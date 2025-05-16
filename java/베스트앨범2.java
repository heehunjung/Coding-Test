import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> all = new HashMap<>();
        Map<String, Map<Integer, Integer>> inGenres = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0;i<plays.length;i++) {
            if (!all.containsKey(genres[i])) {
                all.put(genres[i], plays[i]);
                Map<Integer, Integer> temp = new HashMap<>();
                temp.put(i, plays[i]);
                inGenres.put(genres[i], temp);
            } else {
                all.put(genres[i], all.get(genres[i]) + plays[i]);
                inGenres.get(genres[i]).put(i,plays[i]);
            }
        }        
        
        List<String> sortedGenres = new ArrayList<>(all.keySet());
        sortedGenres.sort((a, b) -> all.get(b) - all.get(a));

        for(String name: sortedGenres) {
            Map<Integer, Integer> temp = inGenres.get(name);
            List<Integer> arr = new ArrayList<>(temp.keySet());
            arr.sort((a,b) -> {
                if (temp.get(a)==temp.get(b)) {
                    return a-b;
                }
                return temp.get(b) - temp.get(a);
            });
            for(int i=0;i<arr.size();i++) {
                answer.add(arr.get(i));
                if(i == 1) break;
            }
        }
        int[] result = new int[answer.size()];
        for(int i=0;i<answer.size();i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
