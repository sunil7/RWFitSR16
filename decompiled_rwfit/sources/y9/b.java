package y9;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.stats.WakeLockEvent;
import com.google.android.gms.internal.mlkit_vision_common.t;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int t8 = t.t(parcel);
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z5 = false;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        long j4 = 0;
        long j10 = 0;
        long j11 = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < t8) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i3 = t.o(parcel, readInt);
                    break;
                case 2:
                    j4 = t.p(parcel, readInt);
                    break;
                case 3:
                case 7:
                case '\t':
                default:
                    t.s(parcel, readInt);
                    break;
                case 4:
                    str = t.g(parcel, readInt);
                    break;
                case 5:
                    i11 = t.o(parcel, readInt);
                    break;
                case 6:
                    int r = t.r(parcel, readInt);
                    int dataPosition = parcel.dataPosition();
                    if (r != 0) {
                        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                        parcel.setDataPosition(dataPosition + r);
                        arrayList = createStringArrayList;
                        break;
                    } else {
                        arrayList = null;
                        break;
                    }
                case '\b':
                    j10 = t.p(parcel, readInt);
                    break;
                case '\n':
                    str3 = t.g(parcel, readInt);
                    break;
                case 11:
                    i10 = t.o(parcel, readInt);
                    break;
                case '\f':
                    str2 = t.g(parcel, readInt);
                    break;
                case '\r':
                    str4 = t.g(parcel, readInt);
                    break;
                case 14:
                    i12 = t.o(parcel, readInt);
                    break;
                case 15:
                    t.u(parcel, readInt, 4);
                    f2 = parcel.readFloat();
                    break;
                case 16:
                    j11 = t.p(parcel, readInt);
                    break;
                case 17:
                    str5 = t.g(parcel, readInt);
                    break;
                case 18:
                    z5 = t.l(parcel, readInt);
                    break;
            }
        }
        t.k(parcel, t8);
        return new WakeLockEvent(i3, j4, i10, str, i11, arrayList, str2, j10, i12, str3, str4, f2, j11, str5, z5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new WakeLockEvent[i3];
    }
}
