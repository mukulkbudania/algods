package geeks.companies.facebook;

public class Dijakstra {
    /*public static class Graph {

        private final Set<Node> nodes = new HashSet<>();

        public void addNode(final Node nodeA) {
            nodes.add(nodeA);
        }

        public Set<Node> getNodes() {
            return nodes;
        }
    }
    public static class Node {

        private final String name;

        private final List<Node> shortestPath = new LinkedList<>();

        private final Integer distance = Integer.MAX_VALUE;

        Map<Node, Integer> adjacentNodes = new HashMap<>();

        public void addDestination(final Node destination, final int distance) {
            adjacentNodes.put(destination, distance);
        }

        public Node(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<Node> getShortestPath() {
            return shortestPath;
        }

        public Integer getDistance() {
            return distance;
        }

        public Map<Node, Integer> getAdjacentNodes() {
            return adjacentNodes;
        }

        public void setAdjacentNodes(final Map<Node, Integer> adjacentNodes) {
            this.adjacentNodes = adjacentNodes;
        }
    }
    public static Graph calculateShortestPathFromSource(final Graph graph, final Dijakstra.Node source) {
        source.setDistance(0);

        final Set<Node> settledNodes = new HashSet<>();
        final Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            final Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (final Map.Entry< Node, Integer> adjacencyPair:
                currentNode.getAdjacentNodes().entrySet()) {
                final Node adjacentNode = adjacencyPair.getKey();
                final Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(final Set < Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (final Node node: unsettledNodes) {
            final int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void CalculateMinimumDistance(final Dijakstra.Node evaluationNode,
                                                 final Integer edgeWeigh, final Node sourceNode) {
        final Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            final LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }*/
}
