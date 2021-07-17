package com.example.saudi_emarah;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
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

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;


public class About_Page extends AppCompatActivity {

    Bitmap ImageBit;
    float ImageRadius = 40.0f;
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //This is used to hide/show 'Status Bar' & 'System Bar'. Swip bar to get it as visible.
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        View imgV = findViewById(R.id.imageView4);
        View lauout1 = findViewById(R.id.relativelayout1);
        View lauout2 = findViewById(R.id.relativelayout2);



        ImageBit = BitmapFactory.decodeResource(getResources(), R.drawable.aboutpage1);
        ((ImageView) imgV).setImageBitmap(ImageBit);


        RoundedBitmapDrawable RBD = RoundedBitmapDrawableFactory.create(getResources(),ImageBit);

        RBD.setCornerRadius(ImageRadius);

        RBD.setAntiAlias(true);
        ((ImageView) imgV).setImageDrawable(RBD);


        GradientDrawable gdButton3 = new GradientDrawable();
        gdButton3.setColor(Color.argb((float)0.7,(float)44.0/255,(float)180.0/255,(float)100.0/255));
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
        //  animation1.start();

    }
    public void onBackPress(View v)
    {
        onBackPressed();
    }


    public void GoToTwitter(View v) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + "emara_najran")));
        }catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/" + "emara_najran")));
        }


    }
    public void GoToWebsite(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.e-najran.gov.sa"));
        startActivity(intent);


    }
    @SuppressLint("IntentReset")
    public void SendMail(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"info@e-najran.gov.sa"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT   , "Message Body.....");
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();

        } catch (android.content.ActivityNotFoundException ignored) {
        }
    }
}