/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree;

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
public class NodeTest {

    public NodeTest() {
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
    public void testGetValue() {
        System.out.println("getValue");

        int expResult = 0;
        Node instance = new Node(new HuffmanItem("a", 0));
        int result = instance.getValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddLowerNode() {
        System.out.println("AddLowerNode");
        Node instance = new Node(new HuffmanItem("a", 100));
        Node expresult = new Node(new HuffmanItem("b", 20));
        instance.addSon(expresult);
        assertEquals(expresult, instance.getLeftNode());
    }

    @Test
    public void testAddBiggerNode() {
        System.out.println("AddBiggerNode");
        Node instance = new Node(new HuffmanItem("a", 100));
        Node expresult = new Node(new HuffmanItem("b", 200));
        instance.addSon(expresult);
        assertEquals(expresult, instance.getRightNode());
    }

    @Test
    public void testAddBiggerNodeTwice() {
        System.out.println("AddBiggerNode");
        Node instance = new Node(new HuffmanItem("a", 100));
        instance.addSon(new Node(new HuffmanItem("b", 200)));
        Node expresult = new Node(new HuffmanItem("c", 300));
        instance.addSon(expresult);
        assertEquals(expresult, instance.getRightNode().getRightNode());
    }

    @Test
    public void testAddLowerNodeTwice() {
        System.out.println("AddBiggerNode");
        Node instance = new Node(new HuffmanItem("a", 100));
        instance.addSon(new Node(new HuffmanItem("b", 50)));
        Node expresult = new Node(new HuffmanItem("a", 30));
        instance.addSon(expresult);
        assertEquals(expresult, instance.getLeftNode().getLeftNode());
    }

    @Test
    public void testIsLeaf() {
        System.out.println("isLeaf");
        Node instance = new Node(new HuffmanItem("a", 100));
        boolean expResult = true;
        boolean result = instance.isLeaf();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotLeaf() {
        System.out.println("isNotLeaf");
        Node instance = new Node(new HuffmanItem("a", 100));
        instance.addSon(new Node(new HuffmanItem("b", 20)));
        boolean expResult = false;
        boolean result = instance.isLeaf();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddEqualValue() {
        System.out.println("AddEqualValue");
        HuffmanItem item = new HuffmanItem("a", 100);
        Node instance = new Node(item);
        instance.addSon(new Node(item));
        boolean result = instance.isLeaf();
        assertTrue(result);
    }

    @Test
    public void testAddHimself() {
        System.out.println("AddEqualValue");
        HuffmanItem item = new HuffmanItem("a", 100);
        Node instance = new Node(item);
        instance.addSon(instance);
        boolean result = instance.isLeaf();
        assertTrue(result);
    }
}
