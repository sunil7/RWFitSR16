package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.SystemClock;

/* loaded from: classes.dex */
public class PlaybackException extends Exception {
    public static final a CREATOR = new b9.a(22);
    public static final int CUSTOM_ERROR_CODE_BASE = 1000000;
    public static final int ERROR_CODE_AUDIO_TRACK_INIT_FAILED = 5001;
    public static final int ERROR_CODE_AUDIO_TRACK_WRITE_FAILED = 5002;
    public static final int ERROR_CODE_BEHIND_LIVE_WINDOW = 1002;
    public static final int ERROR_CODE_DECODER_INIT_FAILED = 4001;
    public static final int ERROR_CODE_DECODER_QUERY_FAILED = 4002;
    public static final int ERROR_CODE_DECODING_FAILED = 4003;
    public static final int ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES = 4004;
    public static final int ERROR_CODE_DECODING_FORMAT_UNSUPPORTED = 4005;
    public static final int ERROR_CODE_DRM_CONTENT_ERROR = 6003;
    public static final int ERROR_CODE_DRM_DEVICE_REVOKED = 6007;
    public static final int ERROR_CODE_DRM_DISALLOWED_OPERATION = 6005;
    public static final int ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED = 6004;
    public static final int ERROR_CODE_DRM_LICENSE_EXPIRED = 6008;
    public static final int ERROR_CODE_DRM_PROVISIONING_FAILED = 6002;
    public static final int ERROR_CODE_DRM_SCHEME_UNSUPPORTED = 6001;
    public static final int ERROR_CODE_DRM_SYSTEM_ERROR = 6006;
    public static final int ERROR_CODE_DRM_UNSPECIFIED = 6000;
    public static final int ERROR_CODE_FAILED_RUNTIME_CHECK = 1004;
    public static final int ERROR_CODE_IO_BAD_HTTP_STATUS = 2004;
    public static final int ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED = 2007;
    public static final int ERROR_CODE_IO_FILE_NOT_FOUND = 2005;
    public static final int ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE = 2003;
    public static final int ERROR_CODE_IO_NETWORK_CONNECTION_FAILED = 2001;
    public static final int ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT = 2002;
    public static final int ERROR_CODE_IO_NO_PERMISSION = 2006;
    public static final int ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE = 2008;
    public static final int ERROR_CODE_IO_UNSPECIFIED = 2000;
    public static final int ERROR_CODE_PARSING_CONTAINER_MALFORMED = 3001;
    public static final int ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED = 3003;
    public static final int ERROR_CODE_PARSING_MANIFEST_MALFORMED = 3002;
    public static final int ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED = 3004;
    public static final int ERROR_CODE_REMOTE_ERROR = 1001;
    public static final int ERROR_CODE_TIMEOUT = 1003;
    public static final int ERROR_CODE_UNSPECIFIED = 1000;
    protected static final int FIELD_CUSTOM_ID_BASE = 1000;
    public final int errorCode;
    public final long timestampMs;

    public PlaybackException(String str, Throwable th2, int i3) {
        this(str, th2, i3, SystemClock.elapsedRealtime());
    }

    public static String getErrorCodeName(int i3) {
        if (i3 == 5001) {
            return "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
        }
        if (i3 == 5002) {
            return "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
        }
        switch (i3) {
            case 1000:
                return "ERROR_CODE_UNSPECIFIED";
            case 1001:
                return "ERROR_CODE_REMOTE_ERROR";
            case 1002:
                return "ERROR_CODE_BEHIND_LIVE_WINDOW";
            case 1003:
                return "ERROR_CODE_TIMEOUT";
            case 1004:
                return "ERROR_CODE_FAILED_RUNTIME_CHECK";
            default:
                switch (i3) {
                    case 2000:
                        return "ERROR_CODE_IO_UNSPECIFIED";
                    case 2001:
                        return "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
                    case 2002:
                        return "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
                    case 2003:
                        return "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
                    case ERROR_CODE_IO_BAD_HTTP_STATUS /* 2004 */:
                        return "ERROR_CODE_IO_BAD_HTTP_STATUS";
                    case ERROR_CODE_IO_FILE_NOT_FOUND /* 2005 */:
                        return "ERROR_CODE_IO_FILE_NOT_FOUND";
                    case ERROR_CODE_IO_NO_PERMISSION /* 2006 */:
                        return "ERROR_CODE_IO_NO_PERMISSION";
                    case ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED /* 2007 */:
                        return "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
                    case ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE /* 2008 */:
                        return "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
                    default:
                        switch (i3) {
                            case 3001:
                                return "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
                            case 3002:
                                return "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
                            case 3003:
                                return "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
                            case ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED /* 3004 */:
                                return "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
                            default:
                                switch (i3) {
                                    case 4001:
                                        return "ERROR_CODE_DECODER_INIT_FAILED";
                                    case 4002:
                                        return "ERROR_CODE_DECODER_QUERY_FAILED";
                                    case ERROR_CODE_DECODING_FAILED /* 4003 */:
                                        return "ERROR_CODE_DECODING_FAILED";
                                    case ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES /* 4004 */:
                                        return "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
                                    case ERROR_CODE_DECODING_FORMAT_UNSUPPORTED /* 4005 */:
                                        return "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
                                    default:
                                        switch (i3) {
                                            case ERROR_CODE_DRM_UNSPECIFIED /* 6000 */:
                                                return "ERROR_CODE_DRM_UNSPECIFIED";
                                            case ERROR_CODE_DRM_SCHEME_UNSUPPORTED /* 6001 */:
                                                return "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                                            case ERROR_CODE_DRM_PROVISIONING_FAILED /* 6002 */:
                                                return "ERROR_CODE_DRM_PROVISIONING_FAILED";
                                            case ERROR_CODE_DRM_CONTENT_ERROR /* 6003 */:
                                                return "ERROR_CODE_DRM_CONTENT_ERROR";
                                            case ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED /* 6004 */:
                                                return "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                                            case ERROR_CODE_DRM_DISALLOWED_OPERATION /* 6005 */:
                                                return "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                                            case ERROR_CODE_DRM_SYSTEM_ERROR /* 6006 */:
                                                return "ERROR_CODE_DRM_SYSTEM_ERROR";
                                            case ERROR_CODE_DRM_DEVICE_REVOKED /* 6007 */:
                                                return "ERROR_CODE_DRM_DEVICE_REVOKED";
                                            case ERROR_CODE_DRM_LICENSE_EXPIRED /* 6008 */:
                                                return "ERROR_CODE_DRM_LICENSE_EXPIRED";
                                            default:
                                                return i3 >= 1000000 ? "custom error code" : "invalid error code";
                                        }
                                }
                        }
                }
        }
    }

