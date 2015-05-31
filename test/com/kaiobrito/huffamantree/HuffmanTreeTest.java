/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree;

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
    public void testGetItemWithSymbol() {
        System.out.println("setCompressText");
        HuffmanItem h1 = new HuffmanItem("a", 1);
        HuffmanItem h2 = new HuffmanItem("b", 1);
        HuffmanTree instance = new HuffmanTree();
        ArrayList<HuffmanItem> huffmanArray = new ArrayList<>();
        huffmanArray.add(h1);
        huffmanArray.add(h2);
        instance.setItens(huffmanArray);
        assertEquals(instance.getItemWithSymbol("a"), h1);

    }

    @Test
    public void testGetItemWithSymbolNullResult() {
        System.out.println("GetItemWithSymbolNullResult");
        HuffmanItem h1 = new HuffmanItem("a", 1);
        HuffmanItem h2 = new HuffmanItem("b", 1);
        HuffmanTree instance = new HuffmanTree();
        ArrayList<HuffmanItem> huffmanArray = new ArrayList<>();
        huffmanArray.add(h1);
        huffmanArray.add(h2);
        instance.setItens(huffmanArray);
        assertEquals(instance.getItemWithSymbol(" "), null);

    }

    @Test
    public void testSetCompressTextTestItensCounts() {
        System.out.println("SetCompressTextTestItensCounts");
        String compressText = "aaabbc ";
        HuffmanTree instance = new HuffmanTree();
        instance.setCompressText(compressText);
        assertEquals(instance.getItemWithSymbol("a").getWeight(), 3, 0);
        assertEquals(instance.getItemWithSymbol("b").getWeight(), 2, 0);
        assertEquals(instance.getItemWithSymbol("c").getWeight(), 1, 0);
        assertEquals(instance.getItemWithSymbol(" ").getWeight(), 1, 0);

    }

    @Test
    public void testSetCompressTextTestItensCountsOnInstance() {
        System.out.println("SetCompressTextTestItensCounts");
        String compressText = "aaabbc ";
        HuffmanTree instance = new HuffmanTree(compressText);
        assertEquals(instance.getItemWithSymbol("a").getWeight(), 3, 0);
        assertEquals(instance.getItemWithSymbol("b").getWeight(), 2, 0);
        assertEquals(instance.getItemWithSymbol("c").getWeight(), 1, 0);
        assertEquals(instance.getItemWithSymbol(" ").getWeight(), 1, 0);

    }
}
