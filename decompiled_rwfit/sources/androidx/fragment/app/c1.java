package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentTabHost;

/* loaded from: classes.dex */
public final class c1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        FragmentTabHost.SavedState savedState = new FragmentTabHost.SavedState(parcel);
        savedState.f2123a = parcel.readString();
        return savedState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        return new FragmentTabHost.SavedState[i3];
    }
}
