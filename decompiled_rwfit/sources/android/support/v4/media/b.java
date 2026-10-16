package android.support.v4.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import android.view.KeyEvent;
import ef.i;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import n.g0;
import y0.h;

/* loaded from: classes.dex */
public final class b extends MediaBrowser.ConnectionCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f302a;

    public b(g0 g0Var) {
        this.f302a = g0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.support.v4.media.session.c] */
    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnected() {
        android.support.v4.media.session.a aVar;
        boolean z5 = false;
        g0 g0Var = this.f302a;
        e eVar = (e) g0Var.f16175b;
        if (eVar != null) {
            MediaBrowser mediaBrowser = eVar.f304b;
            try {
                Bundle extras = mediaBrowser.getExtras();
                if (extras != null) {
                    extras.getInt("extra_service_version", 0);
                    IBinder a3 = h.a(extras, "extra_messenger");
                    if (a3 != null) {
                        i iVar = new i(1, z5);
                        iVar.f12629b = new Messenger(a3);
                        iVar.f12630c = eVar.f305c;
                        eVar.f307f = iVar;
                        a aVar2 = eVar.f306d;
                        Messenger messenger = new Messenger(aVar2);
                        eVar.f308g = messenger;
                        aVar2.getClass();
                        aVar2.f301b = new WeakReference(messenger);
                        try {
                            i iVar2 = eVar.f307f;
                            Context context = eVar.f303a;
                            Messenger messenger2 = eVar.f308g;
                            iVar2.getClass();
                            Bundle bundle = new Bundle();
                            bundle.putString("data_package_name", context.getPackageName());
                            bundle.putInt("data_calling_pid", Process.myPid());
                            bundle.putBundle("data_root_hints", (Bundle) iVar2.f12630c);
                            iVar2.K(messenger2, 6, bundle);
                        } catch (RemoteException unused) {
                            Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                        }
                    }
                    IBinder a10 = h.a(extras, "extra_session_binder");
                    int i3 = android.support.v4.media.session.b.f324a;
                    if (a10 == null) {
                        aVar = null;
                    } else {
                        IInterface queryLocalInterface = a10.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof android.support.v4.media.session.c)) {
                            android.support.v4.media.session.a aVar3 = new android.support.v4.media.session.a();
                            aVar3.f323a = a10;
                            aVar = aVar3;
                        } else {
                            aVar = (android.support.v4.media.session.c) queryLocalInterface;
                        }
                    }
                    if (aVar != null) {
                        MediaSession.Token sessionToken = mediaBrowser.getSessionToken();
                        eVar.f309h = sessionToken != null ? new MediaSessionCompat$Token(sessionToken, aVar) : null;
                    }
                }
            } catch (IllegalStateException e) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e);
            }
        }
        e eVar2 = ((g) g0Var.f16178f).f311a;
        if (eVar2.f309h == null) {
            MediaSession.Token sessionToken2 = eVar2.f304b.getSessionToken();
            eVar2.f309h = sessionToken2 != null ? new MediaSessionCompat$Token(sessionToken2, null) : null;
        }
        MediaSessionCompat$Token mediaSessionCompat$Token = eVar2.f309h;
        new ConcurrentHashMap();
        if (mediaSessionCompat$Token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        android.support.v4.media.session.d dVar = new android.support.v4.media.session.d((Context) g0Var.f16176c, mediaSessionCompat$Token);
        KeyEvent keyEvent = (KeyEvent) ((Intent) g0Var.f16177d).getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        dVar.f325a.dispatchMediaButtonEvent(keyEvent);
        g0Var.h();
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnectionFailed() {
        g0 g0Var = this.f302a;
        e eVar = (e) g0Var.f16175b;
        if (eVar != null) {
            eVar.getClass();
        }
        g0Var.h();
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnectionSuspended() {
        g0 g0Var = this.f302a;
        e eVar = (e) g0Var.f16175b;
        if (eVar != null) {
            eVar.f307f = null;
            eVar.f308g = null;
            eVar.f309h = null;
            a aVar = eVar.f306d;
            aVar.getClass();
            aVar.f301b = new WeakReference(null);
        }
        g0Var.h();
    }
}
