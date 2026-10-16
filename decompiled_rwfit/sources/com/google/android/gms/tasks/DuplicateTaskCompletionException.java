package com.google.android.gms.tasks;

import ia.f;
import ia.m;

/* loaded from: classes.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    public static IllegalStateException of(f fVar) {
        if (!fVar.e()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception c9 = fVar.c();
        return new DuplicateTaskCompletionException("Complete with: ".concat(c9 != null ? "failure" : fVar.f() ? "result ".concat(String.valueOf(fVar.d())) : ((m) fVar).f14401d ? "cancellation" : "unknown issue"), c9);
    }
}
