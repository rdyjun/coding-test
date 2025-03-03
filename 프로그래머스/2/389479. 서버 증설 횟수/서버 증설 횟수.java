import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Server> serverQueue = new LinkedList<>();
        int playerLength = players.length;
        int serverAmount = 0;
        
        for (int time = 0; time < playerLength; time++) {
            while (!serverQueue.isEmpty()) {
                Server server = serverQueue.peek();
                if (!server.isOverTime(time)) {
                    break;
                }
                
                serverAmount -= server.getAmount();
                serverQueue.poll();
            }
            
            int needAmount = players[time] / m;
            if (serverAmount >= needAmount) {
                continue;
            }
            
            int addAmount = needAmount - serverAmount;
            
            answer += addAmount;
            serverAmount += addAmount;
            
            Server server = new Server(time, addAmount, k);
            serverQueue.add(server);
        }
        
        return answer;
    }
    
    static class Server {
        int end;
        int amount;
        
        public Server(int start, int amount, int usage) {
            this.end = start + usage;
            this.amount = amount;
        }
        
        public boolean isOverTime(int time) {
            return time >= end;
        }
        
        public int getAmount() {
            return this.amount;
        }
    }
}