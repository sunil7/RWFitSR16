package com.google.common.base;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f10996a;

    static {
        Charset.forName("US-ASCII");
        Charset.forName("ISO-8859-1");
        f10996a = Charset.forName("UTF-8");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-16");
    }
}
