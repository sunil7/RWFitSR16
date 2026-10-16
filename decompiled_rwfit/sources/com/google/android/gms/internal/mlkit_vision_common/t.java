package com.google.android.gms.internal.mlkit_vision_common;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class t {
    public static BigDecimal a(Parcel parcel, int i3) {
        int r = r(parcel, i3);
        int dataPosition = parcel.dataPosition();
        if (r == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + r);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static Bundle b(Parcel parcel, int i3) {
        int r = r(parcel, i3);
        int dataPosition = parcel.dataPosition();
        if (r == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + r);
        return readBundle;
    }

    public static byte[] c(Parcel parcel, int i3) {
        int r = r(parcel, i3);
        int dataPosition = parcel.dataPosition();
        if (r == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + r);
        return createByteArray;
    }

    public static float[] d(Parcel parcel, int i3) {
        int r = r(parcel, i3);
        int dataPosition = parcel.dataPosition();
        if (r == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + r);
        return createFloatArray;
    }

    public static int[] e(Parcel parcel, int i3) {
        int r = r(parcel, i3);
        int dataPosition = parcel.dataPosition();
        if (r == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + r);
        return createIntArray;
    }

    public static Parcelable f(Parcel parcel, int i3, Parcelable.Creator creator) {
        int r = r(parcel, i3);
        int dataPosition = parcel.dataPosition();
        if (r == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + r);
        return parcelable;
    }

    public static String g(Parcel parcel, int i3) {
        int r = r(parcel, i3);
        int dataPosition = parcel.dataPosition();
        if (r == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + r);
        return readString;
    }

    public static String[] h(Parcel parcel, int i3) {
        int r = r(parcel, i3);
        int dataPosition = parcel.dataPosition();
        if (r == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + r);
        return createStringArray;
    }

    public static Object[] i(Parcel parcel, int i3, Parcelable.Creator creator) {
        int r = r(parcel, i3);
        int dataPosition = parcel.dataPosition();
        if (r == 0) {
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + r);
        return createTypedArray;
    }

    public static ArrayList j(Parcel parcel, int i3, Parcelable.Creator creator) {
        int r = r(parcel, i3);
        int dataPosition = parcel.dataPosition();
        if (r == 0) {
            return null;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + r);
        return createTypedArrayList;
    }

    public static void k(Parcel parcel, int i3) {
        if (parcel.dataPosition() != i3) {
            throw new SafeParcelReader$ParseException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "Overread allowed size end="), parcel);
        }
    }

    public static boolean l(Parcel parcel, int i3) {
        u(parcel, i3, 4);
        return parcel.readInt() != 0;
    }

    public static double m(Parcel parcel, int i3) {
        u(parcel, i3, 8);
        return parcel.readDouble();
    }

    public static IBinder n(Parcel parcel, int i3) {
        int r = r(parcel, i3);
        int dataPosition = parcel.dataPosition();
        if (r == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + r);
        return readStrongBinder;
    }

    public static int o(Parcel parcel, int i3) {
        u(parcel, i3, 4);
        return parcel.readInt();
    }

    public static long p(Parcel parcel, int i3) {
        u(parcel, i3, 8);
        return parcel.readLong();
    }

    public static Long q(Parcel parcel, int i3) {
        int r = r(parcel, i3);
        if (r == 0) {
            return null;
        }
        if (r == 8) {
            return Long.valueOf(parcel.readLong());
        }
        throw new SafeParcelReader$ParseException("Expected size 8 got " + r + " (0x" + Integer.toHexString(r) + ")", parcel);
    }

    public static int r(Parcel parcel, int i3) {
        return (i3 & (-65536)) != -65536 ? (char) (i3 >> 16) : parcel.readInt();
    }

    public static void s(Parcel parcel, int i3) {
        parcel.setDataPosition(parcel.dataPosition() + r(parcel, i3));
    }

    public static int t(Parcel parcel) {
        int readInt = parcel.readInt();
        int r = r(parcel, readInt);
        char c9 = (char) readInt;
        int dataPosition = parcel.dataPosition();
        if (c9 != 20293) {
            throw new SafeParcelReader$ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(readInt))), parcel);
        }
        int i3 = r + dataPosition;
        if (i3 < dataPosition || i3 > parcel.dataSize()) {
            throw new SafeParcelReader$ParseException(com.google.android.gms.internal.mlkit_vision_barcode.l0.i(dataPosition, i3, "Size read is invalid start=", " end="), parcel);
        }
        return i3;
    }

    public static void u(Parcel parcel, int i3, int i10) {
        int r = r(parcel, i3);
        if (r == i10) {
            return;
        }
        throw new SafeParcelReader$ParseException(r5.a.f(com.google.android.gms.internal.mlkit_vision_barcode.l0.s(i10, "Expected size ", r, " got ", " (0x"), Integer.toHexString(r), ")"), parcel);
    }
}
