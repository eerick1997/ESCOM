package Adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.erick.adooproject.ActivityStations;
import com.example.erick.adooproject.R;

import java.util.ArrayList;

import Objects.Line;
import UIElements.ChangeStyle;

public class AdapterLines extends Adapter<AdapterLines.LinesViewHolder> {

    //Constants
    private static final String TAG = "Adapterlines.java";
    //Variables
    private ArrayList<Line> lines;
    private Activity activity;
    private ChangeStyle style;
    private String type;

    public class LinesViewHolder extends RecyclerView.ViewHolder{

        //Constants
        private static final String TAG = "LinesViewHolder.java";
        //Variables
        private TextView TXT_line;
        private TextView TXT_color;

        public LinesViewHolder(View view){
            super(view);
            //Getting interface elements
            TXT_line = view.findViewById(R.id.line_info_text);
            TXT_color = view.findViewById(R.id.line_info_color);
        }

        //This method manipulates interface
        public void bindName(Line line){
            Log.d(TAG, "bindName() called with: line = [" + line + "]");
            String line_text = line.getStations().get(0).getName() + " - " +
                    line.getStations().get(line.getStations().size() - 1).getName();
            TXT_line.setText(line_text);
            TXT_color.setBackgroundColor(Color.parseColor(style.getLineColor(line.getWhichLine())));
            String txt_replace = "metro";
            if (type.equals("Metrobus"))
                txt_replace = "metrobus";
            String txtL = line.getWhichLine().replace(txt_replace.trim(), "");
            Log.i(TAG, "Line: " + txtL);
            TXT_color.setText(txtL.toUpperCase().replace(" ", ""));
        }
    }

    //Constructor super class
    public AdapterLines(ArrayList<Line> lines, Activity activity, String type) {
        this.lines = lines;
        this.activity = activity;
        style = new ChangeStyle(this.activity);
        this.type = type;
    }

    @Override
    public LinesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.line_info_element, viewGroup, false);
        LinesViewHolder linesViewHolder = new LinesViewHolder(itemView);
        return linesViewHolder;
    }

    @Override
    public void onBindViewHolder(LinesViewHolder viewHolder, final int position){
        Log.d(TAG, "onBindViewHolder() called with: viewHolder = [" + viewHolder + "], position = [" + position + "]");
        final Line line = lines.get(position);
        viewHolder.bindName(line);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ActivityStations.class);
                intent.putParcelableArrayListExtra("Stations", line.getStations());
                intent.putExtra("color", line.getWhichLine());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount(){
        Log.d(TAG, "getItemCount() returned: " + lines.size());
        return lines.size();
    }

}