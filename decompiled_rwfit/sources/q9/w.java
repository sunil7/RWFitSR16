package q9;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* loaded from: classes.dex */
public final class w implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f17851a;

    public /* synthetic */ w(x xVar) {
        this.f17851a = xVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 0) {
            synchronized (this.f17851a.f17855a) {
                try {
                    u uVar = (u) message.obj;
                    v vVar = (v) this.f17851a.f17855a.get(uVar);
                    if (vVar != null && vVar.f17845a.isEmpty()) {
                        if (vVar.f17847c) {
                            vVar.f17850g.f17857c.removeMessages(1, vVar.e);
                            x xVar = vVar.f17850g;
                            xVar.f17858d.a(xVar.f17856b, vVar);
                            vVar.f17847c = false;
                            vVar.f17846b = 2;
                        }
                        this.f17851a.f17855a.remove(uVar);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i3 != 1) {
            return false;
        }
        synchronized (this.f17851a.f17855a) {
            try {
                u uVar2 = (u) message.obj;
                v vVar2 = (v) this.f17851a.f17855a.get(uVar2);
                if (vVar2 != null && vVar2.f17846b == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(uVar2)), new Exception());
                    ComponentName componentName = vVar2.f17849f;
                    if (componentName == null) {
                        uVar2.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = uVar2.f17843b;
                        n.e(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    vVar2.onServiceDisconnected(componentName);
                }
            } finally {
            }
        }
        return true;
    }
}
