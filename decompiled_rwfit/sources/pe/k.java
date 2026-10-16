package pe;

import android.content.Context;
import android.content.Intent;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.services.FileDownloadService;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class k implements r, we.c {

    /* renamed from: a, reason: collision with root package name */
    public boolean f17575a = false;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f17576b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public we.d f17577c;

    @Override // pe.r
    public final byte a(int i3) {
        if (!b()) {
            ye.a.a("request get the status for the task[%d] in the download service", Integer.valueOf(i3));
            return (byte) 0;
        }
        FileDownloadModel L = ((re.a) this.f17577c.f19622b.f16732a).L(i3);
        if (L == null) {
            return (byte) 0;
        }
        return L.k();
    }

    @Override // pe.r
    public final boolean b() {
        return this.f17577c != null;
    }

    @Override // pe.r
    public final boolean c(int i3) {
        if (b()) {
            return this.f17577c.f19622b.l(i3);
        }
        ye.a.a("request pause the task[%d] in the download service", Integer.valueOf(i3));
        return false;
    }

    @Override // pe.r
    public final void j() {
        if (!b()) {
            ye.a.a("request cancel the foreground status[%B] for the download service", Boolean.TRUE);
        } else {
            this.f17577c.j(true);
            this.f17575a = false;
        }
    }

    @Override // pe.r
    public final boolean n(String str, String str2, boolean z5) {
        if (b()) {
            this.f17577c.h(str, str2, z5, 100, 10, 0, false, null, false);
            return true;
        }
        ye.a.a("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z5));
        return false;
    }

    @Override // pe.r
    public final boolean p() {
        return this.f17575a;
    }

    @Override // pe.r
    public final void s(Context context) {
        Intent intent = new Intent(context, (Class<?>) FileDownloadService.SharedMainProcessService.class);
        boolean j4 = ye.e.j(context);
        this.f17575a = j4;
        intent.putExtra("is_foreground", j4);
        if (this.f17575a) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
