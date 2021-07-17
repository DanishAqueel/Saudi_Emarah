package com.example.saudi_emarah;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class xmlHandler {

    private String msg_code="code";
    private String msg ="message";
    private XmlPullParserFactory xmlFactroyobject;
    public volatile boolean parsingComplete=true;
    int event;
    public xmlHandler(){

    }

    public String getCode(){
        return msg_code;
    }
    public String getMessage()
    {
        return msg;
    }

    public void ParsedXMLdata(XmlPullParser xmlPullParser) {
        Log.i("getXmlDoc","Parsing XML Doc");
        try {
            event = xmlPullParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) ;
            {
                String name = xmlPullParser.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        xmlPullParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (name.equals("Code")) {
                            msg_code = xmlPullParser.getText();
                        } else if (name.equals("Message")) {
                            msg = xmlPullParser.getText();
                        } else {
                            break;
                        }
                }

                event= xmlPullParser.next();
            }
            parsingComplete = false;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void getXmlDoc(String urlstring){
        Log.i("getXmlDoc","Fetching XML Doc");
        Thread thread=new Thread(() -> {
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
        });

        thread.start();


    }
}

