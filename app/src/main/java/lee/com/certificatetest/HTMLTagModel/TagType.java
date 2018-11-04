package lee.com.certificatetest.HTMLTagModel;

import org.jsoup.nodes.Element;

public abstract class TagType {
    String ImageBase = "http://www.comcbt.com/cbt/";

    TagType(Element element){
        if(!element.select("img").isEmpty()){
            TagTypeImag(ImageBase + element.select("img").attr("src"));
        }else{
            TagTypeText(element.text());
        }
    }
    public abstract void TagTypeImag(String contents);
    public abstract void TagTypeText(String contents);
}
