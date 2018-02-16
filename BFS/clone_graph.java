/*
*
* 133. Clone Graph
* https://leetcode.com/problems/clone-graph/description/
*
* 用BFS来一个node一个node的clone graph
* */

package BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class clone_graph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        // 用map来避免重复把一个node放进queue，因为graph里可能有循环,，同时用map来represent新graph
        Map<Integer, UndirectedGraphNode> map = new HashMap<>(); // map<label, new node>
        Queue<UndirectedGraphNode> queue = new LinkedList<>(); // queue里存的老node
        // 新建一个cloned root node
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(root.label, root);
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode poll = queue.poll();
            for (UndirectedGraphNode neighbor : poll.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    // 因为是clone，放一个新的node进去，而不是放neighbor
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(poll.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return root;
    }
}
