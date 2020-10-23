package com.example.learnfragment;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TransactionMethod extends AppCompatActivity {

    FragmentB mFragmentB;
    FragmentA mFragmentA;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_method);
        mFragmentA = new FragmentA();
        mFragmentB = new FragmentB();
        mFragmentManager = getSupportFragmentManager();


    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
    }


    public void addFragmentA(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.container, mFragmentA, "FragmentA");
        mFragmentTransaction.commit();
    }

    public void removeFragmentA(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        FragmentA frgA = (FragmentA) mFragmentManager.findFragmentByTag("FragmentA");
        if (frgA != null) {
            mFragmentTransaction.remove(frgA);
            mFragmentTransaction.commit();
        }

    }

    public void addFragmentB(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.container, mFragmentB, "FragmentB");
        mFragmentTransaction.commit();
    }

    public void removeFragmentB(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        FragmentB frgB = (FragmentB) mFragmentManager.findFragmentByTag("FragmentB");
        if (frgB != null) {
            mFragmentTransaction.remove(frgB);
            mFragmentTransaction.commit();
        }
    }

    public void replaceBWithC(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        FragmentC fragmentC = new FragmentC();
        mFragmentTransaction.replace(R.id.container, fragmentC, "FragmentC");
        mFragmentTransaction.commit();
    }

    public void replaceAWithC(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        FragmentC fragmentC = new FragmentC();
        mFragmentTransaction.replace(R.id.container, fragmentC, "FragmentC");
        mFragmentTransaction.commit();
    }

    public void removeFragmentC(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        FragmentC frgC = (FragmentC) mFragmentManager.findFragmentByTag("FragmentC");
        if (frgC != null) {
            mFragmentTransaction.remove(frgC);
            mFragmentTransaction.commit();
        }
    }

    public void hideFragmentA(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        FragmentA frgA = (FragmentA) mFragmentManager.findFragmentByTag("FragmentA");
        if (frgA != null) {
            mFragmentTransaction.hide(frgA);
            mFragmentTransaction.commit();
        }
    }

    public void showFragmentA(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        FragmentA frgA = (FragmentA) mFragmentManager.findFragmentByTag("FragmentA");
        if (frgA != null) {
            mFragmentTransaction.show(frgA);
            mFragmentTransaction.commit();
        }
    }

    public void detachFragmentA(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        FragmentA frgA = (FragmentA) mFragmentManager.findFragmentByTag("FragmentA");
        if (frgA != null) {
            mFragmentTransaction.detach(frgA);
            mFragmentTransaction.commit();
        }
    }
}