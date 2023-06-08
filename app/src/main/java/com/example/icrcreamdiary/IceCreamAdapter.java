package com.example.icrcreamdiary;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IceCreamAdapter extends RecyclerView.Adapter<IceCreamAdapter.ViewHolder> {

        private ArrayList<IceCreamList> content;
        ItemClicked activity;

        public interface ItemClicked {
            void onItemClicked(int index);
        }

        public IceCreamAdapter(Context context, ArrayList<IceCreamList> list) {

            content = list;

        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView ivImage;
            TextView tvTitle, tvContent;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvTitle = itemView.findViewById(R.id.tvTitle);
                tvContent = itemView.findViewById(R.id.tvContent);
                ivImage = itemView.findViewById(R.id.ivImage);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      //  activity.onItemClicked(content.indexOf((IceCreamList) view.getTag()));
                    }
                });
            }
        }

        @NonNull
        @Override
        public IceCreamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list, viewGroup, false);
            return new ViewHolder(v);
        }

        @RequiresApi(api = Build.VERSION_CODES.P)
        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.itemView.setTag(content.get(i));
            viewHolder.tvTitle.setText(content.get(i).getTitle());
            viewHolder.tvContent.setText(content.get(i).getContent());
            if (content.get(i).getImage().equals("icecream")) {
                viewHolder.ivImage.setImageResource(R.drawable.logo);
            } else {
                viewHolder.ivImage.setImageResource(R.drawable.icecream);
            }
        }

        @Override
        public int getItemCount() {
            return content.size();
        }
    }


