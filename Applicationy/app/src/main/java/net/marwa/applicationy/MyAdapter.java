package net.marwa.applicationy;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Hall> {

    Activity activity;
    int resource;
    List<Hall> list;

    public MyAdapter(Activity activity, int resource, List<Hall> list) {
        super(activity, resource,list);
        this.activity = activity;
        this.resource = resource;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = activity.getLayoutInflater();

        View view = layoutInflater.inflate(resource,null);

        ImageView imageView = (ImageView) view.findViewById(R.id.getImages);
        TextView name = (TextView) view.findViewById(R.id.getName);
        TextView des = (TextView) view.findViewById(R.id.getDes);
        TextView address = (TextView) view.findViewById(R.id.getAddress);
        TextView price = (TextView) view.findViewById(R.id.getPrice);
        TextView capacity = (TextView) view.findViewById(R.id.getCapacity);

        name.setText(list.get(position).getName());
        des.setText(list.get(position).getDescription());
        address.setText(list.get(position).getAddress());
        price.setText(list.get(position).getPrice()+"");
        capacity.setText(list.get(position).getCapacity()+"");

        Glide.with(activity).load(list.get(position).getImageUri()).into(imageView);

        return view;
    }
}