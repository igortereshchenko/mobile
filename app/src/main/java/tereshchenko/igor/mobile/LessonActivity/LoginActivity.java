package tereshchenko.igor.mobile.LessonActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import tereshchenko.igor.mobile.R;

public class LoginActivity  extends AppCompatActivity{

    protected void onCreate(Bundle stage){
        super.onCreate(stage);

        setContentView(R.layout.login_layout);

        Button btn  = (Button) findViewById(R.id.btnLogin);

        btn.setOnClickListener(view -> {

            Intent container = new Intent(this,ProfileActivity.class);

            EditText txtLogin = (EditText) findViewById(R.id.txtLoginLogin);
            EditText txtPassword = (EditText) findViewById(R.id.txtPass);

            container.putExtra("login",txtLogin.getText());
            container.putExtra("password",txtPassword.getText());

            startActivity(container);
        });
    }
}
