package com.amap.api.col.p0003sl;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class ea {

    /* renamed from: a, reason: collision with root package name */
    private static volatile da f4023a;

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f4024b = new AtomicBoolean(false);

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (ea.class) {
                if (ea.f4023a == null) {
                    try {
                        da unused = ea.f4023a = ea.c();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private ea() {
    }

    public static /* synthetic */ da c() {
        da a3 = a(Build.MANUFACTURER);
        if (!"".equals(a3.a())) {
            return a3;
        }
        Iterator it = Arrays.asList(da.MIUI.a(), da.Flyme.a(), da.RH.a(), da.ColorOS.a(), da.FuntouchOS.a(), da.SmartisanOS.a(), da.AmigoOS.a(), da.Sense.a(), da.LG.a(), da.Google.a(), da.NubiaUI.a()).iterator();
        while (it.hasNext()) {
            da a10 = a((String) it.next());
            if (!"".equals(a10.a())) {
                return a10;
            }
        }
        return da.Other;
    }

    public static da a() {
        if (f4023a == null && f4024b.compareAndSet(false, true)) {
            new Thread(new a(), "RI").start();
        }
        return f4023a;
    }

    private static String b(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (!TextUtils.isEmpty(null)) {
            throw null;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(str)).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (IOException unused2) {
                if (bufferedReader == null) {
                    return null;
                }
                try {
                    bufferedReader.close();
                    return null;
                } catch (IOException unused3) {
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static da a(String str) {
        if (str != null && str.length() > 0) {
            da daVar = da.MIUI;
            if (str.equalsIgnoreCase(daVar.a())) {
                if (!TextUtils.isEmpty(b("ro.miui.ui.version.name"))) {
                    String b3 = b("ro.build.version.incremental");
                    a(daVar, b3);
                    daVar.b(b3);
                    return daVar;
                }
            } else {
                da daVar2 = da.Flyme;
                if (str.equalsIgnoreCase(daVar2.a())) {
                    String b10 = b("ro.flyme.published");
                    String b11 = b("ro.meizu.setupwizard.flyme");
                    if (!TextUtils.isEmpty(b10) || !TextUtils.isEmpty(b11)) {
                        String b12 = b("ro.build.display.id");
                        a(daVar2, b12);
                        daVar2.b(b12);
                        return daVar2;
                    }
                } else {
                    da daVar3 = da.RH;
                    if (str.equalsIgnoreCase(daVar3.a())) {
                        String b13 = b("ro.build.version.emui");
                        if (!TextUtils.isEmpty(b13)) {
                            a(daVar3, b13);
                            daVar3.b(b13);
                            return daVar3;
                        }
                    } else {
                        da daVar4 = da.ColorOS;
                        if (str.equalsIgnoreCase(daVar4.a())) {
                            String b14 = b("ro.build.version.opporom");
                            if (!TextUtils.isEmpty(b14)) {
                                a(daVar4, b14);
                                daVar4.b(b14);
                                return daVar4;
                            }
                        } else {
                            da daVar5 = da.FuntouchOS;
                            if (str.equalsIgnoreCase(daVar5.a())) {
                                String b15 = b("ro.vivo.os.build.display.id");
                                if (!TextUtils.isEmpty(b15)) {
                                    a(daVar5, b15);
                                    daVar5.b(b15);
                                    return daVar5;
                                }
                            } else {
                                da daVar6 = da.SmartisanOS;
                                if (str.equalsIgnoreCase(daVar6.a())) {
                                    String b16 = b("ro.smartisan.version");
                                    if (!TextUtils.isEmpty(b16)) {
                                        a(daVar6, b16);
                                        daVar6.b(b16);
                                        return daVar6;
                                    }
                                } else {
                                    da daVar7 = da.AmigoOS;
                                    if (str.equalsIgnoreCase(daVar7.a())) {
                                        String b17 = b("ro.build.display.id");
                                        if (!TextUtils.isEmpty(b17) && b17.matches("amigo([\\d.]+)[a-zA-Z]*")) {
                                            a(daVar7, b17);
                                            daVar7.b(b17);
                                            return daVar7;
                                        }
                                    } else {
                                        da daVar8 = da.EUI;
                                        if (str.equalsIgnoreCase(daVar8.a())) {
                                            String b18 = b("ro.letv.release.version");
                                            if (!TextUtils.isEmpty(b18)) {
                                                a(daVar8, b18);
                                                daVar8.b(b18);
                                                return daVar8;
                                            }
                                        } else {
                                            da daVar9 = da.Sense;
                                            if (str.equalsIgnoreCase(daVar9.a())) {
                                                String b19 = b("ro.build.sense.version");
                                                if (!TextUtils.isEmpty(b19)) {
                                                    a(daVar9, b19);
                                                    daVar9.b(b19);
                                                    return daVar9;
                                                }
                                            } else {
                                                da daVar10 = da.LG;
                                                if (str.equalsIgnoreCase(daVar10.a())) {
                                                    String b20 = b("sys.lge.lgmdm_version");
                                                    if (!TextUtils.isEmpty(b20)) {
                                                        a(daVar10, b20);
                                                        daVar10.b(b20);
                                                        return daVar10;
                                                    }
                                                } else {
                                                    da daVar11 = da.Google;
                                                    if (str.equalsIgnoreCase(daVar11.a())) {
                                                        if ("android-google".equals(b("ro.com.google.clientidbase"))) {
                                                            String b21 = b("ro.build.version.release");
                                                            daVar11.a(Build.VERSION.SDK_INT);
                                                            daVar11.b(b21);
                                                            return daVar11;
                                                        }
                                                    } else {
                                                        da daVar12 = da.NubiaUI;
                                                        if (str.equalsIgnoreCase(daVar12.a())) {
                                                            String b22 = b("ro.build.nubia.rom.code");
                                                            if (!TextUtils.isEmpty(b22)) {
                                                                a(daVar12, b22);
                                                                daVar12.b(b22);
                                                                return daVar12;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return da.Other;
        }
        return da.Other;
    }

    private static void a(da daVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                daVar.a(group);
                daVar.a(Integer.parseInt(group.split("\\.")[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
