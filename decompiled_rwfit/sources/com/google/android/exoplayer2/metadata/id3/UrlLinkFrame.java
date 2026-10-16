package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import i9.g;
import q9.o;
import r5.a;

/* loaded from: classes.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new o(17);
    public final String description;
    public final String url;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public UrlLinkFrame(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = i9.g.f14378a
            r2.<init>(r0)
            java.lang.String r0 = r3.readString()
            r2.description = r0
            java.lang.String r3 = r3.readString()
            r2.url = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.UrlLinkFrame.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && UrlLinkFrame.class == obj.getClass()) {
            UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
            if (this.f8889id.equals(urlLinkFrame.f8889id) && g.a(this.description, urlLinkFrame.description) && g.a(this.url, urlLinkFrame.url)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int d5 = l0.d(527, 31, this.f8889id);
        String str = this.description;
        int hashCode = (d5 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.url;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        String str = this.f8889id;
        String str2 = this.url;
        return a.b(a.a(a.a(6, str), str2), str, ": url=", str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f8889id);
        parcel.writeString(this.description);
        parcel.writeString(this.url);
    }
}
