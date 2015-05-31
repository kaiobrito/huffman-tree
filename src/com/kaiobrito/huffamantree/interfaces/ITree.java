/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree.interfaces;

import java.util.ArrayList;

/**
 *
 * @author kaiobrito
 */
public interface ITree {

    public abstract INode toTree();

    public abstract ArrayList<INode> getTheTwoLessFrequenciesSymbols();

    public abstract INode getLessFrenquentSymbol();
}
