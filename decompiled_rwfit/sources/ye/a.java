package ye;

import com.google.android.gms.internal.mlkit_vision_common.o6;

/* loaded from: classes2.dex */
public abstract class a {
    public static void a(String str, Object... objArr) {
        o6.b(a.class, str.concat(", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your code invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()"), objArr);
    }
}
