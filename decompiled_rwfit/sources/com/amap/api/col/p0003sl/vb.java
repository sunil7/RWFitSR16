package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.f9;
import com.amap.api.col.p0003sl.fb;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class vb {
    public static void a(Context context, ub ubVar, String str, int i3, int i10, String str2) {
        ubVar.f5150a = ha.a(context, str);
        ubVar.f5153d = i3;
        ubVar.f5151b = i10;
        ubVar.f5152c = str2;
    }

    public static ub a(WeakReference<ub> weakReference) {
        return (ub) new WeakReference(new ub()).get();
    }

    public static byte[] a(fb fbVar, String str) {
        fb.e eVar;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            eVar = fbVar.c(str);
            if (eVar != null) {
                try {
                    InputStream a3 = eVar.a(0);
                    if (a3 == null) {
                        if (a3 != null) {
                            try {
                                a3.close();
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        try {
                            eVar.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    } else {
                        bArr = new byte[a3.available()];
                        a3.read(bArr);
                        try {
                            a3.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                        try {
                            eVar.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        return bArr;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        ka.a(th, "sui", "rdS");
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                            }
                        }
                        if (eVar != null) {
                            try {
                                eVar.close();
                            } catch (Throwable th8) {
                                th8.printStackTrace();
                            }
                        }
                        return bArr;
                    } finally {
                    }
                }
            } else if (eVar != null) {
                try {
                    eVar.close();
                    return bArr;
                } catch (Throwable th9) {
                    th9.printStackTrace();
                }
            }
            return bArr;
        } catch (Throwable th10) {
            th = th10;
            eVar = null;
        }
    }

    public static void a(String str, byte[] bArr, ub ubVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        fb fbVar;
        boolean z5;
        OutputStream outputStream = null;
        try {
            try {
                z5 = new File(ubVar.f5150a, str + ".0").exists();
            } catch (Throwable th2) {
                ka.a(th2, "leg", "fet");
                z5 = false;
            }
            if (z5) {
                return;
            }
            File file = new File(ubVar.f5150a);
            if (!file.exists()) {
                file.mkdirs();
            }
            fbVar = fb.a(file, 1, 1, ubVar.f5151b);
            try {
                fbVar.a(ubVar.f5153d);
                byte[] b3 = ubVar.e.b(bArr);
                fb.d b10 = fbVar.b(str);
                outputStream = b10.a(0);
                outputStream.write(b3);
                b10.b();
                fbVar.i();
                try {
                    outputStream.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                try {
                    fbVar.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            } catch (Throwable th5) {
                th = th5;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
                if (fbVar != null) {
                    try {
                        fbVar.close();
                        throw th;
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            fbVar = null;
        }
    }

    public static String a(Context context, m9 m9Var) {
        StringBuilder sb2 = new StringBuilder();
        try {
            f9.d dVar = f9.e;
            sb2.append("\"sim\":\"");
            sb2.append("");
            sb2.append("\",\"sdkversion\":\"");
            sb2.append(m9Var.b());
            sb2.append("\",\"product\":\"");
            sb2.append(m9Var.d());
            sb2.append("\",\"ed\":\"");
            sb2.append(m9Var.a());
            sb2.append("\",\"nt\":\"");
            sb2.append(f9.j(context));
            sb2.append("\",\"np\":\"");
            sb2.append(f9.k(context));
            sb2.append("\",\"mnc\":\"");
            sb2.append("");
            sb2.append("\",\"ant\":\"");
            sb2.append(f9.i(context));
            sb2.append("\"");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return sb2.toString();
    }

    public static int a(ub ubVar) {
        ArrayList arrayList;
        byte[] a3;
        fb fbVar = null;
        try {
            try {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        if (ubVar.f5154f.b()) {
            ubVar.f5154f.a(true);
            fb a10 = fb.a(new File(ubVar.f5150a), 1, 1, ubVar.f5151b);
            try {
                arrayList = new ArrayList();
                a3 = a(a10, ubVar, arrayList);
            } catch (Throwable th4) {
                th = th4;
                fbVar = a10;
            }
            if (a3 != null && a3.length != 0) {
                JSONObject jSONObject = new JSONObject(new String(ib.a().a(new ia(a3, ubVar.f5152c)).f4927a));
                if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                    nc ncVar = ubVar.f5154f;
                    if (ncVar != null) {
                        ncVar.a(a3.length);
                    }
                    if (ubVar.f5154f.a() < Integer.MAX_VALUE) {
                        try {
                            int size = arrayList.size();
                            int i3 = 0;
                            while (i3 < size) {
                                Object obj = arrayList.get(i3);
                                i3++;
                                a10.d((String) obj);
                            }
                            a10.close();
                        } catch (Throwable th5) {
                            ka.a(th5, "ofm", "dlo");
                        }
                        return a3.length;
                    }
                    try {
                        a10.f();
                    } catch (Throwable th6) {
                        ka.a(th6, "ofm", "dlo");
                    }
                    return a3.length;
                    th = th4;
                    fbVar = a10;
                    try {
                        ka.a(th, "leg", "uts");
                        if (fbVar != null) {
                            fbVar.close();
                        }
                        return -1;
                    } catch (Throwable th7) {
                        if (fbVar != null) {
                            try {
                                fbVar.close();
                            } catch (Throwable th8) {
                                th8.printStackTrace();
                            }
                        }
                        throw th7;
                    }
                }
                fbVar = a10;
            }
            try {
                a10.close();
            } catch (Throwable th9) {
                th9.printStackTrace();
            }
            return -1;
        }
        if (fbVar != null) {
            fbVar.close();
        }
        return -1;
    }

    private static byte[] a(fb fbVar, ub ubVar, List<String> list) {
        try {
            File k10 = fbVar.k();
            if (k10 != null && k10.exists()) {
                int i3 = 0;
                for (String str : k10.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a3 = a(fbVar, str2);
                        i3 += a3.length;
                        list.add(str2);
                        if (i3 > ubVar.f5154f.a()) {
                            break;
                        }
                        ubVar.f5155g.a(a3);
                    }
                }
                if (i3 <= 0) {
                    return null;
                }
                return ubVar.f5155g.a();
            }
        } catch (Throwable th2) {
            ka.a(th2, "leg", "gCo");
        }
        return new byte[0];
    }
}
