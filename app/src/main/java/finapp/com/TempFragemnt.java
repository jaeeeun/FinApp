package finapp.com;


import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class TempFragemnt extends Fragment {
/*
    MaterialCalendarView mc;
    private CalendarDay date;
    int Year,Month,Day;


    public TempFragemnt() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Button btn1=(Button)findViewById(R.id.btn1);
        final TabHost tabs=(TabHost)getView().findViewById(R.id.tabhost);
        tabs.setup();
        final TabHost.TabSpec spec = tabs.newTabSpec("tag1");

        spec.setContent(R.id.monthCaleder);
        spec.setIndicator("Project");
        tabs.addTab(spec);


        mc=getView().findViewById(R.id.monthCaleder);
        mc.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2017, 0, 1))
                .setMaximumDate(CalendarDay.from(2030, 11, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();



        mc.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Year = date.getYear();
                Month = date.getMonth() + 1;
                Day = date.getDay();

                Log.i("Year test", Year + "");
                Log.i("Month test", Month + "");
                Log.i("Day test", Day + "");

                String shot_Day = Year + "," + Month + "," + Day;

                Log.i("shot_Day test", shot_Day + "");
                mc.clearSelection();



                Toast.makeText(getApplicationContext(), shot_Day , Toast.LENGTH_SHORT).show();
            }
        });

        String[] result={Year + "," + Month + "," + Day};
        new ProjectActivity.ApiSimulator(result).executeOnExecutor(Executors.newSingleThreadExecutor());


        return inflater.inflate(R.layout.fragment_temp_fragemnt, container, false);
    }
*/
}
