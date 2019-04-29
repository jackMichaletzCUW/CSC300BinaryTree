package com.example.csc300binarytree;

import java.util.LinkedList;

public class TreeCollection
{
    private LinkedList<TreeValue> theMappings;

    public TreeCollection()
    {
        this.theMappings = new LinkedList<TreeValue>();
    }

    public void addTree(String secretCode, BinaryTree2 tree2)
    {
        this.theMappings.add(new TreeValue(secretCode, tree2));
    }

    public BinaryTree2 getTreeWithSuperSecretCode(String secretCode)
    {
        for(TreeValue tv : theMappings)
        {
            if(tv.secretCode.equals(secretCode))
            {
                return tv.tree;
            }
        }
        return null;
    }

}
