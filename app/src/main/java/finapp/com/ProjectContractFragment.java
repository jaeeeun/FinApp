package finapp.com;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectContractFragment extends Fragment {


    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = firebaseDatabase.getReference();

    Button project_contract_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_project_contract, container, false);
        ;

        project_contract_button = v.findViewById(R.id.project_contract_button);

        project_contract_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "프로젝트가 생성 되었습니다", Toast.LENGTH_SHORT).show();

                //데이터베이스에 추가
                // 파이어베이스 인증 객체 선언

                HashMap user;
                user = new HashMap<>();
                user.put("projectname", "브랜드컨셉");
                user.put("startmonth", 6);
                user.put("startday", 1);
                user.put("endmonth", 6);
                user.put("endday", 29);
                user.put("day1", 4);
                user.put("day2", 12);
                user.put("day3", 16);
                user.put("income", "80,000,000");
                myRef.child("project1").push().setValue(user);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment1;

                fragment1=new ProjectFragment();
                transaction.replace(R.id.container,fragment1);
                transaction.commit();

            }
        });
        return v;
    }

}
