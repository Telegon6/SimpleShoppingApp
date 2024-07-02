package com.chessytrooper.simpleshoppingapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chessytrooper.simpleshoppingapp.MainActivity;
import com.chessytrooper.simpleshoppingapp.R;
import com.chessytrooper.simpleshoppingapp.models.Product;
import com.chessytrooper.simpleshoppingapp.adapters.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize product list
        productList = new ArrayList<>();
        productList.add(new Product("Product 1", 10.00));
        productList.add(new Product("Product 2", 20.00));
        productList.add(new Product("Product 3", 30.00));

        productAdapter = new ProductAdapter(productList, (MainActivity) getActivity());
        recyclerView.setAdapter(productAdapter);

        return view;
    }
}
