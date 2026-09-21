package portfolio.algorithms;/*
 * I attest that the code in this file is entirely my own except for the starter
 * code provided with the assignment and the following exceptions:
 * <Enter all external resources and collaborations here. Note external code may
 * reduce your score but appropriate citation is required to avoid academic
 * integrity violations. Please see the Course Syllabus as well as the
 * university code of academic integrity:
 * Signed,
 * Author: Neira Ibrahimovic
 * Date: 2024-02-26
 */

public class BinarySearchTree<E extends Comparable<E>> {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 29384723897L;

    class Node {
        E value;
        Node left = null;
        Node right = null;

        Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "( " + value + " )";
        }
    }

    protected Node root = null;
    protected int size = 0;

    /**
     * Adds value to BST and returns true only if value is non-null and does not
     * already exist in the BST.
     * 
     * @param val Value to be added to BST
     * @return True only if element was added to BST
     */
    public boolean add(E val) {
        if (val == null)
            return false;
        int size = this.size;
        this.root = add(this.root, val);
        return size != this.size;
    }

    /**
     * Adds a value to the tree starting at Node n, returning the node occupying the
     * same position as was given, which may be a new node containing the given
     * value if the given node is null, or it may be an existing node if that node
     * already contains the given value.
     * 
     * @param n   The subtree to which to add the value
     * @param val The value to add
     * @return The updated subtree root (possibly null) after adding the value
     */
    private Node add(Node n, E val) {
        if (n == null) {
            this.size++;
            return new Node(val);
        }

        int cmp = val.compareTo(n.value);
        if (cmp < 0)
            n.left = add(n.left, val);
        else if (cmp > 0)
            n.right = add(n.right, val);
        return n;
    }

    /**
     * Removes value from BST and returns true only if value is non-null and existed
     * in BST.
     * 
     * @param val The value to remove
     * @return True only if the value was removed from the BST
     */
    public boolean remove(E val) {
        if (val == null)
            return false;
        int size = this.size;
        this.root = remove(this.root, val);
        return size != this.size;
    }

    /**
     * Removes a value from the tree starting at Node n, returning the node
     * occupying the same position as was given (which can be null if the given node
     * gets removed).
     * 
     * The below code follows the BST node deletion algorithm described in Data
     * Structures and Algorithms in Java, Section 11.1.2, page 464.
     * 
     * @param n   The subtree from which to remove the value
     * @param val The value to remove
     * @return The updated subtree root (possibly null) after removing the value
     */
    private Node remove(Node n, E val) {
        if (n == null)
            return null;
        int cmp = val.compareTo(n.value);
        if (cmp < 0)
            n.left = remove(n.left, val);
        else if (cmp > 0)
            n.right = remove(n.right, val);
        else if (n.left == null) {
            /*
             * The value of n.right is the correct return value for this method whether it
             * is null or a Node. Thus there is no need for a (n.left == null && n.right ==
             * null) branch.
             */
            this.size--;
            return n.right;
        } else if (n.right == null) {
            this.size--;
            return n.left;
        } else {
            E pred = maxValue(n.left);
            n.value = pred;
            n.left = remove(n.left, pred);
        }

        return n;
    }

    /**
     * Returns the maximum value contained in the subtree rooted at the given Node,
     * or null if the given subtree is empty.
     * 
     * @param n The subtree from which to search for the maximum value
     * @return The value of the node at the rightmost position, which holds the
     *         maximum value of the represented sorted set
     */
    protected E maxValue(Node n) {
        if (n == null)
            return null;
        if (n.right == null)
            return n.value;
        return maxValue(n.right);
    }

    /*
     * ASSIGNMENT METHODS: Implement the methods below.
     */

    /**
     * Given a value that is stored in this BST, this method returns the
     * corresponding Node that holds it, or null if the value is null or does
     * not exist in this BST.
     * 
     * @param val The value to find in the BST
     * @return The Node containing the value if it exists in this BST, else null
     */
    protected Node findNode(E val) {
    	//Edge Case: If the value is null, return null
        if (val == null) return null;  
        
        //Start from the root node and assign the root node to current variable
        Node current = root;  
        
        //Traverse the tree until a null node is reached
        while (current != null) {
        	
        	//Compare the user's input value with the value of the current node
            int cmp = val.compareTo(current.value); 
            
            //If the values are equal, return the node
            if (cmp == 0) return current;  
            
            //If the user's value is less than the current node's value, move to the left node
            else if (cmp < 0) current = current.left; 
            
            //If the user's value is greater than the current node's value, move to the right node
            else current = current.right;  
        }
        //Edge Case: If the value does not exist in the binary search tree (the while loop was completed with no match), return null
        return null;  
    }

    /**
     * Given a value, this method returns the depth of its Node, or -1 if the
     * value is null or does not exist in this BST. The depth is defined as the
     * number of edges from that node to the root.
     * 
     * @param val The value of the node from which to calculate depth
     * @return The number of edges from the node containing the given value in
     *         this BST to the root of the BST, or -1 if value does not exist
     *         in the BST
     */
    protected int depth(E val) {
    	//Edge Case: If value is null, return -1
        if (val == null) return -1;  
        
        //Start from the root node and set the root node to current variable
        Node current = root;  
        
        //Initialize the depth counter to 0
        int depth = 0;  
        
        //Traverse the tree until a null node is reached
        while (current != null) {  
        	
        	//Compare the user's input value with the value of the current node
            int cmp = val.compareTo(current.value);  
            
            //If the values are equal, you have found the user's input node, so return the depth
            if (cmp == 0) return depth;  
            
            //If the user's value is less than the current node's value, move to the left node
            else if (cmp < 0) current = current.left;  
            
            //If the user's value is greater than the current node's value, move to the right nodE
            else current = current.right;  
            
            //Increment depth counter
            depth++;  
        }
        
        //Edge Case: If the value does not exist in the binary search tree (the while loop was completed with no match), return -1
        return -1;  
    }

    /**
     * For the subtree rooted at the given Node, this method returns the height
     * of the subtree. The height of a subtree is defined as the maximum number
     * of edges between the root of the subtree and any descendant leaf. The
     * height of a leaf is 0. The height of an empty subtree, represented as a
     * null Node, is defined to be -1.
     * 
     * @param n Node representing a subtree rooted at that node
     * @return The height of the given subtree
     */
    protected static int height(BinarySearchTree<?>.Node n) {
    	//Edge Case: If node is null, return -1
    	if (n == null) return -1;
    	
    	//Compute height recursively
        return 1 + Math.max(height(n.left), height(n.right));  
        
        //Longer explanation: Continue calling the height function until you reach a null node
        //The null node returns -1. If both child nodes are null, this means the height will be 0 (1 + max(-1, -1)).
        //Once a null node is reached, we will get out of the current function in the recursion and move up a level in the recursion.
        //The heights will be recursively added on until the final height is reached when we get back to the root level of the recursion.
        
    }

    /**
     * Given null, returns true. Given an instance of Node, returns true only if
     * the absolute value of the difference in heights of its left and right
     * children is less than 2.
     * 
     * @param n The node to test for balance
     * @return True only if node is null or is non-null and the absolute value
     *         of the difference in heights of its left and right children is
     *         less than 2
     */
    protected static boolean isBalancedNode(BinarySearchTree<?>.Node n) {
    	//Null nodes are considered balanced. If the node is null, return true.
    	if (n == null) return true;  
    	
    	//Get left subtree height using the height method and store in variable
        int leftHeight = height(n.left);  
        
        //Get right subtree height using the height method and store in variable
        int rightHeight = height(n.right); 
        
        //Check if height difference is at most 1 and return the result
        return Math.abs(leftHeight - rightHeight) < 2;  
    }

    /**
     * This method returns false if and only if there exists any node in the
     * tree for which isBalancedNode(n) returns false; otherwise it returns
     * true.
     * 
     * @return True only if the entire tree is balanced
     */
    public boolean isBalanced() {
        // Checking only the root and its children misses deeper imbalances.
        return balancedSubtree(root);
    }

    private boolean balancedSubtree(Node node) {
        return node == null || (isBalancedNode(node)
                && balancedSubtree(node.left) && balancedSubtree(node.right));
    }
    

    /**
     * OPTIONAL CHALLENGE: Produces the same result as isBalanced() but does so
     * in O(n) time.
     * 
     * Ungraded. Do not attempt until after you have a working isBalanced() for
     * grading.
     * 
     * @return True only if the entire tree is balanced
     */
    public boolean isBalancedFast() {
        return balancedHeight(root) != Integer.MIN_VALUE;
    }

    /** Return subtree height, or a sentinel when any descendant is unbalanced.
     * Each visited node is evaluated once: O(n) time and O(h) call-stack space.
     * This completion was added during portfolio maintenance, not recovered.
     */
    private int balancedHeight(Node node) {
        if (node == null) return -1;
        int left = balancedHeight(node.left);
        if (left == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int right = balancedHeight(node.right);
        if (right == Integer.MIN_VALUE || Math.abs(left - right) > 1)
            return Integer.MIN_VALUE;
        return 1 + Math.max(left, right);
    }
}