    public static String keyForField(int i3) {
        return Integer.toString(i3, 36);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
    
        if (r3 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean errorInfoEquals(com.google.android.exoplayer2.PlaybackException r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L4
            return r0
        L4:
            r1 = 0
            if (r7 == 0) goto L5e
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L12
            goto L5e
        L12:
            java.lang.Throwable r2 = r6.getCause()
            java.lang.Throwable r3 = r7.getCause()
            if (r2 == 0) goto L3c
            if (r3 == 0) goto L3c
            java.lang.String r4 = r2.getMessage()
            java.lang.String r5 = r3.getMessage()
            boolean r4 = i9.g.a(r4, r5)
            if (r4 != 0) goto L2d
            return r1
        L2d:
            java.lang.Class r2 = r2.getClass()
            java.lang.Class r3 = r3.getClass()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L41
            return r1
        L3c:
            if (r2 != 0) goto L5e
            if (r3 == 0) goto L41
            goto L5e
        L41:
            int r2 = r6.errorCode
            int r3 = r7.errorCode
            if (r2 != r3) goto L5e
            java.lang.String r2 = r6.getMessage()
            java.lang.String r3 = r7.getMessage()
            boolean r2 = i9.g.a(r2, r3)
            if (r2 == 0) goto L5e
            long r2 = r6.timestampMs
            long r4 = r7.timestampMs
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 != 0) goto L5e
            return r0
        L5e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.PlaybackException.errorInfoEquals(com.google.android.exoplayer2.PlaybackException):boolean");
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(keyForField(0), this.errorCode);
        bundle.putLong(keyForField(1), this.timestampMs);
        bundle.putString(keyForField(2), getMessage());
        Throwable cause = getCause();
        if (cause != null) {
            bundle.putString(keyForField(3), cause.getClass().getName());
            bundle.putString(keyForField(4), cause.getMessage());
        }
        return bundle;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PlaybackException(android.os.Bundle r8) {
        /*
            r7 = this;
            r0 = 2
            java.lang.String r0 = keyForField(r0)
            java.lang.String r2 = r8.getString(r0)
            r0 = 3
            java.lang.String r0 = keyForField(r0)
            java.lang.String r0 = r8.getString(r0)
            r1 = 4
            java.lang.String r1 = keyForField(r1)
            java.lang.String r1 = r8.getString(r1)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L51
            java.lang.Class<com.google.android.exoplayer2.PlaybackException> r3 = com.google.android.exoplayer2.PlaybackException.class
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch: java.lang.Throwable -> L53
            java.lang.Class r0 = java.lang.Class.forName(r0, r4, r3)     // Catch: java.lang.Throwable -> L53
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            boolean r3 = r3.isAssignableFrom(r0)     // Catch: java.lang.Throwable -> L53
            if (r3 == 0) goto L4a
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            java.lang.Class[] r3 = new java.lang.Class[]{r3}     // Catch: java.lang.Throwable -> L53
            java.lang.reflect.Constructor r0 = r0.getConstructor(r3)     // Catch: java.lang.Throwable -> L53
            java.lang.Object[] r3 = new java.lang.Object[]{r1}     // Catch: java.lang.Throwable -> L53
            java.lang.Object r0 = r0.newInstance(r3)     // Catch: java.lang.Throwable -> L53
            r5 = r0
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch: java.lang.Throwable -> L53
        L4a:
            if (r5 != 0) goto L51
            android.os.RemoteException r5 = new android.os.RemoteException
            r5.<init>(r1)
        L51:
            r3 = r5
            goto L59
        L53:
            android.os.RemoteException r5 = new android.os.RemoteException
            r5.<init>(r1)
            goto L51
        L59:
            r0 = 0
            java.lang.String r0 = keyForField(r0)
            r1 = 1000(0x3e8, float:1.401E-42)
            int r0 = r8.getInt(r0, r1)
            java.lang.String r1 = keyForField(r4)
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r5 = r8.getLong(r1, r4)
            r1 = r7
            r4 = r0
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.PlaybackException.<init>(android.os.Bundle):void");
    }

    public PlaybackException(String str, Throwable th2, int i3, long j4) {
        super(str, th2);
        this.errorCode = i3;
        this.timestampMs = j4;
    }

    public final String getErrorCodeName() {
        return getErrorCodeName(this.errorCode);
    }
}
