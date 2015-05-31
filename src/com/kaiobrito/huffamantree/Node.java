/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree;

import com.kaiobrito.huffamantree.interfaces.INode;
import java.util.ArrayList;

/**
 *
 * @author kaiobrito
 */
public class Node extends INode {

    public Node(HuffmanItem value) {
        super(value);
    }

    @Override
    public void addSon(INode node) {
        if (getValue() != node.getValue()) {
            if (getValue() > node.getValue()) {
                if (leftNode == null) {
                    leftNode = (Node) node;
                } else {
                    leftNode.addSon(node);
                }
            } else {
                if (rightNode == null) {
                    rightNode = (Node) node;
                } else {
                    rightNode.addSon(node);
                }
            }
        }
    }

    @Override
    public int getValue() {
        return value.getWeight();
    }

    public boolean isLeaf() {
        return rightNode == null && leftNode == null;
    }

    @Override
    public int compareTo(INode o) {
        return this.getItem().compareTo(o.getItem());
    }

    @Override
    public String preOrder() {
        return (getItem().getSymbol())
                + ((leftNode != null) ? leftNode.preOrder() : "")
                + ((rightNode != null) ? rightNode.preOrder() : "");

    }

    @Override
    public ArrayList<INode> getLeafs() {
        ArrayList<INode> result = new ArrayList<>();
        if (isLeaf()) {
            result.add(this);
            return result;
        } else {
            if (leftNode != null) {
                result.addAll(leftNode.getLeafs());
            }
            if (rightNode != null) {
                result.addAll(rightNode.getLeafs());
            }
            return result;
        }
    }

    @Override
    public String getBinarySon(String symbol) {

        if (leftNode != null) {
            if (leftNode.getItem().getSymbol().equals(symbol)) {
                return "0";
            } else {
                String leftResult = leftNode.getBinarySon(symbol);
                if (leftResult != null) {
                    return "0" + leftResult;
                }
            }
        }
        if (rightNode != null) {
            if (rightNode.getItem().getSymbol().equals(symbol)) {
                return "1";
            } else {

                String rightResult = rightNode.getBinarySon(symbol);
                if (rightResult != null) {
                    return "1" + rightResult;
                }
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return getItem().toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
