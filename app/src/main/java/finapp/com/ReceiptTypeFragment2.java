package finapp.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ReceiptTypeFragment2 extends Fragment {
    public static ReceiptTypeFragment2 newInstance(){
        return new ReceiptTypeFragment2();
    }
    public ReceiptTypeFragment2(){

    }

    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_receipt_type_fragment2, container,false );
    }
}
