package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new androidx.databinding.g(17);
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int accessibilityChannel;
    public final int averageBitrate;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final Class<Object> exoMediaCryptoType;
    public final float frameRate;
    private int hashCode;
    public final int height;

    /* renamed from: id, reason: collision with root package name */
    public final String f8842id;
    public final List<byte[]> initializationData;
    public final String label;
    public final String language;
    public final int maxInputSize;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final int peakBitrate;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    public Format(g gVar) {
        gVar.getClass();
        this.f8842id = null;
        this.label = null;
        this.language = i9.g.e(null);
        this.selectionFlags = 0;
        this.roleFlags = 0;
        int i3 = gVar.f8846a;
        this.averageBitrate = i3;
        int i10 = gVar.f8847b;
        this.peakBitrate = i10;
        this.bitrate = i10 != -1 ? i10 : i3;
        this.codecs = null;
        this.metadata = null;
        this.containerMimeType = null;
        this.sampleMimeType = gVar.f8848c;
        this.maxInputSize = gVar.f8849d;
        this.initializationData = Collections.EMPTY_LIST;
        this.drmInitData = null;
        this.subsampleOffsetUs = gVar.e;
        this.width = gVar.f8850f;
        this.height = gVar.f8851g;
        this.frameRate = gVar.f8852h;
        this.rotationDegrees = 0;
        float f2 = gVar.f8853i;
        this.pixelWidthHeightRatio = f2 == -1.0f ? 1.0f : f2;
        this.projectionData = null;
        this.stereoMode = gVar.f8854j;
        this.colorInfo = null;
        this.channelCount = gVar.f8855k;
        this.sampleRate = gVar.f8856l;
        this.pcmEncoding = gVar.f8857m;
        this.encoderDelay = 0;
        this.encoderPadding = 0;
        this.accessibilityChannel = gVar.f8858n;
        this.exoMediaCryptoType = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        int i3;
        if (this == obj) {
            return true;
        }
        if (obj != null && Format.class == obj.getClass()) {
            Format format = (Format) obj;
            int i10 = this.hashCode;
            if ((i10 == 0 || (i3 = format.hashCode) == 0 || i10 == i3) && this.selectionFlags == format.selectionFlags && this.roleFlags == format.roleFlags && this.averageBitrate == format.averageBitrate && this.peakBitrate == format.peakBitrate && this.maxInputSize == format.maxInputSize && this.subsampleOffsetUs == format.subsampleOffsetUs && this.width == format.width && this.height == format.height && this.rotationDegrees == format.rotationDegrees && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.accessibilityChannel == format.accessibilityChannel && Float.compare(this.frameRate, format.frameRate) == 0 && Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && i9.g.a(this.exoMediaCryptoType, format.exoMediaCryptoType) && i9.g.a(this.f8842id, format.f8842id) && i9.g.a(this.label, format.label) && i9.g.a(this.codecs, format.codecs) && i9.g.a(this.containerMimeType, format.containerMimeType) && i9.g.a(this.sampleMimeType, format.sampleMimeType) && i9.g.a(this.language, format.language) && Arrays.equals(this.projectionData, format.projectionData) && i9.g.a(this.metadata, format.metadata) && i9.g.a(this.colorInfo, format.colorInfo) && i9.g.a(this.drmInitData, format.drmInitData)) {
                boolean z5 = false;
                if (this.initializationData.size() == format.initializationData.size()) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= this.initializationData.size()) {
                            z5 = true;
                            break;
                        }
                        if (!Arrays.equals(this.initializationData.get(i11), format.initializationData.get(i11))) {
                            break;
                        }
                        i11++;
                    }
                }
                if (z5) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            String str = this.f8842id;
            int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.label;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.language;
            int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31) + this.averageBitrate) * 31) + this.peakBitrate) * 31;
            String str4 = this.codecs;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.metadata;
            int hashCode5 = (hashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.containerMimeType;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.sampleMimeType;
            int floatToIntBits = (((((((((((((((Float.floatToIntBits(this.pixelWidthHeightRatio) + ((((Float.floatToIntBits(this.frameRate) + ((((((((((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + this.width) * 31) + this.height) * 31)) * 31) + this.rotationDegrees) * 31)) * 31) + this.stereoMode) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31) + this.accessibilityChannel) * 31;
            Class<Object> cls = this.exoMediaCryptoType;
            this.hashCode = floatToIntBits + (cls != null ? cls.hashCode() : 0);
        }
        return this.hashCode;
    }

    public final String toString() {
        String str = this.f8842id;
        String str2 = this.label;
        String str3 = this.containerMimeType;
        String str4 = this.sampleMimeType;
        String str5 = this.codecs;
        int i3 = this.bitrate;
        String str6 = this.language;
        int i10 = this.width;
        int i11 = this.height;
        float f2 = this.frameRate;
        int i12 = this.channelCount;
        int i13 = this.sampleRate;
        StringBuilder g10 = r5.a.g(r5.a.a(r5.a.a(r5.a.a(r5.a.a(r5.a.a(r5.a.a(104, str), str2), str3), str4), str5), str6), "Format(", str, ", ", str2);
        android.support.v4.media.session.e.z(g10, ", ", str3, ", ", str4);
        g10.append(", ");
        g10.append(str5);
        g10.append(", ");
        g10.append(i3);
        g10.append(", ");
        g10.append(str6);
        g10.append(", [");
        g10.append(i10);
        g10.append(", ");
        g10.append(i11);
        g10.append(", ");
        g10.append(f2);
        g10.append("], [");
        g10.append(i12);
        g10.append(", ");
        g10.append(i13);
        g10.append("])");
        return g10.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f8842id);
        parcel.writeString(this.label);
        parcel.writeString(this.language);
        parcel.writeInt(this.selectionFlags);
        parcel.writeInt(this.roleFlags);
        parcel.writeInt(this.averageBitrate);
        parcel.writeInt(this.peakBitrate);
        parcel.writeString(this.codecs);
        parcel.writeParcelable(this.metadata, 0);
        parcel.writeString(this.containerMimeType);
        parcel.writeString(this.sampleMimeType);
        parcel.writeInt(this.maxInputSize);
        int size = this.initializationData.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            parcel.writeByteArray(this.initializationData.get(i10));
        }
        parcel.writeParcelable(this.drmInitData, 0);
        parcel.writeLong(this.subsampleOffsetUs);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.rotationDegrees);
        parcel.writeFloat(this.pixelWidthHeightRatio);
        int i11 = this.projectionData == null ? 0 : 1;
        int i12 = i9.g.f14378a;
        parcel.writeInt(i11);
        byte[] bArr = this.projectionData;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.stereoMode);
        parcel.writeParcelable(this.colorInfo, i3);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.pcmEncoding);
        parcel.writeInt(this.encoderDelay);
        parcel.writeInt(this.encoderPadding);
        parcel.writeInt(this.accessibilityChannel);
    }

    public Format(Parcel parcel) {
        this.f8842id = parcel.readString();
        this.label = parcel.readString();
        this.language = parcel.readString();
        this.selectionFlags = parcel.readInt();
        this.roleFlags = parcel.readInt();
        int readInt = parcel.readInt();
        this.averageBitrate = readInt;
        int readInt2 = parcel.readInt();
        this.peakBitrate = readInt2;
        this.bitrate = readInt2 != -1 ? readInt2 : readInt;
        this.codecs = parcel.readString();
        this.metadata = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
        this.containerMimeType = parcel.readString();
        this.sampleMimeType = parcel.readString();
        this.maxInputSize = parcel.readInt();
        int readInt3 = parcel.readInt();
        this.initializationData = new ArrayList(readInt3);
        for (int i3 = 0; i3 < readInt3; i3++) {
            List<byte[]> list = this.initializationData;
            byte[] createByteArray = parcel.createByteArray();
            createByteArray.getClass();
            list.add(createByteArray);
        }
        DrmInitData drmInitData = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.drmInitData = drmInitData;
        this.subsampleOffsetUs = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.rotationDegrees = parcel.readInt();
        this.pixelWidthHeightRatio = parcel.readFloat();
        int i10 = i9.g.f14378a;
        this.projectionData = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.stereoMode = parcel.readInt();
        this.colorInfo = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.encoderDelay = parcel.readInt();
        this.encoderPadding = parcel.readInt();
        this.accessibilityChannel = parcel.readInt();
        this.exoMediaCryptoType = drmInitData != null ? m8.b.class : null;
    }
}
