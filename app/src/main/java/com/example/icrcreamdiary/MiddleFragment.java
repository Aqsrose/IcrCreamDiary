package com.example.icrcreamdiary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MiddleFragment extends Fragment implements IceCreamAdapter.ItemClicked {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    TextView tvTitle, tvContent;


    public MiddleFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_middle, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.list);
        tvTitle =view.findViewById(R.id.tvTitle);
        tvContent=view.findViewById(R.id.tvContent);
        recyclerView.setHasFixedSize(true);
//        layoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        myAdapter= new IceCreamAdapter(this.getActivity(),ApplicationClass.content);
        recyclerView.setAdapter(myAdapter);
    }

    public void notifyDataChanged(){
        myAdapter.notifyDataSetChanged();
    }

    public void onItemClicked(int index) {
        tvTitle.setText(ApplicationClass.content.get(index).getTitle());
        tvContent.setText(ApplicationClass.content.get(index).getContent());
        tvTitle.setText(ApplicationClass.content.get(index).getTitle());
    }

}
