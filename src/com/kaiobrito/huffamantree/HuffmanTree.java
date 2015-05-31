/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kaiobrito
 */
public class HuffmanTree {

    private ArrayList<Node> itens;
    private String compressText;

    public ArrayList<Node> getItens() {
        return itens;
    }

    public HuffmanTree() {
    }

    public String toTree() {
        ArrayList<Node> copyItens = new ArrayList<>(itens);
        while (itens.size() > 1) {
            Collections.sort(itens);
            ArrayList<Node> twoLess = getTheTwoLessFrequenciesSymbols();
            Node n1 = twoLess.get(0);
            Node n2 = twoLess.get(1);
            Node root = new Node(new HuffmanItem("*", n1.getItem().getWeight() + n2.getItem().getWeight()));

            root.setLeftNode(n1);
            root.setRightNode(n2);

            itens.add(root);
        }
        return itens.get(0).preOrder();
    }

    public HuffmanTree(String compressText) {
        setCompressText(compressText);
    }

    public void setItens(ArrayList<Node> itens) {
        this.itens = itens;
    }

    public Node getItemWithSymbol(String symbol) {
        for (Node item : itens) {
            if (item.getItem().getSymbol().equals(symbol)) {
                return item;
            }
        }
        return null;
    }

    public Node getLessFrenquentSymbol() {
        Collections.sort(itens);
        Node item = itens.get(0);
        itens.remove(0);
        return item;

    }

    public ArrayList<Node> getTheTwoLessFrequenciesSymbols() {
        Collections.sort(itens);
        ArrayList<Node> result = new ArrayList<>();

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
            Node node = getItemWithSymbol(String.valueOf(word));
            if (node == null) {
                itens.add(new Node(new HuffmanItem(String.valueOf(word), 1)));
            } else {
                HuffmanItem symbol = node.getItem();
                symbol.setWeight(symbol.getWeight() + 1);
            }
        }

    }

}
