package lee.com.certificatetest.Contract;


import java.util.ArrayList;

import lee.com.certificatetest.Adapter.Constract.OptionAdapterConstract;
import lee.com.certificatetest.Adapter.OptionAdapter;
import lee.com.certificatetest.DataModel.HashData;

public interface TestClassContract {
    interface View{
        void showToast(String massage);
        void MainTestTitle(ArrayList<String> MainTitlelist);
        void SubTestTitle(ArrayList<HashData> SubTitlelist);
        void setTestTimeOption(ArrayList<HashData> SubTitlelist);
        void moveProblemActivity();


    }

    interface Presenter{
        void setOptionAdapterViewModel(OptionAdapterConstract.Model model);
        void setOptionAdapterViewView(OptionAdapterConstract.View view);
        void attachView(View view);
        void detachView();
        void setMainTestTitle();
        void setSubTestTitle(String mainTitle);
        void setOptionDate(String imsidbname,String dbname);
        void certificateDataSet(String dbname,String talename);


    }
}
