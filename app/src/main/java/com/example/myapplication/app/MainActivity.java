package com.example.myapplication.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.app.adapter.SimpleAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView lRV = findViewById(R.id.recyclerview);

        SimpleAdapter lSimpleAdapter = new SimpleAdapter();
        lRV.setLayoutManager(
                new LinearLayoutManager(
                        getApplicationContext(),
                        RecyclerView.VERTICAL,
                        false));
        lRV.setAdapter(lSimpleAdapter);


        SwipeController.SwipeControllerActions lInterFace = new SwipeController.SwipeControllerActions() {
            @Override
            public void onSwipePerformed(int position)
            {
                Toast.makeText(
                        getApplicationContext(),
                        getApplicationContext().getString(R.string.Replt_toast, position),
                        Toast.LENGTH_SHORT).show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeController(getApplicationContext(), lInterFace));
        itemTouchHelper.attachToRecyclerView(lRV);
    }
}