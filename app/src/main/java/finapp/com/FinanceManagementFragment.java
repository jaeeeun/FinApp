package finapp.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class FinanceManagementFragment extends Fragment {
    public FinanceManagementFragment() {
        // Required empty public constructor
    }

    public static FinanceManagementFragment newInstance(String param1, String param2) {
        FinanceManagementFragment fragment = new FinanceManagementFragment();
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finance_management, container, false);


        Button bt_incomemanagement = (Button) view.findViewById(R.id.bt_incomemanagement);
        Button bt_creditreport = (Button) view.findViewById(R.id.bt_creditreport);
        Button bt_raisecredit = (Button) view.findViewById(R.id.bt_raisecredit);
        Button bt_loan = (Button) view.findViewById(R.id.bt_loan);

        /*
        bt_incomemanagement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, new Fragment1());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        bt_creditreport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.frame, new Fragment2()).commit();
            }
        });
        bt_raisecredit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.frame, new Fragment3()).commit();
            }
        });

        bt_loan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.frame, new Fragment4()).commit();
            }
        });
*/
        return view;

    }
}