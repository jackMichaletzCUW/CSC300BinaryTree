package com.example.csc300binarytree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private BinaryTree2 bt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(this.getIntent().hasExtra("Tree"))
        {
            String secretCode = this.getIntent().getStringExtra("Tree");

            bt = Core.theVault.getTreeWithSuperSecretCode(secretCode);
        }
        else
        {
            bt = new BinaryTree2(5);
            bt.add(3);
            bt.add(3);
            bt.add(8);
            bt.add(6);
        }

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
        Intent i = new Intent(this, MainActivity.class);

        i.putExtra("Tree", String.format("%d", Core.currentCode));

        Core.theVault.addTree(String.format("%d", Core.currentCode), bt.leftTree);

        Core.currentCode++;

        this.startActivity(i);
    }

    public void traverseRightBtnClicked(View v)
    {
        Intent i = new Intent(this, MainActivity.class);

        i.putExtra("Tree", String.format("%d", Core.currentCode));

        Core.theVault.addTree(String.format("%d", Core.currentCode), bt.rightTree);

        Core.currentCode++;

        this.startActivity(i);
    }
}
