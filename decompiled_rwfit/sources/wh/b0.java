package wh;

import com.google.android.gms.internal.mlkit_vision_common.e6;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* loaded from: classes2.dex */
public final class b0 extends e {

    /* renamed from: a, reason: collision with root package name */
    public final Socket f19637a;

    public b0(Socket socket) {
        kotlin.jvm.internal.e.f(socket, "socket");
        this.f19637a = socket;
    }

    @Override // wh.e
    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // wh.e
    public final void timedOut() {
        Socket socket = this.f19637a;
        try {
            socket.close();
        } catch (AssertionError e) {
            if (!e6.c(e)) {
                throw e;
            }
            t.f19667a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
        } catch (Exception e10) {
            t.f19667a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e10);
        }
    }
}
