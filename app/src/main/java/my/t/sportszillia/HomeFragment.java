package my.t.sportszillia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends BookingManager {

    View view;
    Button createBookingButton,viewBookingButton,viewFacilitiesButton,manageBookingButton;
    Integer adminFlag = 1;
    private ViewBookingFragment viewFrag = new ViewBookingFragment();
    private static final int adminKey = 148;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container,false);

        createBookingButton= view.findViewById(R.id.button_frag_home_create_booking);
        viewBookingButton = view.findViewById(R.id.button_frag_home_view_booking);
        viewFacilitiesButton = view.findViewById(R.id.button_frag_home_view_facilities);
        manageBookingButton = view.findViewById(R.id.button_frag_home_manage_bookings_a);


        createBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new CreateBookingFragment()).commit();
            }
        });
        viewBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, viewFrag).commit();
            }
        });
        viewFacilitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new ViewFacilitiesFragment()).commit();
            }
        });
        manageBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                //fragmentTransaction.replace(R.id.fragment_container, ManageFragment()).commit();
            }
        });

        adminFlag = getArguments().getInt("ADMIN");

        Bundle bundle3 = new Bundle();
        bundle3.putInt("ADMIN3", adminFlag);
        viewFrag.setArguments(bundle3);

        if(adminFlag != adminKey){
            manageBookingButton.setVisibility(View.GONE);
        }

        return view;
    }



    /*
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_frag_home_create_boking:
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new CreateBookingFragment());
                fragmentTransaction.commit();
                break;
            case R.id.button_frag_home_view_booking:
                break;
            case R.id.button_frag_home_view_facilities:
                //Intent intent = new Intent(HomeFragment.this,ViewFacilities.class);
                //startActivity(intent);
                break;
            case R.id.button_frag_home_manage_bookings_a:
                break;
        }
    }
    */
}
