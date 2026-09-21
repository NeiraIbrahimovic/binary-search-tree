package portfolio.algorithms;/*
 ***** Important!  Please Read! *****
 *
 *  - Do NOT remove any of the existing import statements
 *  - Do NOT import additional junit packages 
 *  - You MAY add in other non-junit packages as needed
 * 
 *  - Do NOT remove any of the existing test methods or change their name
 *  - You MAY add additional test methods.  If you do, they should all pass
 * 
 *  - ALL of your assert test cases within each test method MUST pass, otherwise the 
 *        autograder will fail that test method
 *  - You MUST write the require number of assert test cases in each test method, 
 *        otherwise the autograder will fail that test method
 *  - You MAY write more than the required number of assert test cases as long as they all pass
 * 
 *  - All of your assert test cases within a method must be related to the method they are meant to test
 *  - All of your assert test cases within a method must be distinct and non-trivial
 *  - Your test cases should reflect the method requirements in the homework instruction specification
 * 
 *  - Your assert test cases will be reviewed by the course instructors and they may take off
 *        points if your assert test cases to do not meet the requirements
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class BinarySearchTreeTest {
	
	@Test
	void testDepth() {
		/* 
		 * TODO Write at least 3 assert test cases that test your 'depth' method
		 * Review the homework instructions and write assert test realated the this methods specification
		 * All 3 assert statements MUST pass.
		 */
		
		//Initialize a new Binary Search Tree which holds integers
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.root = bst.new Node(10);
        bst.root.left = bst.new Node(5);
        bst.root.right = bst.new Node(15);
        bst.root.left.left = bst.new Node(3);
        
        //TEST 1: Normal case - Ensure depth of the root node is 0
        assertEquals(0, bst.depth(10), "Root should have depth 0");
        
        //TEST 2: Edge case - Ensure depth of a leaf node comes out correctly
        assertEquals(2, bst.depth(3), "Left grandchild should have depth 2");
        
        //TEST 3: Edge case - Ensure depth of any immediate child of the root Node is 1
        assertEquals(1, bst.depth(5), "Children of root node should have depth 2");
        
        //TEST 4: Edge case - Non-existing node should return -1
        assertEquals(-1, bst.depth(20), "Non-existing value should return -1");
        
        //TEST 5: Edge case - Null input value should return -1
        assertEquals(-1, bst.depth(null), "Null input values should return -1");
	}

	@Test
	void testFindNode() {
		/* 
		 * TODO Write at least 3 assert test cases that test your 'findNode' method
		 * Review the homework instructions and write assert test realated the this methods specification
		 * All 3 assert statements MUST pass.
		 */
		
		  //Initialize a new Binary Search Tree which holds integers
	      BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	        bst.root = bst.new Node(10);
	        bst.root.left = bst.new Node(5);
	        bst.root.right = bst.new Node(15);
	        bst.root.left.left = bst.new Node(2);
	        bst.root.right.right = bst.new Node(20);
	        
	        //TEST 1: Normal case - Ensure that the nodes can be found in the BST
	        assertNotNull(bst.findNode(10), "Root node should be found");
	        assertNotNull(bst.findNode(5), "Left node should be found");
	        assertNotNull(bst.findNode(15), "Right node should be found");
	        
	        //TEST 2: Edge case- Ensure that leaf nodes can be found in the BST
	        assertNotNull(bst.findNode(2), "Leaf node should be found");
	        assertNotNull(bst.findNode(20), "Leaf node should be found");
	        
	        //TEST 3: Edge case- Ensure that non-existent nodes return null
	        assertNull(bst.findNode(25), "Non-existing value should return null");
	        assertNull(bst.findNode(30), "Non-existing value should return null");
	        
	        //TEST 4: Edge case- Ensure that null input values return null
	        assertNull(bst.findNode(null), "Null input values should return null");
	        
	}

	@Test
	void testHeight() {
		/* 
		 * TODO Write at least 3 assert test cases that test your 'height' method
		 * Review the homework instructions and write assert test realated the this methods specification
		 * All 3 assert statements MUST pass.
		 */
        
		//Initialize a new Binary Search Tree which holds integers
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        BinarySearchTree<Integer>.Node root = bst.new Node(10);
        root.left = bst.new Node(5);
        root.right = bst.new Node(15);
        root.left.left = bst.new Node(2);
        root.right.right = bst.new Node(20);
        
        //TEST 1: Normal case - Height of the full tree
        assertEquals(2, BinarySearchTree.height(root), "Tree height should be 2");
        
        //TEST 2: Edge case - Height of a subtree
        assertEquals(1, BinarySearchTree.height(root.left), "Left subtree height should be 1");
        assertEquals(1, BinarySearchTree.height(root.right), "Right subtree height should be 1");
        
        //TEST 3: Edge case - Ensure the height of a leaf node is 0
        assertEquals(0, BinarySearchTree.height(root.left.left), "Leaf node height should be 0");
        assertEquals(0, BinarySearchTree.height(root.right.right), "Leaf node height should be 0");
        
        //TEST 4: Edge case - Ensure the height of an empty subtree (null Node) is -1
        assertEquals(-1, BinarySearchTree.height(root.left.left.left), "Null node height should be -1");
        assertEquals(-1, BinarySearchTree.height(root.right.right.right), "Null node height should be -1");
        assertEquals(-1, BinarySearchTree.height(root.left.left.right), "Null node height should be -1");
        assertEquals(-1, BinarySearchTree.height(root.right.right.left), "Null node height should be -1");
	}

	@Test
	void testIsBalancedNode() {
		/* 
		 * TODO Write at least 3 assert test cases that test your 'isBalancedNode' method
		 * Review the homework instructions and write assert test realated the this methods specification
		 * All 3 assert statements MUST pass.
		 */
		
		//Initialize a new Binary Search Tree which holds integers
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        BinarySearchTree<Integer>.Node root = bst.new Node(10);
        root.left = bst.new Node(5);
        root.right = bst.new Node(15);
        
        //TEST 1: Normal case - Ensure a node is balanced if the difference in height of the left and right subtree is 0
        assertTrue(BinarySearchTree.isBalancedNode(root), "Balanced node with equal left and right heights should return true");
        
        //TEST 2: Boundary Case - Ensure a node is NOT balanced if the difference in height of the left and right subtree is 2
        root.left.left = bst.new Node(3);
        root.left.left.left = bst.new Node(1);
        assertFalse(BinarySearchTree.isBalancedNode(root), "Unbalanced node off by 2 or more nodes should return false");
        assertFalse(BinarySearchTree.isBalancedNode(root.left), "Unbalanced node off by 2 or more nodes should return false");
        
        //TEST 2: Normal case - Ensure a node IS balanced if the difference in height of the left and right subtree is 1
        root.right.right = bst.new Node(20);
        root.right.right.right = bst.new Node(25);
        root.right.right.right.right = bst.new Node(30);
        assertTrue(BinarySearchTree.isBalancedNode(root), "Balanced node off by 1 node should return true");

        // TEST 3: Edge case - A leaf node is always balanced
        assertTrue(BinarySearchTree.isBalancedNode(root.right.right.right.right), "Leaf nodes should be balanced");
        assertTrue(BinarySearchTree.isBalancedNode(root.left.left.left), "Leaf nodes should be balanced");
        
        //TEST 4: Ensure a null input returns true
        assertTrue(BinarySearchTree.isBalancedNode(null), "A null input should return true.");
	}

	@Test
	void testIsBalancedTree() {
		/* 
		 * TODO Write at least 3 assert test cases that test your 'isBalanced' method
		 * Review the homework instructions and write assert test realated the this methods specification
		 * All 3 assert statements MUST pass.
		 */
		
		//Initialize a new Binary Search Tree which holds integers
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.root = bst.new Node(10);
        bst.root.left = bst.new Node(5);
        bst.root.right = bst.new Node(15);
        
        //TEST 1: Normal case - Fully balanced tree
        assertTrue(bst.isBalanced(), "Balanced tree should return true");
        
        //TEST 2: Edge case - Tree becomes unbalanced after adding deep left subtree
        bst.root.left.left = bst.new Node(3);
        bst.root.left.left.left = bst.new Node(1);
        assertFalse(bst.isBalanced(), "Unbalanced tree should return false");
        
        //TEST 3: Edge case - A single-node tree is always balanced
        BinarySearchTree<Integer> singleNodeBST = new BinarySearchTree<>();
        singleNodeBST.root = singleNodeBST.new Node(10);
        assertTrue(singleNodeBST.isBalanced(), "Single-node tree should be balanced");
	}
}