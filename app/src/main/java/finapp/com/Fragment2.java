package finapp.com;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    public Fragment2(){

    }
    public static Fragment2 newInstance(){
        return new Fragment2();
    }


    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment2, container,false );
    }
}
