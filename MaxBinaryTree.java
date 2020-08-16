// LeetCode #654 - https://leetcode.com/problems/maximum-binary-tree/submissions/
/**
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class MaxBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
	TreeNode root = binaryTree(nums, 0, nums.length-1);
	return root;
		
    }
	
    public TreeNode binaryTree(int[] nums, int start, int end) {
        int index = findMax(nums, start, end);

	if(start > index ) return null;
	if(index > end ) return null;

	TreeNode root = new TreeNode(nums[index]);
	root.left = binaryTree(nums, start, index-1);
	root.right = binaryTree(nums, index+1, end);

	return root;
    }
	
	
    public int findMax(int[] nums, int start, int end) {
	int max = -1;
	int index = 0;

	for(int i=start; i <= end; i++) {
		if(nums[i] > max) {
			max = nums[i];
			index = i;
		}
	}
	return index;
    }
	
}
