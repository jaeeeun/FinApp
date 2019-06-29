package finapp.com;

public class SingerItem {
    String text;
    String time;
    int resId;

    public SingerItem(String text, String time) {
        this.text = text;
        this.time = time;
    }

    public SingerItem(String text, String time, int resId) {
        this.text = text;
        this.time = time;
        this.resId = resId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
