package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import ha.d;
import l2.c;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new d(2);
    private final l2.d mParcel;

    public ParcelImpl(Parcel parcel) {
        this.mParcel = new c(parcel).h();
    }

    public final l2.d a() {
        return this.mParcel;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        new c(parcel).l(this.mParcel);
    }
}
