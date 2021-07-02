package com.example.hotelreservation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HotelListFragment extends Fragment implements HotelListAdapter.ItemClickListener {

    View view;
    ProgressBar progressBar;
    List<HotelListModel> hotelData;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println(container);
        view = inflater.inflate(R.layout.hotel_list_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progress_bar);
        getHotelData();

    }

    public static HotelListFragment newInstance(String hotel_name) {
        HotelListFragment fragment=new HotelListFragment();
        return fragment;
    }

    private void getHotelData(){
        progressBar.setVisibility(View.VISIBLE);
        Api.getClient().getHotelList(new Callback<List<HotelListModel>>() {
            @Override
            public void success(List<HotelListModel> hotelList, Response response) {

                hotelData = hotelList;
                progressBar.setVisibility(View.GONE);
                RecyclerView recyclerView = view.findViewById(R.id.hotels_list_recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                HotelListAdapter hotelListAdapter = new HotelListAdapter(getActivity(),hotelData,HotelListFragment.this::onItemClick);
                recyclerView.setAdapter(hotelListAdapter);

            }

            @Override
            public void failure(RetrofitError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }



    public ArrayList<HotelListModel> initHotelListData() {
        ArrayList<HotelListModel> list = new ArrayList<>();

        list.add(new HotelListModel("Halifax Regional Hotel", "2000$", "true"));
        list.add(new HotelListModel("Hotel Pearl", "500$", "false"));

        return list;
    }

    @Override
    public void onItemClick(HotelListModel hotelModel) {

        System.out.println("helowwww");
        Fragment fragment = HotelSearchFragment.newInstance(hotelModel.getHotel_name());
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
