package com.example.test.service;

/* loaded from: classes.dex */
public final class l implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7728a;

    public l(d0 d0Var) {
        this.f7728a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7728a, "查找手机监控失败：", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0053, code lost:
    
        if (((android.os.Vibrator) r7.f12629b).hasVibrator() == false) goto L12;
     */
    @Override // u5.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 2
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto Le8
            int r7 = r7.intValue()
            boolean r1 = y5.d.f20005b
            r2 = 1
            r1 = r1 ^ r2
            if (r7 != r1) goto Ld4
            ef.i r7 = ef.i.y()
            java.lang.Object r1 = r7.f12629b
            android.os.Vibrator r1 = (android.os.Vibrator) r1
            r3 = 0
            if (r1 != 0) goto L56
            com.example.test.XXApplication r1 = com.example.test.XXApplication.f7400h
            com.example.test.XXApplication r1 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a()
            java.lang.String r4 = "vibrator"
            java.lang.Object r1 = r1.getSystemService(r4)
            android.os.Vibrator r1 = (android.os.Vibrator) r1
            r7.f12629b = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "手机是否有震动器 "
            r1.<init>(r4)
            java.lang.Object r4 = r7.f12629b
            android.os.Vibrator r4 = (android.os.Vibrator) r4
            boolean r4 = r4.hasVibrator()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r4 = "VibratorUtils"
            java.lang.Object[] r1 = new java.lang.Object[]{r4, r1}
            java.lang.String r4 = com.example.baselibrary.utils.b.f7264b
            com.example.baselibrary.utils.b.o(r4, r1)
            java.lang.Object r1 = r7.f12629b
            android.os.Vibrator r1 = (android.os.Vibrator) r1
            boolean r1 = r1.hasVibrator()
            if (r1 != 0) goto L56
            goto L66
        L56:
            long[] r1 = new long[r0]
            r1 = {x00ea: FILL_ARRAY_DATA , data: [500, 500} // fill-array
            android.os.VibrationEffect r1 = android.os.VibrationEffect.createWaveform(r1, r3)
            java.lang.Object r7 = r7.f12629b
            android.os.Vibrator r7 = (android.os.Vibrator) r7
            r7.vibrate(r1)
        L66:
            ef.i r7 = ef.i.y()
            com.example.test.XXApplication r1 = com.example.test.XXApplication.f7400h
            com.example.test.XXApplication r1 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a()
            r7.getClass()
            android.net.Uri r4 = android.media.RingtoneManager.getDefaultUri(r2)     // Catch: java.lang.Exception -> L9e
            android.media.MediaPlayer r5 = new android.media.MediaPlayer     // Catch: java.lang.Exception -> L9e
            r5.<init>()     // Catch: java.lang.Exception -> L9e
            r7.f12630c = r5     // Catch: java.lang.Exception -> L9e
            r5.setDataSource(r1, r4)     // Catch: java.lang.Exception -> L9e
            java.lang.Object r1 = r7.f12630c     // Catch: java.lang.Exception -> L9e
            android.media.MediaPlayer r1 = (android.media.MediaPlayer) r1     // Catch: java.lang.Exception -> L9e
            r1.setAudioStreamType(r0)     // Catch: java.lang.Exception -> L9e
            java.lang.Object r0 = r7.f12630c     // Catch: java.lang.Exception -> L9e
            android.media.MediaPlayer r0 = (android.media.MediaPlayer) r0     // Catch: java.lang.Exception -> L9e
            r0.setLooping(r2)     // Catch: java.lang.Exception -> L9e
            java.lang.Object r0 = r7.f12630c     // Catch: java.lang.Exception -> L9e
            android.media.MediaPlayer r0 = (android.media.MediaPlayer) r0     // Catch: java.lang.Exception -> L9e
            r0.prepare()     // Catch: java.lang.Exception -> L9e
            java.lang.Object r7 = r7.f12630c     // Catch: java.lang.Exception -> L9e
            android.media.MediaPlayer r7 = (android.media.MediaPlayer) r7     // Catch: java.lang.Exception -> L9e
            r7.start()     // Catch: java.lang.Exception -> L9e
            goto La2
        L9e:
            r7 = move-exception
            r7.printStackTrace()
        La2:
            boolean r7 = y5.d.f20005b
            if (r7 != 0) goto Le8
            com.example.test.XXApplication r7 = com.example.test.XXApplication.f7400h
            com.example.test.XXApplication r7 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a()
            android.app.Activity r7 = r7.c()
            if (r7 == 0) goto Le8
            com.example.test.ui.dialog.r r0 = new com.example.test.ui.dialog.r
            r0.<init>(r7)
            com.example.test.service.d0 r7 = r6.f7728a
            r7.getClass()
            int r7 = com.example.test.R$string.str_cancel_search_device
            r0.b(r7)
            r0.a()
            r0.setCancelable(r3)
            n9.e r7 = new n9.e
            r1 = 4
            r7.<init>(r1)
            r0.setOnDialogListener(r7)
            r0.show()
            goto Le8
        Ld4:
            ef.i r7 = ef.i.y()
            java.lang.Object r7 = r7.f12629b
            android.os.Vibrator r7 = (android.os.Vibrator) r7
            if (r7 == 0) goto Le1
            r7.cancel()
        Le1:
            ef.i r7 = ef.i.y()
            r7.N()
        Le8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.service.l.e(java.lang.Object):void");
    }
}
