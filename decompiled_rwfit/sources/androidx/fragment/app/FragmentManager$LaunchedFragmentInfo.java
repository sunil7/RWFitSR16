package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
class FragmentManager$LaunchedFragmentInfo implements Parcelable {
    public static final Parcelable.Creator<FragmentManager$LaunchedFragmentInfo> CREATOR = new b(1);

    /* renamed from: a, reason: collision with root package name */
    public String f2099a;

    /* renamed from: b, reason: collision with root package name */
    public int f2100b;

    public FragmentManager$LaunchedFragmentInfo(String str, int i3) {
        this.f2099a = str;
        this.f2100b = i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f2099a);
        parcel.writeInt(this.f2100b);
    }
}
