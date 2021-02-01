package com.buzzware.sofittask.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.buzzware.sofittask.Model.ServicesModel;
import com.buzzware.sofittask.R;
import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.MyViewHolder> {

    private List<ServicesModel> servicesModelList;
    Context mContext;

    public ServicesAdapter(List<ServicesModel> list,Context context){
        this.servicesModelList = list;
        this.mContext=context;
    }
    @Override
    public ServicesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.govtservice_layout, parent, false);

        return new ServicesAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ServicesAdapter.MyViewHolder holder, int position) {
        //todo just for testing the model is dumy actual it work it when the daata loaded from server with api and feth it from model Retro
        ServicesModel servicesModel = servicesModelList.get(position);
        holder.serviceImageview.setImageResource(servicesModel.getServiceImageview());
        holder.propertysericeTitle.setText(servicesModel.getPropertysericeTitle());
        holder.vehicleserviceTitle.setText(servicesModel.getVehicleserviceTitle());
        holder.housesericeTitle.setText(servicesModel.getHousesericeTitle());
        holder.mediaserviceTitle.setText(servicesModel.getMediaserviceTitle());
        holder.complainsericeTitle.setText(servicesModel.getComplainsericeTitle());
        holder.serviceTitle.setText(servicesModel.getServiceTitle());
        holder.workserviceTitle.setText(servicesModel.getWorkserviceTitle());
        holder.schedualsericeTitle.setText(servicesModel.getSchedualsericeTitle());
        holder.ComerceserviceTitle.setText(servicesModel.getComerceserviceTitle());
        holder.waletsericeTitle.setText(servicesModel.getWaletsericeTitle());
    }
    @Override
    public int getItemCount() {

       return servicesModelList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView serviceImageview;
        TextView propertysericeTitle, vehicleserviceTitle, housesericeTitle, mediaserviceTitle, complainsericeTitle;
        TextView serviceTitle, workserviceTitle, schedualsericeTitle, ComerceserviceTitle, waletsericeTitle;
        public MyViewHolder(View view) {
            super(view);
            serviceImageview = view.findViewById(R.id.home_IV);
            propertysericeTitle = view.findViewById(R.id.home_Tv);
            vehicleserviceTitle = view.findViewById(R.id.traveTV);
            housesericeTitle = view.findViewById(R.id.propertyTV);
            mediaserviceTitle = view.findViewById(R.id.mediaTV);
            complainsericeTitle = view.findViewById(R.id.complainTV);
            serviceTitle = view.findViewById(R.id.serviceTV);
            workserviceTitle = view.findViewById(R.id.workTV);
            schedualsericeTitle = view.findViewById(R.id.schedualTV);
            ComerceserviceTitle = view.findViewById(R.id.comerceTV);
            waletsericeTitle = view.findViewById(R.id.waletTV);
        }
    }

}
