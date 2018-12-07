package tereshchenko.igor.mobile.LessonLayouts;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tereshchenko.igor.mobile.R;

public class ConstraintLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getConstraintLayout(this));


    }

    protected View getConstraintLayout(Context context){

        ConstraintLayout layout = new ConstraintLayout(context);
        layout.setMinHeight(300);
        layout.setMinWidth(300);


        layout.setId(1000);


        TextView contactUs = new TextView(context);
        contactUs.setText("Contact us: ");
        contactUs.setTextSize(25);
        contactUs.setId(1);

        ConstraintLayout.LayoutParams contactUsparams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        contactUs.setLayoutParams(contactUsparams);
        contactUsparams.setMargins(50,50,50,50);

        layout.addView(contactUs);


        ConstraintSet rules = new ConstraintSet();
        rules.clone(layout);


        rules.connect(contactUs.getId(),ConstraintSet.TOP,layout.getId(),ConstraintSet.TOP,20);
        rules.connect(contactUs.getId(),ConstraintSet.LEFT,layout.getId(),ConstraintSet.LEFT,10);
//        rules.connect(contactUs.getId(),ConstraintSet.BOTTOM,layout.getId(),ConstraintSet.BOTTOM,10);
//        rules.connect(contactUs.getId(),ConstraintSet.RIGHT,layout.getId(),ConstraintSet.RIGHT,10);

        rules.applyTo(layout);



        return layout;
    }


}
