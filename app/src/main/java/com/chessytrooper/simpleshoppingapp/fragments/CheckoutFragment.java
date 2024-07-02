package com.chessytrooper.simpleshoppingapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chessytrooper.simpleshoppingapp.MainActivity;
import com.chessytrooper.simpleshoppingapp.OrderSuccessActivity;
import com.chessytrooper.simpleshoppingapp.R;
import com.chessytrooper.simpleshoppingapp.adapters.CheckoutAdapter;
import com.chessytrooper.simpleshoppingapp.models.Product;

import java.util.List;

public class CheckoutFragment extends Fragment {
    private RecyclerView recyclerView;
    private CheckoutAdapter checkoutAdapter;
    private List<Product> checkoutList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkout, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize checkout list
        checkoutList = ((MainActivity) getActivity()).getCheckoutList();

        checkoutAdapter = new CheckoutAdapter(checkoutList, (MainActivity) getActivity());
        recyclerView.setAdapter(checkoutAdapter);

        Button buttonOrderSuccess = view.findViewById(R.id.button_order_success);
        buttonOrderSuccess.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), OrderSuccessActivity.class);
            startActivity(intent);
        });

        return view;
    }

    public void updateCheckoutList() {
        if (checkoutAdapter != null) {
            checkoutAdapter.notifyDataSetChanged();
        }
    }
}
