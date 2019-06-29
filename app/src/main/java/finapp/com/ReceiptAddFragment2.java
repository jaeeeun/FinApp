package finapp.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReceiptAddFragment2 extends Fragment {
    public ReceiptAddFragment2() {
    }
    public static ReceiptAddFragment2 newInstance() {return new ReceiptAddFragment2(); }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_receipt_add_fragment2,container,false);

        Button bt_receiptadd=(Button)view.findViewById(R.id.bt_receiptadd);

        bt_receiptadd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_add_image, new ReceiptAddFragment1());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;

    }


}