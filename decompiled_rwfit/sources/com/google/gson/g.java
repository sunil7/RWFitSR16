package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes.dex */
public abstract class g {
    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            cc.b bVar = new cc.b(stringWriter);
            bVar.e = true;
            com.google.gson.internal.a.k(bVar, this);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
