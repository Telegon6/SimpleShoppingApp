package com.chessytrooper.simpleshoppingapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.chessytrooper.simpleshoppingapp.fragments.CheckoutFragment;
import com.chessytrooper.simpleshoppingapp.fragments.ProductsFragment;
import com.chessytrooper.simpleshoppingapp.models.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private List<Product> checkoutList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // Default Fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductsFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    int itemId = item.getItemId();
                    if (itemId == R.id.nav_products) {
                        selectedFragment = new ProductsFragment();
                    } else if (itemId == R.id.nav_checkout) {
                        selectedFragment = new CheckoutFragment();
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };

    public void addProductToCheckout(Product product) {
        boolean found = false;
        for (Product p : checkoutList) {
            if (p.getName().equals(product.getName())) {
                p.setQuantity(p.getQuantity() + 1);
                found = true;
                break;
            }
        }
        if (!found) {
            checkoutList.add(product);
        }

        // Update the CheckoutFragment if it is visible
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment instanceof CheckoutFragment) {
            ((CheckoutFragment) fragment).updateCheckoutList();
        }
    }

    public void removeProductFromCheckout(Product product) {
        checkoutList.remove(product);
        // Update the CheckoutFragment if it is visible
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment instanceof CheckoutFragment) {
            ((CheckoutFragment) fragment).updateCheckoutList();
        }
    }

    public List<Product> getCheckoutList() {
        return checkoutList;
    }
}

