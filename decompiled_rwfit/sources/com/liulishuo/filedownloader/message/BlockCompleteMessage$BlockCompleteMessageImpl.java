package com.liulishuo.filedownloader.message;

import java.util.Locale;
import ye.e;

/* loaded from: classes2.dex */
public class BlockCompleteMessage$BlockCompleteMessageImpl extends MessageSnapshot {
    private final MessageSnapshot mCompletedSnapshot;

    public BlockCompleteMessage$BlockCompleteMessageImpl(MessageSnapshot messageSnapshot) {
        super(messageSnapshot.h());
        if (messageSnapshot.n() == -3) {
            this.mCompletedSnapshot = messageSnapshot;
            return;
        }
        int h4 = messageSnapshot.h();
        byte n4 = messageSnapshot.n();
        int i3 = e.f20123a;
        Locale locale = Locale.ENGLISH;
        throw new IllegalArgumentException(android.support.v4.media.session.e.g(h4, "can't create the block complete message for id[", n4, "], status[", "]"));
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public final byte n() {
        return (byte) 4;
    }

    public final MessageSnapshot r() {
        return this.mCompletedSnapshot;
    }
}
