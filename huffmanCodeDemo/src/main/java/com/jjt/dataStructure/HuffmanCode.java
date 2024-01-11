package com.jjt.dataStructure;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * ClassName: HuffmanCode
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/11 12:03
 * @Version 1.0
 * Description:
 *              哈夫曼编码实现文件的压缩和解压缩
 *
 *              哈夫曼编码介绍：
 *              > 哈夫曼编码是一种可变长编码
 *              > 哈夫曼编码是一种前缀编码，字符的编码都不能是其他字符编码的前缀，因此在解码时不存在二义性
 *              > 哈夫曼编码是一种无损压缩编码
 *              > 哈夫曼编码的压缩率可达 20%~90%，文件当中重复的字符越多，压缩率越大
 *
 *              如何建立哈夫曼编码：
 *                1. 统计文件当中字符出现的频数，从作为哈夫曼树结点的权值，并且哈夫曼树结点还需要有一个 data属性，保存字符的ASCII
 *                2. 建立哈夫曼树
 *                3. 分别从哈夫曼树根节点开始遍历查找叶子结点，其走过的路径（向左走是0，向右走是1）形成的0、1序列就是该字符的哈夫曼编码
 *
 *              如可建立哈夫曼树：
 *                1. 将每一个数据构建成的二叉树结点node，放入到结点集合nodes当中
 *                2. 根据结点的权值对所有的结点进行升序排序
 *                3. 取出根节点权值最小的两颗二叉树
 *                4. 组成一颗新的二叉树，该新的二叉树的根节点权值是前面两颗二叉树根节点权值之和
 *                5. 将这颗新的二叉树的根节点放入到结点集合nodes当中，重复步骤2~5，直到所有的数据都被处理，这样就形成了一颗新的二叉树
 */
public class HuffmanCode {

    /**
     *   结点类
     *   为了让 Node 对象支持排序 Collections 工具类的 集合排序
     *   需要实现 Comparable接口
     * */
    public class Node implements Comparable<Node> {

        private int weight;  // 结点权值
        private int ch;      // 该节点编码的字符，只有叶子结点，该属性才有效
        private Node left;   // 指向左子结点
        private Node right;  // 指向右子结点

        public Node(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }


        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getCh() {
            return ch;
        }

        public void setCh(int ch) {
            this.ch = ch;
        }

        /**
         *  对结点的权值进行升序排列
         * */
        @Override
        public int compareTo(Node o) {
            return this.weight - o.getWeight();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return weight == node.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(weight);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "weight=" + weight +
                    ", ch=" + (char)ch +
                    '}';
        }

        /**
         *  前序遍历结点
         * */
        public void preOrder() {
            System.out.println(this);
            if(this.left != null) {
                this.left.preOrder();
            }
            if(this.right != null) {
                this.right.preOrder();
            }
        }

        /**
         * 遍历查找 huffman树，获取编码
         *
         * @param code   保存当前的编码
         * @param codeMap 保存编码结果     key， Integer表示编码的字符的UTF-8编码, value是0、1字符序列
         */
        public void getCode(String code, Map<Integer, String> codeMap) {
            if(this.left == null && this.right ==null) {
                // 该节点是叶子结点
                codeMap.put(this.ch, code);
                return;
            }
            if(this.left != null) {
                // 向左递归查找
                this.left.getCode(code+"0", codeMap);
            }
            if(this.right != null) {
                // 向右递归查找
                this.right.getCode(code+"1", codeMap);
            }
        }
    }

