package je;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Vibrator;
import com.king.camera.scan.R$raw;
import com.king.logx.LogX;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class d implements MediaPlayer.OnErrorListener, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f15420a;

    /* renamed from: b, reason: collision with root package name */
    public MediaPlayer f15421b = null;

    /* renamed from: c, reason: collision with root package name */
    public Vibrator f15422c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15423d;
    public boolean e;

    public d(Context context) {
        this.f15420a = context;
        b();
    }

    public final synchronized void b() {
        Vibrator defaultVibrator;
        try {
            if (this.f15421b == null) {
                Context context = this.f15420a;
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(R$raw.camera_scan_beep);
                    mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                    mediaPlayer.setOnErrorListener(this);
                    mediaPlayer.setLooping(false);
                    mediaPlayer.prepare();
                } catch (Exception e) {
                    LogX.w(e);
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                this.f15421b = mediaPlayer;
            }
            if (this.f15422c == null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    defaultVibrator = c.f(this.f15420a.getSystemService("vibrator_manager")).getDefaultVibrator();
                    this.f15422c = defaultVibrator;
                } else {
                    this.f15422c = (Vibrator) this.f15420a.getSystemService("vibrator");
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            MediaPlayer mediaPlayer = this.f15421b;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                this.f15421b = null;
            }
        } catch (Exception e) {
            LogX.w(e);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final synchronized boolean onError(MediaPlayer mediaPlayer, int i3, int i10) {
        close();
        b();
        return true;
    }
}
