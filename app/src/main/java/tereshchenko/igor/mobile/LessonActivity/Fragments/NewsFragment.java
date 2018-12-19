package tereshchenko.igor.mobile.LessonActivity.Fragments;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tereshchenko.igor.mobile.LessonActivity.CustomAdapter.News;
import tereshchenko.igor.mobile.LessonActivity.CustomAdapter.NewsAdapter;
import tereshchenko.igor.mobile.LessonActivity.DbHandler.DatabaseNewsHelper;
import tereshchenko.igor.mobile.LessonActivity.DbHandler.Handler;
import tereshchenko.igor.mobile.R;

public class NewsFragment extends Fragment {


    View search_layout;
//    NewsAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        search_layout = inflater.inflate(R.layout.news_list_layout,container,false);


//        ArrayList<News> news = new ArrayList<>();
//
//        for(int i=1; i<=10;i++)
//            news.add(new News("Title "+i, "Context dfjhsd gjklhsdfjkgh lsdfhglkjsdfhjlkgh sdlfjkh  kghdjkfh"+i,new Date(),"path"));


        ListView listNews = (ListView) search_layout.findViewById(R.id.listNews);
//        adapter = new NewsAdapter(search_layout.getContext(),R.layout.news_layout,news);

        DatabaseNewsHelper databaseNewsHelper = new DatabaseNewsHelper(getActivity());

        SQLiteDatabase db = databaseNewsHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from "+DatabaseNewsHelper.TABLE,null);

        String[] header = new String[]{DatabaseNewsHelper.NEWS_TITLE, DatabaseNewsHelper.NEWS_CONTEXT};

        SimpleCursorAdapter adapter  = new SimpleCursorAdapter(getActivity(),android.R.layout.two_line_list_item,cursor,header,new int[]{android.R.id.text1,android.R.id.text2}, 0 );

        listNews.setAdapter(adapter);


//        Handler.createTextTable(getActivity());
//
//        Handler.insertTestTable(getActivity());

//        List<String> list = Handler.selectTestTable(getActivity());

        return search_layout;

    }


    public void searchNews(ISearchNews sender){

//        Toast.makeText(search_layout.getContext() , sender.getTopic()+sender.getDateFrom().toString()+
//
//                                                                sender.getDateTo().toString(),Toast.LENGTH_SHORT).show();

//        adapter.getFilter().filter(sender.getTopic());
    }
}
