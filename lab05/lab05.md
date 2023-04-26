### Problems marked (P) below require programming, those marked (A) require only answers.
• (P) Add a data field size to the inner Node class. Adjust the dynamic methods
add(String s) and delete(String s) (as well as the private methods they
may call) so that the size of any node in the tree is correctly maintained.

• (P) Add a method size(String s) that returns the size of the subtree rooted
at s (or 0 if s is not in the tree).

• (P) Add a data field height to the inner Node class. Adjust the dynamic methods
add(String s) and delete(String s) (as well as the private methods they
may call) so that the size of any node in the tree is correctly maintained.

• (P) Add a method height(String s) that returns the height of the node whose
key is s (or -1 if s is not in the tree).

• (P) In lecture 12, an algorithm to construct an “as balanced as possible” tree from
a sorted array of String was described (recursively: make the midpoint of the
list the root, and do the same to construct the left subtree from the things before it,
and the right subtree from the things after it). Implement that method as static
BST makeBalanced(String[] dictionary) inside the BST class.

#### (A) How could you use that method to fully balance a given BST? That is, how would you code an instance method void makeBalanced() that makes a given that BST as balanced as possible? It is generally not possible to assign to this, i.e.,something along the line of this = BST.makeBalanced(...) is not going to work.
we need to create an array of the strings 
then we need to call teh inordertransversal() method to get the array of string items in teh BST(this is done recurssivly(inordertransversal))and then we are going to set the list to this 
then we use the inorderList which is a list that will be used as a parameter in teh inorder transversal method, 

-call to the inorder transversal method(recurssive calls)
private void inOrderTraversal(Node<T> node, List<T> inOrderList) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, inOrderList);
        inOrderList.add(node.data);
        inOrderTraversal(node.right, inOrderList);
    }


and then we are going to recurssivly call the inrdertransversal and use .add method to the inorderList that will now contain the node data 
we are going to do this for both right and left children 

now we can call the makeBalanced() method using the new inorder array lsit 



• (P) Add a method next(String s) that returns the first (in alphabetical order) string t contained in a BST that is greater than s. It should return null if there is
not such a node.
DONE


#### (A) How might the code for a method private Node next(Node n) that returns the next Node of a BST (or null) i.e., the node whose key is the least key of the tree greater than the key at the given node differ fundamentally from the previous method? (for the purposes of increased efficiency) – in fact, doesn’t it already exist?