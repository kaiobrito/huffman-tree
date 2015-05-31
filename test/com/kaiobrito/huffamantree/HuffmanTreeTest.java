/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree;

import com.kaiobrito.huffamantree.interfaces.INode;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kaiobrito
 */
public class HuffmanTreeTest {

    public HuffmanTreeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSetCompressText() {
        System.out.println("setCompressText");
        String compressText = "";
        HuffmanTree instance = new HuffmanTree();
        instance.setCompressText(compressText);
        assertEquals(instance.getCompressText(), compressText);
    }

    @Test
    public void testGetItens() {
        System.out.println("setCompressText");
        String compressText = "";
        HuffmanTree instance = new HuffmanTree(compressText);
        assertEquals(instance.getItens(), new ArrayList<HuffmanItem>());
    }

    @Test
    public void testGetItemWithSymbol() {
        System.out.println("setCompressText");
        HuffmanItem h1 = new HuffmanItem("a", 1);
        HuffmanItem h2 = new HuffmanItem("b", 1);
        HuffmanTree instance = new HuffmanTree();
        ArrayList<INode> huffmanArray = new ArrayList<>();
        Node n1 = new Node(h1);
        huffmanArray.add(n1);
        huffmanArray.add(new Node(h2));
        instance.setItens(huffmanArray);
        assertEquals(instance.getItemWithSymbol("a"), n1);

    }

    @Test
    public void testGetItemWithSymbolNullResult() {
        System.out.println("GetItemWithSymbolNullResult");
        HuffmanItem h1 = new HuffmanItem("a", 1);
        HuffmanItem h2 = new HuffmanItem("b", 1);
        HuffmanTree instance = new HuffmanTree();
        ArrayList<INode> huffmanArray = new ArrayList<>();
        huffmanArray.add(new Node(h1));
        huffmanArray.add(new Node(h2));
        instance.setItens(huffmanArray);
        assertEquals(instance.getItemWithSymbol(" "), null);

    }

    @Test
    public void testSetCompressTextTestItensCounts() {
        System.out.println("SetCompressTextTestItensCounts");
        String compressText = "aaabbc ";
        HuffmanTree instance = new HuffmanTree();
        instance.setCompressText(compressText);
        assertEquals(instance.getItemWithSymbol("a").getItem().getWeight(), 3, 0);
        assertEquals(instance.getItemWithSymbol("b").getItem().getWeight(), 2, 0);
        assertEquals(instance.getItemWithSymbol("c").getItem().getWeight(), 1, 0);
        assertEquals(instance.getItemWithSymbol(" ").getItem().getWeight(), 1, 0);

    }

    @Test
    public void testSetCompressTextTestItensCountsOnInstance() {
        System.out.println("SetCompressTextTestItensCounts");
        String compressText = "aaabbc ";
        HuffmanTree instance = new HuffmanTree(compressText);
        assertEquals(instance.getItemWithSymbol("a").getItem().getWeight(), 3, 0);
        assertEquals(instance.getItemWithSymbol("b").getItem().getWeight(), 2, 0);
        assertEquals(instance.getItemWithSymbol("c").getItem().getWeight(), 1, 0);
        assertEquals(instance.getItemWithSymbol(" ").getItem().getWeight(), 1, 0);

    }

    @Test
    public void testGetLessFrequentHuffmanSymbol() {
        System.out.println("GetLessFrequentHuffmanItens");
        String compressText = "daaabbc ";
        HuffmanTree instance = new HuffmanTree();
        instance.setCompressText(compressText);
        assertEquals(instance.getLessFrenquentSymbol().compareTo(new Node(new HuffmanItem(" ", 1))), 0);

    }

    @Test
    public void testgetTheTwoLessFrequenciesSymbols() {
        System.out.println("getTheTwoLessFrequenciesSymbols");
        String compressText = "daaabbc ";
        HuffmanTree instance = new HuffmanTree();
        instance.setCompressText(compressText);
        ArrayList<Node> expresult = new ArrayList<>();
        expresult.add(new Node(new HuffmanItem(" ", 1)));
        expresult.add(new Node(new HuffmanItem("c", 1)));

        ArrayList<INode> result = instance.getTheTwoLessFrequenciesSymbols();
        assertEquals(expresult.get(0).compareTo(result.get(0)), 0);
        assertEquals(expresult.get(1).compareTo(result.get(1)), 0);

    }

    @Test
    public void testToTree() {
        System.out.println("toTree");
        HuffmanTree instance = new HuffmanTree("aaaaaabbbbbccccdddeef");
        assertEquals(instance.toTree().preOrder(), "**cb***feda");

    }

    @Test
    public void testToTreeGetBinary() {
        System.out.println("ToTreeGetBinary");
        HuffmanTree instance = new HuffmanTree("aaaaaabbbbbccccdddeef");
        INode root = instance.toTree();
        assertEquals("11", root.getBinarySon("a"));
        assertEquals("01", root.getBinarySon("b"));
        assertEquals("00", root.getBinarySon("c"));
        assertEquals("101", root.getBinarySon("d"));
        assertEquals("1001", root.getBinarySon("e"));
        assertEquals("1000", root.getBinarySon("f"));
    }
}
