package tereshchenko.igor.mobile.LessonActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import tereshchenko.igor.mobile.R;


public class HttpURLFragment extends Fragment {


    TextView txtContent;
    String content;
    WebView webView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){

        View layout = inflater.inflate(R.layout.fragment_http_url,container,false);


        txtContent = (TextView)layout.findViewById(R.id.txtContent);
        webView = (WebView)layout.findViewById(R.id.webView);



        Button btn = (Button)layout.findViewById(R.id.btnDownload);

        btn.setOnClickListener(view -> {

            try {
                content = getContent("https://github.com/index.html");
                webView.loadData(content,"text/html; charset=utf-8","utf-8");

                txtContent.setText(content);

            }catch (IOException e){

            }
        });

        return layout;
    }


    private String getContent(String path) throws IOException{

        BufferedReader reader = null;

        try{

            URL url = new URL(path);
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();


            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);

            connection.connect();


            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();
            String line="";

            while( (line = reader.readLine())!=null){

                stringBuffer.append(line+"\n");
            }
            return stringBuffer.toString();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{

        }

        return "";
    }
}
