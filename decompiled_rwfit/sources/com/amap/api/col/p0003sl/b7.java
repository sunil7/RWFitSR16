package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.poisearch.PoiSearchV2;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
abstract class b7<T, V> extends f6<T, V> {
    public b7(Context context, T t8) {
        super(context, t8);
    }

    public String a(PoiSearchV2.ShowFields showFields) {
        if (showFields == null || showFields.getValue() == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        if ((showFields.getValue() & 1) != 0) {
            sb2.append("children,");
        }
        if ((showFields.getValue() & 2) != 0) {
            sb2.append("business,");
        }
        if ((showFields.getValue() & 4) != 0) {
            sb2.append("indoor,");
        }
        if ((showFields.getValue() & 8) != 0) {
            sb2.append("navi,");
        }
        if ((showFields.getValue() & 16) != 0) {
            sb2.append("photos,");
        }
        if (sb2.length() <= 0) {
            return null;
        }
        sb2.replace(sb2.length() - 1, sb2.length(), "");
        return sb2.toString();
    }

    public boolean e(String str) {
        return str == null || str.equals("") || str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }
}
