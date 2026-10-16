package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;

/* loaded from: classes.dex */
public final class q0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        LinearLayoutManager.SavedState savedState = new LinearLayoutManager.SavedState();
        savedState.f2437a = parcel.readInt();
        savedState.f2438b = parcel.readInt();
        savedState.f2439c = parcel.readInt() == 1;
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        return new LinearLayoutManager.SavedState[i3];
    }
}
