package android.support.v4.media.session;

import a1.k;
import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.versionedparcelable.ParcelImpl;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final MediaController f325a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f326b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f327c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f328d = new HashMap();
    public final MediaSessionCompat$Token e;

    public d(Context context, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.e = mediaSessionCompat$Token;
        MediaController mediaController = new MediaController(context, (MediaSession.Token) mediaSessionCompat$Token.b());
        this.f325a = mediaController;
        if (mediaSessionCompat$Token.a() == null) {
            mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ResultReceiver(this) { // from class: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver
                private WeakReference<d> mMediaControllerImpl;

                {
                    super(null);
                    this.mMediaControllerImpl = new WeakReference<>(this);
                }

                @Override // android.os.ResultReceiver
                public final void onReceiveResult(int i3, Bundle bundle) {
                    c cVar;
                    d dVar = this.mMediaControllerImpl.get();
                    if (dVar == null || bundle == null) {
                        return;
                    }
                    synchronized (dVar.f326b) {
                        MediaSessionCompat$Token mediaSessionCompat$Token2 = dVar.e;
                        IBinder a3 = y0.h.a(bundle, "android.support.v4.media.session.EXTRA_BINDER");
                        int i10 = b.f324a;
                        l2.d dVar2 = null;
                        if (a3 == null) {
                            cVar = null;
                        } else {
                            IInterface queryLocalInterface = a3.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                                a aVar = new a();
                                aVar.f323a = a3;
                                cVar = aVar;
                            } else {
                                cVar = (c) queryLocalInterface;
                            }
                        }
                        mediaSessionCompat$Token2.d(cVar);
                        MediaSessionCompat$Token mediaSessionCompat$Token3 = dVar.e;
                        try {
                            Bundle bundle2 = (Bundle) bundle.getParcelable("android.support.v4.media.session.SESSION_TOKEN2");
                            if (bundle2 != null) {
                                bundle2.setClassLoader(l2.a.class.getClassLoader());
                                Parcelable parcelable = bundle2.getParcelable(Const.INTENT_KEY_APIKEY);
                                if (!(parcelable instanceof ParcelImpl)) {
                                    throw new IllegalArgumentException("Invalid parcel");
                                }
                                dVar2 = ((ParcelImpl) parcelable).a();
                            }
                        } catch (RuntimeException unused) {
                        }
                        mediaSessionCompat$Token3.h(dVar2);
                        dVar.a();
                    }
                }
            });
        }
    }

    public final void a() {
        if (this.e.a() == null) {
            return;
        }
        ArrayList arrayList = this.f327c;
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            arrayList.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            this.f328d.put(null, new k());
            throw null;
        }
    }
}
