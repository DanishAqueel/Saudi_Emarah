package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class compose_sms extends AppCompatActivity {

EditText message=findViewById(R.id.editTextTextPersonName5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_sms);

        Button btn_send=findViewById(R.id.button7);

        String s = getIntent().getStringExtra("abc");
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg=message.getText().toString();
                Intent msg_intent=new Intent(getApplicationContext(),compose_sms.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,msg_intent,0);

                SmsManager smsManager= SmsManager.getDefault();
                smsManager.sendTextMessage(s,null,msg,pi,null);
                Toast.makeText(getApplicationContext(),"Message sent successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}