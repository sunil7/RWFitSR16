package oc;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.mlkit_vision_common.t;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;

/* loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int t8 = t.t(parcel);
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < t8) {
            int readInt = parcel.readInt();
            char c9 = (char) readInt;
            if (c9 == 1) {
                i3 = t.o(parcel, readInt);
            } else if (c9 == 2) {
                i10 = t.o(parcel, readInt);
            } else if (c9 == 3) {
                i11 = t.o(parcel, readInt);
            } else if (c9 == 4) {
                j4 = t.p(parcel, readInt);
            } else if (c9 != 5) {
                t.s(parcel, readInt);
            } else {
                i12 = t.o(parcel, readInt);
            }
        }
        t.k(parcel, t8);
        return new VisionImageMetadataParcel(j4, i3, i10, i11, i12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new VisionImageMetadataParcel[i3];
    }
}
