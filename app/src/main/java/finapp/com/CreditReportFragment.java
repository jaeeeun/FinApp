package finapp.com;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class CreditReportFragment extends Fragment {


    private static final String TAG = "TestActivity";
    private HttpConnection httpConn = HttpConnection.getInstance();

    TextView currentloan;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_credit_report, container, false);
        currentloan=view.findViewById(R.id.currentloan);

        URLEncoder.encode("UTF-8");

        sendData(); // 웹 서버로 데이터 전송

        return view;
    }

    private void sendData() {
        new Thread() {
            public void run() {
                try {
                    httpConn.requestWebServer(callback);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        ;
    }

    private final Callback callback = new Callback() {
        //@Override
        public void onFailure(Call call, IOException e) {
            Log.d(TAG, "콜백오류:" + e.getMessage());
        }

        //@Override
        public void onResponse(Call call, Response response) throws IOException {

            String body = response.body().string();
            currentloan.setText(body+"");
            Log.d(TAG, "서버에서 응답한 Body:" + body);
        }
    };

}
