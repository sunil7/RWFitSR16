package pe;

import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class m extends we.a {
    @Override // pe.r
    public final byte a(int i3) {
        if (!b()) {
            ye.a.a("request get the status for the task[%d] in the download service", Integer.valueOf(i3));
            return (byte) 0;
        }
        try {
            return this.f19615b.a(i3);
        } catch (RemoteException e) {
            e.printStackTrace();
            return (byte) 0;
        }
    }

    @Override // pe.r
    public final boolean c(int i3) {
        if (!b()) {
            ye.a.a("request pause the task[%d] in the download service", Integer.valueOf(i3));
            return false;
        }
        try {
            return this.f19615b.c(i3);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // pe.r
    public final void j() {
        if (!b()) {
            ye.a.a("request cancel the foreground status[%B] for the download service", Boolean.TRUE);
            return;
        }
        try {
            this.f19615b.j(true);
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            this.f19617d = false;
        }
    }

    @Override // pe.r
    public final boolean n(String str, String str2, boolean z5) {
        if (!b()) {
            ye.a.a("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z5));
            return false;
        }
        try {
            this.f19615b.h(str, str2, z5, 100, 10, 0, false, null, false);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
