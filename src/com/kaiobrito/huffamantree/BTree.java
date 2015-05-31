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
public class BTree {

    private Node root;

    public BTree(Node root) {
        this.root = root;
    }

    public String preOrder() {
        return (root.preOrder());

    }
    
    public String toTable(){
        return "";
    }
}
