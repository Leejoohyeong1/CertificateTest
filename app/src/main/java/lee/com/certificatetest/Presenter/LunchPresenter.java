package lee.com.certificatetest.Presenter;

import lee.com.certificatetest.Contract.LunchContract;

public class LunchPresenter implements LunchContract.Presenter {

    private LunchContract.View LunchView;

    @Override
    public void attachView(LunchContract.View view) {
        this.LunchView = view;
    }

    @Override
    public void detachView() {
        this.LunchView = null;
    }
}
