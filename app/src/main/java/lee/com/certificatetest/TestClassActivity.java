package lee.com.certificatetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import lee.com.certificatetest.Adapter.OptionAdapter;
import lee.com.certificatetest.BlockPoint.BlockPont;
import lee.com.certificatetest.Contract.TestClassContract;
import lee.com.certificatetest.DataModel.HashData;
import lee.com.certificatetest.Presenter.TestClassPresenter;

public class TestClassActivity extends AppCompatActivity implements TestClassContract.View,AdapterView.OnItemSelectedListener,View.OnClickListener{

    private Spinner testClassSpinner,subTitleSpinner,testTimeSpinner;
    private TestClassContract.Presenter presenter;
    private Button test;
    private OptionAdapter optionAdapter;
    private RecyclerView SubjectRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_class);

        this.testClassSpinner = (Spinner) findViewById(R.id.imsidbname);
        this.subTitleSpinner = (Spinner) findViewById(R.id.dbname);
        this.testTimeSpinner = (Spinner) findViewById(R.id.tablename);
        this.SubjectRecyclerView = (RecyclerView) findViewById(R.id.part);
        this.test = (Button) findViewById(R.id.CerificateStart);
        this.test.setOnClickListener(this);

        LinearLayoutManager manager = new LinearLayoutManager(TestClassActivity.this,LinearLayoutManager.VERTICAL,false);
        this.SubjectRecyclerView.setLayoutManager(manager);


        this.optionAdapter = new OptionAdapter(this);
        this.SubjectRecyclerView.setAdapter(this.optionAdapter);

        this.presenter = new TestClassPresenter();
        this.presenter.attachView(this);

        this.presenter.setOptionAdapterViewModel(this.optionAdapter);
        this.presenter.setOptionAdapterViewView(this.optionAdapter);

        this.presenter.setMainTestTitle();

        this.testClassSpinner.setOnItemSelectedListener(this);
        this.subTitleSpinner.setOnItemSelectedListener(this);
        this.testTimeSpinner.setOnItemSelectedListener(this);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.imsidbname:
                this.presenter.setSubTestTitle((String) testClassSpinner.getItemAtPosition(i));
                break;
            case R.id.dbname:
                HashData hashData = (HashData) subTitleSpinner.getItemAtPosition(i);
                String title = (String) testClassSpinner.getSelectedItem();
                this.presenter.setOptionDate(title,hashData.getValue());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        return;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.detachView();
    }


    @Override
    public void showToast(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void MainTestTitle(ArrayList<String> list) {
        ArrayAdapter SubspinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,list);
        this.testClassSpinner.setAdapter(SubspinnerAdapter);
    }

    @Override
    public void SubTestTitle(ArrayList<HashData> SubTitlelist) {
        if(SubTitlelist == null){
            this.subTitleSpinner.setAdapter(null);
            return;
        }
        ArrayAdapter SubspinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,SubTitlelist);
        this.subTitleSpinner.setAdapter(SubspinnerAdapter);

    }

    @Override
    public void setTestTimeOption(ArrayList<HashData> SubTitlelist) {
        if(SubTitlelist == null){
            this.testTimeSpinner.setAdapter(null);
            return;
        }
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,SubTitlelist);
        this.testTimeSpinner.setAdapter(spinnerAdapter);
    }

    @Override
    public void moveProblemActivity() {
        Intent intent = new Intent(this,ExamActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(this.testClassSpinner.getSelectedItem().equals(BlockPont.subtitleBlock)) return;
        HashData dbname = (HashData) this.subTitleSpinner.getSelectedItem();
        HashData tablename = (HashData) this.testTimeSpinner.getSelectedItem();
        this.presenter.certificateDataSet(dbname.getValue(),tablename.getValue());
    }
}
