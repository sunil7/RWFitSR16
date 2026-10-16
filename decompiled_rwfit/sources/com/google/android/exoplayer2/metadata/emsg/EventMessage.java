package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.metadata.Metadata;
import ha.d;
import java.util.Arrays;
import r5.a;

/* loaded from: classes.dex */
public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR;
    private static final Format ID3_FORMAT;
    public static final String ID3_SCHEME_ID_AOM = "https://aomedia.org/emsg/ID3";
    private static final String ID3_SCHEME_ID_APPLE = "https://developer.apple.com/streaming/emsg-id3";
    private static final Format SCTE35_FORMAT;
    public static final String SCTE35_SCHEME_ID = "urn:scte:scte35:2014:bin";
    public final long durationMs;
    private int hashCode;

    /* renamed from: id, reason: collision with root package name */
    public final long f8888id;
    public final byte[] messageData;
    public final String schemeIdUri;
    public final String value;

    static {
        g gVar = new g();
        gVar.f8848c = "application/id3";
        ID3_FORMAT = new Format(gVar);
        g gVar2 = new g();
        gVar2.f8848c = "application/x-scte35";
        SCTE35_FORMAT = new Format(gVar2);
        CREATOR = new d(18);
    }

    public EventMessage(Parcel parcel) {
        String readString = parcel.readString();
        int i3 = i9.g.f14378a;
        this.schemeIdUri = readString;
        this.value = parcel.readString();
        this.durationMs = parcel.readLong();
        this.f8888id = parcel.readLong();
        this.messageData = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && EventMessage.class == obj.getClass()) {
            EventMessage eventMessage = (EventMessage) obj;
            if (this.durationMs == eventMessage.durationMs && this.f8888id == eventMessage.f8888id && i9.g.a(this.schemeIdUri, eventMessage.schemeIdUri) && i9.g.a(this.value, eventMessage.value) && Arrays.equals(this.messageData, eventMessage.messageData)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            String str = this.schemeIdUri;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.value;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            long j4 = this.durationMs;
            int i3 = (((hashCode + hashCode2) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j10 = this.f8888id;
            this.hashCode = Arrays.hashCode(this.messageData) + ((i3 + ((int) (j10 ^ (j10 >>> 32)))) * 31);
        }
        return this.hashCode;
    }

    public final String toString() {
        String str = this.schemeIdUri;
        long j4 = this.f8888id;
        long j10 = this.durationMs;
        String str2 = this.value;
        StringBuilder sb2 = new StringBuilder(a.a(a.a(79, str), str2));
        sb2.append("EMSG: scheme=");
        sb2.append(str);
        sb2.append(", id=");
        sb2.append(j4);
        sb2.append(", durationMs=");
        sb2.append(j10);
        sb2.append(", value=");
        sb2.append(str2);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.schemeIdUri);
        parcel.writeString(this.value);
        parcel.writeLong(this.durationMs);
        parcel.writeLong(this.f8888id);
        parcel.writeByteArray(this.messageData);
    }
}
