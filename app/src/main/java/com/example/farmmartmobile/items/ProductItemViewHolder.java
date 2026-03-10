package com.example.farmmartmobile.items;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmmartmobile.R;


public class ProductItemViewHolder extends RecyclerView.ViewHolder {
    TextView nameTxt, priceTxt;
    public ProductItemViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTxt = itemView.findViewById(R.id.productNameTxt);
        priceTxt = itemView.findViewById(R.id.priceTxt);
    }
}
