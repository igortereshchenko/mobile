package tereshchenko.igor.mobile.LessonActivity.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tereshchenko.igor.mobile.R;

public class SearchFragment extends Fragment  implements ISearchNews{


    private OnSearchListener news_activity;

    private View search_layout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        search_layout = inflater.inflate(R.layout.search_layout,container,false);

        final ISearchNews sender = this;

        search_layout.findViewById(R.id.btnSearch).setOnClickListener(view -> {

            news_activity.onSearch(sender);

        });

        EditText txtTopic = (EditText)search_layout.findViewById(R.id.txtSearchTopic);
        txtTopic.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                news_activity.onSearch(sender);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        return search_layout;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        news_activity = (OnSearchListener)context;


    }

    @Override
    public String getTopic() {
        return ((EditText)search_layout.findViewById(R.id.txtSearchTopic)).getText().toString();
    }

    @Override
    public Date getDateFrom() {
        return parseDate(((EditText)search_layout.findViewById(R.id.txtSearchDateFrom)).getText().toString());
    }

    @Override
    public Date getDateTo() {
       return parseDate(((EditText)search_layout.findViewById(R.id.txtSearchDateTo)).getText().toString());
    }


    private Date parseDate(String  date){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");

        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
