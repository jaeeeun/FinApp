package finapp.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class RaiseCreditFragment4 extends Fragment {

    public RaiseCreditFragment4(){

    }
    public static RaiseCreditFragment4 newInstance(){
        return new RaiseCreditFragment4();
    }


    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_raise_credit_fragment4,container,false);

        Button bt_raisecredit4=(Button)view.findViewById(R.id.bt_raisecredit4);
        bt_raisecredit4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.frame, new Fragment3()).commit();
            }
        });
        return view;

    }

}