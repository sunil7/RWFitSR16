package te;

import android.app.Notification;
import android.os.IInterface;
import com.liulishuo.filedownloader.model.FileDownloadHeader;

/* loaded from: classes2.dex */
public interface e extends IInterface {
    byte a(int i3);

    boolean c(int i3);

    boolean d(int i3);

    void h(String str, String str2, boolean z5, int i3, int i10, int i11, boolean z6, FileDownloadHeader fileDownloadHeader, boolean z8);

    long i(int i3);

    void j(boolean z5);

    void n(b bVar);

    boolean p();

    long q(int i3);

    void r();

    void s(b bVar);

    boolean t(String str, String str2);

    boolean u(int i3);

    void v(int i3, Notification notification);

    void w();
}
