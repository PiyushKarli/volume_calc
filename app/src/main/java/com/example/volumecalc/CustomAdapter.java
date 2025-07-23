package com.example.volumecalc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Shape> {

    Context context;
    private ArrayList<Shape> shapeArrayList;

    public CustomAdapter( Context context, ArrayList<Shape> shapeArrayList) {
        super(context, R.layout.grid_item_layout, shapeArrayList);
        this.context = context;
        this.shapeArrayList = shapeArrayList;
    }

    private static class ViewHolder {
        TextView shapeName;
        ImageView shapeImg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Shape shapes = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.grid_item_layout,parent,false);

            viewHolder.shapeName = (TextView) convertView.findViewById(R.id.textView);
            viewHolder.shapeImg = (ImageView) convertView.findViewById(R.id.imageview);
            convertView.setTag(viewHolder);


        }else{

            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.shapeName.setText(shapes.getShapeName());
        viewHolder.shapeImg.setImageResource(shapes.getShapeImg());

        return convertView;
    }
}
