package com.luohong.daddycontacts.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/**
 * Created by luohong on 15/11/23.
 */
public class ContactsHelper {

    private static final String TAG = ContactsHelper.class.getSimpleName();

    //查询所有联系人的姓名，电话，邮箱
    public static void queryContacts(Context context) throws Exception {
        Uri uri = Uri.parse("content://com.android.contacts/contacts");
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(uri, new String[]{"_id"}, null, null, null);
        while (cursor.moveToNext()) {
            int contractID = cursor.getInt(0);
            StringBuilder sb = new StringBuilder("contractID=");
            sb.append(contractID);
            uri = Uri.parse("content://com.android.contacts/contacts/" + contractID + "/data");
            Cursor cursor1 = resolver.query(uri, new String[]{"mimetype", "data1", "data2"}, null, null, null);
            while (cursor1.moveToNext()) {
                String data1 = cursor1.getString(cursor1.getColumnIndex("data1"));
                String mimeType = cursor1.getString(cursor1.getColumnIndex("mimetype"));
                if ("vnd.android.cursor.item/name".equals(mimeType)) { //是姓名
                    sb.append(",name=" + data1);
                } else if ("vnd.android.cursor.item/photo".equals(mimeType)) { //邮箱
                    sb.append(",email=" + data1);
                } else if ("vnd.android.cursor.item/phone_v2".equals(mimeType)) { //手机
                    sb.append(",phone=" + data1);
                }
            }
            cursor1.close();
            Log.i(TAG, sb.toString());
        }
        cursor.close();
    }

}
