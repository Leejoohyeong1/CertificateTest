package lee.com.certificatetest.JsonpParser;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import lee.com.certificatetest.CertificateURL.CertificateURL;


public abstract class MainCertificate extends AsyncTask<Void,Void,ArrayList<String>> {


    @Override
    protected ArrayList<String> doInBackground(Void... voids) {

        String rootURL = CertificateURL.MainURL;
        Document doc = null;
        ArrayList<String> miantitle = new ArrayList<>();
        try {
            doc = Jsoup.connect(rootURL).data("hack_number","0").post();
        } catch (IOException e) {
            e.printStackTrace();
            ConnectError(e);
        }
        Elements newsHeadlines = doc.select("select[name=imsidbname]");



        for( Element e : newsHeadlines )
        {
            Elements result = e.select("option");

            for( Element e1 : result ){
                miantitle.add(e1.val());
            }
        }

        return miantitle;
    }

    @Override
    protected void onPostExecute(ArrayList<String> strings) {
        super.onPostExecute(strings);

        if(strings.size() > 0){
            MainTitleCertificateSuccess(strings);
        }else{
            MainTitleCertificateError();
        }

    }

    protected abstract void MainTitleCertificateSuccess(ArrayList<String> title);
    protected abstract void MainTitleCertificateError();
    protected abstract void ConnectError(IOException e);
}
