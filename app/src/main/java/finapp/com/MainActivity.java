package finapp.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    String name = null; //고객명
    String money = null; //계좌 잔액
    String okmoney = null; //출금 가능 금액


    String jsonstring = "{'고객명':'배트맨'}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.button);


      //  foodlistjsonParser(jsonstring);

       // Toast.makeText(getApplication(),"고객명:"+name+"출금 가능 잔액"+money , Toast.LENGTH_SHORT).show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplication(),"고객명:"+name+"출금 가능 잔액"+money , Toast.LENGTH_SHORT).show();
                Intent it=new Intent(MainActivity.this, MenuActivity.class);
                startActivity(it);
            }
        });

    }

    public String[] foodlistjsonParser(String jsonString) {

        String[] arraysum = new String[8];
        try {
            JSONArray jarray = new JSONObject(jsonString).getJSONArray("food_list");
            for (int i = 0; i < jarray.length(); i++) {
                HashMap map = new HashMap<>();
                JSONObject jObject = jarray.getJSONObject(i);

                name = jObject.optString("고객명");
                money = jObject.optString("계좌잔액");
                okmoney = jObject.optString("계좌출금가능금액");


                arraysum[0] = name;
                arraysum[1] = money;
                arraysum[2] = okmoney;

                Toast.makeText(getApplication(),"고객명:"+arraysum[0] , Toast.LENGTH_SHORT).show();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arraysum;
    }


}
