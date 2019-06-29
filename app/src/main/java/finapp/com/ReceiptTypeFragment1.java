package finapp.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ReceiptTypeFragment1 extends Fragment {
    public static ReceiptTypeFragment1 newInstance(){
        return new ReceiptTypeFragment1();
    }
    public ReceiptTypeFragment1(){

    }

    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_receipt_type_fragment1, container,false );
    }
}
