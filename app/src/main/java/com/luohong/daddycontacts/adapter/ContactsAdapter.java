package com.luohong.daddycontacts.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import com.luohong.daddycontacts.R;

/**
 * Created by luohong on 15/11/23.
 */
public class ContactsAdapter extends CursorAdapter {


    public ContactsAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return View.inflate(context, R.layout.item_contacts, parent);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}
