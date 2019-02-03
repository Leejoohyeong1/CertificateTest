package lee.com.certificatetest.DataModel;

import java.util.ArrayList;

public class OptionData {

    ArrayList<String> Subject;
    ArrayList<HashData> Datetime;

    public OptionData(){
        this.Subject = new ArrayList<String>();
        this.Datetime = new ArrayList<HashData>();
    }

    public OptionData(ArrayList<String> Subject, ArrayList<HashData> Datetime){
        this.Subject = Subject;
        this.Datetime = Datetime;
    }

    public void addDatetime(String title,String value){
        this.Datetime.add(new HashData(title,value));
    }


    public HashData getDatetimePosition(int position){
        return  Datetime.get(position);
    }

    public ArrayList<HashData> getDatetime() {
        return Datetime;
    }

    public void setDatetime(ArrayList<HashData> datetime) {
        this.Datetime = datetime;
    }



    public ArrayList<String> getSubject() {
        return Subject;
    }

    public void setSubject(ArrayList<String> subject) {
        this.Subject = subject;
    }

    public void SubjectAdd(String string){
        this.Subject.add(string);
    }

    public String getSubjectPosition(int position){
        return this.Subject.get(position);
    }

    public boolean empty(){
        if (Subject.size() > 0 && Datetime.size() > 0) return false;
        return true;
    }



}
