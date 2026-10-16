package y1;

import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.media.MediaBrowserServiceCompat;
import java.util.HashMap;
import l1.r1;
import pe.o;

/* loaded from: classes.dex */
public final class a implements IBinder.DeathRecipient {

    /* renamed from: a, reason: collision with root package name */
    public final String f19914a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19915b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19916c;

    /* renamed from: d, reason: collision with root package name */
    public final mc.g f19917d;
    public final HashMap e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ MediaBrowserServiceCompat f19918f;

    public a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, int i3, int i10, mc.g gVar) {
        this.f19918f = mediaBrowserServiceCompat;
        this.f19914a = str;
        this.f19915b = i3;
        this.f19916c = i10;
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if (Build.VERSION.SDK_INT >= 28) {
            r1.h(i3, i10, str);
        }
        this.f19917d = gVar;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f19918f;
        mediaBrowserServiceCompat.e.post(new o(this, 13));
    }
}
