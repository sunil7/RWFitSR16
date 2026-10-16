package pe;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class g implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17564a;

    public /* synthetic */ g(int i3) {
        this.f17564a = i3;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f17564a) {
            case 0:
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 == 2) {
                        ArrayList arrayList = (ArrayList) message.obj;
                        int size = arrayList.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Object obj = arrayList.get(i10);
                            i10++;
                            i iVar = (i) obj;
                            if (!h.a(iVar)) {
                                iVar.a();
                            }
                        }
                        arrayList.clear();
                        f.f17563a.b();
                        break;
                    }
                } else {
                    ((i) message.obj).a();
                    break;
                }
                break;
            default:
                if (message.what == 1) {
                    ((z3.s) message.obj).recycle();
                    break;
                }
                break;
        }
        return true;
    }
}
