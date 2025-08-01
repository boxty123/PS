package LeeJungHyun.DS.Queue;

import java.util.*;

class Server {
    public int server(int[] players, int m, int k) {
        int answer = 0;
        int newServer=0;
        int currentServer;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<players.length;i++){

            int needServer= players[i]/m;

            while(!q.isEmpty() && q.peek()<=i)
                q.poll();

            currentServer=q.size();

            if(currentServer<needServer)
                newServer=needServer-currentServer;

            answer+=newServer;

            for(int j=0;j<newServer;j++)
                q.offer(i+k);
        }
        return answer;
    }
}