public class NetworkDelayTime {
    class Node {
        int nodeId, distance;
        public Node(int nodeId, int distance){
            this.nodeId = nodeId;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        for(int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        List<Node>[] nodeList = new List[n];
        for(int i=0; i < nodeList.length; i++){
            nodeList[i] = new ArrayList<>();
        }

        for(int[] time : times){
            nodeList[time[0] - 1].add(new Node(time[1] -1, time[2]));
        }

        Queue<Node> queue = new PriorityQueue<>((n1, n2)-> n1.distance - n2.distance);
        queue.offer(new Node(k-1, 0));
        dist[k-1] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int distance = node.distance;
            int nodeId = node.nodeId;

            for (int i = 0; i < nodeList[nodeId].size(); i++) {
                Node curNode = nodeList[nodeId].get(i);
                int curNodeId = curNode.nodeId;
                int curNodeDistance = curNode.distance;
                if (dist[curNodeId] > distance + curNodeDistance) {
                    dist[curNodeId] = distance + curNodeDistance;
                    queue.add(new Node(curNodeId, distance + curNodeDistance));
                }
            }
        }

        for(int i : dist) {
            if(i == Integer.MAX_VALUE) return -1;
        }

        int max = 0;
        for(int i : dist) {
            max = Math.max(max, i);
        }
        return max;
    }
}