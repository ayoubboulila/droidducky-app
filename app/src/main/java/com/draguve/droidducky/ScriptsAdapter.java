package com.draguve.droidducky;

/**
 * Created by Draguve on 1/3/2018.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class ScriptsAdapter extends RecyclerView.Adapter<ScriptsAdapter.MyViewHolder>{

    private List<Script> scriptList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }
    public ScriptsAdapter(List<Script> scriptList) {
        this.scriptList = scriptList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.script_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent codeEditorIntent = new Intent(v.getContext(),CodeEditor.class);
                codeEditorIntent.putExtra("idSelected",scriptList.get(position).getID());
                v.getContext().startActivity(codeEditorIntent);
            }
        });
        Script script = scriptList.get(position);
        holder.title.setText(script.getName());
        holder.genre.setText("Test");
        holder.year.setText("Test");
    }

    @Override
    public int getItemCount() {
        return scriptList.size();
    }
}
