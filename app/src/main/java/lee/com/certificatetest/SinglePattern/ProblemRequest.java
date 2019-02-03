package lee.com.certificatetest.SinglePattern;

import java.util.HashMap;
import java.util.Iterator;

public class ProblemRequest {

    private static ProblemRequest one;
    String dbname;
    String tablename;
    int number = 1;
    HashMap<String, Boolean> partMap;


    ProblemRequest(){
        this.partMap = new HashMap<>();
        this.partMapinit();
    }


    public void Numberinit(){
        this.number = 1;
    }


    public static ProblemRequest getInstance() {
        if (one == null) {
            one = new ProblemRequest();
        }
        return one;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public HashMap<String, Boolean> getPartMap() {
        return partMap;
    }

    public void partMapinit() {
        for (int part = 1; part <= 6; part++) {
            partMap.put("part" + part, false);
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void nextProblem() {
        this.number++;
    }

    public void RequestReady(String dbname,String talename, HashMap<String, Boolean> partMap ){
        this.Numberinit();
        this.partMapinit();
        this.setTablename(dbname);
        this.setTablename(talename);
        this.getPartMap().putAll(partMap);
    }

    public String CreateGetURL() {
        String URL = "http://www.comcbt.com/cbt/s_view3_in.php?mode=mode2&jumsu=0&odabnumber=&jungdabnumber=&hack_number=0&mo=0&gichul_number=-2&yearmoradio=0&";
        URL += "dbname="+this.getDbname()+"&";
        URL += "tablename="+this.getTablename() +"&";
        URL += "tablename2="+this.getTablename()+"&";
        URL += "number="+this.getNumber()+"&";

        Iterator<String> keys = this.getPartMap().keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
            URL += key+"="+this.getPartMap().get(key)+"&";
        }
        return URL;
    }

    @Override
    public String toString() {
        return "ProblemRequest{" +
                "dbname='" + dbname + '\'' +
                ", tablename='" + tablename + '\'' +
                ", number='" + number + '\'' +
                ", partMap=" + partMap.toString() +
                '}';
    }

}