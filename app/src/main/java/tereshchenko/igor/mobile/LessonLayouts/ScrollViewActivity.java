package tereshchenko.igor.mobile.LessonLayouts;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import tereshchenko.igor.mobile.R;

public class ScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getScrollView(this));
    }

    protected View getScrollView(Context context){

        ScrollView layout = new ScrollView(context);

        TextView lblText = new TextView(context);

        lblText.setText("Слово коала (англ. koala) происходит от даракского[en] слова gulawan или его укороченной формы gula. Первоначально транскрибированное на латинский шрифт как cullawine, его постепенно вытеснил вариант koola. Хотя гласная /u/ была первоначально написана в английской орфографии как «оо», она, возможно по ошибке, было изменена на «oa»[2]. Ошибочно считалось, что это слово означало «не пьёт»[2].\n" +
                "\n" +
                "Видовое название cinereus было предложено в 1817 году Георгом Августом Гольдфусом, и с латинского языка означает «пепельный»[3][4].\n" +
                "\n" +
                "Несмотря на то, что таксономически коалы не являются медведями или близкими к ним животными, англоговорящие поселенцы конца XVIII века называли их медведем коала (англ. koala bear) из-за внешнего сходства коал и медведей и это название до сих пор используется за пределами Австралии[5], хотя его использование не рекомендуется из-за возникающей амбивалентности названия");

        lblText.setTextSize(70);

        ScrollView.LayoutParams lblLayoutParameters = new ScrollView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        layout.addView(lblText,lblLayoutParameters);

        return layout;

    }

}
