package finapp.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment3 extends Fragment {
    public static Fragment3 newInstance(){
        return new Fragment3();
    }
    public Fragment3(){

    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_fragment3,container,false);

        Button bt_raisecredit1=(Button)view.findViewById(R.id.bt_raisecredit1);

        FragmentTransaction transaction2=getActivity().getSupportFragmentManager().beginTransaction();

        bt_raisecredit1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fragment fragment1;
                //getFragmentManager().beginTransaction().replace(R.id.frame3, new RaiseCreditFragment2()).commit();


                fragment1=new RaiseCreditFragment2();
                transaction2.replace(R.id.frame,fragment1).commit();

            }
        });
        return view;

    }
}