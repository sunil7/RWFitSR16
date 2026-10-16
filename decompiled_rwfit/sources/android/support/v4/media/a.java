package android.support.v4.media;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f300a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f301b;

    public a(e eVar) {
        this.f300a = new WeakReference(eVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        WeakReference weakReference = this.f301b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        WeakReference weakReference2 = this.f300a;
        if (weakReference2.get() == null) {
            return;
        }
        Bundle data = message.getData();
        android.support.v4.media.session.g.a(data);
        e eVar = (e) weakReference2.get();
        Messenger messenger = (Messenger) this.f301b.get();
        try {
            int i3 = message.what;
            if (i3 == 1) {
                android.support.v4.media.session.g.a(data.getBundle("data_root_hints"));
                data.getString("data_media_item_id");
                eVar.getClass();
                return;
            }
            if (i3 == 2) {
                eVar.getClass();
                return;
            }
            if (i3 != 3) {
                Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                return;
            }
            android.support.v4.media.session.g.a(data.getBundle("data_options"));
            android.support.v4.media.session.g.a(data.getBundle("data_notify_children_changed_options"));
            String string = data.getString("data_media_item_id");
            data.getParcelableArrayList("data_media_item_list");
            if (eVar.f308g != messenger) {
                return;
            }
            if (eVar.e.getOrDefault(string, null) != null) {
                throw new ClassCastException();
            }
            if (g.f310b) {
                Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + string);
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaBrowserCompat", "Could not unparcel the data.");
            if (message.what == 1) {
                eVar.getClass();
            }
        }
    }
}
