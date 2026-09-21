package portfolio.algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Maintenance regressions, separate from the recovered test suite. */
class BalanceRegressionTest {
    @Test void detectsImbalanceBelowBalancedRootAndChildren() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.root = tree.new Node(20);
        tree.root.left = tree.new Node(10);
        tree.root.left.left = tree.new Node(5);
        tree.root.left.left.left = tree.new Node(3);
        tree.root.left.left.left.left = tree.new Node(1);
        tree.root.left.right = tree.new Node(15);
        tree.root.left.right.right = tree.new Node(17);
        tree.root.right = tree.new Node(30);
        tree.root.right.left = tree.new Node(25);
        tree.root.right.left.left = tree.new Node(23);
        tree.root.right.right = tree.new Node(35);
        assertTrue(BinarySearchTree.isBalancedNode(tree.root));
        assertTrue(BinarySearchTree.isBalancedNode(tree.root.left));
        assertFalse(tree.isBalanced());
        assertFalse(tree.isBalancedFast());
    }
    @Test void emptyAndBalancedTreesAgree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertTrue(tree.isBalanced());
        assertTrue(tree.isBalancedFast());
        tree.root = tree.new Node(2);
        tree.root.left = tree.new Node(1);
        tree.root.right = tree.new Node(3);
        assertTrue(tree.isBalanced());
        assertTrue(tree.isBalancedFast());
    }
}
