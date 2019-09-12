package com.gmail.candy7manner.fifteenth_web;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/*
  XML : eXtensible Mark-up Languae
  XML 은 JSON과 더불어 인터넷 등에서 '자료 교환(Data Exchange)'을 위해
  가장 널리 사용되는 데이터 포맷 입니다.
  어떠한 플랫폼에서 개발을 하든 XML 과 JSON 데이터 파일을
  파싱(parsing) 하고 원하는 데이터를 추출할수 있어야 합니다.
   안드로이드를 개발하면서 XML 을 파싱하는 대표적인 3가지 방법은
   다음과 같습니다.
   1. DOM Parser
   2. SAX Parser
   3. XMLPullParser
   node, element 등 DOM 에 대한 이해 필요.
*/

/*
■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1
샘플url
XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/키값넣으세요/xml/stationInfo/0/5/서울
예] http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/0/5/서울
JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/키값넣으세요/json/stationInfo/0/5/서울
예] http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/0/5/서울
*/
public class Main3Activity extends AppCompatActivity {

    private TextView tvResult;
    private EditText et;
    private Button btnXML;
    private Button btnJSON;
    private Button btnParse;

    // API 를 위한 parameter 들
    String reqType = "";
    String reqService = "stationInfo";
    int reqStartIndex = 0;
    int reqEndIndex = 5;
    String reqSearchStr = "";

    String api_key = "";

    String urlAddress = "";
    Handler handler = new Handler();

    HttpURLConnection conn = null;

    StringBuffer sb;   // response 받은 결과(텍스트) 저장

    // XML 파싱
    DocumentBuilderFactory dbFactory = null;
    DocumentBuilder dBuilder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // 웹에서 html 읽어오기
        // 1. 인터넷 권한 얻어오기 AndroidManifest.xml
        // 2. 쓰레드를 작성
        // 3. Handler 객체를 통해야만 화면을 그릴수 있다

        tvResult = findViewById(R.id.tvResult);
        btnXML = findViewById(R.id.btnXML);
        btnJSON = findViewById(R.id.btnJSON);
        btnParse = findViewById(R.id.btnParse);
        et = findViewById(R.id.editText);

        // API 키
        api_key = getResources().getString(R.string.api_key);

        // DOM parser 객체 생성
        try {
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        btnXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reqType = "xml";
                reqSearchStr = et.getText().toString().trim().replaceAll(" ", "");

                // url 에 한글이 들어가는 경우 URL Encode 를 해야 한다
                try {
                    reqSearchStr = URLEncoder.encode(reqSearchStr, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                if(reqSearchStr.length() > 0 ){
                    urlAddress = "http://swopenAPI.seoul.go.kr/api/subway/" +
                            api_key + "/" + reqType + "/" + reqService +"/" +
                            reqStartIndex +"/" + reqEndIndex + "/" + reqSearchStr;

                    Log.d("myapp", urlAddress);

                    // 웹에서 request-response 받아오기
                    sendRequest();
                }
            }
        });

        btnJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reqType = "json";

                reqSearchStr = et.getText().toString().trim();
                // url에 한글이 들어가는 경우 URLEncode 해야 한다.
                try {
                    reqSearchStr = URLEncoder.encode(reqSearchStr, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                if(reqSearchStr.length() > 0){
                    urlAddress = "http://swopenAPI.seoul.go.kr/api/subway/" +
                            api_key + "/" + reqType + "/" + reqService +"/" +
                            reqStartIndex +"/" + reqEndIndex + "/" + reqSearchStr;

                    Log.d("myapp", urlAddress);

                    // 웹에서 request-response 받아오기
                    sendRequest();
                }


            }
        });

        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");

                switch (reqType){
                    case "xml":
                        parseXML();
                        break;
                    case "json":
                        parseJSON();
                        break;
                }
            }
        });

    } // end onCreate()


    void sendRequest(){
        tvResult.setText("");  // 화면상의 텍스트 제거

        new Thread(new Runnable() {
            @Override
            public void run() {
                sb = new StringBuffer();

                try{
                    URL url = new URL(urlAddress);
                    conn = (HttpURLConnection) url.openConnection();   // 접속
                    if(conn != null){
                        conn.setConnectTimeout(2000);
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                        conn.setUseCaches(false);
                        conn.connect();

                        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                            BufferedReader br =
                                    new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

                            while(true){
                                String line = br.readLine();
                                if(line == null) break;  // 끝까지 다 받아오면 종료
                                sb.append(line + "\n");
                            }
                            br.close();  // 스트림 해제
                        }
                        conn.disconnect(); // 연결 끊기
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tvResult.setText(sb.toString());
                        }
                    });

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    } // end sendRequest

    void parseXML(){
        // String -> InputStream -> InputSource -> DocumentBuilder
        InputSource is = new InputSource(new StringReader(sb.toString()));

        // DOM parser 객체 생성
        Document doc;   // 곧바로 InputStream 으로부터 받아 파싱

        try{
            doc = dBuilder.parse(is);
            Element element = doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("row");   // 서울시 지하철 <row> ~ </row> 로 구성됨.

            Log.d("myapp", "subway length = " + nList.getLength());  // 몇개의 element?

            for(int i = 0; i < nList.getLength(); i++){
                Node node = nList.item(i);  // 각각의 <row> element 꺼내기
                Element rowElement = (Element)node;  /// 원래는 node.getNoteType == Node.ELEMENT_NODE 체크하고 해야 함
                final String subwayId =
                        rowElement.getElementsByTagName("subwayId").item(0).getChildNodes().item(0).getNodeValue();
                final String subwayNm =
                        rowElement.getElementsByTagName("subwayNm").item(0).getChildNodes().item(0).getNodeValue();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvResult.setText(tvResult.getText().toString() +
                                "-----------\nId:" + subwayId + "\n호선" + subwayNm + "\n");
                    }
                });
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void parseJSON(){
        try {
            JSONObject obj = new JSONObject(sb.toString());
            JSONArray stationArr = obj.getJSONArray("stationList");

            for(int i = 0; i < stationArr.length(); i++){
                JSONObject station = (JSONObject)stationArr.get(i);
                final String subwayId = station.getString("subwayId");
                final String subwayNm = station.getString("subwayNm");

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvResult.setText(tvResult.getText().toString() +
                                "-----------\nId:" + subwayId + "\n호선" + subwayNm + "\n");
                    }
                });
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
} // end class
