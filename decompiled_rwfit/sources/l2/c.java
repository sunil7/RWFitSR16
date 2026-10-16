package l2;

import android.os.Parcel;
import android.util.SparseIntArray;

/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f15756d;
    public final Parcel e;

    /* renamed from: f, reason: collision with root package name */
    public final int f15757f;

    /* renamed from: g, reason: collision with root package name */
    public final int f15758g;

    /* renamed from: h, reason: collision with root package name */
    public final String f15759h;

    /* renamed from: i, reason: collision with root package name */
    public int f15760i;

    /* renamed from: j, reason: collision with root package name */
    public int f15761j;

    /* renamed from: k, reason: collision with root package name */
    public int f15762k;

    public c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new m0.b(), new m0.b(), new m0.b());
    }

    @Override // l2.b
    public final c a() {
        Parcel parcel = this.e;
        int dataPosition = parcel.dataPosition();
        int i3 = this.f15761j;
        if (i3 == this.f15757f) {
            i3 = this.f15758g;
        }
        return new c(parcel, dataPosition, i3, r5.a.f(new StringBuilder(), this.f15759h, "  "), this.f15753a, this.f15754b, this.f15755c);
    }

    @Override // l2.b
    public final boolean e(int i3) {
        while (this.f15761j < this.f15758g) {
            int i10 = this.f15762k;
            if (i10 == i3) {
                return true;
            }
            if (String.valueOf(i10).compareTo(String.valueOf(i3)) > 0) {
                return false;
            }
            int i11 = this.f15761j;
            Parcel parcel = this.e;
            parcel.setDataPosition(i11);
            int readInt = parcel.readInt();
            this.f15762k = parcel.readInt();
            this.f15761j += readInt;
        }
        return this.f15762k == i3;
    }

    @Override // l2.b
    public final void i(int i3) {
        int i10 = this.f15760i;
        SparseIntArray sparseIntArray = this.f15756d;
        Parcel parcel = this.e;
        if (i10 >= 0) {
            int i11 = sparseIntArray.get(i10);
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i11);
            parcel.writeInt(dataPosition - i11);
            parcel.setDataPosition(dataPosition);
        }
        this.f15760i = i3;
        sparseIntArray.put(i3, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i3);
    }

    public c(Parcel parcel, int i3, int i10, String str, m0.b bVar, m0.b bVar2, m0.b bVar3) {
        super(bVar, bVar2, bVar3);
        this.f15756d = new SparseIntArray();
        this.f15760i = -1;
        this.f15762k = -1;
        this.e = parcel;
        this.f15757f = i3;
        this.f15758g = i10;
        this.f15761j = i3;
        this.f15759h = str;
    }
}
