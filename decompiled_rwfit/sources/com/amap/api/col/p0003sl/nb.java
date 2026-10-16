package com.amap.api.col.p0003sl;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.amap.api.col.p0003sl.c9;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class nb extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f4712a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4713b;

    /* renamed from: c, reason: collision with root package name */
    private SSLContext f4714c;

    public nb(Context context, SSLContext sSLContext) {
        if (context != null) {
            try {
                this.f4713b = context.getApplicationContext();
            } catch (Throwable th2) {
                try {
                    ka.a(th2, "myssl", "<init>");
                    try {
                        if (this.f4714c == null) {
                            this.f4714c = SSLContext.getDefault();
                        }
                    } catch (Throwable th3) {
                        ka.a(th3, "myssl", "<init2>");
                    }
                    try {
                        if (this.f4712a == null) {
                            this.f4712a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        ka.a(th4, "myssl", "<init3>");
                        return;
                    }
                } finally {
                }
            }
        }
        this.f4714c = sSLContext;
        if (sSLContext != null) {
            this.f4712a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f4714c == null) {
                this.f4714c = SSLContext.getDefault();
            }
        } catch (Throwable th5) {
            ka.a(th5, "myssl", "<init2>");
        }
        try {
            if (this.f4712a == null) {
                this.f4712a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th6) {
            ka.a(th6, "myssl", "<init3>");
        }
    }

    private static Socket a(Socket socket) {
        try {
            if (c9.g.f3863b && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
                return socket;
            }
        } catch (Throwable th2) {
            ka.a(th2, "myssl", "stlv2");
        }
        return socket;
    }

    private static void b(Socket socket) {
        int i3 = Build.VERSION.SDK_INT;
        if (c9.g.f3864c && c9.g.e && (socket instanceof SSLSocket)) {
            int i10 = c9.g.f3866f;
            int i11 = c9.g.f3865d;
            if (i10 > i11) {
                i10 = i11;
            }
            if (i10 <= 17 || i3 <= i10) {
                try {
                    socket.getClass().getMethod(n9.b("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th2) {
                    ka.a(th2, "myssl", "sust");
                }
            }
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        boolean z5;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f4712a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a3 = a(sSLSocketFactory.createSocket());
            b(a3);
            return a3;
        } finally {
            if (!z5) {
            }
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f4712a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th2) {
            ka.a(th2, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f4712a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th2) {
            ka.a(th2, "myssl", "gscs");
        }
        return new String[0];
    }

    public void a() {
        int i3 = Build.VERSION.SDK_INT;
        if (!c9.g.f3864c || this.f4713b == null || this.f4714c == null) {
            return;
        }
        int i10 = c9.g.f3865d;
        if (i10 <= 17 || i3 <= i10) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f4713b);
            if (i3 < 28) {
                try {
                    sSLSessionCache.getClass().getMethod(n9.b("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.f4714c);
                    return;
                } catch (Throwable th2) {
                    ka.a(th2, "myssl", "isc1");
                    a(sSLSessionCache);
                    return;
                }
            }
            a(sSLSessionCache);
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z5) throws IOException {
        boolean z6;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f4712a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a3 = a(sSLSocketFactory.createSocket(socket, str, i3, z5));
            b(a3);
            return a3;
        } finally {
            if (!z6) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f4712a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a3 = a(sSLSocketFactory.createSocket(str, i3));
            b(a3);
            return a3;
        } catch (Throwable th2) {
            ka.a(th2, "myssl", "cs3");
            if (!(th2 instanceof UnknownHostException)) {
                if (th2 instanceof IOException) {
                    throw th2;
                }
                return null;
            }
            throw th2;
        }
    }

    private void a(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.f4714c;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(n9.b("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String b3 = n9.b("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (Method method : methods) {
                if (method.getName().equals(b3)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (Throwable th2) {
            ka.a(th2, "myssl", "isc2");
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i10) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f4712a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a3 = a(sSLSocketFactory.createSocket(str, i3, inetAddress, i10));
            b(a3);
            return a3;
        } catch (Throwable th2) {
            ka.a(th2, "myssl", "cs4");
            if (!(th2 instanceof UnknownHostException)) {
                if (th2 instanceof IOException) {
                    throw th2;
                }
                return null;
            }
            throw th2;
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        boolean z5;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f4712a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a3 = a(sSLSocketFactory.createSocket(inetAddress, i3));
            b(a3);
            return a3;
        } finally {
            if (!z5) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i10) throws IOException {
        boolean z5;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f4712a;
            if (sSLSocketFactory == null) {
                return null;
            }
            Socket a3 = a(sSLSocketFactory.createSocket(inetAddress, i3, inetAddress2, i10));
            b(a3);
            return a3;
        } finally {
            if (!z5) {
            }
        }
    }
}
