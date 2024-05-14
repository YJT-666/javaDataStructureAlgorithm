import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class huaweiTest {
    public static TreeNode buildFullBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);

        return root;
    }
    public static String searchPath(TreeNode root, int target) {
        StringBuilder path = new StringBuilder("S"); // 添加根节点标识符
        if (search(root, target, path)) {
            path.append("Y");
        } else {
            path.append("N");
        }
        return path.toString();
    }

    private static boolean search(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        if (target < root.val && root.left != null) {
            path.append("L");
            if (search(root.left, target, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1); // Backtrack
        } else if (target > root.val && root.right != null) {
            path.append("R");
            if (search(root.right, target, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1); // Backtrack
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = buildFullBST(nums);
        int target = 6;
        String path = searchPath(root, target);
        //System.out.println(path);
        Stack<Character> stack = new Stack<>(){{
            add('?');
        }};
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
