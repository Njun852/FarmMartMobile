package com.example.farmmartmobile.items;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmmartmobile.R;
import com.example.farmmartmobile.model.Product;

import java.util.ArrayList;

public class ProductItemAdapter extends RecyclerView.Adapter<ProductItemViewHolder> {

    ArrayList<Product> products;
    Context context;

    public ProductItemAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }
    @NonNull
    @Override
    public ProductItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductItemViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.product_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductItemViewHolder holder, int position) {
        Product product = products.get(position);
        holder.priceTxt.setText("PHP "+product.getSellPrice());
        holder.nameTxt.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
