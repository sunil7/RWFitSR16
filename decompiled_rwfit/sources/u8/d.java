package u8;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final long f19014a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f19015b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19016c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f19017d;
    public final long e;

    /* renamed from: f, reason: collision with root package name */
    public final List f19018f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f19019g;

    /* renamed from: h, reason: collision with root package name */
    public final long f19020h;

    /* renamed from: i, reason: collision with root package name */
    public final int f19021i;

    /* renamed from: j, reason: collision with root package name */
    public final int f19022j;

    /* renamed from: k, reason: collision with root package name */
    public final int f19023k;

    public d(Parcel parcel) {
        this.f19014a = parcel.readLong();
        this.f19015b = parcel.readByte() == 1;
        this.f19016c = parcel.readByte() == 1;
        this.f19017d = parcel.readByte() == 1;
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(new c(parcel.readInt(), parcel.readLong()));
        }
        this.f19018f = Collections.unmodifiableList(arrayList);
        this.e = parcel.readLong();
        this.f19019g = parcel.readByte() == 1;
        this.f19020h = parcel.readLong();
        this.f19021i = parcel.readInt();
        this.f19022j = parcel.readInt();
        this.f19023k = parcel.readInt();
    }
}
