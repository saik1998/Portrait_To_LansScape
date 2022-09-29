package com.firstapp.portrait_to_lansscape;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    Context context;
    List<DataModel> dataModelList;

    public DataAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler,parent,false);

        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        holder.location.setText(dataModelList.get(position).getLocation());
        holder.equipment.setText(dataModelList.get(position).getEquipment());
        holder.description.setText(dataModelList.get(position).getDescription());
        holder.work.setText(dataModelList.get(position).getWorkcenter());



    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView location,equipment,description,work;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            location=itemView.findViewById(R.id.recycler_location);
            equipment=itemView.findViewById(R.id.recycler_equipement);

            description=itemView.findViewById(R.id.recycler_description);
            work=itemView.findViewById(R.id.recycler_work);


        }
    }
}
