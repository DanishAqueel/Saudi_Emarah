package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class An_Al_Imarah extends AppCompatActivity {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_al_imarah);
        TextView result = findViewById(R.id.textView2);
        result.setText("منطقة نجران هي إحدى المناطق الثلاثة عشر للمملكة العربية السعودية، وتقع في جنوب غرب المملكة على الحدود مع اليمن. وتبلغ مساحة منطقة نجران 360000 كم2، وعدد سكانها 620,000  الف نسمة، وعاصمتها هي مدينة نجران. تشتهر بالـزراعة، وبها سد وادي نجران، الذي يعد من أكبر السدود المقامة في السعودية إذ تصل طاقته التخزينية لحوالي 85 مليون مترا مكعبا، يكثر فيها الـنخيل، وأشهر آثارها المنطقة الأخدودية التي ورد ذكرها في القرآن الكريم في سورة البروج. ولا تزال آثار الأخدود قائمة تبهر زوارها من محبي التاريخ والباحثين في طيات الآثار. كما أن جبال نجران وكثير من مواقعها التاريخية لا تزال بكرا تزخر بالكثير من المواقع الأثرية والنقوش المتنوعة المليئة بالرسوم.في نجران أسواق تقليدية ومزارع حديثة وفنادق ومجالات أخرى لسكنى الزوار والسياح، وسكان منطقة نجران متمسكون بتقاليدهم القبلية. نجران منطقة جذب سياحي ومناخها معتدل صيفا وشتاء.ومن أشهر أحياء نجران هو حي الفيصليه الذي يتسم بالمنبع الاقتصادي للمنطقه.");

    }

    public void onBackPress(View v)
    {
        onBackPressed();
    }

}