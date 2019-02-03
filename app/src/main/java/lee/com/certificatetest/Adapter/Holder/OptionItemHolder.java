package lee.com.certificatetest.Adapter.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import lee.com.certificatetest.DataModel.OptionItem;
import lee.com.certificatetest.R;

public class OptionItemHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener{

    CheckBox checkBox;
    TextView subjectTitle;

    OptionItem optionItem;

    public OptionItemHolder(@NonNull View itemView) {
        super(itemView);
        this.checkBox = (CheckBox) itemView.findViewById(R.id.option_checkbox);
        this.subjectTitle = (TextView) itemView.findViewById(R.id.option_text);

    }


    public void onBind(OptionItem optionItem) {
        this.optionItem = optionItem;
        subjectTitle.setText(optionItem.getSubJect());
        checkBox.setChecked(optionItem.isCheckbol());
        checkBox.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        optionItem.setCheckbol(isChecked);
    }
}
