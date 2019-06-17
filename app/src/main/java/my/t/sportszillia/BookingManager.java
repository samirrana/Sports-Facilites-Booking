package my.t.sportszillia;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class BookingManager extends Fragment {
    Boolean flag = true;

    static ArrayList<Booking> bookingArr = new ArrayList<>();


    public BookingManager() {
        AddDefaultsIntoArr();
    }

    public void ShowArr() {

    }

    public static void AddIntoArr(Object object) {
        bookingArr.add((Booking) object);
    }


    private void AddDefaultsIntoArr() {
        Booking b1 = new Booking("10/6/19_12:03:20", "Football Field A","12/6/19","6PM","2 Hours","Football club practice");
        Booking b2 = new Booking("10/6/19_14:36:43", "Multipurpose Court","11/6/19","6PM","2 Hours","dogeball");
        Booking b3 = new Booking("10/6/19_15:12:10", "Basketball Court","11/6/19","6PM","1.5 Hours","weekly club use");
        Booking b4 = new Booking("10/6/19_18:24:08", "Multipurpose Court","11/6/19","8PM","2 Hours","badminton non-club");
        Booking b5 = new Booking("11/6/19_09:56:32", "Football Field B","12/6/19","5PM","2 Hours","womens football club");
        Booking b6 = new Booking("11/6/19_11:19:22", "Tennis Court","12/6/19","6PM","2 Hours","tennis club");
        Booking b7 = new Booking("11/6/19_15:03:49", "Multipurpose Court","15/6/19","1PM","2 Hours","CIMP event 1");
        Booking b8 = new Booking("11/6/19_15:04:12", "Multipurpose Court","15/6/19","3PM","2 Hours","CIMP event 2");
        Booking b9 = new Booking("11/6/19_15:04:57", "Multipurpose Court","15/6/19","5PM","2 Hours","CIMP event 3");
        Booking b10 = new Booking("11/6/19_17:27:01", "Basketball Court","13/6/19","8PM","2 Hours","basketball local competition");

        AddIntoArr(b1);
        AddIntoArr(b2);
        AddIntoArr(b3);
        AddIntoArr(b4);
        AddIntoArr(b5);
        AddIntoArr(b6);
        AddIntoArr(b7);
        AddIntoArr(b8);
        AddIntoArr(b9);
        AddIntoArr(b10);

    }
}