    /**
     * 读取ASCII 字符文件，统计里面出现字符的频数
     *
     * @param filePath  ASCII 字符文件路径
     * @return 返回的是统计结果List<Node>，频数保存都在node.weight当中，字符数据保存在node.ch当中
     */
    List<Node>  statisticCharsCnt(String filePath) throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filePath);

        Map<Integer, Integer> map = new HashMap();  // k 是字符的编码，v是字符统计的频数
        while (true) {
            int data = resourceAsStream.read();
            if(data == -1) break; // 已经读完
            if(!map.containsKey(data)) {
                // 还没有该字符存在记录，创建该字符的记录
                map.put(data, 0);
            }
            map.put(data, map.get(data)+1);
        }
        resourceAsStream.close();

        // 生成 node list
        Node node;
        List<Node> nodes = new ArrayList<>();
        Set<Map.Entry<Integer, Integer> > entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry:
                entrySet) {
            node = new Node(entry.getValue());
            node.setCh(entry.getKey());
            nodes.add(node);
        }
        return nodes;
    }

    /**
     * 创建 huffman 树
     *  TODO:
     *      1. 将每一个数据构建成的二叉树结点node，放入到结点集合nodes当中
     *      2. 根据结点的权值对所有的结点进行升序排序
     *      3. 取出根节点权值最小的两颗二叉树
     *      4. 组成一颗新的二叉树，该新的二叉树的根节点权值是前面两颗二叉树根节点权值之和
     *      5. 将这颗新的二叉树的根节点放入到结点集合nodes当中，重复步骤2~5，直到所有的数据都被处理，这样就形成了一颗新的二叉树
     *
     * @param nodes  包含 huffmanTree 所有的叶子节点
     * @return  返回创建的huffmanTree 的根节点
     */
    public Node createHuffmanTree(List<Node> nodes) {
        if(nodes == null || nodes.size()==0) {
            return null;
        }
        Node parentNode;
        Node node1;
        Node node2;
        while (nodes.size() > 1) {
            // 2. 根据结点的权值对所有的结点进行升序排序
            Collections.sort(nodes);
            // 3. 取出根节点权值最小的两颗二叉树
            node1 = nodes.get(0);
            node2 = nodes.get(1);
            nodes.remove(node1);  // 删除的是第一个找到的元素，因此这里的删除是安全的
            nodes.remove(node2);
            // 4. 组成一颗新的二叉树，该新的二叉树的根节点权值是前面两颗二叉树根节点权值之和
            parentNode = new Node(node1.getWeight()+node2.getWeight());
            if(node1.compareTo(node2) < 0) {
                parentNode.setLeft(node1);
                parentNode.setRight(node2);
            } else {
                parentNode.setLeft(node2);
                parentNode.setRight(node1);
            }
            // 5. 将这颗新的二叉树的根节点放入到结点集合nodes当中
            nodes.add(parentNode);
        }
        return nodes.get(0);
    }

    /**
     * 创建 huffMan 编码
     *
     * @param filePath 参与 huffman 编码的文件
     * @return the map  返回生成的 huffman 编码 的map
     */
    public Map<Integer, String> createHuffmanCode(String filePath) {
        // 1 读取要压缩的文件，统计各字符出现的频数
        List<Node> nodes = null;
        try {
            nodes = statisticCharsCnt(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 2 根据各字符出现的频数生成哈夫曼树
        Node root = createHuffmanTree(nodes);
        // 3 根据哈夫曼树获得哈夫曼编码
        Map<Integer, String> char2CodeMap = new HashMap<>();
        root.getCode("", char2CodeMap);
        // printCodeMap(char2CodeMap);
        return char2CodeMap;
    }

    /**
     * 反转 huffMan 编码
     *
     * @param huffmanCode k 是字符的编码    v是huffman 0、1的编码序列
     * @return the map    k huffman 0、1的编码序列   v是字符的编码
     */
    public Map<String, Integer> reverseHuffmanCode(Map<Integer, String> huffmanCode) {
        Map<String, Integer> reHuffmanCode = new HashMap<>();
        for (Map.Entry<Integer, String> entry :
                huffmanCode.entrySet()) {
            reHuffmanCode.put(entry.getValue(), entry.getKey());
        }
        return reHuffmanCode;
    }
    /**
     * 保存 huffman 编码到文件，以解压缩文件
     * @param huffmanCode 哈夫曼编码
     * @param filePath    保存的文件路径，保存的格式是json格式
     */
    public void saveHuffmanCode(Map<Integer, String> huffmanCode, String filePath) {
        // 1. 将反转后的 huffMan 编码序列化成 json文件
        Map<String, Integer> reHuffmanCode = reverseHuffmanCode(huffmanCode); // 保存的是反转后的 huffMan 编码
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(reHuffmanCode);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        // 2. 将json字符串写入json文件
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(json.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 从文件当中读取 reHuffman 编码到Map，以解压缩文件
     * k huffman 0、1的编码序列   v是字符的编码
     *
     * @param filePath  保存 reHuffman 编码的json文件
     * @return the map k huffman 0、1的编码序列   v是字符的编码
     */
    public Map<String, Integer> readHuffmanCode(String filePath) {
        Map<String, Integer> reHuffmanCode = new HashMap<>();
        FileInputStream fileInputStream = null;
        String json;
        try {
            fileInputStream = new FileInputStream(filePath);
            json = new String(fileInputStream.readAllBytes(), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            Iterator<String> stringIterator = jsonNode.fieldNames();
            while (stringIterator.hasNext()) {
                String key = stringIterator.next();
                reHuffmanCode.put(key, jsonNode.get(key).intValue());
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return reHuffmanCode;
    }


    /**
     * 根据哈夫曼编码压缩文件
     *                       压缩的是文本文件
     * @param filePath       需要压缩的文件路径  （在classPath下的相对路径）
     */
    public void zip(String filePath) {
        // 1. 获取该文件的 huffman 编码
        Map<Integer, String> huffmanCode = createHuffmanCode(filePath);

        // 2. 根据 huffman 编码获得该文件编码的0、1字符序列字符串
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        int preCnt = 0;  // 用于计算压缩前，文件占的字节数
        try {
            while (true) {
                int data = resourceAsStream.read();
                if(data == -1) break;
                stringBuilder.append(huffmanCode.get(data));  // 将编码的0、1字符序列加入stringBuilder
                // 下面是统计压缩前占几个字节
                preCnt++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // 3. 将0、1字符序列字符串转成 byte[]
        int len = (stringBuilder.length() + 7) / 8;  // 压缩后的字节数组大小
        byte[] bytes = new byte[len];
        int index = 0; // 跟踪bytes数组
        String strByte =null;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            strByte = stringBuilder.substring(i, i+8 > stringBuilder.length()?stringBuilder.length():i+8);
            bytes[index++] = (byte)Integer.parseInt(strByte, 2);
        }
        // 4. 保存 huffman 编码
        String codeOutFilePath = this.getClass().getClassLoader().getResource(filePath).getPath().split("\\.")[0] + "_hmcode.json";
        saveHuffmanCode(huffmanCode, codeOutFilePath);

        // 5. 将byte[]写入到压缩文件
        String outFilePath = this.getClass().getClassLoader().getResource(filePath).getPath() + ".hm";
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(outFilePath);
            fileOutputStream.write(bytes);  // 写入到文件
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // 输出压缩结果信息：
        System.out.println("压缩完毕！");
        System.out.println("输出文件保存在：" + outFilePath);
        System.out.println("压缩前文件大小：" + preCnt+ "字节");
        System.out.println("压缩后文件大小：" + bytes.length + "字节");
        System.out.println("压缩比为：" + (double)bytes.length/preCnt * 100 + "%");
    }


    /**
     * 解压缩文件
     * 使用此函数要求保存哈夫曼编码文件的json文件与压缩后的文件保存在同一个路径下
     *
     * @param filePath 压缩过后的文件路径
     * @return the string  返回解码后的字符串
     */
    public void unzip(String filePath) {
        // 1 读取 reHuffmanCode
        String codeFilePath = this.getClass().getClassLoader().getResource(filePath).getPath().split("\\.")[0] + "_hmcode.json";
        Map<String, Integer> reHuffmanCode = readHuffmanCode(codeFilePath);
        // 2 根据读取的压缩文件的补码字节流，并将其转换成0，1序列字符串
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
        byte[] bytes = null;
        try {
            bytes = new byte[resourceAsStream.available()];
            resourceAsStream.read(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(bytes == null) {
            System.out.println("待恢复的文件为空");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(byte2BitString(bytes[i], i==bytes.length-1?false:true));
        }

        // 3. 根据0，1序列字符串和 reHuffmanCode 回复源数据
        List<Byte> resultList = new ArrayList<>();
        StringBuilder huffmanCodeBuilder = new StringBuilder();
        for (int i = 0; i < stringBuilder.length(); i++) {
            huffmanCodeBuilder.append(stringBuilder.charAt(i));
            if(reHuffmanCode.containsKey(huffmanCodeBuilder.toString())){
                // 有该编码
                Integer integer = reHuffmanCode.get(huffmanCodeBuilder.toString()); // 获取对应的字节数据
                resultList.add((Byte) integer.byteValue());
                huffmanCodeBuilder.delete(0, huffmanCodeBuilder.length());
            }
        }

        // 4. 将数据写回源文件
        String[] spiltPath = this.getClass().getClassLoader().getResource(filePath).getPath().split("\\.");
        String outFilePath = spiltPath[0] + "_res." + spiltPath[1];
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outFilePath);
            for (Byte b :
                    resultList) {
                fileOutputStream.write(b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("解压缩完毕！");
        System.out.println("输出文件保存在：" + outFilePath);
    }

    /**
     *  遍历打印编码结果
     * */
    public void printCodeMap(Map<Integer, String> codeMap){
        System.out.println("Code Map:");
        Set<Map.Entry<Integer, String>> entries = codeMap.entrySet();
        for (Map.Entry<Integer, String> entry:
                entries) {
            System.out.println((char) entry.getKey().intValue() + "=" + entry.getValue());
        }
        System.out.println("---------------------------------------------------");
    }

    /**
     * 将一个byte转成一个0、1字符串序列（8位）
     *
     * @param b    参与转换的 byte
     * @param flag  true 表示需要将高位不足补0  false 表示不需要补0
     * @return the string  转换结果  是 b 对应的二进制字符串（按补码返回）
     */
    public String byte2BitString(byte b, boolean flag) {
        int temp = b;
        if(flag) {
            temp = b | 256; // 低8位高位不足8位，补上0
        }
        String s = Integer.toBinaryString(temp);
        if(flag) {
            s = s.substring(s.length()-8, s.length());  // 补0后取后8位
        }
        return s;
    }
}