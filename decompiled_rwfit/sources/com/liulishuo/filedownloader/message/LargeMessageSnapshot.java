package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes2.dex */
public abstract class LargeMessageSnapshot extends MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements ue.a {
    }

    public static class PausedSnapshot extends PendingMessageSnapshot {
        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
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

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public final byte n() {
            return (byte) -4;
        }
    }

    public LargeMessageSnapshot(int i3) {
        super(i3);
        this.f11465a = true;
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public final int l() {
        return i() > 2147483647L ? SubsamplingScaleImageView.TILE_SIZE_AUTO : (int) i();
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public final int m() {
        return j() > 2147483647L ? SubsamplingScaleImageView.TILE_SIZE_AUTO : (int) j();
    }

    public static class ProgressMessageSnapshot extends LargeMessageSnapshot {
        private final long sofarBytes;

        public ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readLong();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final long i() {
            return this.sofarBytes;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final byte n() {
            return (byte) 3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeLong(this.sofarBytes);
        }

        public ProgressMessageSnapshot(int i3, long j4) {
            super(i3);
            this.sofarBytes = j4;
        }
    }

    public static class RetryMessageSnapshot extends ErrorMessageSnapshot {
        private final int retryingTimes;

        public RetryMessageSnapshot(int i3, long j4, Throwable th2, int i10) {
            super(i3, j4, th2);
            this.retryingTimes = i10;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final int k() {
            return this.retryingTimes;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public final byte n() {
            return (byte) 5;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.retryingTimes);
        }

        public RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.retryingTimes = parcel.readInt();
        }
    }

    public static class CompletedSnapshot extends LargeMessageSnapshot {
        private final boolean reusedDownloadedFile;
        private final long totalBytes;

        public CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.reusedDownloadedFile = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final long j() {
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
            parcel.writeLong(this.totalBytes);
        }

        public CompletedSnapshot(int i3, long j4, boolean z5) {
            super(i3);
            this.reusedDownloadedFile = z5;
            this.totalBytes = j4;
        }
    }

    public static class ErrorMessageSnapshot extends LargeMessageSnapshot {
        private final long sofarBytes;
        private final Throwable throwable;

        public ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readLong();
            this.throwable = (Throwable) parcel.readSerializable();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final long i() {
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
            parcel.writeLong(this.sofarBytes);
            parcel.writeSerializable(this.throwable);
        }

        public ErrorMessageSnapshot(int i3, long j4, Throwable th2) {
            super(i3);
            this.sofarBytes = j4;
            this.throwable = th2;
        }
    }

    public static class PendingMessageSnapshot extends LargeMessageSnapshot {
        private final long sofarBytes;
        private final long totalBytes;

        public PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final long i() {
            return this.sofarBytes;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public final long j() {
            return this.totalBytes;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte n() {
            return (byte) 1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeLong(this.sofarBytes);
            parcel.writeLong(this.totalBytes);
        }

        public PendingMessageSnapshot(WarnMessageSnapshot warnMessageSnapshot) {
            this(warnMessageSnapshot.h(), warnMessageSnapshot.sofarBytes, warnMessageSnapshot.totalBytes);
        }

        public PendingMessageSnapshot(int i3, long j4, long j10) {
            super(i3);
            this.sofarBytes = j4;
            this.totalBytes = j10;
        }
    }

    public static class ConnectedMessageSnapshot extends LargeMessageSnapshot {
        private final String etag;
        private final String fileName;
        private final boolean resuming;
        private final long totalBytes;

        public ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.resuming = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
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
        public final long j() {
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
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.etag);
            parcel.writeString(this.fileName);
        }

        public ConnectedMessageSnapshot(int i3, boolean z5, long j4, String str, String str2) {
            super(i3);
            this.resuming = z5;
            this.totalBytes = j4;
            this.etag = str;
            this.fileName = str2;
        }
    }
}
