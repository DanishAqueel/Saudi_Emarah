package com.example.saudi_emarah;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import org.jetbrains.annotations.NotNull;

import static android.view.View.*;


public class About_Page extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;

    String tv1_text;
    String tv2_text;

    Bitmap ImageBit;
    float ImageRadius = 40.0f;
    private static final int REQUEST_CALL = 1;



  /*  public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //This is used to hide/show 'Status Bar' & 'System Bar'. Swip bar to get it as visible.
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | SYSTEM_UI_FLAG_FULLSCREEN
                            | SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }*/

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about_page);
        View imgV = findViewById(R.id.imageView4);
        View lauout1 = findViewById(R.id.relativelayout1);
        View lauout2 = findViewById(R.id.relativelayout2);

        tv1 = findViewById(R.id.textView9);// 8052245732
        tv2 = findViewById(R.id.textView10); // 7705872824
        tv3 = findViewById(R.id.textView11);
        tv4 = findViewById(R.id.textView12);
        tv5 = findViewById(R.id.textView13);

        ImageBit = BitmapFactory.decodeResource(getResources(), R.drawable.aboutpage1);
        ((ImageView) imgV).setImageBitmap(ImageBit);


        RoundedBitmapDrawable RBD = RoundedBitmapDrawableFactory.create(getResources(), ImageBit);

        RBD.setCornerRadius(ImageRadius);

        RBD.setAntiAlias(true);
        ((ImageView) imgV).setImageDrawable(RBD);


        GradientDrawable gdButton3 = new GradientDrawable();
        gdButton3.setColor(Color.argb((float) 0.7, (float) 44.0 / 255, (float) 180.0 / 255, (float) 100.0 / 255));
        gdButton3.setCornerRadius(40);
        lauout2.setBackground(gdButton3);

        // Create an animation instance

        // Animation an = new RotateAnimation(0.0f, 360.0f, pivotX, pivotY);
        ObjectAnimator animation = ObjectAnimator.ofFloat(lauout1, "rotationY", 0.0f, 360f);
        animation.setDuration(500);

        animation.setRepeatCount(0);
//        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();

        ObjectAnimator animation1 = ObjectAnimator.ofFloat(lauout2, "rotationY", 360.0f, 0.0f);
        animation1.setDuration(800);

        animation1.setRepeatCount(0);
        animation1.setInterpolator(new AccelerateDecelerateInterpolator());
        animation1.start();


        tv1.setOnClickListener(new OnClickListener() {
            @Override
            // 8052245732
            public void onClick(View view) {
                call_sms_chooser(view);
            }
        });


        tv2.setOnClickListener(new OnClickListener() {
            @Override
            //7705872824
            public void onClick(View view) {
                call_sms_chooser(view);
            }
        });


        tv3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                SendMail(view);

            }
        });

        tv4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToWebsite(view);
            }
        });

        tv5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToTwitter(view);
            }
        });


    }

    public void onBackPress(View v) {
        onBackPressed();
    }


    public void call_sms_chooser(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.dialermenu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.call_key:
                    if(v.getId()==R.id.textView9){
                    call_number_1();// 8052245732
                    }

                    else if (v.getId()==R.id.textView10){
                        call_number_2(); // 7705872824
                    }

                case R.id.sms_key:
                    if(v.getId()==R.id.textView9) {

                        send_sms_1();
                    }

                    else if (v.getId()==R.id.textView10)
                    {
                        send_sms_2();
                    }
                default:
                    return false;
            }

        });
        popupMenu.show();
    }

    public void call_number_1() {

         tv1_text = tv1.getText().toString();
        if (tv1_text.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(About_Page.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(About_Page.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + tv1_text;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
            }
            }

    public void call_number_2() {

        tv2_text = tv2.getText().toString();
        if (tv2_text.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(About_Page.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(About_Page.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + tv2_text;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    private void send_sms_1(){
        tv1_text=tv1.getText().toString();
        Intent smsintent = new Intent(Intent.ACTION_SENDTO);
        smsintent.setData(Uri.parse("smsto:"+tv1_text));
        smsintent.putExtra("sms_body","Write Message");
        try {
            startActivity(smsintent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(About_Page.this,"SMS Failed",Toast.LENGTH_SHORT).show();
        }
    };

    private void send_sms_2(){
        tv2_text=tv2.getText().toString();
        Intent smsintent = new Intent(Intent.ACTION_SENDTO);
        smsintent.setData(Uri.parse("smsto:"+tv2_text));
        smsintent.putExtra("sms_body","Write Message");
        try {
            startActivity(smsintent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(About_Page.this,"SMS Failed",Toast.LENGTH_SHORT).show();
        }
    };

    public void onRequestPermissionsResult ( int requestCode,
            @NonNull @NotNull String[] permissions,
            @NonNull @NotNull int[] grantResults){
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                if (requestCode == REQUEST_CALL) {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        call_number_1();
                        call_number_2();
                    } else {
                        Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            public void GoToTwitter (View v){
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + "emara_najran")));
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/" + "emara_najran")));
                }


            }

            public void GoToWebsite (View v){
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.e-najran.gov.sa"));
                startActivity(intent);


            }

            @SuppressLint("IntentReset")
            public void SendMail (View v){
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@e-najran.gov.sa"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Message Body.....");
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();

                } catch (android.content.ActivityNotFoundException ignored) {
                }
            }


        }

