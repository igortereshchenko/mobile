package tereshchenko.igor.mobile.LessonActivity.CustomAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import tereshchenko.igor.mobile.R;

public class NewsAdapter extends ArrayAdapter<News> {

    private List<News> news;
    private int news_layout;
    private LayoutInflater inflater;

    public NewsAdapter(@NonNull Context context, int resource, @NonNull List<News> objects) {
        super(context, resource, objects);

        this.news = objects;
        this.news_layout = resource;

        this.inflater = LayoutInflater.from(context);
    }



    public View getView(int index, View currentView, ViewGroup parent){

        final ViewHandler viewHandler;

        if (currentView ==null){
            currentView = inflater.inflate(this.news_layout,parent,false);

            viewHandler = new ViewHandler(currentView);

            currentView.setTag(viewHandler);
        }
        else
            viewHandler =(ViewHandler) currentView.getTag();


        final News current_news = news.get(index);

        viewHandler.txtTitle.setText(current_news.getTitle());


        viewHandler.txtContext.setText(current_news.getContext().substring(0,26)+"...");


        viewHandler.btnView.setOnClickListener(view -> {

            Toast.makeText(getContext(),current_news.getContext(),Toast.LENGTH_LONG).show();
        });


        return currentView;

    }



    private class ViewHandler{

        public final Button btnView;
        public final TextView txtTitle, txtContext;
        public final ImageView imgNews;


        ViewHandler(View view){

            btnView = (Button)view.findViewById(R.id.btnView);
            txtTitle = (TextView)view.findViewById(R.id.txtTitle);
            txtContext  =(TextView)view.findViewById(R.id.txtContent);
            imgNews = (ImageView)view.findViewById(R.id.imgNews);

        }

    }

}
