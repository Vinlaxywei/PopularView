package com.example.hhoo7.popularview;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hhoo7.popularview.data.MovieContract;

public class MovieAdapter extends CursorAdapter {

    public MovieAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    /*
    * 返回一个新的视图Item
    * */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.gridview_item, parent, false);
        return view;
    }

    /*
    * 使用cursor中的数据填充新的视图Item
    * */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView imageView = (ImageView) view.findViewById(R.id.poster_imageview);
        String posterUri = cursor.getString(cursor.getColumnIndex(MovieContract.DetailEntry.COLUMN_POSTER_PATH));
        Utility.loadPicture(context, posterUri, imageView);
    }
}
