package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public interface d {
    @CanIgnoreReturnValue
    @NullableDecl
    Object apply(@NullableDecl Object obj);

    boolean equals(@NullableDecl Object obj);
}
