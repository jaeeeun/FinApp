package finapp.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ReceiptAddFragment1 extends Fragment {
    public ReceiptAddFragment1() {
    }
    public static ReceiptAddFragment1 newInstance() {return new ReceiptAddFragment1(); }

    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_receipt_add_fragment1,container,false);

        Button bt_recepityype1=(Button)view.findViewById(R.id.bt_recepityype1);
        ImageButton ib_question=(ImageButton)view.findViewById(R.id.ib_question);
        FloatingActionButton floatingActionButton_receiptadd=(FloatingActionButton)view.findViewById(R.id.floatingActionButton_receiptadd);

        floatingActionButton_receiptadd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_receipt_main, new ReceiptAddFragment2());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        bt_recepityype1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_receipt_main, new ReceiptTypeFragment1());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ib_question.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_receipt_main, new ReceiptGuideFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



        return view;

    }


}