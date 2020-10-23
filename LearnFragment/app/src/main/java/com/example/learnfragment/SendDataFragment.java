package com.example.learnfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class SendDataFragment extends Fragment {
Bundle mBundle;
int num1 ,num2;
Button btnAdd,btnMulti;
TextView txvResult;
EditText etxnum1 , etxnum2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         mBundle = getArguments();
         num1 = mBundle.getInt(BundleKey.FIRST_NUMBER,0);
         num2 = mBundle.getInt(BundleKey.SECOND_NUMBER,0);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          View view = inflater.inflate(R.layout.fragment_send_data, container, false);

          btnAdd = view.findViewById(R.id.btn_add);
          txvResult = view.findViewById(R.id.txResult);
          etxnum1 = view.findViewById(R.id.editTextNumber1);
          etxnum2 = view.findViewById(R.id.editTextNumber2);


          btnAdd.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                int res = num1 + num2;
                txvResult.setText("Result : "+res);
              }
          });




          return  view;

    }
    public  void getResult(){
        int a ,b;
        if (etxnum1 == null || etxnum2 == null){
            a = 0;
            b = 0;
        } else{
            a = Integer.valueOf(etxnum1.getText().toString());
            b = Integer.valueOf(etxnum2.getText().toString());
        }

        ISendData  iSendData = (ISendData)getActivity();
        iSendData.Multiple(a,b);
    }
}