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

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder> {
    private List<Product> checkoutList;
    private MainActivity mainActivity;

    public CheckoutAdapter(List<Product> checkoutList, MainActivity mainActivity) {
        this.checkoutList = checkoutList;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public CheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkout_item, parent, false);
        return new CheckoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutViewHolder holder, int position) {
        Product product = checkoutList.get(position);
        holder.textViewName.setText(product.getName());
        holder.textViewPrice.setText("$" + product.getPrice());
        holder.productQuantity.setText("Qty: " + product.getQuantity());
        holder.buttonRemove.setOnClickListener(v -> mainActivity.removeProductFromCheckout(product));
    }

    @Override
    public int getItemCount() {
        return checkoutList.size();
    }

    public class CheckoutViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewPrice, productQuantity;
        Button buttonRemove;

        public CheckoutViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.checkout_name);
            textViewPrice = itemView.findViewById(R.id.checkout_price);
            productQuantity = itemView.findViewById(R.id.product_quantity);
            buttonRemove = itemView.findViewById(R.id.button_remove);
        }
    }
}

