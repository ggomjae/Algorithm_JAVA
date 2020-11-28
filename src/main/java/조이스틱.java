import java.util.*;
class Solution {

    static boolean[] visited;
    static int answer = 0;
    static int point = 0;

    public boolean isOK(){
        for(int i = 0 ; i < visited.length ; ++i){
            if(!visited[i]) return false;
        }
        return true;
    }

    public int solution(String name) {

        visited = new boolean[name.length()];

        for(int i = 0 ; i < name.length() ; ++i){
            if(name.charAt(i) == 'A') visited[i] = true;
        }

        while (!isOK()) {
            int next = 0; int left_answer = 0; int right_answer = 0;

            for (int i = 0; i < name.length(); i++) {
                if (point + i < name.length()) right_answer = point + i;
                else right_answer = point + i - name.length();

                if (point - i >= 0) left_answer = point - i;
                else left_answer = point - i + name.length();

                if (!visited[right_answer]) next = right_answer;
                else if (!visited[left_answer]) next = left_answer;
                else continue;

                visited[next] = true;
                answer += i;
                answer += Math.min(name.charAt(next) - 'A', 'Z' - name.charAt(next) + 1);
                break;
            }
            point = next;
        }

        return answer;
    }
}