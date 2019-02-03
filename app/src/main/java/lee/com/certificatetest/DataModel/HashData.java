package lee.com.certificatetest.DataModel;

public class HashData {
    String title,value;

    public HashData(){
        this.title = null;
        this.value = null;

    }

    public HashData(String title,String value){
        this.title = title;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
