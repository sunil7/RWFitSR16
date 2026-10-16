package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new b(2);

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f2101a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f2102b;

    /* renamed from: c, reason: collision with root package name */
    public BackStackState[] f2103c;

    /* renamed from: d, reason: collision with root package name */
    public int f2104d;
    public String e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f2105f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f2106g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f2107h;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.f2101a);
        parcel.writeStringList(this.f2102b);
        parcel.writeTypedArray(this.f2103c, i3);
        parcel.writeInt(this.f2104d);
        parcel.writeString(this.e);
        parcel.writeStringList(this.f2105f);
        parcel.writeTypedList(this.f2106g);
        parcel.writeTypedList(this.f2107h);
    }
}
