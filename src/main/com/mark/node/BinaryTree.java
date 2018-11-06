package main.com.mark.node;

import javax.management.loading.PrivateClassLoader;

public class BinaryTree {

    private static Node root;

    public BinaryTree (int data) {
        root = new Node(data);
    }

    private void add (Node parent, Node child, String orientation) {
        if (orientation.equals("left")) {
            parent.setLeft(child);
        } else if (orientation.equals("right")) {
            parent.setRight(child);
        }
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if ( value < current.value ) {
            current.setLeft( addRecursive(current.getLeft(), value) );
        } else if ( value > current.getKey() ) {
            current.setRight( addRecursive(current.getRight() , value));
        } else {
            return current;
        }
    }

    private void add2 (int value) {
        root = addRecursive(root, value);
    }



    /**
     * 前序遍历
     */
    public static void preOrder( Node node) {
        if (node == null) {
            return;
        }
        System.out.println( node.getKey() );
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    private static void test1 () {
        Node n1 = new Node(1);
        Node n2 = new Node(4);
        Node n3 = new Node(2);
        Node n4 = new Node(5);

        BinaryTree tree = new BinaryTree(3);
        tree.add(root, n1, "left");
        tree.add(root, n2, "right");
        tree.add(n2, n3, "left");
        tree.add(n2, n4, "right");

        /**
         * 3 / \ 1 4 / \ 2 5
         */

        System.out.println(tree);

        preOrder(tree.root);
    }

    private static BinaryTree test2() {
        BinaryTree bt = new BinaryTree();

        bt.add2(6);
        bt.add2(4);
        bt.add2(8);
        bt.add2(3);
        bt.add2(5);
        bt.add2(7);
        bt.add2(9);
        return bt;
    }

    public static void main(String[] args) {
 

    }

}

class Node {
    private int key;
    private Node left;
    private Node right;

    Node (int key) {
        this.key = key;
        right = null;
        left = null;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

}