package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.log.SLog;

/* loaded from: classes2.dex */
public class a extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public static String f12128a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f12129b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f12130c = false;

    public a(InputConnection inputConnection, boolean z5) {
        super(inputConnection, z5);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i3) {
        f12130c = true;
        f12128a = charSequence.toString();
        SLog.v("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i3);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            SLog.i("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            f12128a = String.valueOf((char) keyEvent.getUnicodeChar());
            f12130c = true;
            SLog.d("openSDK_LOG.CaptureInputConnection", "s: " + f12128a);
        }
        SLog.d("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + f12128a);
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i3) {
        f12130c = true;
        f12128a = charSequence.toString();
        SLog.v("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i3);
    }
}
