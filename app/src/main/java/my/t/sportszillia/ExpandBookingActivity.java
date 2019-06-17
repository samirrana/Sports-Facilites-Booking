package my.t.sportszillia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExpandBookingActivity extends AppCompatActivity {

    private String title,fac,date,time,dur,desc;
    private TextView textTitle,textFac,textDate,textTime,textDur,textDesc;
    private Integer adminKey;
    private Button buttonDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_booking);

        textTitle = findViewById(R.id.expand_booking_title);
        textFac = findViewById(R.id.expand_booking_fac);
        textTime = findViewById(R.id.expand_booking_time);
        textDate = findViewById(R.id.expand_booking_date);
        textDur = findViewById(R.id.expand_booking_dur);
        textDesc = findViewById(R.id.expand_booking_desc);
        buttonDel = findViewById(R.id.button_expand_booking_delete);

        intentKey();
        setValues();

        if(adminKey != 148){
            buttonDel.setVisibility(View.GONE);
        }

    }
    private void intentKey(){
        final String sender=this.getIntent().getExtras().getString("SEND_KEY");
        if(sender != null)
        {
            this.getValues();
        }
    }

    private void getValues(){
        Intent intent = getIntent();

        adminKey = intent.getIntExtra("ADMIN_KEY",0);
        title =intent.getStringExtra("TITLE_KEY");
        fac = intent.getStringExtra("FAC_KEY");
        date = intent.getStringExtra("DATE_KEY");
        time = intent.getStringExtra("TIME_KEY");
        dur = intent.getStringExtra("DUR_KEY");
        desc = intent.getStringExtra("DESC_KEY");

    }
    private void setValues(){
        textTitle.setText(title);
        textFac.setText(fac);
        textTime.setText(time);
        textDate.setText(date);
        textDur.setText(dur);
        textDesc.setText(desc);
    }
}
