package tereshchenko.igor.mobile.LessonActivity.CustomAdapter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import tereshchenko.igor.mobile.LessonActivity.Fragments.ISearchNews;
import tereshchenko.igor.mobile.LessonActivity.Fragments.NewsFragment;
import tereshchenko.igor.mobile.LessonActivity.Fragments.OnSearchListener;
import tereshchenko.igor.mobile.R;

public class NewsActivity extends AppCompatActivity implements OnSearchListener {

    protected void onCreate(Bundle stage){
        super.onCreate(stage);


//        setContentView(R.layout.news_list_layout);
//
//        ArrayList<News> news = new ArrayList<>();
//
//        for(int i=1; i<=10;i++)
//            news.add(new News("Title "+i, "Context dfjhsd gjklhsdfjkgh lsdfhglkjsdfhjlkgh sdlfjkh  kghdjkfh"+i,new Date(),"path"));
//
//        ListView  listNews = (ListView) findViewById(R.id.listNews);
//        NewsAdapter adapter = new NewsAdapter(this,R.layout.news_layout,news);
//
//
//        listNews.setAdapter(adapter);


        setContentView(R.layout.news_activity_layout);


    }

    @Override
    public void onSearch(ISearchNews sender) {

        NewsFragment newsFragment = (NewsFragment)getFragmentManager().findFragmentById(R.id.frgNews);

        newsFragment.searchNews(sender);
    }
}
