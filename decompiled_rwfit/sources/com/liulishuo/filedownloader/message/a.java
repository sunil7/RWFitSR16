package com.liulishuo.filedownloader.message;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class a implements Parcelable.Creator {
    /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    @Override // android.os.Parcelable.Creator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createFromParcel(android.os.Parcel r5) {
        /*
            r4 = this;
            byte r0 = r5.readByte()
            r1 = 1
            if (r0 != r1) goto L9
            r0 = r1
            goto La
        L9:
            r0 = 0
        La:
            byte r2 = r5.readByte()
            r3 = -4
            if (r2 == r3) goto L84
            r3 = -3
            if (r2 == r3) goto L76
            r3 = -1
            if (r2 == r3) goto L68
            if (r2 == r1) goto L5a
            r1 = 2
            if (r2 == r1) goto L4c
            r1 = 3
            if (r2 == r1) goto L3e
            r1 = 5
            if (r2 == r1) goto L30
            r1 = 6
            if (r2 == r1) goto L28
            r5 = 0
            goto L92
        L28:
            com.liulishuo.filedownloader.message.MessageSnapshot$StartedMessageSnapshot r1 = new com.liulishuo.filedownloader.message.MessageSnapshot$StartedMessageSnapshot
            r1.<init>(r5)
        L2d:
            r5 = r1
            goto L92
        L30:
            if (r0 == 0) goto L38
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$RetryMessageSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$RetryMessageSnapshot
            r1.<init>(r5)
            goto L2d
        L38:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$RetryMessageSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$RetryMessageSnapshot
            r1.<init>(r5)
            goto L2d
        L3e:
            if (r0 == 0) goto L46
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$ProgressMessageSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$ProgressMessageSnapshot
            r1.<init>(r5)
            goto L2d
        L46:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$ProgressMessageSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$ProgressMessageSnapshot
            r1.<init>(r5)
            goto L2d
        L4c:
            if (r0 == 0) goto L54
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$ConnectedMessageSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$ConnectedMessageSnapshot
            r1.<init>(r5)
            goto L2d
        L54:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$ConnectedMessageSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$ConnectedMessageSnapshot
            r1.<init>(r5)
            goto L2d
        L5a:
            if (r0 == 0) goto L62
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$PendingMessageSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$PendingMessageSnapshot
            r1.<init>(r5)
            goto L2d
        L62:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$PendingMessageSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$PendingMessageSnapshot
            r1.<init>(r5)
            goto L2d
        L68:
            if (r0 == 0) goto L70
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$ErrorMessageSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$ErrorMessageSnapshot
            r1.<init>(r5)
            goto L2d
        L70:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$ErrorMessageSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$ErrorMessageSnapshot
            r1.<init>(r5)
            goto L2d
        L76:
            if (r0 == 0) goto L7e
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$CompletedSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$CompletedSnapshot
            r1.<init>(r5)
            goto L2d
        L7e:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$CompletedSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$CompletedSnapshot
            r1.<init>(r5)
            goto L2d
        L84:
            if (r0 == 0) goto L8c
            com.liulishuo.filedownloader.message.LargeMessageSnapshot$WarnMessageSnapshot r1 = new com.liulishuo.filedownloader.message.LargeMessageSnapshot$WarnMessageSnapshot
            r1.<init>(r5)
            goto L2d
        L8c:
            com.liulishuo.filedownloader.message.SmallMessageSnapshot$WarnMessageSnapshot r1 = new com.liulishuo.filedownloader.message.SmallMessageSnapshot$WarnMessageSnapshot
            r1.<init>(r5)
            goto L2d
        L92:
            if (r5 == 0) goto L97
            r5.f11465a = r0
            return r5
        L97:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Can't restore the snapshot because unknown status: "
            java.lang.String r0 = com.google.android.gms.internal.mlkit_vision_barcode.l0.j(r2, r0)
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.message.a.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        return new MessageSnapshot[i3];
    }
}
