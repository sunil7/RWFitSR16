package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new b(3);

    /* renamed from: a, reason: collision with root package name */
    public final String f2108a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2109b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2110c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2111d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final String f2112f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2113g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f2114h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f2115i;

    /* renamed from: j, reason: collision with root package name */
    public final Bundle f2116j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f2117k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2118l;

    /* renamed from: m, reason: collision with root package name */
    public Bundle f2119m;

    public FragmentState(Fragment fragment) {
        this.f2108a = fragment.getClass().getName();
        this.f2109b = fragment.mWho;
        this.f2110c = fragment.mFromLayout;
        this.f2111d = fragment.mFragmentId;
        this.e = fragment.mContainerId;
        this.f2112f = fragment.mTag;
        this.f2113g = fragment.mRetainInstance;
        this.f2114h = fragment.mRemoving;
        this.f2115i = fragment.mDetached;
        this.f2116j = fragment.mArguments;
        this.f2117k = fragment.mHidden;
        this.f2118l = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f2108a);
        sb2.append(" (");
        sb2.append(this.f2109b);
        sb2.append(")}:");
        if (this.f2110c) {
            sb2.append(" fromLayout");
        }
        int i3 = this.e;
        if (i3 != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(i3));
        }
        String str = this.f2112f;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(str);
        }
        if (this.f2113g) {
            sb2.append(" retainInstance");
        }
        if (this.f2114h) {
            sb2.append(" removing");
        }
        if (this.f2115i) {
            sb2.append(" detached");
        }
        if (this.f2117k) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f2108a);
        parcel.writeString(this.f2109b);
        parcel.writeInt(this.f2110c ? 1 : 0);
        parcel.writeInt(this.f2111d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f2112f);
        parcel.writeInt(this.f2113g ? 1 : 0);
        parcel.writeInt(this.f2114h ? 1 : 0);
        parcel.writeInt(this.f2115i ? 1 : 0);
        parcel.writeBundle(this.f2116j);
        parcel.writeInt(this.f2117k ? 1 : 0);
        parcel.writeBundle(this.f2119m);
        parcel.writeInt(this.f2118l);
    }

    public FragmentState(Parcel parcel) {
        this.f2108a = parcel.readString();
        this.f2109b = parcel.readString();
        this.f2110c = parcel.readInt() != 0;
        this.f2111d = parcel.readInt();
        this.e = parcel.readInt();
        this.f2112f = parcel.readString();
        this.f2113g = parcel.readInt() != 0;
        this.f2114h = parcel.readInt() != 0;
        this.f2115i = parcel.readInt() != 0;
        this.f2116j = parcel.readBundle();
        this.f2117k = parcel.readInt() != 0;
        this.f2119m = parcel.readBundle();
        this.f2118l = parcel.readInt();
    }
}
