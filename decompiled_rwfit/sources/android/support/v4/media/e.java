package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Process;
import android.support.v4.media.session.MediaSessionCompat$Token;
import ef.i;
import n.g0;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f303a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaBrowser f304b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f305c;

    /* renamed from: d, reason: collision with root package name */
    public final a f306d = new a(this);
    public final m0.b e = new m0.b();

    /* renamed from: f, reason: collision with root package name */
    public i f307f;

    /* renamed from: g, reason: collision with root package name */
    public Messenger f308g;

    /* renamed from: h, reason: collision with root package name */
    public MediaSessionCompat$Token f309h;

    public e(Context context, ComponentName componentName, g0 g0Var) {
        this.f303a = context;
        Bundle bundle = new Bundle();
        this.f305c = bundle;
        bundle.putInt("extra_client_version", 1);
        bundle.putInt("extra_calling_pid", Process.myPid());
        g0Var.f16175b = this;
        this.f304b = new MediaBrowser(context, componentName, (b) g0Var.f16174a, bundle);
    }
}
