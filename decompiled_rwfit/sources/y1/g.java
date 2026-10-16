package y1;

import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19935a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ mc.g f19936b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19937c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ResultReceiver f19938d;
    public final /* synthetic */ xg.b e;

    public g(xg.b bVar, mc.g gVar, String str, ResultReceiver resultReceiver) {
        this.e = bVar;
        this.f19936b = gVar;
        this.f19937c = str;
        this.f19938d = resultReceiver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19935a) {
            case 0:
                if (((a) ((MediaBrowserServiceCompat) this.e.f19825a).f2426d.getOrDefault(((Messenger) this.f19936b.f16022b).getBinder(), null)) != null) {
                    ResultReceiver resultReceiver = this.f19938d;
                    if ((2 & 2) == 0) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("media_item", null);
                        resultReceiver.b(0, bundle);
                        break;
                    } else {
                        resultReceiver.b(-1, null);
                        break;
                    }
                } else {
                    Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f19937c);
                    break;
                }
            default:
                if (((a) ((MediaBrowserServiceCompat) this.e.f19825a).f2426d.getOrDefault(((Messenger) this.f19936b.f16022b).getBinder(), null)) != null) {
                    this.f19938d.b(-1, null);
                    break;
                } else {
                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f19937c);
                    break;
                }
        }
    }

    public g(xg.b bVar, mc.g gVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.e = bVar;
        this.f19936b = gVar;
        this.f19937c = str;
        this.f19938d = resultReceiver;
    }
}
