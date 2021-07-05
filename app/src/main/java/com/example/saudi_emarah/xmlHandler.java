package com.example.saudi_emarah;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class xmlHandler {

 private String code="code";
 private String message="message";
 private String urlstring =null;
 private XmlPullParserFactory xmlFactroyobject;
 public volatile boolean parsingComplete=true;
 public xmlHandler(String url){
     this.urlstring=url;
 }
 public String getCode(){
     return code;
 }
public String getMessage()
{
    return message;
}
public void ParsedXMLdata(XmlPullParser parser) {

    int event;
    String text = null;

    try {
        event = parser.getEventType();
        while (event != XmlPullParser.END_DOCUMENT) ;
        {
            String name = parser.getName();
            switch (event) {
                case XmlPullParser.START_TAG:
                    break;
                case XmlPullParser.TEXT:
                    text = parser.getText();
                    break;
                case XmlPullParser.END_TAG:
                    if (name.equals(code)) {
                        code = parser.getAttributeValue(null, "value");
                    } else if (name.equalsIgnoreCase(message)) {
                        message = parser.getAttributeValue(null, "value");
                    } else {
                        break;
                    }
                    event = parser.next();
            }
        }
        parsingComplete = false;
    } catch (Exception e) {
        e.printStackTrace();
    }

}
public void getXmlDoc(){
Thread thread=new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            URL url=new URL(urlstring);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(10000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();

            InputStream stream=connection.getInputStream();
            xmlFactroyobject=XmlPullParserFactory.newInstance();
            XmlPullParser parser= xmlFactroyobject.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parser.setInput(stream,null);
            ParsedXMLdata(parser);
            stream.close();
        }
        catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
    }
});

thread.start();


}
}

