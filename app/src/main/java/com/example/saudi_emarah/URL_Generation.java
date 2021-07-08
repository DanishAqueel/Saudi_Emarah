package com.example.saudi_emarah;

import android.util.Log;
import android.widget.Toast;

public class URL_Generation {
//Converting id and Year in coded format.

    public String getCodedForm(String number) {

        Log.i("URL","Inside URL generation method");
        String[] ids = number.split("");
        String digitString = "";
        for (int i = 0; i < ids.length; i++) {

            int d = Integer.parseInt(ids[i]);
            switch (d) {
                case 0:
                    digitString = digitString + "+48";
                    break;
                case 1:
                    digitString = digitString + "+49";
                    break;
                case 2:
                    digitString = digitString + "+50";
                    break;
                case 3:
                    digitString = digitString + "+51";
                    break;
                case 4:
                    digitString = digitString + "+52";
                    break;
                case 5:
                    digitString = digitString + "+53";
                    break;
                case 6:
                    digitString = digitString + "+54";
                    break;
                case 7:
                    digitString = digitString + "+55";
                    break;
                case 8:
                    digitString = digitString + "+56";
                    break;
                default:
                    digitString = digitString + "+57";
            }
        }
        //digitString = digitString + "+";
        digitString = digitString.substring(1);
        return digitString;
    }


// Preparing url string.

    public String getUrl(String id, String year) {
        Log.i("URL","Inside getUrl method");
        String url = "";
        String idString = id;
        String yearString = year;
        url = "http://eservices.e-najran.gov.sa/webservice_najran/ByKayedWared.aspx?73+78+68+79+67+78+79=" + idString + "&89+69+65+82=" + yearString + "&msgType=1&RETURN=xml";
        return url;
    }
    public String getUrlFromID(String id) {
        Log.i("URL","Inside getUrlFromID method");
        String url = "";
        String digitString = id;
        url = "http://eservices.e-najran.gov.sa/webservice_najran/ByCITIZEN_ID.aspx?73+78+68+79+67+78+79=" + digitString + "&msgType=1&RETURN=xml";
        return url;
    }
}
