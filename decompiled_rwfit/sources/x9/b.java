package x9;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import com.google.android.gms.internal.mlkit_vision_common.t;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int t8 = t.t(parcel);
        String str = null;
        String str2 = null;
        zaa zaaVar = null;
        int i3 = 0;
        int i10 = 0;
        boolean z5 = false;
        int i11 = 0;
        boolean z6 = false;
        int i12 = 0;
        while (parcel.dataPosition() < t8) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i3 = t.o(parcel, readInt);
                    break;
                case 2:
                    i10 = t.o(parcel, readInt);
                    break;
                case 3:
                    z5 = t.l(parcel, readInt);
                    break;
                case 4:
                    i11 = t.o(parcel, readInt);
                    break;
                case 5:
                    z6 = t.l(parcel, readInt);
                    break;
                case 6:
                    str = t.g(parcel, readInt);
                    break;
                case 7:
                    i12 = t.o(parcel, readInt);
                    break;
                case '\b':
                    str2 = t.g(parcel, readInt);
                    break;
                case '\t':
                    zaaVar = (zaa) t.f(parcel, readInt, zaa.CREATOR);
                    break;
                default:
                    t.s(parcel, readInt);
                    break;
            }
        }
        t.k(parcel, t8);
        return new FastJsonResponse$Field(i3, i10, z5, i11, z6, str, i12, str2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new FastJsonResponse$Field[i3];
    }
}
