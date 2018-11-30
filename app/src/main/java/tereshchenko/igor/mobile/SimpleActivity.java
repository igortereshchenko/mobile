package tereshchenko.igor.mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SimpleActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_interface);

        Log.d("message","onCreate");

    }

    protected void onStop(){
        super.onStop();

        Log.d("message","onStop");
    }

    protected void onStart(){
        super.onStart();

        Log.d("message","onStart");
    }


    protected void onPause(){
        super.onPause();

        Log.d("message","onPause");
    }

    protected void onResume(){
        super.onResume();

        Log.d("message","onResume");
    }

    protected void onRestart(){
        super.onRestart();

        Log.d("message","onRestart");
    }


    protected  void onDestroy(){

        Log.d("message","onDestroy");
        super.onDestroy();
    }
}
