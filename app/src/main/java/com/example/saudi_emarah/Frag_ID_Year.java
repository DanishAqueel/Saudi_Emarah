package com.example.saudi_emarah;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.chrono.HijrahDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Frag_ID_Year extends Fragment {

    public Frag_ID_Year() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    Integer selectedYearIndex = -1;
    Spinner spinner;
    EditText et;
    private String url_final;
   // @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_frag__i_d__year, container, false);

        List<String> yearArray = new ArrayList<String>();

         spinner = v.findViewById(R.id.spinner);
      //  spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        spinner.setBackgroundColor(Color.WHITE);
      //  Locale locale = new Locale("ar_SA");
        HijrahDate hijrahDate = HijrahDate.now();
        String hijDate = hijrahDate.toString();
        String[] parts = hijDate.split(" ");
        String dateStr = parts[2];
        String[] dateParts = dateStr.split("-");
        int year = Integer.valueOf(dateParts[0]);
        int maxPrvYear = year - 20;
        int index = 0;
        for (Integer i = maxPrvYear; i <= year; ++i) {
            yearArray.add(String.valueOf(i));
            if (i == year) {
                selectedYearIndex = index;
            }
            ++index;
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, yearArray);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setSelection(selectedYearIndex);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                parentView.getChildAt(0);
                selectedYearIndex = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        // Getting Id and Year values from EditText and Spinners.
        et = v.findViewById(R.id.editTextTextPersonName);
       String id=et.getText().toString();

        Spinner spinner = v.findViewById(R.id.spinner);
        String yearString = yearArray.get(selectedYearIndex);

        Button btn2=v.findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                URL_Generation url_generation = new URL_Generation();
                url_final =url_generation.getUrl(url_generation.getCodedForm(id),url_generation.getCodedForm(yearString));
                xmlHandler xmlhandler=new xmlHandler(url_final);


                String code=xmlhandler.getCode();
                String msg= xmlhandler.getMessage();

                Intent intent=new Intent(getContext(),ShowResult.class);
                intent.putExtra("Key1",code);
                intent.putExtra("Key2",msg);
                startActivity(intent);

            }



        });
        return v;


    }
}