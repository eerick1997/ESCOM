package Adapters;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.erick.adooproject.R;

import java.util.ArrayList;

import Objects.ElementAdapter;
import Objects.Exit;
import Objects.Service;

public class AdapterStationsInfo extends Adapter<AdapterStationsInfo.StationsInfoViewHolder> implements View.OnClickListener{


    //Variables
    private View.OnClickListener listener;
    private ArrayList<Object> objects;
    //private ArrayList<ElementAdapter> elementsAdapter;

    public static class StationsInfoViewHolder extends RecyclerView.ViewHolder{

        //Constants
        private static final String TAG = "AdapterStationsInfo.java";
        //Variables
        private TextView TXT_title, TXT_Description;
        private ImageView IV_Icon;

        public StationsInfoViewHolder(View view){
            super(view);
            TXT_title = (TextView)view.findViewById(R.id.station_info_element_title);
            TXT_Description = (TextView)view.findViewById(R.id.station_info_element_description);
            IV_Icon = (ImageView)view.findViewById(R.id.station_info_element_image);
        }

        //This method sets text in our TextView;
        @SuppressLint("LongLogTag")
        public void bindName(/**ElementAdapter elementsAdapter**/Object object){
            //Log.d(TAG, "bindName() called with: elementsAdapter = [" + elementsAdapter + "]");
            //TXT_title.setText(elementsAdapter.getTitle());
            //TXT_Description.setText(elementsAdapter.getDescription());
            Log.d(TAG, "bindName() called with: object = [" + object + "]");
            if(object instanceof Service){
                Service service = (Service)object;
                TXT_title.setText(((Service) object).getName());
                String title = service.getName().trim();
                if(title.contains("BICI"))
                    IV_Icon.setBackgroundResource(R.mipmap.ic_bici);
                else if(title.contains("DISCAPACIDAD"))
                    IV_Icon.setBackgroundResource(R.mipmap.ic_acces);
                else if(title.contains("SALUD"))
                    IV_Icon.setBackgroundResource(R.mipmap.ic_salud);
                else if(title.contains("TROLEBUS"))
                    IV_Icon.setBackgroundResource(R.mipmap.ic_trolebus);
                else if(title.contains("INMUJERES"))
                    IV_Icon.setBackgroundResource(R.mipmap.ic_inmujeres);
                else if(title.contains("VITRINA"))
                    IV_Icon.setBackgroundResource(R.mipmap.ic_vitrina);
                else if (title.contains("MURAL"))
                    IV_Icon.setBackgroundResource(R.mipmap.ic_murales);
                else if(title.contains("MINISTERIO"))
                    IV_Icon.setBackgroundResource(R.mipmap.ic_mp);
                else if(title.contains("METROBUS"))
                    IV_Icon.setBackgroundResource(R.mipmap.ic_mbus);
                else if(title.contains("CIBER"))
                    IV_Icon.setBackgroundResource(R.mipmap.ic_ciber);
                else if(title.contains("TROLEBUS"))
                    IV_Icon.setBackgroundResource(R.mipmap.ic_trolebus);
                else
                    IV_Icon.setBackgroundResource(R.mipmap.event_by_user);
                TXT_Description.setText(((Service) object).getDescription());
            } else if(object instanceof Exit){
                TXT_title.setText("Salida " + ((Exit)object).getName());
                TXT_Description.setText(((Exit)object).getStreets());
                IV_Icon.setBackgroundResource(R.drawable.comment_arrow_right);
            }
            //IV_Icon.setBackgroundResource(R.mipmap.ic_women_module);
        }
    }

    //Constructor
    public AdapterStationsInfo(ArrayList<Object> objects/**ArrayList<ElementAdapter> elementsAdapter**/){
        /**this.elementsAdapter = elementsAdapter;**/
        this.objects = objects;
    }

    @Override
    public StationsInfoViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.station_info_title, viewGroup, false);
        itemView.setOnClickListener(this);
        StationsInfoViewHolder stationsViewHolder = new StationsInfoViewHolder(itemView);
        return stationsViewHolder;
    }

    @Override
    public void onBindViewHolder(StationsInfoViewHolder viewHolder, int position) {

        //ElementAdapter elementAdapter = elementsAdapter.get(position);
        Object object = objects.get(position);
        viewHolder.bindName(/**elementAdapter**/ object);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public void setOnClickLister(View.OnClickListener lister){
        this.listener = lister;
    }
}
