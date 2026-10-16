package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.e;
import okhttp3.ConnectionSpec;

/* loaded from: classes2.dex */
public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(List<ConnectionSpec> connectionSpecs) {
        e.f(connectionSpecs, "connectionSpecs");
        this.connectionSpecs = connectionSpecs;
    }

    private final boolean isFallbackPossible(SSLSocket sSLSocket) {
        int size = this.connectionSpecs.size();
        for (int i3 = this.nextModeIndex; i3 < size; i3++) {
            if (this.connectionSpecs.get(i3).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public final ConnectionSpec configureSecureSocket(SSLSocket sslSocket) throws IOException {
        ConnectionSpec connectionSpec;
        e.f(sslSocket, "sslSocket");
        int i3 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i3 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.connectionSpecs.get(i3);
            if (connectionSpec.isCompatible(sslSocket)) {
                this.nextModeIndex = i3 + 1;
                break;
            }
            i3++;
        }
        if (connectionSpec != null) {
            this.isFallbackPossible = isFallbackPossible(sslSocket);
            connectionSpec.apply$okhttp(sslSocket, this.isFallback);
            return connectionSpec;
        }
        StringBuilder sb2 = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb2.append(this.isFallback);
        sb2.append(", modes=");
        sb2.append(this.connectionSpecs);
        sb2.append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        e.c(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        e.e(arrays, "java.util.Arrays.toString(this)");
        sb2.append(arrays);
        throw new UnknownServiceException(sb2.toString());
    }

    public final boolean connectionFailed(IOException e) {
        e.f(e, "e");
        this.isFallback = true;
        if (!this.isFallbackPossible || (e instanceof ProtocolException) || (e instanceof InterruptedIOException)) {
            return false;
        }
        return (((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException) || !(e instanceof SSLException)) ? false : true;
    }
}
