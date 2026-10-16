package l1;

import android.database.CursorWindow;
import android.media.session.MediaSessionManager;

/* loaded from: classes.dex */
public abstract /* synthetic */ class r1 {
    public static /* synthetic */ CursorWindow b(long j4, String str) {
        return new CursorWindow(str, j4);
    }

    public static /* synthetic */ void h(int i3, int i10, String str) {
        new MediaSessionManager.RemoteUserInfo(str, i3, i10);
    }
}
