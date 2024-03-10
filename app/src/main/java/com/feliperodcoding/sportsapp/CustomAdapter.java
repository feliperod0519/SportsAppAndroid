package com.feliperodcoding.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.SportsViewHolder> {



    private List<Sport> sportList;

    public ItemClickListener clickListener;

    public void setClickListener(ItemClickListener listener){
        this.clickListener = listener;
    }

    public CustomAdapter(List<Sport> sportList) {
        this.sportList = sportList;
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {
        //called for each item in the list and is responsible for
        //binding the data from Sports obj to the views
        Sport sport = sportList.get(position);
        holder.textView.setText(sport.sportName);
        holder.imageView.setImageResource(sport.sportImg);
        System.out.println(":)");
    }

    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflating the layout for each item in the recycleview
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new SportsViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return this.sportList.size();
    }

    public class SportsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;
        ImageView imageView;
        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageviewCard);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            if (clickListener!=null){
                clickListener.onClick(v,getAdapterPosition());
            }
            System.out.println("hello");
        }
    }

}
