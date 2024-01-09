import com.jjt.dataStructure.BinaryTree;
import com.jjt.dataStructure.HeroNode;
import org.junit.jupiter.api.Test;

/**
 * ClassName: BinaryTreeTest
 * Package: PACKAGE_NAME
 *
 * @Author jjt
 * @Create 2024/1/9 18:50
 * @Version 1.0
 * Description:
 *        测试 二叉树相关功能
 */
public class BinaryTreeTest {


    @Test
    public void test01(){


        HeroNode root = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "吴用");
        HeroNode heroNode3 = new HeroNode(3, "卢俊义");
        HeroNode heroNode4 = new HeroNode(4, "林冲");
        HeroNode heroNode5 = new HeroNode(5, "关胜");

        // 手动创建二叉树
        BinaryTree binaryTree = new BinaryTree(root);
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        root.getRight().setRight(heroNode4);
        root.getRight().setLeft(heroNode5);

        // 测试查找
        System.out.println("测试查找");
        System.out.println(binaryTree.preOrderSearch(3));
        System.out.println(binaryTree.infixOrderSearch(4));
        System.out.println(binaryTree.postOrderSearch(5));

        System.out.println(binaryTree.preOrderSearch(7));
        System.out.println(binaryTree.infixOrderSearch(7));
        System.out.println(binaryTree.postOrderSearch(7));


        System.out.println("-----------------------------------");

        // 测试遍历
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("----------------------------------");

        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("----------------------------------");

        System.out.println("后序遍历");
        binaryTree.postOrder();
        System.out.println("----------------------------------");


        // 测试删除节点
        System.out.println("删除节点");
        binaryTree.remove(5);
        binaryTree.preOrder();
        System.out.println("----------------------------------");
        binaryTree.remove(3);
        binaryTree.preOrder();
        System.out.println("----------------------------------");

    }
}
