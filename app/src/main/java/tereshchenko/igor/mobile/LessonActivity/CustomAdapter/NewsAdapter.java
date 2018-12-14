package tereshchenko.igor.mobile.LessonActivity.CustomAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tereshchenko.igor.mobile.R;

public class NewsAdapter extends ArrayAdapter<News> {

    private List<News> news;

    private List<News> filtered_news;

    private int news_layout;
    private LayoutInflater inflater;

    public NewsAdapter(@NonNull Context context, int resource, @NonNull List<News> objects) {
        super(context, resource, objects);

        this.news = objects;
        this.news_layout = resource;
        this.filtered_news = objects;

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



        final News current_news = filtered_news.get(index);

        viewHandler.txtTitle.setText(current_news.getTitle());


        viewHandler.txtContext.setText(current_news.getContext().substring(0,26)+"...");


        viewHandler.btnView.setOnClickListener(view -> {

            Toast.makeText(getContext(),current_news.getContext(),Toast.LENGTH_LONG).show();
        });


        return currentView;

    }


    @NonNull
    @Override
    public Filter getFilter() {

        Filter myFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence condition) {

                FilterResults results = new FilterResults();
                ArrayList<News> filtered  = new ArrayList<>();

                // TODO news not empty

                if (condition==null|| condition.length()==0){
                    results.count = news.size();
                    results.values = news;
                }
                else{
                    String condition_str = condition.toString();

                    for (int i=0; i<news.size();i++){
                        String current_title= news.get(i).getTitle();
                        if (current_title.toLowerCase().startsWith(condition_str.toLowerCase())){
                            filtered.add(news.get(i));
                        }
                    }

                    results.count = filtered.size();
                    results.values = filtered;
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {


                filtered_news = (List<News>)filterResults.values;
                notifyDataSetChanged();

            }
        };

        return myFilter;

    }

    @Override
    public int getCount() {
        return filtered_news.size();
    }

    public News getItem(int position){

        return filtered_news.get(position);
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
