package my.t.sportszillia;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class CreateBookingFragment extends BookingManager {

    View view;
    TextView dateSpinner;
    Spinner facilitySpinner,timeSpinner,durationSpinner;
    Button submitButton, resetButton;
    EditText descEdit;
    DatePickerDialog datePicker;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_create_booking, container,false);

        facilitySpinner = view.findViewById(R.id.spinner_create_booking_select_facility);
        timeSpinner = view.findViewById(R.id.spinner_create_booking_select_time);
        dateSpinner = view.findViewById(R.id.field_create_booking_select_date);
        durationSpinner = view.findViewById(R.id.spinner_create_booking_select_dur);
        descEdit = view.findViewById(R.id.field_create_booking_dur);
        submitButton = view.findViewById(R.id.button_create_booking_submit);
        resetButton = view.findViewById(R.id.button_create_booking_reset);

        dateSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                datePicker = new DatePickerDialog(Objects.requireNonNull(getActivity()),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dateSpinner.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePicker.show();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBooking();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetFields();
            }
        });
        return view;
    }

    private void sendBooking(){
        String Fac  = facilitySpinner.getSelectedItem().toString();
        String Time  = timeSpinner.getSelectedItem().toString();
        String Dur  = durationSpinner.getSelectedItem().toString();
        String Desc  = descEdit.getText().toString();
        String Date = dateSpinner.getText().toString();

        //auto generate title
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy'_'h:mm:ss");
        String Title = format.format(calendar.getTime());
        Booking newBooking = new Booking(Title, Fac, Time, Date, Dur, Desc);
        BookingManager.AddIntoArr(newBooking);

        Toast.makeText(getActivity(), "Booking Created!", Toast.LENGTH_LONG).show();

        resetFields();
    }

    private void resetFields(){
        facilitySpinner.setSelection(0);
        timeSpinner.setSelection(0);
        durationSpinner.setSelection(0);
        descEdit.getText().clear();
        dateSpinner.setText("Select Date");

    }

}
