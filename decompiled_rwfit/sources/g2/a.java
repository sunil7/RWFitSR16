package g2;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f13789d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final File f13790a;

    /* renamed from: b, reason: collision with root package name */
    public final Lock f13791b;

    /* renamed from: c, reason: collision with root package name */
    public FileChannel f13792c;

    public a(File file, String str) {
        Lock lock;
        this.f13790a = file != null ? new File(file, str.concat(".lck")) : null;
        HashMap hashMap = f13789d;
        synchronized (hashMap) {
            try {
                Object obj = hashMap.get(str);
                if (obj == null) {
                    obj = new ReentrantLock();
                    hashMap.put(str, obj);
                }
                lock = (Lock) obj;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f13791b = lock;
    }

    public final void a(boolean z5) {
        this.f13791b.lock();
        if (z5) {
            File file = this.f13790a;
            try {
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(file).getChannel();
                channel.lock();
                this.f13792c = channel;
            } catch (IOException e) {
                this.f13792c = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e);
            }
        }
    }

    public final void b() {
        try {
            FileChannel fileChannel = this.f13792c;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f13791b.unlock();
    }
}
