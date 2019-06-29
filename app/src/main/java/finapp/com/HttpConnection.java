package finapp.com;

import java.io.UnsupportedEncodingException;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpConnection {

    private static final String TAG = "TestActivity";
    private OkHttpClient client;
    private static HttpConnection instance = new HttpConnection();
    public static HttpConnection getInstance() {
        return instance;
    }

    private HttpConnection(){ this.client = new OkHttpClient(); }

    /** 웹 서버로 요청을 한다. */
    public void requestWebServer(Callback callback) throws UnsupportedEncodingException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"dataHeader\":{},\"dataBody\":{\"계좌번호\":\"66130904009885\",\"실행번호\":\"\"}}");

        Request request = new Request.Builder()
                .url("https://dev-openapi.kbstar.com:8443/hackathon/getLoanBalance")
                .post(body)
                .addHeader("apikey", "l7xxd3d3817c16c24fa1a64ea99085bab7c5")
                .addHeader("hskey", "gefr8UjNf4AC/Thi1PTrjWRlpbx2dvFuw8DYium3xiw=")
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Agent", "PostmanRuntime/7.15.0")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "56d054de-e06d-4b9a-a6a4-704e516f9f2d,be072eea-8cb1-45f6-82fc-f68ebddc495d")
                .addHeader("Host", "dev-openapi.kbstar.com:8443")
                .addHeader("cookie", "QSID=5025&&tQH2dXmJsXBdHLjFhMDJhwRKsJl4lyV8y7pKV2JTw5qkwpjdlThn!-647553270!1561798164392")
                .addHeader("accept-encoding", "gzip, deflate")
                .addHeader("content-length", "80")
                .addHeader("Connection", "keep-alive")
                .addHeader("cache-control", "no-cache")
                .build();
          client.newCall(request).enqueue(callback);

    }

}
