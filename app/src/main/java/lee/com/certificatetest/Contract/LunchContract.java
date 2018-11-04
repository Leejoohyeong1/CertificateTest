package lee.com.certificatetest.Contract;

public interface LunchContract {

    interface  View{
        void TestView();
        void Histortview();
    }

    interface Presenter{
        void attachView(View view);
        void detachView();
    }
}
