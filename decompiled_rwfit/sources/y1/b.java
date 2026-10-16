package y1;

import android.content.Context;
import android.os.Bundle;
import android.os.Messenger;
import android.service.media.MediaBrowserService;
import androidx.media.MediaBrowserServiceCompat;
import y0.h;

/* loaded from: classes.dex */
public final class b extends MediaBrowserService {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f19919a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f19920b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f19921c;

    public b(c cVar, Context context) {
        this.f19921c = cVar;
        this.f19920b = cVar;
        this.f19919a = cVar;
        attachBaseContext(context);
    }

    @Override // android.service.media.MediaBrowserService
    public final MediaBrowserService.BrowserRoot onGetRoot(String str, int i3, Bundle bundle) {
        android.support.v4.media.session.g.a(bundle);
        Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        c cVar = this.f19919a;
        MediaBrowserServiceCompat mediaBrowserServiceCompat = cVar.f19925d;
        int i10 = -1;
        if (bundle2 != null && bundle2.getInt("extra_client_version", 0) != 0) {
            bundle2.remove("extra_client_version");
            cVar.f19924c = new Messenger(mediaBrowserServiceCompat.e);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("extra_service_version", 2);
            h.b(bundle3, "extra_messenger", cVar.f19924c.getBinder());
            cVar.f19922a.add(bundle3);
            i10 = bundle2.getInt("extra_calling_pid", -1);
            bundle2.remove("extra_calling_pid");
        }
        new a(cVar.f19925d, str, i10, i3, null);
        mediaBrowserServiceCompat.a();
        return null;
    }

    @Override // android.service.media.MediaBrowserService
    public final void onLoadChildren(String str, MediaBrowserService.Result result) {
        c cVar = this.f19919a;
        cVar.getClass();
        cVar.f19925d.b();
    }

    @Override // android.service.media.MediaBrowserService
    public final void onLoadItem(String str, MediaBrowserService.Result result) {
        n6.a aVar = new n6.a(result, 28);
        a aVar2 = this.f19920b.e.f2424b;
        ((MediaBrowserService.Result) aVar.f16381b).sendResult(null);
    }

    @Override // android.service.media.MediaBrowserService
    public final void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
        android.support.v4.media.session.g.a(bundle);
        this.f19921c.f19926f.b();
    }
}
