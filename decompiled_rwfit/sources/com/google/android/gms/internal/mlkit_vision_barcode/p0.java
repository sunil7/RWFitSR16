package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class p0 {
    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.emoji2.text.q a(android.content.Context r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto Ld
            androidx.emoji2.text.c r0 = new androidx.emoji2.text.c
            r1 = 2
            r0.<init>(r1)
            goto L13
        Ld:
            eb.e r0 = new eb.e
            r1 = 2
            r0.<init>(r1)
        L13:
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            java.lang.String r2 = "Package manager required to locate emoji font provider"
            com.google.android.gms.internal.mlkit_vision_barcode.pd.e(r1, r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "androidx.content.action.LOAD_EMOJI_FONT"
            r2.<init>(r3)
            r3 = 0
            java.util.List r2 = r1.queryIntentContentProviders(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L2c:
            boolean r4 = r2.hasNext()
            r5 = 0
            if (r4 == 0) goto L48
            java.lang.Object r4 = r2.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ProviderInfo r4 = r4.providerInfo
            if (r4 == 0) goto L2c
            android.content.pm.ApplicationInfo r6 = r4.applicationInfo
            if (r6 == 0) goto L2c
            int r6 = r6.flags
            r7 = 1
            r6 = r6 & r7
            if (r6 != r7) goto L2c
            goto L49
        L48:
            r4 = r5
        L49:
            if (r4 != 0) goto L4d
        L4b:
            r1 = r5
            goto L7c
        L4d:
            java.lang.String r2 = r4.authority     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            java.lang.String r4 = r4.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            android.content.pm.Signature[] r0 = r0.s(r1, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            r1.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            int r6 = r0.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
        L5b:
            if (r3 >= r6) goto L69
            r7 = r0[r3]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            byte[] r7 = r7.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            r1.add(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            int r3 = r3 + 1
            goto L5b
        L69:
            java.util.List r0 = java.util.Collections.singletonList(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            androidx.camera.core.impl.e r1 = new androidx.camera.core.impl.e     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            java.lang.String r3 = "emojicompat-emoji-font"
            r1.<init>(r2, r4, r3, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            goto L7c
        L75:
            r0 = move-exception
            java.lang.String r1 = "emoji2.text.DefaultEmojiConfig"
            android.util.Log.wtf(r1, r0)
            goto L4b
        L7c:
            if (r1 != 0) goto L7f
            goto L89
        L7f:
            androidx.emoji2.text.q r5 = new androidx.emoji2.text.q
            androidx.emoji2.text.p r0 = new androidx.emoji2.text.p
            r0.<init>(r8, r1)
            r5.<init>(r0)
        L89:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.p0.a(android.content.Context):androidx.emoji2.text.q");
    }
}
