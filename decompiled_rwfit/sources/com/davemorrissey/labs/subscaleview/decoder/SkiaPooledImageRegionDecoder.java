package com.davemorrissey.labs.subscaleview.decoder;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import r5.a;

/* loaded from: classes.dex */
public class SkiaPooledImageRegionDecoder implements ImageRegionDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = "SkiaPooledImageRegionDecoder";
    private static boolean debug = false;
    private final Bitmap.Config bitmapConfig;
    private Context context;
    private final ReadWriteLock decoderLock;
    private DecoderPool decoderPool;
    private long fileLength;
    private final Point imageDimensions;
    private final AtomicBoolean lazyInited;
    private Uri uri;

    public static class DecoderPool {
        private final Semaphore available;
        private final Map<BitmapRegionDecoder, Boolean> decoders;

        private DecoderPool() {
            this.available = new Semaphore(0, true);
            this.decoders = new ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BitmapRegionDecoder acquire() {
            this.available.acquireUninterruptibly();
            return getNextAvailable();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void add(BitmapRegionDecoder bitmapRegionDecoder) {
            this.decoders.put(bitmapRegionDecoder, Boolean.FALSE);
            this.available.release();
        }

        private synchronized BitmapRegionDecoder getNextAvailable() {
            for (Map.Entry<BitmapRegionDecoder, Boolean> entry : this.decoders.entrySet()) {
                if (!entry.getValue().booleanValue()) {
                    entry.setValue(Boolean.TRUE);
                    return entry.getKey();
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean isEmpty() {
            return this.decoders.isEmpty();
        }

        private synchronized boolean markAsUnused(BitmapRegionDecoder bitmapRegionDecoder) {
            for (Map.Entry<BitmapRegionDecoder, Boolean> entry : this.decoders.entrySet()) {
                if (bitmapRegionDecoder == entry.getKey()) {
                    if (!entry.getValue().booleanValue()) {
                        return false;
                    }
                    entry.setValue(Boolean.FALSE);
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void recycle() {
            while (!this.decoders.isEmpty()) {
                BitmapRegionDecoder acquire = acquire();
                acquire.recycle();
                this.decoders.remove(acquire);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release(BitmapRegionDecoder bitmapRegionDecoder) {
            if (markAsUnused(bitmapRegionDecoder)) {
                this.available.release();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized int size() {
            return this.decoders.size();
        }
    }

    @Keep
    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug(String str) {
        if (debug) {
            Log.d(TAG, str);
        }
    }

    private int getNumCoresOldPhones() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    private int getNumberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialiseDecoder() throws Exception {
        BitmapRegionDecoder bitmapRegionDecoder;
        int i3;
        String uri = this.uri.toString();
        boolean startsWith = uri.startsWith(RESOURCE_PREFIX);
        long j4 = Format.OFFSET_SAMPLE_RELATIVE;
        if (startsWith) {
            String authority = this.uri.getAuthority();
            Resources resources = this.context.getPackageName().equals(authority) ? this.context.getResources() : this.context.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = this.uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                i3 = resources.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i3 = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                    }
                }
                i3 = 0;
            }
            try {
                j4 = this.context.getResources().openRawResourceFd(i3).getLength();
            } catch (Exception unused2) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.context.getResources().openRawResource(i3), false);
        } else if (uri.startsWith(ASSET_PREFIX)) {
            String substring = uri.substring(22);
            try {
                j4 = this.context.getAssets().openFd(substring).getLength();
            } catch (Exception unused3) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.context.getAssets().open(substring, 1), false);
        } else if (uri.startsWith(FILE_PREFIX)) {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(uri.substring(7), false);
            try {
                File file = new File(uri);
                if (file.exists()) {
                    j4 = file.length();
                }
            } catch (Exception unused4) {
            }
            bitmapRegionDecoder = newInstance;
        } else {
            InputStream inputStream = null;
            try {
                ContentResolver contentResolver = this.context.getContentResolver();
                inputStream = contentResolver.openInputStream(this.uri);
                BitmapRegionDecoder newInstance2 = BitmapRegionDecoder.newInstance(inputStream, false);
                try {
                    AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.uri, "r");
                    if (openAssetFileDescriptor != null) {
                        j4 = openAssetFileDescriptor.getLength();
                    }
                } catch (Exception unused5) {
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused6) {
                    }
                }
                bitmapRegionDecoder = newInstance2;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused7) {
                    }
                }
                throw th2;
            }
        }
        this.fileLength = j4;
        this.imageDimensions.set(bitmapRegionDecoder.getWidth(), bitmapRegionDecoder.getHeight());
        this.decoderLock.writeLock().lock();
        try {
            DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                decoderPool.add(bitmapRegionDecoder);
            }
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    private boolean isLowMemory() {
        ActivityManager activityManager = (ActivityManager) this.context.getSystemService(Const.STR_PROCESS_TAG);
        if (activityManager == null) {
            return true;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    private void lazyInit() {
        if (!this.lazyInited.compareAndSet(false, true) || this.fileLength >= Format.OFFSET_SAMPLE_RELATIVE) {
            return;
        }
        debug("Starting lazy init of additional decoders");
        new Thread() { // from class: com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                    SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = SkiaPooledImageRegionDecoder.this;
                    if (!skiaPooledImageRegionDecoder.allowAdditionalDecoder(skiaPooledImageRegionDecoder.decoderPool.size(), SkiaPooledImageRegionDecoder.this.fileLength)) {
                        return;
                    }
                    try {
                        if (SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            SkiaPooledImageRegionDecoder.this.debug("Starting decoder");
                            SkiaPooledImageRegionDecoder.this.initialiseDecoder();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            SkiaPooledImageRegionDecoder.this.debug("Started decoder, took " + (currentTimeMillis2 - currentTimeMillis) + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
                        }
                    } catch (Exception e) {
                        SkiaPooledImageRegionDecoder.this.debug("Failed to start decoder: " + e.getMessage());
                    }
                }
            }
        }.start();
    }

    @Keep
    public static void setDebug(boolean z5) {
        debug = z5;
    }

    public boolean allowAdditionalDecoder(int i3, long j4) {
        if (i3 >= 4) {
            debug("No additional decoders allowed, reached hard limit (4)");
            return false;
        }
        long j10 = i3 * j4;
        if (j10 > 20971520) {
            debug("No additional encoders allowed, reached hard memory limit (20Mb)");
            return false;
        }
        if (i3 >= getNumberOfCores()) {
            debug(a.e(new StringBuilder("No additional encoders allowed, limited by CPU cores ("), getNumberOfCores(), ")"));
            return false;
        }
        if (isLowMemory()) {
            debug("No additional encoders allowed, memory is low");
            return false;
        }
        debug(e.n(e.q(i3, "Additional decoder allowed, current count is ", ", estimated native memory "), j10 / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, "Mb"));
        return true;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public Bitmap decodeRegion(Rect rect, int i3) {
        debug("Decode region " + rect + " on thread " + Thread.currentThread().getName());
        if (rect.width() < this.imageDimensions.x || rect.height() < this.imageDimensions.y) {
            lazyInit();
        }
        this.decoderLock.readLock().lock();
        try {
            DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                BitmapRegionDecoder acquire = decoderPool.acquire();
                if (acquire != null) {
                    try {
                        if (!acquire.isRecycled()) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inSampleSize = i3;
                            options.inPreferredConfig = this.bitmapConfig;
                            Bitmap decodeRegion = acquire.decodeRegion(rect, options);
                            if (decodeRegion != null) {
                                return decodeRegion;
                            }
                            throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                        }
                    } finally {
                        this.decoderPool.release(acquire);
                    }
                }
                if (acquire != null) {
                }
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } finally {
            this.decoderLock.readLock().unlock();
        }
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public Point init(Context context, Uri uri) throws Exception {
        this.context = context;
        this.uri = uri;
        initialiseDecoder();
        return this.imageDimensions;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public synchronized boolean isReady() {
        boolean z5;
        DecoderPool decoderPool = this.decoderPool;
        if (decoderPool != null) {
            z5 = decoderPool.isEmpty() ? false : true;
        }
        return z5;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public synchronized void recycle() {
        this.decoderLock.writeLock().lock();
        try {
            DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                decoderPool.recycle();
                this.decoderPool = null;
                this.context = null;
                this.uri = null;
            }
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config config) {
        this.decoderPool = new DecoderPool();
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.fileLength = Format.OFFSET_SAMPLE_RELATIVE;
        this.imageDimensions = new Point(0, 0);
        this.lazyInited = new AtomicBoolean(false);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = Bitmap.Config.RGB_565;
        }
    }
}
