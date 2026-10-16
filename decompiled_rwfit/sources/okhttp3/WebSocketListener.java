package okhttp3;

import kotlin.jvm.internal.e;
import okio.ByteString;

/* loaded from: classes2.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i3, String reason) {
        e.f(webSocket, "webSocket");
        e.f(reason, "reason");
    }

    public void onClosing(WebSocket webSocket, int i3, String reason) {
        e.f(webSocket, "webSocket");
        e.f(reason, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable t8, Response response) {
        e.f(webSocket, "webSocket");
        e.f(t8, "t");
    }

    public void onMessage(WebSocket webSocket, String text) {
        e.f(webSocket, "webSocket");
        e.f(text, "text");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        e.f(webSocket, "webSocket");
        e.f(response, "response");
    }

    public void onMessage(WebSocket webSocket, ByteString bytes) {
        e.f(webSocket, "webSocket");
        e.f(bytes, "bytes");
    }
}
