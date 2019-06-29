package finapp.com;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.jar.Attributes;

public class SingerItemView extends LinearLayout {

    TextView textView;
    TextView textView2;
    ImageView imageView;

    public SingerItemView(Context context)
    {
        super(context);
        init(context);
    }
    public SingerItemView(Context context, Attributes attrs)
    {
        super(context, (AttributeSet) attrs);
        init(context);
    }

    public void init (Context context)
    {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.siger_item,this,true);

        textView=(TextView) findViewById(R.id.textView);
        textView2=(TextView) findViewById(R.id.textView2);
        imageView=(ImageView) findViewById(R.id.imageView);
    }

    public void setText(String text)
    {
        textView.setText(text);
    }
    public void setTime(String time)
    {
        textView2.setText(time);
    }
    public void setImage(int resId)
    {
        imageView.setImageResource(resId);
    }

}
