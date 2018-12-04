package tereshchenko.igor.mobile.LessonLayouts;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RelativeLayoutActivity extends AppCompatActivity{

    public void onCreate(Bundle stage){
        super.onCreate(stage);

        setContentView(getRelativeLayout(this));

    }


    protected View getRelativeLayout(Context context){

        // protected View getRelativeLayout(View sender){
        // RelativeLayout layout = new RelativeLayout( sender.getContext());
        RelativeLayout layout = new RelativeLayout( context);

        layout.setMinimumHeight(300);
        layout.setMinimumWidth(300);


        TextView lblName = new TextView(context);
        lblName.setId(1);
        lblName.setText("Name: ");

        EditText txtName = new EditText(context);
        txtName.setId(2);

        Button btnSend = new Button(context);
        btnSend.setId(3);
        btnSend.setText("Send");


        RelativeLayout.LayoutParams lblLayoutParameters = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        lblLayoutParameters.addRule(RelativeLayout.CENTER_VERTICAL);

        lblName.setLayoutParams(lblLayoutParameters);



        RelativeLayout.LayoutParams txtLayoutParameters = new RelativeLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);

        txtLayoutParameters.addRule(RelativeLayout.ALIGN_BASELINE,lblName.getId());
        txtLayoutParameters.addRule(RelativeLayout.RIGHT_OF,lblName.getId());
        txtLayoutParameters.addRule(RelativeLayout.ALIGN_PARENT_END);

        txtName.setLayoutParams(txtLayoutParameters);


        RelativeLayout.LayoutParams btnLayoutParameters  = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnLayoutParameters.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btnLayoutParameters.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        btnLayoutParameters.setMargins(40,40,40,40);
//        btnSend.setLayoutParams(btnLayoutParameters);


        layout.addView(lblName);
        layout.addView(txtName);
        layout.addView(btnSend,btnLayoutParameters);


        return layout;

    }
}
