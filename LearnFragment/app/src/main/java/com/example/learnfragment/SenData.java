package com.example.learnfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SenData extends AppCompatActivity implements ISendData {
    EditText firstNumber, secondNumber;
    int res;
    TextView txResult;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sen_data);
        firstNumber = findViewById(R.id.num1);
        secondNumber = findViewById(R.id.num2);
        txResult = findViewById(R.id.txResultData);
        txResult.setVisibility(View.INVISIBLE);
        manager = getSupportFragmentManager();

    }

    public void sendDataToFragment(View view) {

        int num1 = Integer.valueOf(firstNumber.getText().toString());
        int num2 = Integer.valueOf(secondNumber.getText().toString());
        Bundle bundle = new Bundle();
        bundle.putInt(BundleKey.FIRST_NUMBER, num1);
        bundle.putInt(BundleKey.SECOND_NUMBER, num2);

        addFragmentAndSetBundle(bundle);
    }
//TODO kin mochkil mali kikon data fron activity null
    private void addFragmentAndSetBundle(Bundle bundle) {
        SendDataFragment sendDataFragment = new SendDataFragment();
        sendDataFragment.setArguments(bundle);
        if (manager.findFragmentByTag("data") == null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.resultContainer, sendDataFragment, "data");
            transaction.commit();
        }

    }


    @Override
    public void Multiple(int a, int b) {

        this.res = a * b;
    }

    public void ShowAndMultiple(View view) {
        if(manager.findFragmentByTag("data") != null){
            SendDataFragment fragment = (SendDataFragment) manager.findFragmentByTag("data");
            fragment.getResult();
            txResult.setText("Result : " + res);
            txResult.setVisibility(View.VISIBLE);
        }

    }
}