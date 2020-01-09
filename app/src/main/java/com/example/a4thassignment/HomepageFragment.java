package com.example.a4thassignment;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a4thassignment.adapter.ItemAdapter;
import com.example.a4thassignment.adapter.SliderAdapter;
import com.example.a4thassignment.model.Items;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomepageFragment extends Fragment {

    SliderView sliderView;
    RecyclerView recyclerView;

    public HomepageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        sliderView = view.findViewById(R.id.imageSlider);
        recyclerView=view.findViewById(R.id.itemRecyclerView);

        final SliderAdapter adapter = new SliderAdapter(getContext());
        adapter.setCount(5);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();

        //set item list in recycler view
        List<Items> itemList=new ArrayList<>();
        itemList.add(new Items(R.drawable.imagesshopping1,"Item description",1200));
        itemList.add(new Items(R.drawable.shoppingimages2,"Item description",1300));
        itemList.add(new Items(R.drawable.shoppingimages3,"Item description",1400));
        itemList.add(new Items(R.drawable.menclothing,"Item description",1500));

        final ItemAdapter itemAdapter=new ItemAdapter(getContext(),itemList);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        return view;
    }

}
