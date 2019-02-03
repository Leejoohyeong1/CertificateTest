package lee.com.certificatetest.Presenter;


import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import lee.com.certificatetest.Adapter.Constract.OptionAdapterConstract;
import lee.com.certificatetest.BlockPoint.BlockPont;
import lee.com.certificatetest.Contract.TestClassContract;
import lee.com.certificatetest.DataModel.HashData;
import lee.com.certificatetest.DataModel.OptionData;
import lee.com.certificatetest.JsonpParser.MainCertificate;
import lee.com.certificatetest.JsonpParser.OptionCertificate;
import lee.com.certificatetest.JsonpParser.SubtitleCertificate;
import lee.com.certificatetest.SinglePattern.ProblemRequest;

public class TestClassPresenter implements TestClassContract.Presenter {

    TestClassContract.View view;
    ArrayList<HashData> sub;

    OptionAdapterConstract.Model adapterViewModel;
    OptionAdapterConstract.View adapterViewView;


    @Override
    public void attachView(TestClassContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void setMainTestTitle() {
        new MainCertificate() {
            @Override
            protected void MainTitleCertificateSuccess(ArrayList<String> title) {
                view.MainTestTitle(title);
            }

            @Override
            protected void MainTitleCertificateError() {
                view.showToast("과목을 찾을 수가 없습니다");
            }

            @Override
            protected void ConnectError(IOException e) {
                view.showToast("인터넷 연결을 확인해주세요");
            }
        }.execute();
    }

    @Override
    public void setSubTestTitle(String mainTitle) {

         if(mainTitle.equals(BlockPont.subtitleBlock)){

             view.SubTestTitle(null);
             view.setTestTimeOption(null);
             adapterViewModel.clearItems();
             adapterViewView.notfyAdaoter();
             return;
         }

        new SubtitleCertificate(mainTitle) {
             @Override
             protected void SubTitleCertificateSuccess(ArrayList<HashData> list) {
                sub = list;
                view.SubTestTitle(list);
             }

             @Override
             protected void SubTitleCertificateError() {
                  view.showToast("과목을 찾을 수가 없습니다");
             }

             @Override
             protected void ConnectError(IOException e) {
                  view.showToast(" 인터넷 연결을 확인해주세요");
             }
        }.execute();
    }



    @Override
    public void setOptionDate(String imsidbname, final String dbname) {

        new OptionCertificate(imsidbname, dbname) {
            @Override
            protected void OptionCertificateSuccess(OptionData data) {
                view.setTestTimeOption(data.getDatetime());
                ProblemRequest.getInstance().setDbname(dbname);
                Log.d("OptionCertificateList",data.getSubject().toString());
                adapterViewModel.update(data.getSubject());
                adapterViewView.notfyAdaoter();


            }

            @Override
            protected void ConnectError(Exception e) {
                view.showToast(" 인터넷 연결을 확인해주세요");
            }

            @Override
            protected void OptionCertificateError() {
                view.showToast(" 인터넷 연결22을 확인해주세요");
            }
        }.execute();
    }

    @Override
    public void certificateDataSet(String dbname, String talename) {
        ProblemRequest.getInstance().RequestReady(dbname,talename, this.adapterViewModel.getOptionHash());
        this.view.moveProblemActivity();
    }

    @Override
    public void setOptionAdapterViewModel(OptionAdapterConstract.Model model) {
        this.adapterViewModel = model;
    }

    @Override
    public void setOptionAdapterViewView(OptionAdapterConstract.View view) {
        this.adapterViewView = view;
    }

}
