package com.example.hotelreservation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class GuestListAdapter extends ArrayAdapter<GuestModel> {

    private List<GuestModel> guestList = new ArrayList<GuestModel>();

    static class GuestViewHolder {
        TextView guestName;
        TextView gender;
    }

    public GuestListAdapter(@NonNull Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(@Nullable GuestModel object) {
        guestList.add(object);
        super.add(object);

    }

    @Override
    public int getCount() {
        return this.guestList.size();
    }

    @Nullable
    @Override
    public GuestModel getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        GuestViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.guest_list_layout, parent, false);
            viewHolder = new GuestViewHolder();
            viewHolder.guestName = row.findViewById(R.id.guest_name_text);
            viewHolder.gender = row.findViewById(R.id.guest_gender_text);
            row.setTag(viewHolder);
        } else {
            viewHolder = (GuestViewHolder)row.getTag();
        }
        GuestModel guest = getItem(position);
        viewHolder.guestName.setText(guest.getGuest_name());
        viewHolder.gender.setText(guest.getGender());

        return row;
    }

}



