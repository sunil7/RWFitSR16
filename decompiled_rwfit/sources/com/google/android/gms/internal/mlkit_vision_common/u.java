package com.google.android.gms.internal.mlkit_vision_common;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public abstract class u {
    public static void a(Parcel parcel, int i3, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int i10 = i(parcel, i3);
        parcel.writeBundle(bundle);
        j(parcel, i10);
    }

    public static void b(Parcel parcel, int i3, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int i10 = i(parcel, i3);
        parcel.writeByteArray(bArr);
        j(parcel, i10);
    }

    public static void c(Parcel parcel, int i3, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int i10 = i(parcel, i3);
        parcel.writeStrongBinder(iBinder);
        j(parcel, i10);
    }

    public static void d(Parcel parcel, int i3, Parcelable parcelable, int i10) {
        if (parcelable == null) {
            return;
        }
        int i11 = i(parcel, i3);
        parcelable.writeToParcel(parcel, i10);
        j(parcel, i11);
    }

    public static void e(Parcel parcel, int i3, String str) {
        if (str == null) {
            return;
        }
        int i10 = i(parcel, i3);
        parcel.writeString(str);
        j(parcel, i10);
    }

    public static void f(Parcel parcel, int i3, String[] strArr) {
        if (strArr == null) {
            return;
        }
        int i10 = i(parcel, i3);
        parcel.writeStringArray(strArr);
        j(parcel, i10);
    }

    public static void g(Parcel parcel, int i3, Parcelable[] parcelableArr, int i10) {
        if (parcelableArr == null) {
            return;
        }
        int i11 = i(parcel, i3);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int dataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int dataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i10);
                int dataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(dataPosition);
                parcel.writeInt(dataPosition3 - dataPosition2);
                parcel.setDataPosition(dataPosition3);
            }
        }
        j(parcel, i11);
    }

    public static void h(Parcel parcel, int i3, List list) {
        if (list == null) {
            return;
        }
        int i10 = i(parcel, i3);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            Parcelable parcelable = (Parcelable) list.get(i11);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int dataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int dataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int dataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(dataPosition);
                parcel.writeInt(dataPosition3 - dataPosition2);
                parcel.setDataPosition(dataPosition3);
            }
        }
        j(parcel, i10);
    }

    public static int i(Parcel parcel, int i3) {
        parcel.writeInt(i3 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void j(Parcel parcel, int i3) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i3 - 4);
        parcel.writeInt(dataPosition - i3);
        parcel.setDataPosition(dataPosition);
    }

    public static void k(Parcel parcel, int i3, int i10) {
        parcel.writeInt(i3 | (i10 << 16));
    }
}
