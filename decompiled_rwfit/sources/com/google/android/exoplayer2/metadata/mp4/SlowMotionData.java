package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.core.impl.c1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.gms.internal.mlkit_vision_barcode.pc;
import i9.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class SlowMotionData implements Metadata.Entry {
    public static final Parcelable.Creator<SlowMotionData> CREATOR = new a();
    public final List<Segment> segments;

    public static final class Segment implements Parcelable {
        public static final Comparator<Segment> BY_START_THEN_END_THEN_DIVISOR = new c1(6);
        public static final Parcelable.Creator<Segment> CREATOR = new b();
        public final long endTimeMs;
        public final int speedDivisor;
        public final long startTimeMs;

        public Segment(int i3, long j4, long j10) {
            pc.a(j4 < j10);
            this.startTimeMs = j4;
            this.endTimeMs = j10;
            this.speedDivisor = i3;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Segment.class == obj.getClass()) {
                Segment segment = (Segment) obj;
                if (this.startTimeMs == segment.startTimeMs && this.endTimeMs == segment.endTimeMs && this.speedDivisor == segment.speedDivisor) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Long.valueOf(this.startTimeMs), Long.valueOf(this.endTimeMs), Integer.valueOf(this.speedDivisor)});
        }

        public final String toString() {
            long j4 = this.startTimeMs;
            long j10 = this.endTimeMs;
            int i3 = this.speedDivisor;
            int i10 = g.f14378a;
            Locale locale = Locale.US;
            return "Segment: startTimeMs=" + j4 + ", endTimeMs=" + j10 + ", speedDivisor=" + i3;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            parcel.writeLong(this.startTimeMs);
            parcel.writeLong(this.endTimeMs);
            parcel.writeInt(this.speedDivisor);
        }
    }

    public SlowMotionData(ArrayList arrayList) {
        this.segments = arrayList;
        boolean z5 = false;
        if (!arrayList.isEmpty()) {
            long j4 = ((Segment) arrayList.get(0)).endTimeMs;
            int i3 = 1;
            while (true) {
                if (i3 >= arrayList.size()) {
                    break;
                }
                if (((Segment) arrayList.get(i3)).startTimeMs < j4) {
                    z5 = true;
                    break;
                } else {
                    j4 = ((Segment) arrayList.get(i3)).endTimeMs;
                    i3++;
                }
            }
        }
        pc.a(!z5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.segments.equals(((SlowMotionData) obj).segments);
    }

    public final int hashCode() {
        return this.segments.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.segments);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 21);
        sb2.append("SlowMotion: segments=");
        sb2.append(valueOf);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeList(this.segments);
    }
}
