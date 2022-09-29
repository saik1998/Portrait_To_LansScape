package com.firstapp.portrait_to_lansscape;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PopUp extends DialogFragment {
    TextView functionaliy,equipement,workcenter,tasktype,description,breakdown,sympton,sympton_code;
    TextView plant,reported,ramcategory,ram_consequence;

    RecyclerView recyclerView;
    DataAdapter dataAdapter;

    List<DataModel> dataModelList=new ArrayList<>();



    public interface OnInputListener
    {
        void sendInput(String input);

    }
    public OnInputListener onInputListener1;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.custom_design,null,false);

        functionaliy=root.findViewById(R.id.finctionality);

        equipement=root.findViewById(R.id.equipment);

        workcenter=root.findViewById(R.id.workcenter);

        tasktype=root.findViewById(R.id.task);

        description=root.findViewById(R.id.description);

        breakdown=root.findViewById(R.id.break_down);

        sympton=root.findViewById(R.id.sympton);

        sympton_code=root.findViewById(R.id.sympton_code);

        plant=root.findViewById(R.id.plant);

        reported=root.findViewById(R.id.reported);

        ramcategory=root.findViewById(R.id.category);

        ram_consequence=root.findViewById(R.id.consequence_class);



//    recyclerView=root.findViewById(R.id.recylcer_view_main);
////    recyclerView.setHasFixedSize(false);
//    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Button save=root.findViewById(R.id.save_data);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String functionaliy1=functionaliy.getText().toString();
                onInputListener1.sendInput(functionaliy1);

                String equ=equipement.getText().toString();
                String work=workcenter.getText().toString();
                String desc=description.getText().toString();



                DataModel dataModel=new DataModel(functionaliy1,equ,work,desc);
                dataModelList.add(dataModel);

                dataAdapter=new DataAdapter(getContext(),dataModelList);
                recyclerView.setAdapter(dataAdapter);







//                DataAdapter dataAdapter=new DataAdapter(getContext(),dataModelList);
//                ((MainActivity)getActivity()).recyclerView.setAdapter(dataAdapter);





            }
        });

        return root;

//        super.onCreateView(inflater, container, savedInstanceState);


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            onInputListener1= (OnInputListener) getActivity();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
