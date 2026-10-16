package b2;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import androidx.room.MultiInstanceInvalidationService;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class f extends RemoteCallbackList {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f3108a;

    public f(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f3108a = multiInstanceInvalidationService;
    }

    @Override // android.os.RemoteCallbackList
    public final void onCallbackDied(IInterface iInterface, Object obj) {
        HashMap hashMap = this.f3108a.f2819b;
        Integer num = (Integer) obj;
        num.intValue();
        hashMap.remove(num);
    }
}
