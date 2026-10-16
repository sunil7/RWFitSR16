package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new b(0);
    private static final String TAG = "FragmentManager";

    /* renamed from: a, reason: collision with root package name */
    public final int[] f2075a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2076b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f2077c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f2078d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final String f2079f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2080g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2081h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f2082i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2083j;

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence f2084k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f2085l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f2086m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f2087n;

    public BackStackState(a aVar) {
        int size = aVar.f2126a.size();
        this.f2075a = new int[size * 5];
        if (!aVar.f2131g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f2076b = new ArrayList(size);
        this.f2077c = new int[size];
        this.f2078d = new int[size];
        int i3 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            d1 d1Var = (d1) aVar.f2126a.get(i10);
            int i11 = i3 + 1;
            this.f2075a[i3] = d1Var.f2161a;
            ArrayList arrayList = this.f2076b;
            Fragment fragment = d1Var.f2162b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f2075a;
            iArr[i11] = d1Var.f2163c;
            iArr[i3 + 2] = d1Var.f2164d;
            int i12 = i3 + 4;
            iArr[i3 + 3] = d1Var.e;
            i3 += 5;
            iArr[i12] = d1Var.f2165f;
            this.f2077c[i10] = d1Var.f2166g.ordinal();
            this.f2078d[i10] = d1Var.f2167h.ordinal();
        }
        this.e = aVar.f2130f;
        this.f2079f = aVar.f2132h;
        this.f2080g = aVar.r;
        this.f2081h = aVar.f2133i;
        this.f2082i = aVar.f2134j;
        this.f2083j = aVar.f2135k;
        this.f2084k = aVar.f2136l;
        this.f2085l = aVar.f2137m;
        this.f2086m = aVar.f2138n;
        this.f2087n = aVar.f2139o;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeIntArray(this.f2075a);
        parcel.writeStringList(this.f2076b);
        parcel.writeIntArray(this.f2077c);
        parcel.writeIntArray(this.f2078d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f2079f);
        parcel.writeInt(this.f2080g);
        parcel.writeInt(this.f2081h);
        TextUtils.writeToParcel(this.f2082i, parcel, 0);
        parcel.writeInt(this.f2083j);
        TextUtils.writeToParcel(this.f2084k, parcel, 0);
        parcel.writeStringList(this.f2085l);
        parcel.writeStringList(this.f2086m);
        parcel.writeInt(this.f2087n ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f2075a = parcel.createIntArray();
        this.f2076b = parcel.createStringArrayList();
        this.f2077c = parcel.createIntArray();
        this.f2078d = parcel.createIntArray();
        this.e = parcel.readInt();
        this.f2079f = parcel.readString();
        this.f2080g = parcel.readInt();
        this.f2081h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f2082i = (CharSequence) creator.createFromParcel(parcel);
        this.f2083j = parcel.readInt();
        this.f2084k = (CharSequence) creator.createFromParcel(parcel);
        this.f2085l = parcel.createStringArrayList();
        this.f2086m = parcel.createStringArrayList();
        this.f2087n = parcel.readInt() != 0;
    }
}
