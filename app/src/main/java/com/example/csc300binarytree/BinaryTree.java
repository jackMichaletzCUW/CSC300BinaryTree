package com.example.csc300binarytree;

public class BinaryTree
{
    private Node root;

    public BinaryTree()
    {
        this.root = null;
    }

    public void add(int payload)
    {
        Node n = new Node(payload);

        if(this.root == null)
        {
            this.root = n;
        }
        else
        {
            this.root.addChild(n);
        }
    }
}
