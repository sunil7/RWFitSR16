package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
enum Maps$EntryFunction implements com.google.common.base.d {
    KEY { // from class: com.google.common.collect.Maps$EntryFunction.1
        @Override // com.google.common.collect.Maps$EntryFunction, com.google.common.base.d
        @NullableDecl
        public Object apply(Map.Entry<?, ?> entry) {
            return entry.getKey();
        }
    },
    VALUE { // from class: com.google.common.collect.Maps$EntryFunction.2
        @Override // com.google.common.collect.Maps$EntryFunction, com.google.common.base.d
        @NullableDecl
        public Object apply(Map.Entry<?, ?> entry) {
            return entry.getValue();
        }
    };

    Maps$EntryFunction(o1 o1Var) {
    }

    @Override // com.google.common.base.d
    @CanIgnoreReturnValue
    @NullableDecl
    public abstract /* synthetic */ Object apply(@NullableDecl Object obj);
}
