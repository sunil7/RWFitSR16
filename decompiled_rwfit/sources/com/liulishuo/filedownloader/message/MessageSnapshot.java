package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public abstract class MessageSnapshot implements Parcelable {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f11465a;

    /* renamed from: id, reason: collision with root package name */
    private final int f11466id;

    public static class NoFieldException extends IllegalStateException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public NoFieldException(java.lang.String r5, com.liulishuo.filedownloader.message.MessageSnapshot r6) {
            /*
                r4 = this;
                int r0 = r6.h()
                byte r1 = r6.n()
                java.lang.Class r6 = r6.getClass()
                java.lang.String r6 = r6.getName()
                int r2 = ye.e.f20123a
                java.util.Locale r2 = java.util.Locale.ENGLISH
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "There isn't a field for '"
                r2.<init>(r3)
                r2.append(r5)
                java.lang.String r5 = "' in this message "
                r2.append(r5)
                r2.append(r0)
                java.lang.String r5 = " "
                r2.append(r5)
                r2.append(r1)
                r2.append(r5)
                r2.append(r6)
                java.lang.String r5 = r2.toString()
                r4.<init>(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.message.MessageSnapshot.NoFieldException.<init>(java.lang.String, com.liulishuo.filedownloader.message.MessageSnapshot):void");
        }
    }

    public static class StartedMessageSnapshot extends MessageSnapshot {
        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final byte n() {
            return (byte) 6;
        }
    }

    public MessageSnapshot(int i3) {
        this.f11466id = i3;
    }

    public void b() {
        throw new NoFieldException("getEtag", this);
    }

    public String d() {
        throw new NoFieldException("getFileName", this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int h() {
        return this.f11466id;
    }

    public long i() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    public long j() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    public int k() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    public int l() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    public int m() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    public abstract /* synthetic */ byte n();

    public Throwable o() {
        throw new NoFieldException("getThrowable", this);
    }

    public void p() {
        throw new NoFieldException("isResuming", this);
    }

    public void q() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByte(this.f11465a ? (byte) 1 : (byte) 0);
        parcel.writeByte(n());
        parcel.writeInt(this.f11466id);
    }

    public MessageSnapshot(Parcel parcel) {
        this.f11466id = parcel.readInt();
    }
}
