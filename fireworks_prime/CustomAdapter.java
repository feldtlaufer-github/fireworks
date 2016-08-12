package huecomundo.muhich.fireworks_prime;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by plain on 3/15/2016.
 */
public class CustomAdapter extends ArrayAdapter<String> {
    final Context c;
    ArrayList<String> turnLog;
    public CustomAdapter(Context context, ArrayList<String> turnLog){
        super(context, R.layout.custom_row, turnLog);
        this.c = context;
        this.turnLog = turnLog;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.custom_row, parent, false);

        TextView tv = (TextView) row.findViewById(R.id.tvCustomRow);
        tv.setTextColor(Color.WHITE);
        tv.setText(turnLog.get(position));

        return row;
    }
}
