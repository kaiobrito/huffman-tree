/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree;

import com.kaiobrito.huffamantree.interfaces.ITree;

/**
 *
 * @author kaiobrito
 */
public class Main {

    public static void main(String[] args) {
        ITree huffman = new HuffmanTree("Kaio Brito");
        System.out.println(huffman.toTable());
        System.out.println(huffman.codingText());
    }
}
