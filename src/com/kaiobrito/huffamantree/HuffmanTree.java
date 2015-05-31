/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree;

import com.kaiobrito.huffamantree.interfaces.INode;
import com.kaiobrito.huffamantree.interfaces.ITree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author kaiobrito
 */
public class HuffmanTree implements ITree {

    protected ArrayList<INode> itens;
    protected String compressText;

    public ArrayList<INode> getItens() {
        return itens;
    }

    public HuffmanTree() {
    }

    @Override
    public INode toTree() {
        ArrayList<INode> copyItens = new ArrayList<>(itens);
        while (itens.size() > 1) {
            Collections.sort(itens);
            ArrayList<INode> twoLess = getTheTwoLessFrequenciesSymbols();
            INode n1 = twoLess.get(0);
            INode n2 = twoLess.get(1);
            INode root = new Node(new HuffmanItem("*", n1.getItem().getWeight() + n2.getItem().getWeight()));

            root.setLeftNode(n1);
            root.setRightNode(n2);

            itens.add(root);
        }
        return itens.get(0);
    }

    public HuffmanTree(String compressText) {
        setCompressText(compressText);
    }

    public void setItens(ArrayList<INode> itens) {
        this.itens = itens;
    }

    public INode getItemWithSymbol(String symbol) {
        for (INode item : itens) {
            if (item.getItem().getSymbol().equals(symbol)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public INode getLessFrenquentSymbol() {
        Collections.sort(itens);
        INode item = itens.get(0);
        itens.remove(0);
        return item;

    }

    @Override
    public ArrayList<INode> getTheTwoLessFrequenciesSymbols() {
        Collections.sort(itens);
        ArrayList<INode> result = new ArrayList<>();

        result.add(getLessFrenquentSymbol());
        result.add(getLessFrenquentSymbol());
        Collections.sort(result);
        return result;
    }

    public String getCompressText() {
        return compressText;
    }

    public void setCompressText(String compressText) {
        this.compressText = compressText;
        this.itens = new ArrayList<>();
        char[] textArray = compressText.toCharArray();
        for (char word : textArray) {
            INode node = getItemWithSymbol(String.valueOf(word));
            if (node == null) {
                itens.add(new Node(new HuffmanItem(String.valueOf(word), 1)));
            } else {
                HuffmanItem symbol = node.getItem();
                symbol.setWeight(symbol.getWeight() + 1);
            }
        }

    }

    @Override
    public HashMap<String, String> toTable() {
        INode root = toTree();
        HashMap<String, String> result = new HashMap<>();
        for (INode leaf : root.getLeafs()) {
            String leafSymbol = leaf.getItem().getSymbol();
            result.put(leafSymbol, root.getBinarySon(leafSymbol));
        }
        return result;
    }

}
