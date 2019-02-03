package lee.com.certificatetest.JsonpParser;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import lee.com.certificatetest.CertificateURL.CertificateURL;
import lee.com.certificatetest.DataModel.HashData;

public abstract class SubtitleCertificate extends AsyncTask<String,Void,ArrayList<HashData>> {

    String imsidbname;

    public SubtitleCertificate(String imsidbname){
        this.imsidbname = imsidbname;
    }


    @Override
    protected ArrayList<HashData> doInBackground(String... strings) {
        String rootURL = CertificateURL.SubURL;
        Document doc = null;
        try {
            doc = Jsoup.connect(rootURL)
                    .data("hack_number","0")
                    .data("imsidbname",this.imsidbname)
                    .post();
        } catch (IOException e) {
            e.printStackTrace();
            ConnectError(e);
        }

        Elements newsHeadlines = doc.select("select[name=dbname]");
        ArrayList<HashData> sub = new ArrayList<HashData>();
        for( Element e : newsHeadlines )
        {
            Elements result = e.select("option");

            for( Element e1 : result ){
                sub.add(new HashData(e1.text(),e1.val()));
            }
        }
        return sub;
    }

    @Override
    protected void onPostExecute(ArrayList<HashData> list) {
        super.onPostExecute(list);
        if(list.size() > 0){
            SubTitleCertificateSuccess(list);
        }else{
            SubTitleCertificateError();
        }
    }

    protected abstract void SubTitleCertificateSuccess(ArrayList<HashData> list);
    protected abstract void SubTitleCertificateError();
    protected abstract void ConnectError(IOException e);
}
