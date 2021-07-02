package com.example.hotelreservation;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.ViewHolder> {

    private List<HotelListModel> hotelListData;
    private LayoutInflater layoutInflater;
    private ItemClickListener clickListener;

    //Data gets passed in the constructor

    HotelListAdapter(Context context,List<HotelListModel> hotelListData) {
        this.hotelListData = hotelListData;
        this.layoutInflater = layoutInflater.from(context);
    }

    HotelListAdapter(Context context,List<HotelListModel> hotelListData, ItemClickListener clickListener) {
        this.hotelListData = hotelListData;
        this.layoutInflater = layoutInflater.from(context);
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public HotelListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.hotel_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelListAdapter.ViewHolder holder, int position) {
        String hotelName = hotelListData.get(position).getHotel_name();
        String hotelPrice = hotelListData.get(position).getPrice();
        String hotelAvailability = hotelListData.get(position).getAvailability();

        // set up the text
        holder.hotelName.setText(hotelName);
        holder.hotelAvailability.setText(hotelAvailability);
        holder.hotelPrice.setText(hotelPrice);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(hotelListData.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (hotelListData != null) {
            return hotelListData.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView hotelName, hotelPrice, hotelAvailability;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hotelName = itemView.findViewById(R.id.hotel_name);
            hotelPrice = itemView.findViewById(R.id.price);
            hotelAvailability = itemView.findViewById(R.id.availability);

            itemView.findViewById(R.id.book_hotel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("hotel_name",hotelName.getText().toString());
                }
            });

        }
    }

    public interface ItemClickListener{
        public void onItemClick(HotelListModel hotelList);
    }
}
