package lee.com.certificatetest.JsonpParser;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lee.com.certificatetest.CertificateURL.CertificateURL;
import lee.com.certificatetest.DataModel.HashData;
import lee.com.certificatetest.DataModel.OptionData;

public abstract class OptionCertificate extends AsyncTask<Void,Void,OptionData> {
    String imsidbname;
    String dbname;

    public OptionCertificate(String imsidbname,String dbname){
        this.imsidbname = imsidbname;
        this.dbname = dbname;
    }


    @Override
    protected OptionData doInBackground(Void... voids) {

        OptionData data = new OptionData();
        String rootURL = CertificateURL.OptionURL;
        Document doc = null;
        try {
            doc = Jsoup.connect(rootURL)
                    .data("hack_number","0")
                    .data("imsidbname",this.imsidbname)
                    .data("dbname",this.dbname)
                    .post();
            Element element= doc.select("table").get(0);
//            Pattern p = Pattern.compile("[1-9]*?과목 : ((\\W|\\d)+?\\))");
        } catch (IOException e) {
            e.printStackTrace();
            ConnectError(e);
        }


        Element element= doc.select("table").get(0);

        Pattern p = Pattern.compile("[1-9]*?과목 : (([가-힣]|\\d|\\W)+?\\))");
        Matcher m = p.matcher(element.text());

        while (m.find()){
            data.getSubject().add(m.group(1));
        }

        Element select = element.select("select[name=tablename]").first();

        for( Element e : select.select("option"))
        {
            data.addDatetime(e.text(),e.val());
        }
        return data;
    }


    @Override
    protected void onPostExecute(OptionData optionData) {
        super.onPostExecute(optionData);


        if (!optionData.empty()) {
            OptionCertificateSuccess(optionData);
        }else{
            OptionCertificateError();
        }
    }

    protected abstract void ConnectError(Exception e);
    protected abstract void OptionCertificateSuccess(OptionData data);
    protected abstract void OptionCertificateError();
}
