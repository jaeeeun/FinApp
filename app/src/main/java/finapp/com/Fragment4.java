package finapp.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragment4 extends Fragment {

    public Fragment4(){

    }
    public static Fragment4 newInstance(){
        return new Fragment4();
    }


    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment4, container,false );
    }

}