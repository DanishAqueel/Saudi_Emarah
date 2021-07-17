package com.example.saudi_emarah;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.time.chrono.HijrahDate;
import java.util.ArrayList;
import java.util.List;

public class Frag_ID extends Fragment {


    public Frag_ID() {
        // Required empty public constructor
    }
   // Integer selectedYearIndex = -1;
    EditText et;
    String id;
    private String url_final;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("Frag_ID_Year","Inside Frag_ID onCreateView method");
        // Inflate the layout for this fragment
       View v=  inflater.inflate(R.layout.fragment_frag__i_d, container, false);
        // Getting Id and Year values from EditText and Spinners.
        et = v.findViewById(R.id.editTextTextPersonName2);
        Button btn5=v.findViewById(R.id.button5);
        btn5.setOnClickListener(view -> {
            id =et.getText().toString();
            Log.i("Frag_ID","Inside Frag_ID onclick method");
            URL_Generation url_generation=new URL_Generation();
           url_final =url_generation.getUrlFromID(url_generation.getCodedForm(id));
           //Toast.makeText(getActivity(),"Final URL:"+url_final,Toast.LENGTH_SHORT).show();


            xmlHandler xmlhandler=new xmlHandler();
            xmlhandler.getXmlDoc(url_final);
            String code=xmlhandler.getCode();
            String msg= xmlhandler.getMessage();

            Intent intent=new Intent(getContext(),ShowResult.class);
            intent.putExtra("Key2",msg);
            startActivity(intent);


        });
        return v;
    }

}