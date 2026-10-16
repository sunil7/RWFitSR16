package de;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Runnable)) {
            return true;
        }
        ((Runnable) obj).run();
        return true;
    }
}
