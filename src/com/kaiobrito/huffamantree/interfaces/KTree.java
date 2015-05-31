/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree.interfaces;

import com.kaiobrito.huffamantree.Node;

/**
 *
 * @author kaiobrito
 */
public interface KTree {

    public void addNode(Node node);

    public void removeNode(Node node);

    public void contains(Node node);
}
