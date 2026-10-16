package qf;

import android.os.HandlerThread;

/* loaded from: classes2.dex */
public final class h extends HandlerThread {
    @Override // java.lang.Thread
    public final String toString() {
        return super.toString() + "[" + getThreadId() + "]";
    }
}
