package lee.com.certificatetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
