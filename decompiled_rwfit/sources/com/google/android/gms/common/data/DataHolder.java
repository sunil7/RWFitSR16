package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import p9.a;
import p9.b;

@KeepName
/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable, AutoCloseable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new d(20);
    private static final a zaf;

    /* renamed from: a, reason: collision with root package name */
    public final int f9092a;

    /* renamed from: b, reason: collision with root package name */
    public Bundle f9093b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f9094c;
    private final String[] zag;
    private final CursorWindow[] zah;
    private final int zai;
    private final Bundle zaj;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9095d = false;
    private boolean zak = true;

    static {
        b bVar = new b();
        new ArrayList();
        new HashMap();
        zaf = bVar;
    }

    public DataHolder(int i3, String[] strArr, CursorWindow[] cursorWindowArr, int i10, Bundle bundle) {
        this.f9092a = i3;
        this.zag = strArr;
        this.zah = cursorWindowArr;
        this.zai = i10;
        this.zaj = bundle;
    }

    public final void b() {
        this.f9093b = new Bundle();
        int i3 = 0;
        int i10 = 0;
        while (true) {
            String[] strArr = this.zag;
            if (i10 >= strArr.length) {
                break;
            }
            this.f9093b.putInt(strArr[i10], i10);
            i10++;
        }
        this.f9094c = new int[this.zah.length];
        int i11 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zah;
            if (i3 >= cursorWindowArr.length) {
                return;
            }
            this.f9094c[i3] = i11;
            i11 += this.zah[i3].getNumRows() - (i11 - cursorWindowArr[i3].getStartPosition());
            i3++;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            try {
                if (!this.f9095d) {
                    this.f9095d = true;
                    int i3 = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.zah;
                        if (i3 >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i3].close();
                        i3++;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void finalize() {
        boolean z5;
        try {
            if (this.zak && this.zah.length > 0) {
                synchronized (this) {
                    z5 = this.f9095d;
                }
                if (!z5) {
                    close();
                    Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + toString() + ")");
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String[] strArr = this.zag;
        int i10 = u.i(parcel, 20293);
        u.f(parcel, 1, strArr);
        u.g(parcel, 2, this.zah, i3);
        int i11 = this.zai;
        u.k(parcel, 3, 4);
        parcel.writeInt(i11);
        u.a(parcel, 4, this.zaj);
        u.k(parcel, 1000, 4);
        parcel.writeInt(this.f9092a);
        u.j(parcel, i10);
        if ((i3 & 1) != 0) {
            close();
        }
    }
}
