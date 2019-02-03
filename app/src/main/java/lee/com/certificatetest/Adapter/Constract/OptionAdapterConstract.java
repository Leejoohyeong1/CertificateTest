package lee.com.certificatetest.Adapter.Constract;

import java.util.ArrayList;
import java.util.HashMap;

import lee.com.certificatetest.DataModel.OptionItem;
import lee.com.certificatetest.Listener.onOptionCheckBoxListener;

public interface OptionAdapterConstract {
    interface View{
        void notfyAdaoter();
        void dataShow();
    }

    interface Model{
        OptionItem getItem(int position);
        int getSize();
        void update(ArrayList<String> list);
        void clearItems();
        HashMap<String,Boolean> getOptionHash();
    }

}
