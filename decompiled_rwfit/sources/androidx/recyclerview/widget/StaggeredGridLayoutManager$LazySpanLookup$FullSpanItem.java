package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> CREATOR = new f2();

    /* renamed from: a, reason: collision with root package name */
    public int f2496a;

    /* renamed from: b, reason: collision with root package name */
    public int f2497b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f2498c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2499d;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f2496a + ", mGapDir=" + this.f2497b + ", mHasUnwantedGapAfter=" + this.f2499d + ", mGapPerSpan=" + Arrays.toString(this.f2498c) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f2496a);
        parcel.writeInt(this.f2497b);
        parcel.writeInt(this.f2499d ? 1 : 0);
        int[] iArr = this.f2498c;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f2498c);
        }
    }
}
