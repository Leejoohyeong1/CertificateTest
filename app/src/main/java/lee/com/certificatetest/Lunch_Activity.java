package lee.com.certificatetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lee.com.certificatetest.Contract.LunchContract;
import lee.com.certificatetest.Presenter.LunchPresenter;
import lee.com.certificatetest.R;

public class Lunch_Activity extends AppCompatActivity implements View.OnClickListener,LunchContract.View {

    private Button Test;
    LunchPresenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        Test = (Button) findViewById(R.id.test);
        Test.setText(Html.fromHtml("<b>콘덴서 용량이 C<sub>1</sub>, C<sub>2</sub>인 2개를 병렬로 연결했을 때 합성용량은?</b>"));
        presenter = new LunchPresenter();
        presenter.attachView(this);
        Test.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.test :
                Intent intent = new Intent(this,TestClassActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }


    @Override
    public void TestView() {

    }

    @Override
    public void Histortview() {

    }
}
