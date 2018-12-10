package tereshchenko.igor.mobile.LessonActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import tereshchenko.igor.mobile.R;

public class LoginActivity  extends AppCompatActivity{

    public static final String LOGIN = "LoginActivity_login";

    public static final String PASSWORD = "LoginActivity_password";


    public static final String REGIME = "LoginActivityregime";

    protected void onCreate(Bundle stage){
        super.onCreate(stage);

        setContentView(R.layout.login_layout);

        Button btn  = (Button) findViewById(R.id.btnLogin);

        btn.setOnClickListener(view -> {

            Intent container = new Intent(this,ProfileActivity.class);

            EditText txtLogin = (EditText) findViewById(R.id.txtLoginLogin);
            EditText txtPassword = (EditText) findViewById(R.id.txtPass);


            container.putExtra(LOGIN,txtLogin.getText().toString());
            container.putExtra(PASSWORD,txtPassword.getText().toString());
            container.putExtra(REGIME,ProfileActivity.REGIME_PROFILE);

            startActivity(container);
        });


        TextView lblRegistered = (TextView)findViewById(R.id.lblRegister);
        lblRegistered.setOnClickListener(view -> {

            Intent container = new Intent(this,ProfileActivity.class);

            container.putExtra(REGIME,ProfileActivity.REGIME_REGISTER);

            startActivity(container);

        });
    }
}
