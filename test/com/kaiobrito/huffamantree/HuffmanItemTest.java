/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree;

import java.util.ArrayList;
import java.util.Collections;
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
public class HuffmanItemTest {

    public HuffmanItemTest() {
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
    public void testSetSymbol() {
        System.out.println("SetSymbol");
        HuffmanItem instance = new HuffmanItem("b", 100);
        String expResult = "a";
        instance.setSymbol(expResult);
        assertEquals(expResult, instance.getSymbol());
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        HuffmanItem instance = new HuffmanItem("b", 100);
        String expResult = "b->100";
        assertEquals(expResult, instance.toString());
    }

    @Test
    public void testCompareToEqual() {
        System.out.println("CompareToEqual");
        HuffmanItem o = new HuffmanItem("a", 100);
        HuffmanItem instance = new HuffmanItem("a", 100);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testCompareToBigger() {
        System.out.println("CompareToBigger");
        HuffmanItem o = new HuffmanItem("a", 100);
        HuffmanItem instance = new HuffmanItem("b", 50);
        int expResult = -1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testCompareToLower() {
        System.out.println("CompareToLower");
        HuffmanItem o = new HuffmanItem("a", 100);
        HuffmanItem instance = new HuffmanItem("b", 150);
        int expResult = 1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testSortArrayHuffmanItens() {
        System.out.println("SortHuffmanItens");
        HuffmanItem h1 = new HuffmanItem("a", 100);
        HuffmanItem h2 = new HuffmanItem("b", 200);
        HuffmanItem h3 = new HuffmanItem("c", 40);
        ArrayList<HuffmanItem> array = new ArrayList<>();
        array.add(h1);
        array.add(h2);
        array.add(h3);

        ArrayList<HuffmanItem> expresult = new ArrayList<>();
        expresult.add(h3);
        expresult.add(h1);
        expresult.add(h2);

        Collections.sort(array);

        assertEquals(expresult, array);

    }

    @Test
    public void testSortArrayHuffmanItensWithRepatedValue() {
        System.out.println("SortHuffmanItens");
        HuffmanItem h1 = new HuffmanItem("a", 100);
        HuffmanItem h2 = new HuffmanItem("b", 200);
        HuffmanItem h2d = new HuffmanItem("d", 200);
        HuffmanItem h3 = new HuffmanItem("c", 40);
        ArrayList<HuffmanItem> array = new ArrayList<>();
        array.add(h1);
        array.add(h2);
        array.add(h2d);
        array.add(h3);

        ArrayList<HuffmanItem> expresult = new ArrayList<>();
        expresult.add(h3);
        expresult.add(h1);
        expresult.add(h2);
        expresult.add(h2d);

        Collections.sort(array);

        assertEquals(expresult, array);

    }

    @Test
    public void testSortArrayHuffmanItensReverse() {
        System.out.println("SortHuffmanItensReverse");
        HuffmanItem h1 = new HuffmanItem("a", 100);
        HuffmanItem h2 = new HuffmanItem("b", 200);
        HuffmanItem h3 = new HuffmanItem("c", 40);
        ArrayList<HuffmanItem> array = new ArrayList<>();
        array.add(h1);
        array.add(h2);
        array.add(h3);

        ArrayList<HuffmanItem> expresult = new ArrayList<>();
        expresult.add(h2);
        expresult.add(h1);
        expresult.add(h3);

        Collections.sort(array, Collections.reverseOrder());
        assertEquals(expresult, array);

    }
}
