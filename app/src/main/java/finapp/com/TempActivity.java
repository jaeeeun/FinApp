package finapp.com;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TempActivity extends AppCompatActivity {


    private String str = "[{\"boolean\":\"true\",\"color\":\"#82b92c\",\"number\":\"123\",\"string\":\"Hello World\"}," +
            "{\"boolean\":\"false\",\"color\":\"#823333\",\"number\":\"2233\",\"string\":\"Hello World2\"}," +
            "{\"boolean\":\"true\",\"color\":\"#222b92c\",\"number\":\"12333\",\"string\":\"Hello World3\"}]";

    private ArrayList<String> colorList;
    private ArrayList<String>stringList;
    private ArrayList<String>numberList;
    private ArrayList<String>boolList;
    private JSONArray jsonArray;
    private Button button1;
    private TextView txtResult;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);


            colorList = new ArrayList<>();
            stringList = new ArrayList<>();
            numberList = new ArrayList<>();
            boolList = new ArrayList<>();

            try {
                jsonArray = new JSONArray(str);
                for(int i = 0 ; i<jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String color = jsonObject.getString("color");
                    String number = jsonObject.getString("number");
                    String string = jsonObject.getString("string");
                    String bool = jsonObject.getString("boolean");
                    colorList.add(color);
                    stringList.add(string);
                    numberList.add(number);
                    boolList.add(bool);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }




}
