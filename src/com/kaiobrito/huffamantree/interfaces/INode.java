/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree.interfaces;

import com.kaiobrito.huffamantree.HuffmanItem;
import java.util.ArrayList;

/**
 *
 * @author kaiobrito
 */
public abstract class INode implements Comparable<INode> {

    protected INode leftNode;

    protected INode rightNode;

    protected HuffmanItem value;

    public abstract void addSon(INode node);

    public abstract ArrayList<INode> getLeafs();

    public abstract String preOrder();

    public abstract int getValue();

    public abstract String getBinarySon(String symbol);

    public INode(HuffmanItem value) {
        this.value = value;
    }

    public HuffmanItem getItem() {
        return value;
    }

    public void setLeftNode(INode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(INode rightNode) {
        this.rightNode = rightNode;
    }

    public INode getLeftNode() {
        return leftNode;
    }

    public INode getRightNode() {
        return rightNode;
    }

}
