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

    private ArrayList<HuffmanItem> itens;
    private String compressText;

    public ArrayList<HuffmanItem> getItens() {
        return itens;
    }

    public HuffmanTree() {
    }

    public HuffmanTree(String compressText) {
        this.setCompressText(compressText);
    }

    public void setItens(ArrayList<HuffmanItem> itens) {
        this.itens = itens;
    }

    public HuffmanItem getItemWithSymbol(String symbol) {
        for (HuffmanItem item : itens) {
            if (item.getSymbol().equals(symbol)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<HuffmanItem> getTheLessFrequenctTwoSymbols() {
        Collections.sort(itens);
        ArrayList<HuffmanItem> result = new ArrayList<>();
        for (int i = 0; i < 2 && i < itens.size(); i++) {
            result.add(0, itens.get(0));
            itens.remove(0);
        }
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
            HuffmanItem symbol = getItemWithSymbol(String.valueOf(word));
            Integer count = (symbol == null) ? 0 : symbol.getWeight();
            if (symbol == null) {
                itens.add(new HuffmanItem(String.valueOf(word), 1));
            } else {
                symbol.setWeight(symbol.getWeight() + 1);
            }
        }

    }

}
