package lee.com.certificatetest;

import junit.framework.TestCase;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lee.com.certificatetest.CertificateURL.CertificateURL;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    Document doc = null;
    String rootURL = "http://www.comcbt.com/cbt/s_view2.php";

    @Before
    public void JuintStart(){
        System.out.println("띵옹");
        try {
            this.doc = Jsoup.connect(rootURL)
                    .data("hack_number","0")
                    .data("imsidbname","신업기사")
                    .data("dbname","no")
                    .post();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void one() {



        Element element= doc.select("table").get(0);

        Pattern p = Pattern.compile("과목 : ((\\W|\\d)+?\\))");
        Matcher m = p.matcher(element.text());
        for(int i = 0 ; i <= m.groupCount() ;i++){
            if(m.find())
                System.out.println(m.group(1));
        }
    }

    @Test
    public void two() {
        System.out.println("two");
    }

    @After
    public void JuintEnd(){
        System.out.println("뿌직");
    }



}