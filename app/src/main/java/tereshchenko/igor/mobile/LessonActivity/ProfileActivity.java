package tereshchenko.igor.mobile.LessonActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import tereshchenko.igor.mobile.R;

public class ProfileActivity  extends AppCompatActivity{

    protected void onCreate(Bundle stage) {
        super.onCreate(stage);

        Intent container = getIntent();

        Bundle extras = container.getExtras();

//        String login = (String)extras.get("login");
//        String password =  (String)extras.get("password");




        setContentView(R.layout.profile_layout);

        EditText txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtLogin.setText("");

        EditText qwe = (EditText) findViewById(R.id.txtPass2);
        qwe.setText("");


    }

}
