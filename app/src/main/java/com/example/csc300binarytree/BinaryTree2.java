package com.example.csc300binarytree;

import java.io.Serializable;

public class BinaryTree2 implements Serializable
{

    public BinaryTree2 leftTree;
    public BinaryTree2 rightTree;

    public int payload;

    public int size = 1;

    public BinaryTree2(int payload)
    {
        this.leftTree = null;
        this.rightTree = null;

        this.payload = payload;
    }

    public void printInOrder()
    {
        if(leftTree != null)
        {
            leftTree.printInOrder();
        }

        System.out.println("**** " + payload);

        if(rightTree != null)
        {
            rightTree.printInOrder();
        }
    }

    // Returns an array of the tree sorted in order
    public int[] returnInOrder()
    {
        // Create the blank array to be filled
        int[] returnVal = new int[size];

        // Keep track of how many elements have been filled
        int count = 0;

        // Get stuff from the left first
        if(leftTree != null)
        {
            int[] leftVals = leftTree.returnInOrder();

            for(int lc = 0; lc < leftVals.length; lc++)
            {
                returnVal[count] = leftVals[lc];
                count++;
            }
        }

        // Get the payload of the root of this tree
        returnVal[count] = payload;
        count++;

        // Get stuff from the right
        if(rightTree != null)
        {
            int[] rightVals = rightTree.returnInOrder();

            for(int rc = 0; rc < rightVals.length; rc++)
            {
                returnVal[count] = rightVals[rc];
                count++;
            }
        }

        return returnVal;
    }

    public void add(int payloadToAdd)
    {
        if(payloadToAdd <= payload)
        {
            // Add to the left

            if(leftTree == null)
            {
                leftTree = new BinaryTree2(payloadToAdd);
            }
            else
            {
                leftTree.add(payloadToAdd);
            }
        }
        else
        {
            // Add to the right

            if(rightTree == null)
            {
                rightTree = new BinaryTree2(payloadToAdd);
            }
            else
            {
                rightTree.add(payloadToAdd);
            }
        }

        size++;
    }
}
