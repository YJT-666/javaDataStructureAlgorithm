package com.jjt.dataStructure;

import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * ClassName: HuffmanCodeTest
 * Package: com.jjt.dataStructure
 *
 * @Author jjt
 * @Create 2024/1/11 13:12
 * @Version 1.0
 * Description:
 */
public class HuffmanCodeTest {

    // 编码
    @Test
    public void test01() {
        HuffmanCode huffmanCode = new HuffmanCode();

        String filePath = "hello.txt";
        huffmanCode.zip(filePath);
    }

    // 解码
    @Test
    public void test04() {
        HuffmanCode huffmanCode = new HuffmanCode();
        String filePath = "hello.txt.hm";
        huffmanCode.unzip(filePath);
    }

    @Test
    public void test02() {
        HuffmanCode huffmanCode = new HuffmanCode();
        String filePath = "hello.txt";
        String codeFilePath = "hello_hmcode.json";
        Map<Integer, String> code = huffmanCode.createHuffmanCode(filePath);
        huffmanCode.saveHuffmanCode(code, codeFilePath);
    }

    @Test
    public void test03() {
        HuffmanCode huffmanCode = new HuffmanCode();
        String codeFilePath = "hello_hmcode.json";
        huffmanCode.readHuffmanCode(codeFilePath);
    }

    @Test
    public void test05() {
        HuffmanCode huffmanCode = new HuffmanCode();
        byte b = -88;
        System.out.println(huffmanCode.byte2BitString(b, true));
        System.out.println(huffmanCode.byte2BitString(b, false));
    }

    @Test
    public void test06() {
        HuffmanCode huffmanCode = new HuffmanCode();

        String filePath = "img.png";
        huffmanCode.zip(filePath);
        huffmanCode.unzip(filePath+".hm");
    }
}
