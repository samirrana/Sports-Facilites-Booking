package my.t.sportszillia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ViewFacilitiesFragment extends Fragment {
    View view;
    Button buttonViewFootball,buttonViewTennis,buttonViewBasketball,buttonViewMpp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_view_facilities_main, container,false);

        buttonViewFootball = view.findViewById(R.id.button_frag_view_football);
        buttonViewTennis = view.findViewById(R.id.button_frag_view_tennis);
        buttonViewBasketball = view.findViewById(R.id.button_frag_view_basketball);
        buttonViewMpp = view.findViewById(R.id.button_frag_view_mpp);

        buttonViewFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new ViewFootballFragment()).commit();
            }
        });
        buttonViewTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new ViewTennisFragment()).commit();
            }
        });
        buttonViewBasketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new ViewBasketballFragment()).commit();
            }
        });
        buttonViewMpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new ViewMppFragment()).commit();
            }
        });

        return view;
    }
}
