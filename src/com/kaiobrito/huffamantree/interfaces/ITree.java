/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaiobrito.huffamantree.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kaiobrito
 */
public interface ITree {

    public INode toTree();

    public ArrayList<INode> getTheTwoLessFrequenciesSymbols();

    public INode getLessFrenquentSymbol();

    public HashMap<String, String> toTable();

    public String codingText(String text);

    public String codingText();
}
