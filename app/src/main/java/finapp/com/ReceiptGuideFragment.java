package finapp.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class ReceiptGuideFragment extends Fragment {
    public ReceiptGuideFragment() {
    }
    public static ReceiptGuideFragment newInstance() {return new ReceiptGuideFragment(); }

    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_receipt_guide,container,false);
        Button bt_receiptregister=(Button)view.findViewById(R.id.bt_receiptregister);

        bt_receiptregister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_guide, new ReceiptAddFragment1());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;

    }


}