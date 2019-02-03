package lee.com.certificatetest.DataModel;

public class OptionItem {
    String subJect;
    String part;
    boolean checkbol;
    int position;

    public OptionItem(String subJect,int position){
        this.subJect = subJect;
        this.checkbol = true;
        this.part = "part";
        this.part += position;
        this.position = position;
    }



    public OptionItem(String subJect,boolean checkbol,int position){
        this.subJect = subJect;
        this.checkbol = checkbol;
        this.part = "part";
        this.part += position;
        this.position = position;
    }

    public String getSubJect() {
        return subJect;
    }

    public void setSubJect(String subJect) {
        this.subJect = subJect;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public boolean isCheckbol() {
        return checkbol;
    }

    public void setCheckbol(boolean checkbol) {
        this.checkbol = checkbol;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
