/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree;

/**
 *
 * @author kaiobrito
 */
public class HuffmanItem implements Comparable<HuffmanItem> {

    private String symbol;
    private int weight;

    public HuffmanItem(String symbol, int weight) {
        this.symbol = symbol;
        this.weight = weight;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(HuffmanItem o) {
        if (this.getWeight() < o.getWeight()) {
            return -1;
        } else if (this.getWeight() > o.getWeight()) {
            return 1;
        } else {
            return (this.getSymbol().equals(o.getSymbol())) ? 0 : this.getSymbol().compareTo(o.getSymbol());
        }
    }

    @Override
    public String toString() {
        return symbol + "->" + weight;
    }

}
