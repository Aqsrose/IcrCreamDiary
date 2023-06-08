package com.example.icrcreamdiary;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class BottomFragment extends Fragment {
  private Button btnAdd;
  private EditText addtitle;
  private EditText addContent;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_bottom, container, false);

    // Find the button, EditTexts by ID
    btnAdd = view.findViewById(R.id.btnAdd);
    addtitle = view.findViewById(R.id.addtitle);
    addContent = view.findViewById(R.id.addContent);

    // Set a click listener for the button
    Log.d("btn added ",btnAdd+"");
    btnAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (addtitle.getText().toString().isEmpty() || addContent.getText().toString().isEmpty()) {
          Toast.makeText(getActivity(), "Please enter all fields!", Toast.LENGTH_SHORT).show();
        } else {
          // Assuming you have a static `content` list in your ApplicationClass
          ApplicationClass.content.add(new IceCreamList(addtitle.getText().toString().trim(), addContent.getText().toString().trim()));
          Toast.makeText(getActivity(), "Ice cream recipe successfully added", Toast.LENGTH_SHORT).show();
          addtitle.setText("");
          addContent.setText("");
        }
      }
    });


    return view;
  }
}
