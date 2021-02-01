package com.buzzware.sofittask.Fragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.buzzware.sofittask.Adapter.ServicesAdapter;
import com.buzzware.sofittask.Model.ServicesModel;
import com.buzzware.sofittask.R;
import java.util.ArrayList;

public class ServicesFragment extends Fragment {
    RecyclerView servicerecycler;
    ArrayList<ServicesModel> servicesModels;
    ServicesAdapter servicesAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_services, container, false);
        init(view);
        govtServicesData();
        return view;
    }
    private void init(View view) {
        servicerecycler =view.findViewById(R.id.servicerecyclerView);
        servicesModels = new ArrayList<>();
    }
    public void govtServicesData()
    {
//todo only dumy data to show you ni list actual its loaded from jsonAPi (if ready to)  sing loop and set into array model too
        servicesModels.add ( new ServicesModel ( R.drawable.speed_p,"HomeTitle","VainTitle","Propoerty",
                "Media","Complain","VainTitle","VainTitle","Schedual",
                "Commerce",
                "Wallet"));
        servicesModels.add ( new ServicesModel ( R.drawable.speed_p,"HomeTitle","VainTitle","Propoerty",
                "Media","Complain","VainTitle","VainTitle","Schedual",
                "Commerce",
                "Wallet"));
        servicesModels.add ( new ServicesModel ( R.drawable.speed_p,"HomeTitle","VainTitle","Propoerty",
                "Media","Complain","VainTitle","VainTitle","Schedual",
                "Commerce",
                "Wallet"));

        servicesModels.add ( new ServicesModel ( R.drawable.speed_p,"HomeTitle","VainTitle","Propoerty",
                "Media","Complain","VainTitle","VainTitle","Schedual",
                "Commerce",
                "Wallet"));
        servicesModels.add ( new ServicesModel ( R.drawable.speed_p,"HomeTitle","VainTitle","Propoerty",
                "Media","Complain","VainTitle","VainTitle","Schedual",
                "Commerce",
                "Wallet"));
        servicesAdapter = new ServicesAdapter( servicesModels,getActivity ());
        servicerecycler.setAdapter(servicesAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        servicerecycler.setLayoutManager(mLayoutManager);
    }
}