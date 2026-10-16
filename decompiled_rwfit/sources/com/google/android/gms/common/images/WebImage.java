package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.u;
import java.util.Arrays;
import java.util.Locale;
import q9.n;

/* loaded from: classes.dex */
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new g(20);

    /* renamed from: a, reason: collision with root package name */
    public final int f9096a;
    private final Uri zab;
    private final int zac;
    private final int zad;

    public WebImage(int i3, Uri uri, int i10, int i11) {
        this.f9096a = i3;
        this.zab = uri;
        this.zac = i10;
        this.zad = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (n.h(this.zab, webImage.zab) && this.zac == webImage.zac && this.zad == webImage.zad) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zab, Integer.valueOf(this.zac), Integer.valueOf(this.zad)});
    }

    public final String toString() {
        Locale locale = Locale.US;
        int i3 = this.zac;
        int i10 = this.zad;
        String uri = this.zab.toString();
        StringBuilder s7 = l0.s(i3, "Image ", i10, "x", " ");
        s7.append(uri);
        return s7.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9096a);
        u.d(parcel, 2, this.zab, i3);
        int i11 = this.zac;
        u.k(parcel, 3, 4);
        parcel.writeInt(i11);
        int i12 = this.zad;
        u.k(parcel, 4, 4);
        parcel.writeInt(i12);
        u.j(parcel, i10);
    }
}
