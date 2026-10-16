package com.google.android.exoplayer2.video;

import android.view.Surface;
import j9.a;

/* loaded from: classes.dex */
public final class DummySurface extends Surface {
    private static final String TAG = "DummySurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final a thread;
    private boolean threadReleased;

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.thread) {
            try {
                if (!this.threadReleased) {
                    this.thread.getClass();
                    throw null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
