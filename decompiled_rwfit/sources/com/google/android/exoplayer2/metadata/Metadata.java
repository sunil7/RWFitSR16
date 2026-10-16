package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import ha.d;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new d(10);
    private final Entry[] entries;

    public interface Entry extends Parcelable {
    }

    public Metadata(Parcel parcel) {
        this.entries = new Entry[parcel.readInt()];
        int i3 = 0;
        while (true) {
            Entry[] entryArr = this.entries;
            if (i3 >= entryArr.length) {
                return;
            }
            entryArr[i3] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
            i3++;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.entries, ((Metadata) obj).entries);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.entries);
    }

    public final String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.entries));
        return valueOf.length() != 0 ? "entries=".concat(valueOf) : new String("entries=");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.entries.length);
        for (Entry entry : this.entries) {
            parcel.writeParcelable(entry, 0);
        }
    }
}
