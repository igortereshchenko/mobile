package tereshchenko.igor.mobile.LessonActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Calendar;

import tereshchenko.igor.mobile.R;

public class DatePickerControlActivity extends AppCompatActivity {

    public static final String BIRTHDAY ="DatePickerControlActivity_birthday";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        DatePicker datePicker = new DatePicker(this);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {

                String message = day+"/" +month+"/"+year;

                Toast t = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
                t.show();
            }
        });


        layout.addView(datePicker);


        Button btnOk = new Button(this);
        btnOk.setText("Ok");

        btnOk.setOnClickListener(view -> {

            Intent intent = new Intent();

            String date = datePicker.getDayOfMonth()+"/" +datePicker.getMonth()+"/"+datePicker.getYear();

            intent.putExtra(BIRTHDAY,date);

            setResult(RESULT_OK, intent);

            finish();

        });

        layout.addView(btnOk);

        setContentView(layout);
    }

}
