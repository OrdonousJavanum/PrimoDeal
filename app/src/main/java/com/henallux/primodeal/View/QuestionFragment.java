package com.henallux.primodeal.View;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.henallux.primodeal.Model.Question;
import com.henallux.primodeal.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {
private EditText inputQuestion;
private ListView listAnswer;

    private String[] ArrayQuestionChoice = new String[]{
            "Oui", "Non", "peperooni", "une seule raison", "parapluie vert", "Techno"
    };


    //private ArrayList<String> answerArray = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

   View view = inflater.inflate(R.layout.fragment_question, container, false);
        inputQuestion = view.findViewById(R.id.input_question);
        listAnswer = view.findViewById(R.id.listAnswers);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1, answers );
        listAnswer.setAdapter(adapter);





       // listAnswer.setAdapter(ListAnswerAdapter(this, R.layout.row_answer, answerArray));

   return view;


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

   public class AnswerAdapter extends ArrayAdapter<Question> {
       private int layout;

       public AnswerAdapter(Context context, int resource, List<Question> questions) {
           super(context, resource, questions);
           layout = resource;
       }

       @Override
       public View getView(final int position, View convertView, ViewGroup parent) {
           AnswerViewHolder mainViewHolder;

           if (convertView == null)
           {
               convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_answer, parent, false);
           }
                AnswerViewHolder viewHolder = (AnswerViewHolder) convertView.getTag();
           if(viewHolder == null)
           {
               viewHolder = new AnswerViewHolder();
               viewHolder.questionChoice = (TextView) convertView.findViewById(R.id.row_answer_item);
               viewHolder.cancelButton = (Button) convertView.findViewById(R.id.cancel_button_item);
               convertView.setTag(viewHolder);
           }
            Question question = getItem(position);
           viewHolder.questionChoice.setText();

           return super.getView(position, convertView, parent);
       }
   }
        public class AnswerViewHolder
        {
            TextView questionChoice;
            Button cancelButton;
        }

    }




