package com.example.hotelreservation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class GuestListAdapter extends RecyclerView.Adapter<GuestListAdapter.ViewHolder> {

    private List<GuestModel> guestList;
    private LayoutInflater layoutInflater;

    GuestListAdapter(Context context,List<GuestModel> GuestListData) {
        this.guestList= GuestListData;
        this.layoutInflater = layoutInflater.from(context);
    }

    @NonNull
    @Override
    public GuestListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.guest_list_layout, parent, false);
        return new GuestListAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GuestListAdapter.ViewHolder holder, int position) {

        String guestName = guestList.get(position).getGuest_name();
        String guestGender = guestList.get(position).getGender();


        // set up the text
        holder.guestName.setText(guestName);
        holder.guestGender.setText(guestGender);


    }

    @Override
    public int getItemCount() {
        if (guestList != null) {
            return guestList.size();
        } else {
            return 0;
        }
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView guestName,guestGender;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            guestName = itemView.findViewById(R.id.guest_name_text);
            guestGender = itemView.findViewById(R.id.guest_gender_text);

        }
    }
}



