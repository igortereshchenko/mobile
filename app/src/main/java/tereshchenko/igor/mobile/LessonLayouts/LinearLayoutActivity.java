package tereshchenko.igor.mobile.LessonLayouts;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import tereshchenko.igor.mobile.R;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //VBox HBox

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);


        //Label
        TextView lbl = new TextView(this);
        TextView lbl2 = new TextView(this);

        lbl.setText("Hello !");
        lbl.setBackgroundColor(Color.CYAN);

        lbl2.setText("World !");
        lbl2.setBackgroundColor(Color.RED);


        layout.addView(lbl,300,400);
        layout.addView(lbl2,400,300);




        setContentView(layout);

    }

}
