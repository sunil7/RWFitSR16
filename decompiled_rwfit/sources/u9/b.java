package u9;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.internal.mlkit_vision_common.t;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int t8 = t.t(parcel);
        ArrayList arrayList = null;
        String str = null;
        boolean z5 = false;
        String str2 = null;
        while (parcel.dataPosition() < t8) {
            int readInt = parcel.readInt();
            char c9 = (char) readInt;
            if (c9 == 1) {
                arrayList = t.j(parcel, readInt, Feature.CREATOR);
            } else if (c9 == 2) {
                z5 = t.l(parcel, readInt);
            } else if (c9 == 3) {
                str2 = t.g(parcel, readInt);
            } else if (c9 != 4) {
                t.s(parcel, readInt);
            } else {
                str = t.g(parcel, readInt);
            }
        }
        t.k(parcel, t8);
        return new ApiFeatureRequest(arrayList, z5, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new ApiFeatureRequest[i3];
    }
}
