package com.example.myapplication.app.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;

import java.util.ArrayList;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder>
{
    private final ArrayList<String> mItemsList ;
    public SimpleAdapter()
    {
        Log.w("SimpleAdapter","Empty Constructor: ");
        mItemsList = new ArrayList<>();
        //insertItemsintoList();
    }

    @NonNull
    @Override
    public SimpleAdapter.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup aViewGroup,
            int viewType)
    {
        View lView = LayoutInflater.from(aViewGroup.getContext()).
                inflate(R.layout.simple_adapter_item,
                        aViewGroup,
                        false);
        return new ViewHolder(lView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder aViewHolder, int aPosition)
    {
        Log.w("SimpleAdapter","onBindViewHolder: ");
        aViewHolder.mUserName.setText(
                aViewHolder.itemView.getContext().getString(R.string.reply_item_text, aPosition));
    }

    @Override
    public int getItemCount() {
        return 100;
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView mUserName;
        public ViewHolder(View itemView)
        {
            super(itemView);
            mUserName = itemView.findViewById(R.id.simple_adapter_name);
        }
    }
}