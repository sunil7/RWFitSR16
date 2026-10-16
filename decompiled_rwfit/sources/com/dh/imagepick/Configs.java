package com.dh.imagepick;

import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class Configs {
    public static final Builder Builder = new Builder(null);
    private static String cropsResultFile;

    public static final class Builder {
        public /* synthetic */ Builder(c cVar) {
            this();
        }

        public final void configCropsResultFile(String file) {
            e.f(file, "file");
            setCropsResultFile$imagepick_release(file);
        }

        public final String getCropsResultFile$imagepick_release() {
            return Configs.cropsResultFile;
        }

        public final void setCropsResultFile$imagepick_release(String str) {
            Configs.cropsResultFile = str;
        }

        public final void setDebug(boolean z5) {
            DevUtil.INSTANCE.setDebug(z5);
        }

        private Builder() {
        }
    }

    public static final void configCropsResultFile(String str) {
        Builder.configCropsResultFile(str);
    }

    public static final void setDebug(boolean z5) {
        Builder.setDebug(z5);
    }
}
