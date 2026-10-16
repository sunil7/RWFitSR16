package androidx.appcompat.app;

import android.content.DialogInterface;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import com.example.test.ui.view.TimeDownView;
import com.google.android.gms.internal.mlkit_vision_barcode.wf;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class f extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f469a = 0;

    /* renamed from: b, reason: collision with root package name */
    public Object f470b;

    public /* synthetic */ f() {
    }

    public void a(Runnable runnable) {
        if (Thread.currentThread() == getLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (this.f469a) {
            case 0:
                int i3 = message.what;
                if (i3 == -3 || i3 == -2 || i3 == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) this.f470b).get(), message.what);
                    return;
                } else {
                    if (i3 != 1) {
                        return;
                    }
                    ((DialogInterface) message.obj).dismiss();
                    return;
                }
            case 1:
                super.handleMessage(message);
                if (message.what == 1) {
                    TimeDownView timeDownView = (TimeDownView) this.f470b;
                    com.example.test.ui.view.r rVar = timeDownView.f8648g;
                    if (rVar != null) {
                        rVar.b();
                    }
                    int i10 = timeDownView.f8645c;
                    int i11 = timeDownView.f8646d;
                    int i12 = i11 - 1;
                    if (i10 >= i12) {
                        timeDownView.f8650i = 1;
                        if (i10 >= i11) {
                            timeDownView.setText(String.valueOf(i10));
                            if (timeDownView.f8651j) {
                                timeDownView.f8647f.startNow();
                            }
                        } else if (i10 == i12) {
                            timeDownView.setText("GO");
                            if (timeDownView.f8651j) {
                                timeDownView.f8647f.startNow();
                            }
                            timeDownView.f8643a.cancel();
                            com.example.test.ui.view.r rVar2 = timeDownView.f8648g;
                            if (rVar2 != null) {
                                rVar2.f();
                            }
                        }
                        timeDownView.f8645c--;
                        return;
                    }
                    return;
                }
                return;
            default:
                Bundle data = message.getData();
                int i13 = message.what;
                xg.b bVar = (xg.b) this.f470b;
                switch (i13) {
                    case 1:
                        Bundle bundle = data.getBundle("data_root_hints");
                        android.support.v4.media.session.g.a(bundle);
                        String string = data.getString("data_package_name");
                        int i14 = data.getInt("data_calling_pid");
                        int i15 = data.getInt("data_calling_uid");
                        mc.g gVar = new mc.g(message.replyTo, 27);
                        MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) bVar.f19825a;
                        if (string != null) {
                            for (String str : mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i15)) {
                                if (str.equals(string)) {
                                    mediaBrowserServiceCompat.e.a(new y1.e(bVar, gVar, string, i14, i15, bundle));
                                    return;
                                }
                            }
                        }
                        throw new IllegalArgumentException("Package/uid mismatch: uid=" + i15 + " package=" + string);
                    case 2:
                        ((MediaBrowserServiceCompat) bVar.f19825a).e.a(new y1.f(bVar, new mc.g(message.replyTo, 27), 0));
                        return;
                    case 3:
                        Bundle bundle2 = data.getBundle("data_options");
                        android.support.v4.media.session.g.a(bundle2);
                        String string2 = data.getString("data_media_item_id");
                        IBinder a3 = y0.h.a(data, "data_callback_token");
                        ((MediaBrowserServiceCompat) bVar.f19825a).e.a(new gc.j(bVar, new mc.g(message.replyTo, 27), string2, a3, bundle2, 1));
                        return;
                    case 4:
                        String string3 = data.getString("data_media_item_id");
                        IBinder a10 = y0.h.a(data, "data_callback_token");
                        ((MediaBrowserServiceCompat) bVar.f19825a).e.a(new wf(bVar, new mc.g(message.replyTo, 27), string3, a10));
                        return;
                    case 5:
                        String string4 = data.getString("data_media_item_id");
                        ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                        mc.g gVar2 = new mc.g(message.replyTo, 27);
                        bVar.getClass();
                        if (TextUtils.isEmpty(string4) || resultReceiver == null) {
                            return;
                        }
                        ((MediaBrowserServiceCompat) bVar.f19825a).e.a(new y1.g(bVar, gVar2, string4, resultReceiver));
                        return;
                    case 6:
                        Bundle bundle3 = data.getBundle("data_root_hints");
                        android.support.v4.media.session.g.a(bundle3);
                        mc.g gVar3 = new mc.g(message.replyTo, 27);
                        String string5 = data.getString("data_package_name");
                        int i16 = data.getInt("data_calling_pid");
                        ((MediaBrowserServiceCompat) bVar.f19825a).e.a(new y1.e(bVar, gVar3, data.getInt("data_calling_uid"), string5, i16, bundle3));
                        return;
                    case 7:
                        ((MediaBrowserServiceCompat) bVar.f19825a).e.a(new y1.f(bVar, new mc.g(message.replyTo, 27), 1));
                        return;
                    case 8:
                        Bundle bundle4 = data.getBundle("data_search_extras");
                        android.support.v4.media.session.g.a(bundle4);
                        String string6 = data.getString("data_search_query");
                        ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                        mc.g gVar4 = new mc.g(message.replyTo, 27);
                        bVar.getClass();
                        if (TextUtils.isEmpty(string6) || resultReceiver2 == null) {
                            return;
                        }
                        ((MediaBrowserServiceCompat) bVar.f19825a).e.a(new y1.g(bVar, gVar4, string6, bundle4, resultReceiver2));
                        return;
                    case 9:
                        Bundle bundle5 = data.getBundle("data_custom_action_extras");
                        android.support.v4.media.session.g.a(bundle5);
                        String string7 = data.getString("data_custom_action");
                        ResultReceiver resultReceiver3 = (ResultReceiver) data.getParcelable("data_result_receiver");
                        mc.g gVar5 = new mc.g(message.replyTo, 27);
                        bVar.getClass();
                        if (TextUtils.isEmpty(string7) || resultReceiver3 == null) {
                            return;
                        }
                        ((MediaBrowserServiceCompat) bVar.f19825a).e.a(new gc.j(bVar, gVar5, string7, bundle5, resultReceiver3, 2));
                        return;
                    default:
                        Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                        return;
                }
        }
    }

    @Override // android.os.Handler
    public boolean sendMessageAtTime(Message message, long j4) {
        switch (this.f469a) {
            case 2:
                Bundle data = message.getData();
                data.setClassLoader(android.support.v4.media.g.class.getClassLoader());
                data.putInt("data_calling_uid", Binder.getCallingUid());
                int callingPid = Binder.getCallingPid();
                if (callingPid > 0) {
                    data.putInt("data_calling_pid", callingPid);
                } else if (!data.containsKey("data_calling_pid")) {
                    data.putInt("data_calling_pid", -1);
                }
                break;
        }
        return super.sendMessageAtTime(message, j4);
    }

    public f(TimeDownView timeDownView) {
        this.f470b = timeDownView;
    }

    public f(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.f470b = new xg.b(mediaBrowserServiceCompat);
    }
}
