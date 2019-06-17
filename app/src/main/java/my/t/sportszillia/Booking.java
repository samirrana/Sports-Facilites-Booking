package my.t.sportszillia;

public class Booking {

    private String title, facility, date, time, dur, desc;

    Booking(String Title, String Facility, String Date, String Time, String Duration, String Desc) {

        title = Title;
        facility = Facility;
        date = Date;
        time = Time;
        dur = Duration;
        desc = Desc;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDur() {
        return dur;
    }

    public void setDur(String dur) {
        this.dur = dur;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
