package loopy;

public class Loopy {
    public static class Node implements Comparable<Node> {
        public String name;
        public Node next;

        public Node(final String name, final Node next) {
            this.name = name;
            this.next = next;
        }

//        @Override
//        public boolean equals(Node other) {
//            if(other == null) return false;
//            return this.name.equals(other.name);
//        }

        @Override
        public int compareTo(Node other) {
            return this.name.compareTo(other.name);
        }
    }
    public static Node node(final String name, final Node next) {
        return new Node(name, next);
    }

    public static Node node(final String name) {
        return new Node(name, null);
    }

    public static boolean detectCycles(Node root) {
        Node slow = root;
        Node fast = root.next;
        if(fast == null) return false;

        while(!fast.equals(slow)) {
            slow = slow.next;
            if(slow == null) return false;
            fast = fast.next;
            if(fast == null) return false;
            fast = fast.next;
            if(fast == null) return false;
        }
        return true;
    }
}