package com.example.uas_1615323053;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class ListViewArrayAdapter extends ArrayAdapter<Artikel> {
    public ListViewArrayAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_, parent, false);
        Artikel artikel = getItem(position);
        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        TextView title = (TextView) v.findViewById(R.id.textTitle);
        TextView timestamp = (TextView) v.findViewById(R.id.textTime);
        TextView descriptions =(TextView) v.findViewById(R.id.textDesc);

        img.setImageResource(artikel.getImageId());
        title.setText(artikel.getTitle());
        timestamp.setText(artikel.getTimestamp());
        descriptions.setText(artikel.getDescriptions());

        return v;
    }
}
