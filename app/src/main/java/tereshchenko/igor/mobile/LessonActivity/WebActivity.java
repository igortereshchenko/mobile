package tereshchenko.igor.mobile.LessonActivity;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tereshchenko.igor.mobile.R;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
    }
}
