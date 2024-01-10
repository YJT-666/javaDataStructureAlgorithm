import com.jjt.dataStructure.threadedBinaryTree.HeroNode;
import com.jjt.dataStructure.threadedBinaryTree.ThreadedBinaryTree;
import org.junit.jupiter.api.Test;

/**
 * ClassName: ThreadedBinaryTreeTest
 * Package: PACKAGE_NAME
 *
 * @Author jjt
 * @Create 2024/1/10 12:46
 * @Version 1.0
 * Description:
 *         线索化二叉树测试
 */
public class ThreadedBinaryTreeTest {

    @Test
    public void test01() {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        // 二叉树，创建
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(root);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 前序遍历测试，二叉树
        threadedBinaryTree.infixOrder(); // 8, 3, 10, 1, 14, 6
        System.out.println("------------------------------------------");

        // 测试线索化
        threadedBinaryTree.threadNodes();
        System.out.println(node5.getLeft()); // 3
        System.out.println(node5.getRight()); // 1
        System.out.println("------------------------------------------");
        // 线索化遍历
        System.out.println("线索化遍历");
        threadedBinaryTree.threadedList();


    }
}
