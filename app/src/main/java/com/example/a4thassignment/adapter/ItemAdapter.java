package com.example.a4thassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4thassignment.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.itemAdapterViewHolder> {
    private Context context;
    private List<Items> itemsList;

    public ItemAdapter(Context context, List<Items> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }
    @NonNull
    @Override
    public ItemAdapter.itemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);
        return new itemAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.itemAdapterViewHolder holder, int position) {
        final Items items=itemsList.get(position);
        holder.imgItem.setImageResource(items.getImgId());
        holder.tvItemDesc.setText(items.getDesc());
        holder.tvItemPrice.setText("Rs. "+items.getPrice()+" /-");
    }

    @Override

    public int getItemCount() {
        return itemsList.size();
    }

    public class itemAdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView imgItem;
        TextView tvItemDesc, tvItemPrice;

        public itemAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgItem = itemView.findViewById(R.id.imgItem);
            this.tvItemDesc = itemView.findViewById(R.id.tvItemDesc);
            this.tvItemPrice = itemView.findViewById(R.id.tvItemPrice);
        }
    }
}
