/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree;

import java.util.HashMap;

/**
 *
 * @author kaiobrito
 */
public class Node implements Comparable<Node> {

    private Node leftNode;

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
    private Node rightNode;
    private HuffmanItem value;

    public Node(HuffmanItem value) {
        this.value = value;
    }

    public void addSon(Node node) {
        if (getValue() != node.getValue()) {
            if (isLeaf()) {
                if (getValue() > node.getValue()) {
                    leftNode = node;
                } else {
                    rightNode = node;
                }
            } else {
                if (getValue() > node.getValue()) {
                    leftNode.addSon(node);
                } else {
                    rightNode.addSon(node);
                }
            }
        }
    }

    public HuffmanItem getItem() {
        return value;
    }

    public int getValue() {
        return value.getWeight();
    }

    public boolean isLeaf() {
        return rightNode == null && leftNode == null;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    @Override
    public int compareTo(Node o) {
        return this.getItem().compareTo(o.getItem());
    }

    public String preOrder() {
        return (getItem().getSymbol())
                + ((leftNode != null) ? leftNode.preOrder() : "")
                + ((rightNode != null) ? rightNode.preOrder() : "");

    }

}
