package com.liulishuo.filedownloader.message;

import android.os.Parcel;

/* loaded from: classes2.dex */
public abstract class SmallMessageSnapshot extends MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements ue.a {
    }

    public static class PausedSnapshot extends PendingMessageSnapshot {
        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public final byte n() {
            return (byte) -2;
        }
    }

    public static class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements ue.a {
    }

    public static class WarnMessageSnapshot extends PendingMessageSnapshot implements ue.b {
        @Override // ue.b
        public final MessageSnapshot a() {
            return new PendingMessageSnapshot(this);
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public final byte n() {
            return (byte) -4;
        }
    }

    public SmallMessageSnapshot(int i3) {
        super(i3);
        this.f11465a = false;
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public final long i() {
        return l();
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public final long j() {
        return m();
    }

    public static class ProgressMessageSnapshot extends SmallMessageSnapshot {
        private final int sofarBytes;

        public ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readInt();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final int l() {
            return this.sofarBytes;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final byte n() {
            return (byte) 3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.sofarBytes);
        }

        public ProgressMessageSnapshot(int i3, int i10) {
            super(i3);
            this.sofarBytes = i10;
        }
    }

    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {
        private final int retryingTimes;

        public RetryMessageSnapshot(int i3, int i10, Throwable th2, int i11) {
            super(i3, i10, th2);
            this.retryingTimes = i11;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final int k() {
            return this.retryingTimes;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public final byte n() {
            return (byte) 5;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.retryingTimes);
        }

        public RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.retryingTimes = parcel.readInt();
        }
    }

    public static class CompletedSnapshot extends SmallMessageSnapshot {
        private final boolean reusedDownloadedFile;
        private final int totalBytes;

        public CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.reusedDownloadedFile = parcel.readByte() != 0;
            this.totalBytes = parcel.readInt();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final int m() {
            return this.totalBytes;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final byte n() {
            return (byte) -3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final void q() {
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeByte(this.reusedDownloadedFile ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.totalBytes);
        }

        public CompletedSnapshot(int i3, int i10, boolean z5) {
            super(i3);
            this.reusedDownloadedFile = z5;
            this.totalBytes = i10;
        }
    }

    public static class ErrorMessageSnapshot extends SmallMessageSnapshot {
        private final int sofarBytes;
        private final Throwable throwable;

        public ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readInt();
            this.throwable = (Throwable) parcel.readSerializable();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final int l() {
            return this.sofarBytes;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte n() {
            return (byte) -1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final Throwable o() {
            return this.throwable;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.sofarBytes);
            parcel.writeSerializable(this.throwable);
        }

        public ErrorMessageSnapshot(int i3, int i10, Throwable th2) {
            super(i3);
            this.sofarBytes = i10;
            this.throwable = th2;
        }
    }

    public static class PendingMessageSnapshot extends SmallMessageSnapshot {
        private final int sofarBytes;
        private final int totalBytes;

        public PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readInt();
            this.totalBytes = parcel.readInt();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final int l() {
            return this.sofarBytes;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final int m() {
            return this.totalBytes;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte n() {
            return (byte) 1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.sofarBytes);
            parcel.writeInt(this.totalBytes);
        }

        public PendingMessageSnapshot(WarnMessageSnapshot warnMessageSnapshot) {
            this(warnMessageSnapshot.h(), warnMessageSnapshot.sofarBytes, warnMessageSnapshot.totalBytes);
        }

        public PendingMessageSnapshot(int i3, int i10, int i11) {
            super(i3);
            this.sofarBytes = i10;
            this.totalBytes = i11;
        }
    }

    public static class ConnectedMessageSnapshot extends SmallMessageSnapshot {
        private final String etag;
        private final String fileName;
        private final boolean resuming;
        private final int totalBytes;

        public ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.resuming = parcel.readByte() != 0;
            this.totalBytes = parcel.readInt();
            this.etag = parcel.readString();
            this.fileName = parcel.readString();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final void b() {
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final String d() {
            return this.fileName;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final int m() {
            return this.totalBytes;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final byte n() {
            return (byte) 2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final void p() {
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeByte(this.resuming ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.totalBytes);
            parcel.writeString(this.etag);
            parcel.writeString(this.fileName);
        }

        public ConnectedMessageSnapshot(String str, String str2, int i3, boolean z5, int i10) {
            super(i3);
            this.resuming = z5;
            this.totalBytes = i10;
            this.etag = str;
            this.fileName = str2;
        }
    }
}
