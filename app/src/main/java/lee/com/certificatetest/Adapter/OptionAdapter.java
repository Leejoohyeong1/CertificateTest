package lee.com.certificatetest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;

import lee.com.certificatetest.Adapter.Constract.OptionAdapterConstract;
import lee.com.certificatetest.Adapter.Holder.OptionItemHolder;
import lee.com.certificatetest.DataModel.OptionItem;
import lee.com.certificatetest.Listener.onOptionCheckBoxListener;
import lee.com.certificatetest.R;


public class OptionAdapter extends RecyclerView.Adapter<OptionItemHolder> implements OptionAdapterConstract.Model, OptionAdapterConstract.View {


    ArrayList<OptionItem> items;
    Context context;


    public OptionAdapter(Context context){
        this.context = context;
        this.items = new ArrayList<>();
    }


    @NonNull
    @Override
    public OptionItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.subject_item_layout, viewGroup, false);
        OptionItemHolder holder = new OptionItemHolder(v);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull OptionItemHolder optionItemHolder, int i) {
        optionItemHolder.onBind(items.get(i));

    }



    @Override
    public OptionItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public void update(ArrayList<String> list) {
        this.items.clear();

        for (int i = 0; i < list.size() ; i++)
            items.add(new OptionItem(list.get(i),i+1));
    }

    @Override
    public void clearItems() {
        items.clear();
    }

    @Override
    public HashMap<String, Boolean> getOptionHash() {
        HashMap<String, Boolean> map = new HashMap<>();
        for (OptionItem item: items) {
            map.put(item.getPart(),item.isCheckbol());
        }
        return map;
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public void notfyAdaoter() {
        this.notifyDataSetChanged();
    }

    @Override
    public void dataShow() {
        for (OptionItem item: items) {
            Log.d("optionDataShow", item.getPart() + "   "+ item.getSubJect()+"    "+String.valueOf(item.isCheckbol()));
        }
    }

}
