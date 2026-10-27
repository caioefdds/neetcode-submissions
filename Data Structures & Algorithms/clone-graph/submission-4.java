/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> clone = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            clone.putIfAbsent(current, new Node(current.val));

            for (Node neighbor : current.neighbors) {
                clone.putIfAbsent(neighbor, new Node(neighbor.val));
                clone.get(current).neighbors.add(clone.get(neighbor));

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return clone.get(node);
    }
}