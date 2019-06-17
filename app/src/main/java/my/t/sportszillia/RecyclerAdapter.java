package my.t.sportszillia;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewViewHolder> {

    private ArrayList<Booking> mViewList;
    public String T,F,D,Ti,Du,De;
    private Integer n;

    public  class ViewViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextHeader,mTextSubeader,mTextSubeader2;
        public View eView;



        public ViewViewHolder(@NonNull final View itemView) {
            super(itemView);

            eView = itemView;

            mTextHeader = itemView.findViewById(R.id.card_layout_view_booking_header);
            mTextSubeader = itemView.findViewById(R.id.card_layout_view_booking_subheader);
            mTextSubeader2 = itemView.findViewById(R.id.card_layout_view_booking_subheader_2);


            eView.setOnClickListener(view -> {
                Intent intent = new Intent(eView.getContext(), ExpandBookingActivity.class);

                intent.putExtra("SEND_KEY", "RECADAPT");
                intent.putExtra("ADMIN_KEY", n);
                intent.putExtra("TITLE_KEY",T);
                intent.putExtra("FAC_KEY", F);
                intent.putExtra("DATE_KEY", D);
                intent.putExtra("TIME_KEY", Ti);
                intent.putExtra("DUR_KEY", Du);
                intent.putExtra("DESC_KEY", De);

                eView.getContext().startActivity(intent);
            });

        }
    }

    public RecyclerAdapter(ArrayList<Booking> viewList, Integer code){
        mViewList = viewList;
        n = code;
    }

    @NonNull
    @Override
    public ViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_booking_cardview_layout, viewGroup,false);
        ViewViewHolder vh = new ViewViewHolder(v);
        return  vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewViewHolder viewViewHolder, int i) {
        Booking currentItem = mViewList.get(i);
        viewViewHolder.mTextHeader.setText(currentItem.getTitle());
        viewViewHolder.mTextSubeader.setText(currentItem.getFacility());
        viewViewHolder.mTextSubeader2.setText(currentItem.getDate());

        T = currentItem.getTitle();
        F = currentItem.getFacility();
        D = currentItem.getDate();
        Ti = currentItem.getTime();
        Du = currentItem.getDur();
        De = currentItem.getDesc();

    }

    @Override
    public int getItemCount() {
        return mViewList.size();
    }


}
