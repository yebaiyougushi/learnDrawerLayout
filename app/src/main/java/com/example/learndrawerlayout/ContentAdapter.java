package com.example.learndrawerlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContentAdapter extends BaseAdapter {
    private List<ContentModel> data;
    private Context context;
    public ContentAdapter(Context context, List<ContentModel> data){
        super();
        this.data = data;
        this.context = context;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder hold;
        if (convertView == null) {
            hold = new Holder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.content_item, null);
            convertView.setTag(hold);
        } else {
            hold = (Holder) convertView.getTag();
        }

        hold.imageView = (ImageView) convertView
                .findViewById(R.id.item_imageview);
        hold.textView = (TextView) convertView.findViewById(R.id.item_textview);

        hold.imageView.setImageResource(data.get(position).getImageView());
        hold.textView.setText(data.get(position).getText());
        return convertView;

    }
    public class Holder {
        public ImageView imageView;
        public TextView textView;
    }
}
