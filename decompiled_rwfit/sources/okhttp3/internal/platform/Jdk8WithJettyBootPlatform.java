package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.Protocol;

/* loaded from: classes2.dex */
public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = new Companion(null);
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    public static final class AlpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public AlpnProvider(List<String> protocols) {
            e.f(protocols, "protocols");
            this.protocols = protocols;
        }

        public final String getSelected() {
            return this.selected;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] objArr) throws Throwable {
            e.f(proxy, "proxy");
            e.f(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (e.a(name, "supports") && e.a(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (e.a(name, "unsupported") && e.a(Void.TYPE, returnType)) {
                this.unsupported = true;
                return null;
            }
            if (e.a(name, "protocols") && objArr.length == 0) {
                return this.protocols;
            }
            if ((e.a(name, "selectProtocol") || e.a(name, "select")) && String.class.equals(returnType) && objArr.length == 1) {
                Object obj = objArr[0];
                if (obj instanceof List) {
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                    List list = (List) obj;
                    int size = list.size();
                    if (size >= 0) {
                        int i3 = 0;
                        while (true) {
                            Object obj2 = list.get(i3);
                            if (obj2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            String str = (String) obj2;
                            if (!this.protocols.contains(str)) {
                                if (i3 == size) {
                                    break;
                                }
                                i3++;
                            } else {
                                this.selected = str;
                                return str;
                            }
                        }
                    }
                    String str2 = this.protocols.get(0);
                    this.selected = str2;
                    return str2;
                }
            }
            if ((!e.a(name, "protocolSelected") && !e.a(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj3 = objArr[0];
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.selected = (String) obj3;
            return null;
        }

        public final void setSelected(String str) {
            this.selected = str;
        }

        public final void setUnsupported(boolean z5) {
            this.unsupported = z5;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
        
            if (java.lang.Integer.parseInt(r1) >= 9) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final okhttp3.internal.platform.Platform buildIfSupported() {
            /*
                r12 = this;
                java.lang.Class<javax.net.ssl.SSLSocket> r0 = javax.net.ssl.SSLSocket.class
                java.lang.String r1 = "java.specification.version"
                java.lang.String r2 = "unknown"
                java.lang.String r1 = java.lang.System.getProperty(r1, r2)
                r2 = 0
                java.lang.String r3 = "jvmVersion"
                kotlin.jvm.internal.e.e(r1, r3)     // Catch: java.lang.NumberFormatException -> L19
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L19
                r3 = 9
                if (r1 < r3) goto L19
                goto L6f
            L19:
                java.lang.String r1 = "org.eclipse.jetty.alpn.ALPN"
                r3 = 1
                java.lang.Class r1 = java.lang.Class.forName(r1, r3, r2)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r4 = "org.eclipse.jetty.alpn.ALPN$Provider"
                java.lang.Class r4 = java.lang.Class.forName(r4, r3, r2)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r5 = "org.eclipse.jetty.alpn.ALPN$ClientProvider"
                java.lang.Class r10 = java.lang.Class.forName(r5, r3, r2)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r5 = "org.eclipse.jetty.alpn.ALPN$ServerProvider"
                java.lang.Class r11 = java.lang.Class.forName(r5, r3, r2)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r3 = "put"
                java.lang.Class[] r4 = new java.lang.Class[]{r0, r4}     // Catch: java.lang.Throwable -> L6f
                java.lang.reflect.Method r7 = r1.getMethod(r3, r4)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r3 = "get"
                java.lang.Class[] r4 = new java.lang.Class[]{r0}     // Catch: java.lang.Throwable -> L6f
                java.lang.reflect.Method r8 = r1.getMethod(r3, r4)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r3 = "remove"
                java.lang.Class[] r0 = new java.lang.Class[]{r0}     // Catch: java.lang.Throwable -> L6f
                java.lang.reflect.Method r9 = r1.getMethod(r3, r0)     // Catch: java.lang.Throwable -> L6f
                okhttp3.internal.platform.Jdk8WithJettyBootPlatform r6 = new okhttp3.internal.platform.Jdk8WithJettyBootPlatform     // Catch: java.lang.Throwable -> L6f
                java.lang.String r0 = "putMethod"
                kotlin.jvm.internal.e.e(r7, r0)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r0 = "getMethod"
                kotlin.jvm.internal.e.e(r8, r0)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r0 = "removeMethod"
                kotlin.jvm.internal.e.e(r9, r0)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r0 = "clientProviderClass"
                kotlin.jvm.internal.e.e(r10, r0)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r0 = "serverProviderClass"
                kotlin.jvm.internal.e.e(r11, r0)     // Catch: java.lang.Throwable -> L6f
                r6.<init>(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L6f
                return r6
            L6f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.Jdk8WithJettyBootPlatform.Companion.buildIfSupported():okhttp3.internal.platform.Platform");
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public Jdk8WithJettyBootPlatform(Method putMethod, Method getMethod, Method removeMethod, Class<?> clientProviderClass, Class<?> serverProviderClass) {
        e.f(putMethod, "putMethod");
        e.f(getMethod, "getMethod");
        e.f(removeMethod, "removeMethod");
        e.f(clientProviderClass, "clientProviderClass");
        e.f(serverProviderClass, "serverProviderClass");
        this.putMethod = putMethod;
        this.getMethod = getMethod;
        this.removeMethod = removeMethod;
        this.clientProviderClass = clientProviderClass;
        this.serverProviderClass = serverProviderClass;
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(SSLSocket sslSocket) {
        e.f(sslSocket, "sslSocket");
        try {
            this.removeMethod.invoke(null, sslSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sslSocket, String str, List<? extends Protocol> protocols) {
        e.f(sslSocket, "sslSocket");
        e.f(protocols, "protocols");
        try {
            this.putMethod.invoke(null, sslSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(Platform.Companion.alpnProtocolNames(protocols))));
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sslSocket) {
        e.f(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke(null, sslSocket));
            if (invocationHandler == null) {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            AlpnProvider alpnProvider = (AlpnProvider) invocationHandler;
            if (!alpnProvider.getUnsupported() && alpnProvider.getSelected() == null) {
                Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (alpnProvider.getUnsupported()) {
                return null;
            }
            return alpnProvider.getSelected();
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        }
    }
}
