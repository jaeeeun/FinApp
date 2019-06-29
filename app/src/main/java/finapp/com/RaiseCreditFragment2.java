package finapp.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class RaiseCreditFragment2 extends Fragment {
    public RaiseCreditFragment2() {
    }

    public static RaiseCreditFragment2 newInstance(){
        return new RaiseCreditFragment2();
    }

    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_raise_credit_fragment2,container,false);

        Button bt_raisecredit2=(Button)view.findViewById(R.id.bt_raisecredit2);
        bt_raisecredit2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.frame, new RaiseCreditFragment3()).commit();
            }
        });
        return view;

    }
}