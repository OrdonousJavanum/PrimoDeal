package com.henallux.primodeal.View;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.henallux.primodeal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {
private EditText inputQuestion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
   View view = inflater.inflate(R.layout.fragment_question, container, false);
        inputQuestion = view.findViewById(R.id.input_question);
   return view;


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }



}
