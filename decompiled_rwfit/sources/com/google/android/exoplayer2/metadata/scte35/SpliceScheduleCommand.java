package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u8.b;
import u8.c;
import u8.d;

/* loaded from: classes.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new b(1);
    public final List<d> events;

    public SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(new d(parcel));
        }
        this.events = Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = this.events.get(i10);
            parcel.writeLong(dVar.f19014a);
            parcel.writeByte(dVar.f19015b ? (byte) 1 : (byte) 0);
            parcel.writeByte(dVar.f19016c ? (byte) 1 : (byte) 0);
            parcel.writeByte(dVar.f19017d ? (byte) 1 : (byte) 0);
            List list = dVar.f19018f;
            int size2 = list.size();
            parcel.writeInt(size2);
            for (int i11 = 0; i11 < size2; i11++) {
                c cVar = (c) list.get(i11);
                parcel.writeInt(cVar.f19012a);
                parcel.writeLong(cVar.f19013b);
            }
            parcel.writeLong(dVar.e);
            parcel.writeByte(dVar.f19019g ? (byte) 1 : (byte) 0);
            parcel.writeLong(dVar.f19020h);
            parcel.writeInt(dVar.f19021i);
            parcel.writeInt(dVar.f19022j);
            parcel.writeInt(dVar.f19023k);
        }
    }
}
