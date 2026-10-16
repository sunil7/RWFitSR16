package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class Route {
    private final Address address;
    private final Proxy proxy;
    private final InetSocketAddress socketAddress;

    public Route(Address address, Proxy proxy, InetSocketAddress socketAddress) {
        e.f(address, "address");
        e.f(proxy, "proxy");
        e.f(socketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    /* renamed from: -deprecated_address, reason: not valid java name */
    public final Address m214deprecated_address() {
        return this.address;
    }

    /* renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m215deprecated_proxy() {
        return this.proxy;
    }

    /* renamed from: -deprecated_socketAddress, reason: not valid java name */
    public final InetSocketAddress m216deprecated_socketAddress() {
        return this.socketAddress;
    }

    public final Address address() {
        return this.address;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        return e.a(route.address, this.address) && e.a(route.proxy, this.proxy) && e.a(route.socketAddress, this.socketAddress);
    }

    public int hashCode() {
        return this.socketAddress.hashCode() + ((this.proxy.hashCode() + ((this.address.hashCode() + 527) * 31)) * 31);
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        return this.address.sslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    public String toString() {
        return "Route{" + this.socketAddress + '}';
    }
}
