package com.example.csc300binarytree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    private BinaryTree2 bt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = new BinaryTree2(5);
        bt.add(3);
        bt.add(3);
        bt.add(8);
        bt.add(6);

        Intent i = new Intent(this, TreeTraversalActivity.class);

        i.putExtra("Tree", bt);

        this.startActivity(i);
    }

    public void traverseBtnPressed(View v)
    {
        Intent i = new Intent(this, TreeTraversalActivity.class);

        i.putExtra("Tree", bt);

        this.startActivity(i);
    }
}
