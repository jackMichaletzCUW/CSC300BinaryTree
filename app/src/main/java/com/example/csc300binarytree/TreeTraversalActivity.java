package com.example.csc300binarytree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TreeTraversalActivity extends AppCompatActivity
{

    private BinaryTree2 bt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_traversal);

        bt = (BinaryTree2)this.getIntent().getSerializableExtra("Tree");

        TextView payloadView = this.findViewById(R.id.payloadView);

        payloadView.setText(String.format("%d", bt.payload));

        Button traverseLeftBtn = this.findViewById(R.id.traverseLeftBtn);
        Button traverseRightBtn = this.findViewById(R.id.traverseRightBtn);

        if(bt.leftTree == null)
        {
            traverseLeftBtn.setEnabled(false);
        }

        if(bt.rightTree == null)
        {
            traverseRightBtn.setEnabled(false);
        }
    }

    public void traverseLeftBtnClicked(View v)
    {
        Intent i = new Intent(this, TreeTraversalActivity.class);

        i.putExtra("Tree", bt.leftTree);

        this.startActivity(i);
    }

    public void traverseRightBtnClicked(View v)
    {
        Intent i = new Intent(this, TreeTraversalActivity.class);

        i.putExtra("Tree", bt.rightTree);

        this.startActivity(i);
    }
}
