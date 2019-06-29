package finapp.com;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class RaiseCreditFragment3 extends Fragment {
    public RaiseCreditFragment3() {
    }
    public static RaiseCreditFragment3 newInstance(){
        return new RaiseCreditFragment3();
    }


    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_raise_credit_fragment3,container,false);

        Button bt_raisecredit3=(Button)view.findViewById(R.id.bt_raisecredit3);
        bt_raisecredit3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.frame, new RaiseCreditFragment4()).commit();
            }
        });
        return view;

    }

}