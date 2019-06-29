package finapp.com;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;


public class NotifiFragment extends Fragment {

    ListView notifi_list;
    Button notifi_clientbtn;


    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            SingerItemView view = new SingerItemView(getActivity());
            SingerItem item = items.get(position);
            view.setText(item.getText());
            view.setTime(item.getTime());
            view.setImage(item.getResId());

            return view;
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_notifi, container, false);
        // Inflate the layout for this fragment
        notifi_list=(ListView)v.findViewById(R.id.notifi_list);
        notifi_clientbtn=(Button)v.findViewById(R.id.notifi_clintbtn);
        SingerAdapter adapter;
        adapter=new SingerAdapter();
        adapter.addItem(new SingerItem("KISA 님이 모션그래픽 계약금으로 200,000원을 보냈습니다.", "2시간 전",R.drawable.logo));
        adapter.addItem(new SingerItem("모션그래픽 프로젝트가 완료됐습니다.", "2시간 전",R.drawable.logo));
        notifi_list.setAdapter(adapter);

        notifi_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment1;

                fragment1=new ProjectContractFragment();
                transaction.replace(R.id.container,fragment1);
                transaction.commit();

                int count, checked ;
                count = adapter.getCount() ;

                if (count > 0) {
                    // 현재 선택된 아이템의 position 획득.
                    checked = notifi_list.getCheckedItemPosition();

                    if (checked > -1 && checked < count) {
                        notifi_list.removeViewAt(i);
                        // listview 선택 초기화.
                        notifi_list.clearChoices();

                        // listview 갱신.
                        adapter.notifyDataSetChanged();
                    }
                }

            }
        });
        notifi_clientbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem(new SingerItem("KB국민은행 님이 프로젝트 계약 요청을 보냈습니다.", "2시간 전",R.drawable.logo));
                notifi_list.setAdapter(adapter);
            }
        });



        return v;
    }

}
