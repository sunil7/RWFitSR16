package com.google.android.gms.internal.mlkit_vision_barcode;

import android.database.Cursor;

/* loaded from: classes.dex */
public abstract class mb {
    public static int a(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndexOrThrow("`" + str + "`");
    }
}
