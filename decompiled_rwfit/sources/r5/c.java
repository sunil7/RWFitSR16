package r5;

import android.os.Message;
import android.util.Log;
import com.example.baselibrary.utils.e;
import com.example.blesdk.bean.function.FileInfoBean;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import u5.i;

/* loaded from: classes.dex */
public final class c implements o5.a {

    /* renamed from: l, reason: collision with root package name */
    public static c f18074l;

    /* renamed from: a, reason: collision with root package name */
    public String f18075a;

    /* renamed from: b, reason: collision with root package name */
    public String f18076b;

    /* renamed from: c, reason: collision with root package name */
    public long f18077c;

    /* renamed from: d, reason: collision with root package name */
    public int f18078d;
    public float e;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18082i;

    /* renamed from: j, reason: collision with root package name */
    public int f18083j;

    /* renamed from: h, reason: collision with root package name */
    public int f18081h = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f18084k = 0;

    /* renamed from: g, reason: collision with root package name */
    public final e f18080g = new e(this);

    /* renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList f18079f = new CopyOnWriteArrayList();

    public static c h() {
        synchronized (c.class) {
            try {
                if (f18074l == null) {
                    f18074l = new c();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f18074l;
    }

    public final byte[] a(int i3) {
        try {
            byte[] c9 = c(false);
            byte[] bArr = new byte[9];
            if (this.f18081h == -1) {
                if (i3 == 0) {
                    this.f18081h = 2;
                } else {
                    this.f18081h = 3;
                }
            }
            int i10 = this.f18081h;
            char[] cArr = y5.b.f20001a;
            bArr[0] = (byte) (i10 & 255);
            File file = new File(this.f18075a);
            if (file.exists()) {
                byte[] r = y5.b.r(file.length());
                bArr[1] = r[0];
                bArr[2] = r[1];
                bArr[3] = r[2];
                bArr[4] = r[3];
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "当前位置：" + this.f18077c);
            byte[] r8 = y5.b.r(this.f18077c);
            bArr[5] = r8[0];
            bArr[6] = r8[1];
            bArr[7] = r8[2];
            bArr[8] = r8[3];
            byte[] bArr2 = new byte[c9.length + 9];
            System.arraycopy(bArr, 0, bArr2, 0, 9);
            System.arraycopy(c9, 0, bArr2, 9, c9.length);
            this.f18077c += c9.length;
            return bArr2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final byte[] b(int i3) {
        try {
            byte[] c9 = c(true);
            byte[] bArr = new byte[9];
            if (this.f18081h == -1) {
                if (i3 == 0) {
                    this.f18081h = 2;
                } else {
                    this.f18081h = 3;
                }
            }
            int i10 = this.f18081h;
            char[] cArr = y5.b.f20001a;
            bArr[0] = (byte) (i10 & 255);
            File file = new File(this.f18076b);
            if (file.exists()) {
                byte[] r = y5.b.r(file.length());
                bArr[1] = r[0];
                bArr[2] = r[1];
                bArr[3] = r[2];
                bArr[4] = r[3];
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "当前位置：" + this.f18077c);
            byte[] r8 = y5.b.r(this.f18077c);
            bArr[5] = r8[0];
            bArr[6] = r8[1];
            bArr[7] = r8[2];
            bArr[8] = r8[3];
            byte[] bArr2 = new byte[c9.length + 9];
            System.arraycopy(bArr, 0, bArr2, 0, 9);
            System.arraycopy(c9, 0, bArr2, 9, c9.length);
            this.f18077c += c9.length;
            return bArr2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final byte[] c(boolean z5) {
        long length;
        long j4;
        RandomAccessFile randomAccessFile = new RandomAccessFile(z5 ? this.f18076b : this.f18075a, "r");
        randomAccessFile.seek(this.f18077c);
        int i3 = this.f18078d;
        if (y5.d.f20005b) {
            i3 = y5.d.f20006c ? 164 : 2048;
            if (this.f18077c + i3 > randomAccessFile.length()) {
                length = randomAccessFile.length();
                j4 = this.f18077c;
                i3 = (int) (length - j4);
            }
        } else if (this.f18077c + i3 > randomAccessFile.length()) {
            length = randomAccessFile.length();
            j4 = this.f18077c;
            i3 = (int) (length - j4);
        }
        byte[] bArr = new byte[i3];
        randomAccessFile.read(bArr);
        randomAccessFile.close();
        return bArr;
    }

    public final byte[] d(byte b3) {
        try {
            byte[] c9 = c(false);
            byte[] bArr = new byte[12];
            bArr[0] = 7;
            bArr[1] = b3;
            bArr[2] = 0;
            bArr[3] = 0;
            File file = new File(this.f18075a);
            if (file.exists()) {
                byte[] r = y5.b.r(file.length());
                Log.e("qob", "getFileDataJL fileLength " + file.length());
                bArr[4] = r[3];
                bArr[5] = r[2];
                bArr[6] = r[1];
                bArr[7] = r[0];
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "当前位置：" + this.f18077c);
            byte[] r8 = y5.b.r(this.f18077c);
            bArr[8] = r8[3];
            bArr[9] = r8[2];
            bArr[10] = r8[1];
            bArr[11] = r8[0];
            byte[] bArr2 = new byte[c9.length + 12];
            System.arraycopy(bArr, 0, bArr2, 0, 12);
            System.arraycopy(c9, 0, bArr2, 12, c9.length);
            this.f18077c += c9.length;
            return bArr2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final byte[] e() {
        try {
            byte[] c9 = c(false);
            byte[] bArr = new byte[8];
            File file = new File(this.f18075a);
            if (file.exists()) {
                byte[] r = y5.b.r(file.length());
                bArr[0] = r[0];
                bArr[1] = r[1];
                bArr[2] = r[2];
                bArr[3] = r[3];
            }
            byte[] r8 = y5.b.r(this.f18077c);
            bArr[4] = r8[0];
            bArr[5] = r8[1];
            bArr[6] = r8[2];
            bArr[7] = r8[3];
            byte[] bArr2 = new byte[c9.length + 8];
            System.arraycopy(bArr, 0, bArr2, 0, 8);
            System.arraycopy(c9, 0, bArr2, 8, c9.length);
            this.f18077c += c9.length;
            return bArr2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final byte[] f() {
        try {
            byte[] c9 = c(false);
            byte[] bArr = new byte[12];
            File file = new File(this.f18075a);
            if (file.exists()) {
                byte[] r = y5.b.r(file.length());
                bArr[0] = r[0];
                bArr[1] = r[1];
                bArr[2] = r[2];
                bArr[3] = r[3];
            }
            byte[] r8 = y5.b.r(this.f18077c);
            bArr[4] = r8[0];
            bArr[5] = r8[1];
            bArr[6] = r8[2];
            bArr[7] = r8[3];
            byte[] a3 = y5.b.a(0, 2);
            bArr[8] = a3[1];
            bArr[9] = a3[0];
            byte[] a10 = y5.b.a(0, 2);
            bArr[10] = a10[1];
            bArr[11] = a10[0];
            byte[] bArr2 = new byte[c9.length + 12];
            System.arraycopy(bArr, 0, bArr2, 0, 12);
            System.arraycopy(c9, 0, bArr2, 12, c9.length);
            this.f18077c += c9.length;
            return bArr2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final byte[] g() {
        try {
            byte[] c9 = c(false);
            byte[] bArr = new byte[10];
            byte[] a3 = y5.b.a(100, 2);
            bArr[0] = a3[0];
            bArr[1] = a3[1];
            File file = new File(this.f18075a);
            if (file.exists()) {
                byte[] r = y5.b.r(file.length());
                bArr[2] = r[0];
                bArr[3] = r[1];
                bArr[4] = r[2];
                bArr[5] = r[3];
            }
            byte[] r8 = y5.b.r(this.f18077c);
            bArr[6] = r8[0];
            bArr[7] = r8[1];
            bArr[8] = r8[2];
            bArr[9] = r8[3];
            byte[] bArr2 = new byte[c9.length + 10];
            System.arraycopy(bArr, 0, bArr2, 0, 10);
            System.arraycopy(c9, 0, bArr2, 10, c9.length);
            this.f18077c += c9.length;
            return bArr2;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final long i(boolean z5) {
        File file = new File(z5 ? this.f18076b : this.f18075a);
        if (file.exists()) {
            return file.length();
        }
        return 1L;
    }

    public final boolean j(boolean z5) {
        File file = new File(z5 ? this.f18076b : this.f18075a);
        return file.exists() && this.f18077c < file.length();
    }

    public final boolean k(i iVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f18079f;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && weakReference.get() == iVar) {
                return true;
            }
        }
        return false;
    }

    public final boolean l(boolean z5) {
        return new File(z5 ? this.f18076b : this.f18075a).exists();
    }

    public final void m(int i3) {
        this.f18077c = 0L;
        this.f18075a = "";
        this.f18076b = "";
        this.f18081h = -1;
        this.f18083j = -1;
        this.f18084k = 0;
        Iterator it = this.f18079f.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null) {
                ((i) weakReference.get()).a(i3);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:167:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0307  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(boolean r19, byte[] r20) {
        /*
            Method dump skipped, instructions count: 1250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r5.c.n(boolean, byte[]):void");
    }

    public final void o(boolean z5, byte[] bArr, byte b3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输回调 isError = " + z5 + " delay = " + y5.b.h(bArr));
        int length = bArr.length;
        e eVar = this.f18080g;
        if (length < 3) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = 13;
            eVar.sendMessage(obtain);
            return;
        }
        if (!l(false)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------onFileTransferJL isFileExit 11---------");
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            obtain2.obj = 11;
            eVar.sendMessage(obtain2);
            return;
        }
        int i3 = bArr[3] & 255;
        int d5 = y5.b.d(4, 7, bArr);
        int d8 = y5.b.d(8, 11, bArr);
        StringBuilder s7 = l0.s(i3, "tDialIndex ", d5, " tDialFileSize ", " tDialFileIndex ");
        s7.append(d8);
        Log.e("qob", s7.toString());
        if ((i3 >> 4) > 0) {
            Message obtain3 = Message.obtain();
            obtain3.what = 2;
            obtain3.obj = 11;
            eVar.sendMessage(obtain3);
            return;
        }
        if (b3 == -9) {
            r();
            return;
        }
        if (b3 == -10) {
            p();
            return;
        }
        if (b3 == -85) {
            w();
            return;
        }
        if (b3 == -86) {
            v();
        } else if (b3 == -87) {
            s();
        } else if (b3 == 21) {
            t();
        }
    }

    public final void p() {
        boolean l3 = l(false);
        e eVar = this.f18080g;
        if (!l3) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startUiFile  11---------");
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = 11;
            eVar.sendMessage(obtain);
            return;
        }
        if (!j(false)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输结束");
            this.f18077c = 0L;
            this.f18075a = "";
            eVar.sendEmptyMessage(1);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前位置：" + this.f18077c);
        this.e = ((float) this.f18077c) / ((float) i(false));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前进度：" + this.e);
        Message obtain2 = Message.obtain();
        obtain2.what = 0;
        obtain2.obj = Float.valueOf(this.e);
        eVar.sendMessage(obtain2);
        byte[] d5 = d((byte) 4);
        if (d5 != null) {
            x5.c.b().g((byte) -10, d5, new boolean[0]);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startUiFile 12---------");
        Message obtain3 = Message.obtain();
        obtain3.what = 2;
        obtain3.obj = 12;
        eVar.sendMessage(obtain3);
    }

    public final void q(int i3) {
        boolean l3 = l(false);
        e eVar = this.f18080g;
        if (!l3) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startDial  11---------");
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = 11;
            eVar.sendMessage(obtain);
            return;
        }
        if (!j(false)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输结束");
            this.f18077c = 0L;
            this.f18075a = "";
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前位置：" + this.f18077c);
        byte[] a3 = a(i3);
        this.f18084k = this.f18084k + 1;
        if (a3 != null) {
            x5.d.c().j(Byte.MIN_VALUE, a3);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startDial 12---------");
        Message obtain2 = Message.obtain();
        obtain2.what = 2;
        obtain2.obj = 12;
        eVar.sendMessage(obtain2);
    }

    public final void r() {
        boolean l3 = l(false);
        e eVar = this.f18080g;
        if (!l3) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startUiFile  11---------");
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = 11;
            eVar.sendMessage(obtain);
            return;
        }
        if (!j(false)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输结束");
            this.f18077c = 0L;
            this.f18075a = "";
            eVar.sendEmptyMessage(1);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前位置：" + this.f18077c);
        this.e = ((float) this.f18077c) / ((float) i(false));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前进度：" + this.e);
        Message obtain2 = Message.obtain();
        obtain2.what = 0;
        obtain2.obj = Float.valueOf(this.e);
        eVar.sendMessage(obtain2);
        byte[] d5 = d((byte) 1);
        if (d5 != null) {
            x5.c.b().g((byte) -9, d5, new boolean[0]);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startUiFile 12---------");
        Message obtain3 = Message.obtain();
        obtain3.what = 2;
        obtain3.obj = 12;
        eVar.sendMessage(obtain3);
    }

    @Override // o5.a
    public final void r0(Message message) {
        int i3 = message.what;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f18079f;
        if (i3 == 0) {
            float floatValue = ((Float) message.obj).floatValue();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() != null) {
                    ((i) weakReference.get()).b(floatValue);
                }
            }
            return;
        }
        e eVar = this.f18080g;
        if (i3 == 1) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输完成，开始回调");
            eVar.removeMessages(2);
            this.f18077c = 0L;
            this.f18075a = "";
            this.f18076b = "";
            this.f18081h = -1;
            this.f18083j = -1;
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = Float.valueOf(1.0f);
            this.f18084k = 0;
            eVar.sendMessage(obtain);
            Iterator it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                WeakReference weakReference2 = (WeakReference) it2.next();
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((i) weakReference2.get()).onFinish();
                }
            }
            return;
        }
        if (i3 != 3) {
            if (i3 == 2) {
                Object obj = message.obj;
                if (obj != null) {
                    m(((Integer) obj).intValue());
                    return;
                } else {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------FILE_FAIL 12---------");
                    m(12);
                    return;
                }
            }
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "缩略图传输完成，开始传输表盘文件");
        eVar.removeMessages(2);
        this.f18077c = 0L;
        FileInfoBean fileInfoBean = new FileInfoBean();
        fileInfoBean.setFileType(0);
        File file = new File(this.f18075a);
        if (!file.exists()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------FILE_THUMB_FINISH 11---------");
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            obtain2.obj = 11;
            eVar.sendMessage(obtain2);
            return;
        }
        fileInfoBean.setFileLen(file.length());
        if (b.k().f18054c) {
            x5.d c9 = x5.d.c();
            int fileType = fileInfoBean.getFileType();
            char[] cArr = y5.b.f20001a;
            byte[] r = y5.b.r(fileInfoBean.getFileLen());
            c9.j((byte) -127, new byte[]{(byte) (fileType & 255), r[3], r[2], r[1], r[0]});
        } else {
            x5.b.I0().F0((byte) -127);
        }
        Message obtain3 = Message.obtain();
        obtain3.what = 0;
        obtain3.obj = Float.valueOf(0.3f);
        eVar.sendMessage(obtain3);
    }

    public final void s() {
        boolean l3 = l(false);
        e eVar = this.f18080g;
        if (!l3) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startUiFile  11---------");
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = 11;
            eVar.sendMessage(obtain);
            return;
        }
        if (!j(false)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输结束");
            this.f18077c = 0L;
            this.f18075a = "";
            eVar.sendEmptyMessage(1);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前位置：" + this.f18077c);
        this.e = ((float) this.f18077c) / ((float) i(false));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前进度：" + this.e);
        Message obtain2 = Message.obtain();
        obtain2.what = 0;
        obtain2.obj = Float.valueOf(this.e);
        eVar.sendMessage(obtain2);
        byte[] d5 = d((byte) 8);
        if (d5 != null) {
            x5.c.b().g((byte) -87, d5, new boolean[0]);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startUiFile 12---------");
        Message obtain3 = Message.obtain();
        obtain3.what = 2;
        obtain3.obj = 12;
        eVar.sendMessage(obtain3);
    }

    public final void t() {
        boolean l3 = l(false);
        e eVar = this.f18080g;
        if (!l3) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startPXIBinFile  11---------");
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = 11;
            eVar.sendMessage(obtain);
            return;
        }
        if (!j(false)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输结束");
            this.f18077c = 0L;
            this.f18075a = "";
            eVar.sendEmptyMessage(1);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前位置：" + this.f18077c);
        this.e = ((float) this.f18077c) / ((float) i(false));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前进度：" + this.e);
        Message obtain2 = Message.obtain();
        obtain2.what = 0;
        obtain2.obj = Float.valueOf(this.e);
        eVar.sendMessage(obtain2);
        byte[] d5 = d((byte) 12);
        if (d5 != null) {
            x5.c.b().g((byte) 21, d5, new boolean[0]);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startPXIBinFile 12---------");
        Message obtain3 = Message.obtain();
        obtain3.what = 2;
        obtain3.obj = 12;
        eVar.sendMessage(obtain3);
    }

    public final void u(int i3, String str, String str2) {
        FileInfoBean fileInfoBean = new FileInfoBean();
        File file = new File(str);
        if (file.exists()) {
            fileInfoBean.setFileLen(file.length());
            this.f18075a = str;
            this.f18076b = str2;
            this.e = 0.0f;
            this.f18083j = i3;
            if (i3 == 0 || i3 == 1) {
                this.f18078d = b.k().j() - 9;
                boolean z5 = file.length() < ((long) this.f18078d);
                this.f18082i = z5;
                if (z5) {
                    q(i3);
                    return;
                }
                fileInfoBean.setFileType(3);
                File file2 = new File(str2);
                if (file2.exists()) {
                    fileInfoBean.setFileLen(file2.length());
                    if (!b.k().f18054c) {
                        x5.b.I0().F0((byte) -127);
                        return;
                    }
                    x5.d c9 = x5.d.c();
                    int fileType = fileInfoBean.getFileType();
                    char[] cArr = y5.b.f20001a;
                    byte[] r = y5.b.r(fileInfoBean.getFileLen());
                    c9.j((byte) -127, new byte[]{(byte) (fileType & 255), r[3], r[2], r[1], r[0]});
                    return;
                }
                return;
            }
            if (i3 == 2) {
                this.f18078d = b.k().j() - 8;
                fileInfoBean.setFileType(2);
                if (!b.k().f18054c) {
                    x5.b.I0().F0((byte) -127);
                    return;
                }
                x5.d c10 = x5.d.c();
                int fileType2 = fileInfoBean.getFileType();
                char[] cArr2 = y5.b.f20001a;
                byte[] r8 = y5.b.r(fileInfoBean.getFileLen());
                c10.j((byte) -127, new byte[]{(byte) (fileType2 & 255), r8[3], r8[2], r8[1], r8[0]});
                return;
            }
            if (i3 == 3 || i3 == 4) {
                return;
            }
            if (i3 == 5) {
                this.f18078d = b.k().j() - 18;
                fileInfoBean.setFileType(1);
                if (!b.k().f18054c) {
                    x5.b.I0().F0((byte) -127);
                    return;
                }
                x5.d c11 = x5.d.c();
                int fileType3 = fileInfoBean.getFileType();
                char[] cArr3 = y5.b.f20001a;
                byte[] r9 = y5.b.r(fileInfoBean.getFileLen());
                c11.j((byte) -127, new byte[]{(byte) (fileType3 & 255), r9[3], r9[2], r9[1], r9[0]});
                return;
            }
            if (i3 == 6) {
                this.f18078d = b.k().j() - 18;
                fileInfoBean.setFileType(4);
                if (!b.k().f18054c) {
                    x5.b.I0().F0((byte) -127);
                    return;
                }
                x5.d c12 = x5.d.c();
                int fileType4 = fileInfoBean.getFileType();
                char[] cArr4 = y5.b.f20001a;
                byte[] r10 = y5.b.r(fileInfoBean.getFileLen());
                c12.j((byte) -127, new byte[]{(byte) (fileType4 & 255), r10[3], r10[2], r10[1], r10[0]});
                return;
            }
            if (i3 == 7) {
                this.f18078d = b.k().j();
                r();
                return;
            }
            if (i3 == 8) {
                this.f18078d = b.k().j() - 18;
                p();
                return;
            }
            if (i3 == 9) {
                this.f18078d = b.k().j() - 18;
                w();
                return;
            }
            if (i3 == 10) {
                this.f18078d = b.k().j();
                v();
            } else if (i3 == 11) {
                this.f18078d = b.k().j() - 18;
                s();
            } else if (i3 == 12) {
                this.f18078d = 185;
                t();
            }
        }
    }

    public final void v() {
        boolean l3 = l(false);
        e eVar = this.f18080g;
        if (!l3) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startUiFile  11---------");
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = 11;
            eVar.sendMessage(obtain);
            return;
        }
        if (!j(false)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输结束");
            this.f18077c = 0L;
            this.f18075a = "";
            eVar.sendEmptyMessage(1);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前位置：" + this.f18077c);
        this.e = ((float) this.f18077c) / ((float) i(false));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前进度：" + this.e);
        Message obtain2 = Message.obtain();
        obtain2.what = 0;
        obtain2.obj = Float.valueOf(this.e);
        eVar.sendMessage(obtain2);
        byte[] d5 = d((byte) 11);
        if (d5 != null) {
            x5.c.b().g((byte) -86, d5, new boolean[0]);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startUiFile 12---------");
        Message obtain3 = Message.obtain();
        obtain3.what = 2;
        obtain3.obj = 12;
        eVar.sendMessage(obtain3);
    }

    public final void w() {
        boolean l3 = l(false);
        e eVar = this.f18080g;
        if (!l3) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startUiFile  11---------");
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = 11;
            eVar.sendMessage(obtain);
            return;
        }
        if (!j(false)) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输结束");
            this.f18077c = 0L;
            this.f18075a = "";
            eVar.sendEmptyMessage(1);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前位置：" + this.f18077c);
        this.e = ((float) this.f18077c) / ((float) i(false));
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "FileTransferService", "文件传输当前进度：" + this.e);
        Message obtain2 = Message.obtain();
        obtain2.what = 0;
        obtain2.obj = Float.valueOf(this.e);
        eVar.sendMessage(obtain2);
        byte[] d5 = d((byte) 3);
        if (d5 != null) {
            x5.c.b().g((byte) -85, d5, new boolean[0]);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileTransferService", "---------startUiFile 12---------");
        Message obtain3 = Message.obtain();
        obtain3.what = 2;
        obtain3.obj = 12;
        eVar.sendMessage(obtain3);
    }
}
