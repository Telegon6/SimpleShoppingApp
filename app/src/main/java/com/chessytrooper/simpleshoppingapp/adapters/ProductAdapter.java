package com.chessytrooper.simpleshoppingapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chessytrooper.simpleshoppingapp.MainActivity;
import com.chessytrooper.simpleshoppingapp.R;
import com.chessytrooper.simpleshoppingapp.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> productList;
    private MainActivity mainActivity;

    public ProductAdapter(List<Product> productList, MainActivity mainActivity) {
        this.productList = productList;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.textViewName.setText(product.getName());
        holder.textViewPrice.setText("$" + product.getPrice());

        holder.buttonAdd.setOnClickListener(v -> mainActivity.addProductToCheckout(product));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewPrice;
        Button buttonAdd;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.product_name);
            textViewPrice = itemView.findViewById(R.id.product_price);
            buttonAdd = itemView.findViewById(R.id.button_add);
        }
    }
}

