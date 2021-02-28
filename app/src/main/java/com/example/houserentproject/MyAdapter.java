package com.example.houserentproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<HomePageViewHolder>{

    private Context mcontext;
    private List<HomePageData> myHomePageDataList;

    public MyAdapter(Context mcontext, List<HomePageData> myHomePageDataList) {
        this.mcontext = mcontext;
        this.myHomePageDataList = myHomePageDataList;
    }

    @Override
    public HomePageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_item , parent, false);
        return new HomePageViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageViewHolder holder, int position) {
        holder.imageView.setImageResource(myHomePageDataList.get(position).getImage());
        holder.mRentAmount.setText(myHomePageDataList.get(position).getRentAmount());
        holder.mLocation.setText(myHomePageDataList.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return myHomePageDataList.size();
    }
}

class HomePageViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView mRentAmount, mLocation;
    CardView mCardView;

    public HomePageViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.ivImageId);
        mRentAmount = itemView.findViewById(R.id.tvRentAmountId);
        mLocation = itemView.findViewById(R.id.tvLocationId);

        mCardView = itemView.findViewById(R.id.myCardViewId);
    }
}
