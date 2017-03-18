package org.pensionplan.pensionplan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by owner on 2/5/2017.
 */
public class TrusteesListAdapter extends ArrayAdapter<Trustees>{

    Context mContext;
    private int layoutResourceId;
    private List<Trustees> details;

    @Override
    public int getCount(){
        return details.size();
    }

    public TrusteesListAdapter(Context mContext, int layoutResourceId, List<Trustees> detailsList) {

        super(mContext, layoutResourceId);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.details = detailsList ;
    }






    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        /*
         * The convertView argument is essentially a "ScrapView" as described is Lucas post
         * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
         * It will have a non-null value when ListView is asking you recycle the row layout.
         * So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
         */
        if (convertView == null) {
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        // object item based on the position

        Trustees message = details.get(position);
        // get the TextView and then set the text (item name) and tag (item ID) values

        //find views
        TextView textView = (TextView) convertView.findViewById(R.id.name_text);
        TextView textViewOne = (TextView) convertView.findViewById(R.id.loc_text);


        //set properties
        textView.setText(message.getName());
        textViewOne.setText(message.getLocation());


        return convertView;

    }

}






