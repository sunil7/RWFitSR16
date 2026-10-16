package com.tencent.mmkv;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes2.dex */
public class MMKVContentProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    public static Uri f11902a;

    public final Bundle a(int i3, int i10, String str, String str2) {
        MMKV r = MMKV.r(getContext(), str, i3, i10, str2);
        ParcelableMMKV parcelableMMKV = new ParcelableMMKV(r);
        StringBuilder u10 = l0.u(str, " fd = ");
        u10.append(r.ashmemFD());
        u10.append(", meta fd = ");
        u10.append(r.ashmemMetaFD());
        Log.i("MMKV", u10.toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY", parcelableMMKV);
        return bundle;
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        if (str.equals("mmkvFromAshmemID") && bundle != null) {
            try {
                return a(bundle.getInt("KEY_SIZE"), bundle.getInt("KEY_MODE"), str2, bundle.getString("KEY_CRYPT"));
            } catch (Exception e) {
                Log.e("MMKV", e.getMessage());
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return getContext() != null;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }
}
