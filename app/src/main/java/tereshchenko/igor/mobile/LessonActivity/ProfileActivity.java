package tereshchenko.igor.mobile.LessonActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.widget.DatePicker;
import android.widget.EditText;

import tereshchenko.igor.mobile.R;

public class ProfileActivity  extends AppCompatActivity{

    public static final String REGIME_REGISTER = "ProfileActivity_register_regime";
    public static final String REGIME_PROFILE = "ProfileActivity_register_profile";

    private static final int REQUEST_DATE = 1;

    protected void onCreate(Bundle stage) {
        super.onCreate(stage);

        Intent container = getIntent();

        Bundle extras = container.getExtras();

        if (extras!=null) {

            String login = extras.getString(LoginActivity.LOGIN);
            String password = extras.getString(LoginActivity.PASSWORD);


            setContentView(R.layout.profile_layout);

            EditText txtLogin = (EditText) findViewById(R.id.txtLogin);
            txtLogin.setText(login);

            EditText txtPassword = (EditText) findViewById(R.id.txtPass2);
            txtPassword.setText(password);
        }


        findViewById(R.id.txtBirthday).setOnKeyListener(null);
        ((EditText)findViewById(R.id.txtBirthday)).setCursorVisible(false);
//        ((EditText)findViewById(R.id.txtBirthday)).setInputType(InputType.TYPE_NULL);
        findViewById(R.id.txtBirthday).setPressed(false);
        findViewById(R.id.txtBirthday).setClickable(true);


        findViewById(R.id.txtBirthday).setOnClickListener(view -> {

            Intent intent = new Intent(this, DatePickerControlActivity.class);

//            startActivity(intent);

            startActivityForResult(intent,REQUEST_DATE);
        });

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data){

        if (requestCode == REQUEST_DATE){


            if (requestCode ==RESULT_OK){

                String birthdays =  data.getExtras().getString(DatePickerControlActivity.BIRTHDAY);

                ((EditText)findViewById(R.id.txtBirthday)).setText(birthdays);

            }else
                ((EditText)findViewById(R.id.txtBirthday)).setText("");

        }
        else if (requestCode == 23453){ //"some other activy closed"


        }
        else
            super.onActivityResult(requestCode,resultCode,data);

    }




}
