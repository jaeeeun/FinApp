package finapp.com;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.applandeo.materialcalendarview.utils.DateUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import static android.content.ContentValues.TAG;


public class ProjectFragment extends Fragment {

    public ProjectFragment() {
        // Required empty public constructor
    }


    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = firebaseDatabase.getReference();


    private String projectname;
    private int starticon, endicon, startday, endday, startmonth, endmonth, today_start, today_end, day1, day2, day3;
    private int number;
    private int projectnumber;
    String income;
    TextView tv_projectname, tv_projectday,tv_income;

    String[] spinneritems = {"전체","모션그래픽","웨딩영상"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_project, container, false);


        // 텍스트뷰
        tv_projectname = (TextView) view.findViewById(R.id.tv_projectname);
        tv_projectday = (TextView) view.findViewById(R.id.tv_projectday);
        tv_income=(TextView)view.findViewById(R.id.tv_income);
        TextView tv1 = (TextView) view.findViewById(R.id.tv1);
        TextView tv2 = (TextView) view.findViewById(R.id.tv2);
        TextView tv_spinner = (TextView) view.findViewById(R.id.tv_spinner);

        tv1.setText("다음 일정");
        tv_projectname.setText("3차 시안 업로드");
        tv_projectday.setText("6월 8일");
        tv2.setText("예정 수입");
        tv_income.setText("2,500,000원");

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, spinneritems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv_spinner.setText(spinneritems[i]);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment1;
                switch (i) {
                    case 0:
                        //전체
                        projectnumber = 0;
                        //#여기고쳐야되외외오이외외욍
                        break;
                    case 1:
                        projectnumber = 1;
                        tv_projectname.setText("모션그래픽");
                        tv_projectday.setText("6월 3일");
                        tv_income.setText("1,500,000원");

                        fragment1=new Project1Fragment();
                        transaction.replace(R.id.calendarContainer,fragment1);
                        transaction.commit();
                        break;
                    case 2:
                        projectnumber = 2;
                        tv_projectname.setText("웨딩 영상");
                        tv_projectday.setText("6월 8일");
                        tv_income.setText("2,000,000원");

                        fragment1=new Project2Fragment();
                        transaction.replace(R.id.calendarContainer,fragment1);
                        transaction.commit();
                        break;
                    case 3:
                        projectnumber = 3;
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tv_spinner.setText("d");
            }
        });

        List<EventDay> events = new ArrayList<>();

        //캘린더뷰
        CalendarView calendarView = (CalendarView) view.findViewById(R.id.calendarView);

        // 데이터 읽어와서 아이콘 생성
        myRef.child("project1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot fileSnapshot : dataSnapshot.getChildren()) {
                    number = fileSnapshot.child("number").getValue(Integer.class);
                    projectname = fileSnapshot.child("projectname").getValue(String.class);
                    startmonth = fileSnapshot.child("startmonth").getValue(Integer.class);
                    endmonth = fileSnapshot.child("endmonth").getValue(Integer.class);
                    startday = fileSnapshot.child("startday").getValue(Integer.class);
                    endday = fileSnapshot.child("endday").getValue(Integer.class);
                    day1 = fileSnapshot.child("day1").getValue(Integer.class);
                    day2 = fileSnapshot.child("day2").getValue(Integer.class);
                    day3 = fileSnapshot.child("day3").getValue(Integer.class);


                    Log.i("TAG: value is ", projectname);
                    //Toast.makeText(getContext(), projectname, Toast.LENGTH_SHORT).show();

                    Calendar calendar1 = Calendar.getInstance();
                    Calendar calendar2 = Calendar.getInstance();
                    Calendar calendar3 = Calendar.getInstance();
                    Calendar calendar4 = Calendar.getInstance();
                    calendar1.set(2019, 5, 30);
                    calendar2.set(2019, 5, 30);
                    calendar3.set(2019, 5, 30);
                    calendar4.set(2019, 5, 30);

                    if (number == 1) {
                        calendar1.add(Calendar.DAY_OF_MONTH, startday-30);
                        events.add(new EventDay(calendar1, R.drawable.event_blue_styleframe));
                        calendar2.add(Calendar.DAY_OF_MONTH, endday-30);
                        events.add(new EventDay(calendar2, R.drawable.event_blue_red));

                    } else if (number == 2) {
                        calendar3.add(Calendar.DAY_OF_MONTH, startday-30);
                        events.add(new EventDay(calendar3, R.drawable.event_red_meeting));
                        calendar4.add(Calendar.DAY_OF_MONTH, endday-30);
                        events.add(new EventDay(calendar4, R.drawable.event_red_deadline));
                    } else if (number==3)
                    {

                    }
                    calendarView.setEvents(events);
                    calendarView.setDisabledDays(getDisabledDays());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //#income 다른데도 추가해줘야돼
        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {

                Calendar clickedDayCalendar = eventDay.getCalendar();
                int selecteddate = clickedDayCalendar.get(Calendar.DAY_OF_MONTH);
                Toast.makeText(getActivity(),
                        "Selected Date:\n" + "Day = " + clickedDayCalendar.get(Calendar.DAY_OF_MONTH) + "\n" + "Month = " + clickedDayCalendar.get(Calendar.MONTH) + "\n" + "Year = " + clickedDayCalendar.get(Calendar.YEAR) + "        "
                        ,
                        Toast.LENGTH_SHORT).show();
                //디비 찾기
                // 데이터 읽어와서 아이콘 생성
                myRef.child("project1").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot fileSnapshot : dataSnapshot.getChildren()) {
                            projectname = fileSnapshot.child("projectname").getValue(String.class);
                            startday = fileSnapshot.child("startday").getValue(Integer.class);
                            endday = fileSnapshot.child("endday").getValue(Integer.class);
                            income=fileSnapshot.child("income").getValue(String.class);
                            //Toast.makeText(getContext(), selecteddate+"  "+startday,Toast.LENGTH_LONG).show();;
                            if (startday == selecteddate || endday == selecteddate) {
                                tv_income.setText(income+"원");
                                tv_projectname.setText(projectname);
                                tv_projectday.setText(startmonth + "월" + startday + "일");
                            }
                            Log.i("TAG", fileSnapshot.toString());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

            }
        });


        //


        return view;
    }

    private List<Calendar> getDisabledDays() {
        Calendar firstDisabled = DateUtils.getCalendar();
        firstDisabled.add(Calendar.DAY_OF_MONTH, 2);

        Calendar secondDisabled = DateUtils.getCalendar();
        secondDisabled.add(Calendar.DAY_OF_MONTH, 1);

        Calendar thirdDisabled = DateUtils.getCalendar();
        thirdDisabled.add(Calendar.DAY_OF_MONTH, 18);

        List<Calendar> calendars = new ArrayList<>();
        calendars.add(firstDisabled);
        calendars.add(secondDisabled);
        calendars.add(thirdDisabled);
        return calendars;
    }

    private Calendar getRandomCalendar() {
        Random random = new Random();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, random.nextInt(99));

        return calendar;
    }


    private OnDayClickListener listener = new OnDayClickListener() {
        @Override
        public void onDayClick(EventDay eventDay) {
            Calendar clickedDayCalendar = eventDay.getCalendar();
            int selecteddate = clickedDayCalendar.get(Calendar.DAY_OF_MONTH);
            Toast.makeText(getActivity(),
                    "Selected Date:\n" + "Day = " + clickedDayCalendar.get(Calendar.DAY_OF_MONTH) + "\n" + "Month = " + clickedDayCalendar.get(Calendar.MONTH) + "\n" + "Year = " + clickedDayCalendar.get(Calendar.YEAR) + "        "
                    ,
                    Toast.LENGTH_SHORT).show();
            //디비 찾기
            // 데이터 읽어와서 아이콘 생성
            myRef.child("project1").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot fileSnapshot : dataSnapshot.getChildren()) {
                        projectname = fileSnapshot.child("projectname").getValue(String.class);
                        startday = fileSnapshot.child("startday").getValue(Integer.class);
                        endday = fileSnapshot.child("endday").getValue(Integer.class);
                        //Toast.makeText(getContext(), selecteddate+"  "+startday,Toast.LENGTH_LONG).show();;
                        if (startday == selecteddate || endday == selecteddate) {
                            tv_projectname.setText(projectname);
                            tv_projectday.setText(startmonth + "월" + startday + "일");
                        }
                        Log.i("TAG", fileSnapshot.toString());
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });

        }

        private List<Calendar> getSelectedDays() {
            List<Calendar> calendars = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                Calendar calendar = DateUtils.getCalendar();
                calendar.add(Calendar.DAY_OF_MONTH, i);
                calendars.add(calendar);
            }

            return calendars;
        }
    };
}

