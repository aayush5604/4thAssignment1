package com.example.a4thassignment;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a4thassignment.Url.Url;
import com.example.a4thassignment.adapter.ItemAdapter;
import com.example.a4thassignment.adapter.SliderAdapter;
import com.example.a4thassignment.api.ProductApi;
import com.example.a4thassignment.model.Items;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
getProduct();
        return view;
    }
   private void getProduct(){
       ProductApi productApi= Url.getInstance().create(ProductApi.class);
       Call<List<Items>> listCall = productApi.getProduct();
       listCall.enqueue(new Callback<List<Items>>() {
           @Override
           public void onResponse(Call<List<Items>> call, Response<List<Items>> response) {
               if(!response.isSuccessful()){
                   Toast.makeText(getContext(), "Toast " + response.code(), Toast.LENGTH_SHORT).show();
                   return;
           }
               ItemAdapter itemAdapter=new ItemAdapter(getActivity(),response.body());
               recyclerView.setAdapter(itemAdapter);
               recyclerView.setHasFixedSize(true);
               recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
               itemAdapter.notifyDataSetChanged();
           }


           @Override
           public void onFailure(Call<List<Items>> call, Throwable t) {
               Toast.makeText(getActivity(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

           }
       });
   }

}
