package finapp.com;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnSelectDateListener;
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

/**
 * A simple {@link Fragment} subclass.
 */

public class Project1Fragment extends Fragment{

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = firebaseDatabase.getReference();


    private String projectname;
    private int starticon,endicon,startday,endday,startmonth,endmonth,today_start,today_end,day1,day2,day3;
    private int number;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_project1,container,false);


        List<EventDay> events = new ArrayList<>();


        //캘린더뷰
        CalendarView calendarView = (CalendarView) view.findViewById(R.id.calendarView);

        myRef.child("project1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot fileSnapshot : dataSnapshot.getChildren()) {

                    number=fileSnapshot.child("number").getValue(Integer.class);
                    if(number!=1) continue;
                    projectname = fileSnapshot.child("projectname").getValue(String.class);
                    startmonth=fileSnapshot.child("startmonth").getValue(Integer.class);
                    endmonth=fileSnapshot.child("endmonth").getValue(Integer.class);
                    startday=fileSnapshot.child("startday").getValue(Integer.class);
                    endday=fileSnapshot.child("endday").getValue(Integer.class);
                    starticon = fileSnapshot.child("today_start").getValue(Integer.class);
                    endicon = fileSnapshot.child("today_end").getValue(Integer.class);
                    day1=fileSnapshot.child("day1").getValue(Integer.class);
                    day2=fileSnapshot.child("day2").getValue(Integer.class);
                    day3=fileSnapshot.child("day3").getValue(Integer.class);


                    Log.i("TAG: value is ", projectname);
                    Toast.makeText(getContext(), projectname, Toast.LENGTH_SHORT).show();

                    Calendar calendar1 = Calendar.getInstance();
                    Calendar calendar2 = Calendar.getInstance();
                    Calendar calendar3 = Calendar.getInstance();
                    Calendar calendar4 = Calendar.getInstance();
                    Calendar calendar5 = Calendar.getInstance();
                    calendar1.set(2019, 5, 30);
                    calendar2.set(2019, 5, 30);
                    calendar3.set(2019, 5, 30);
                    calendar4.set(2019, 5, 30);
                    calendar5.set(2019, 5, 30);

                    calendar1.add(Calendar.DAY_OF_MONTH, startday-30);
                    events.add(new EventDay(calendar1, R.drawable.project_start));
                    calendar2.add(Calendar.DAY_OF_MONTH, endday-30);
                    events.add(new EventDay(calendar2, R.drawable.project_end));
                    calendar3.add(Calendar.DAY_OF_MONTH, day1-30);
                    events.add(new EventDay(calendar3, R.drawable.event_blue_meeting));
                    calendar4.add(Calendar.DAY_OF_MONTH, day2-30);
                    events.add(new EventDay(calendar4, R.drawable.event_blue_styleframe));
                    calendar5.add(Calendar.DAY_OF_MONTH, day3-30);
                    events.add(new EventDay(calendar5, R.drawable.event_blue_money));

                    calendarView.setEvents(events);
                    calendarView.setDisabledDays(getDisabledDays());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


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
    private OnSelectDateListener listener = new OnSelectDateListener() {
        @Override
        public void onSelect(List<Calendar> calendars) {

            Toast.makeText(getContext(),"zzz",Toast.LENGTH_LONG).show();
        }
    };

    private List<Calendar> getSelectedDays() {
        List<Calendar> calendars = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Calendar calendar = DateUtils.getCalendar();
            calendar.add(Calendar.DAY_OF_MONTH, i);
            calendars.add(calendar);
        }

        return calendars;
    }
}
