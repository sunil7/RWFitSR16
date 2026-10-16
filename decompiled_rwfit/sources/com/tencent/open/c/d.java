package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.log.SLog;
import com.tencent.open.web.security.SecureJsInterface;

/* loaded from: classes2.dex */
public class d extends b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f12007a;

    /* renamed from: b, reason: collision with root package name */
    private KeyEvent f12008b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.open.web.security.a f12009c;

    public d(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode;
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f12007a);
        if (f12007a && keyEvent.getAction() == 0 && (keyCode = keyEvent.getKeyCode()) != 4 && keyCode != 66) {
            if (keyCode == 67) {
                com.tencent.open.web.security.a.f12129b = true;
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getUnicodeChar() == 0) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                return super.dispatchKeyEvent(keyEvent);
            }
            KeyEvent keyEvent2 = new KeyEvent(0, 17);
            this.f12008b = keyEvent2;
            return super.dispatchKeyEvent(keyEvent2);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        SLog.i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        SLog.v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + onCreateInputConnection);
        if (onCreateInputConnection == null) {
            f12007a = false;
            return onCreateInputConnection;
        }
        f12007a = true;
        com.tencent.open.web.security.a aVar = new com.tencent.open.web.security.a(super.onCreateInputConnection(editorInfo), false);
        this.f12009c = aVar;
        return aVar;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        int keyCode;
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f12007a);
        if (f12007a && keyEvent.getAction() == 0 && (keyCode = keyEvent.getKeyCode()) != 4 && keyCode != 66) {
            if (keyCode == 67) {
                com.tencent.open.web.security.a.f12129b = true;
                return super.onKeyDown(i3, keyEvent);
            }
            if (keyEvent.getUnicodeChar() == 0) {
                return super.onKeyDown(i3, keyEvent);
            }
            if (!SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                return super.onKeyDown(i3, keyEvent);
            }
            KeyEvent keyEvent2 = new KeyEvent(0, 17);
            this.f12008b = keyEvent2;
            return super.onKeyDown(keyEvent2.getKeyCode(), this.f12008b);
        }
        return super.onKeyDown(i3, keyEvent);
    }
}
