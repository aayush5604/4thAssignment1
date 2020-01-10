package com.example.a4thassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a4thassignment.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {
    private Context context;
    private int count;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout, null);
        return new SliderAdapterVH(inflate);

    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });

        switch (position) {
            case 0:
                Glide.with(viewHolder.itemView).load(R.drawable.myshoppingslider1).into(viewHolder.imageSlideBackground);
                break;
            case 1:
                Glide.with(viewHolder.itemView).load(R.drawable.myshoppingslider2).into(viewHolder.imageSlideBackground);
                break;
            case 2:
                Glide.with(viewHolder.itemView).load(R.drawable.myshoppingslide3).into(viewHolder.imageSlideBackground);
                break;
            default:
                Glide.with(viewHolder.itemView).load(R.drawable.myshoppingslider1).into(viewHolder.imageSlideBackground);
                break;

        }

    }

    @Override
    public int getCount() {
        return count;
    }


    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageSlideBackground;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageSlideBackground = itemView.findViewById(R.id.iv_image_slider);
            this.itemView = itemView;
        }
    }
}
