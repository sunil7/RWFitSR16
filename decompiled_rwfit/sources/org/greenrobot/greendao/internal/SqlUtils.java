package org.greenrobot.greendao.internal;

import android.support.v4.media.session.e;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;

/* loaded from: classes2.dex */
public class SqlUtils {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static StringBuilder appendColumn(StringBuilder sb2, String str) {
        sb2.append('\"');
        sb2.append(str);
        sb2.append('\"');
        return sb2;
    }

    public static StringBuilder appendColumns(StringBuilder sb2, String str, String[] strArr) {
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            appendColumn(sb2, str, strArr[i3]);
            if (i3 < length - 1) {
                sb2.append(',');
            }
        }
        return sb2;
    }

    public static StringBuilder appendColumnsEqValue(StringBuilder sb2, String str, String[] strArr) {
        for (int i3 = 0; i3 < strArr.length; i3++) {
            appendColumn(sb2, str, strArr[i3]).append("=?");
            if (i3 < strArr.length - 1) {
                sb2.append(',');
            }
        }
        return sb2;
    }

    public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder sb2, String[] strArr) {
        for (int i3 = 0; i3 < strArr.length; i3++) {
            appendColumn(sb2, strArr[i3]).append("=?");
            if (i3 < strArr.length - 1) {
                sb2.append(',');
            }
        }
        return sb2;
    }

    public static StringBuilder appendPlaceholders(StringBuilder sb2, int i3) {
        for (int i10 = 0; i10 < i3; i10++) {
            if (i10 < i3 - 1) {
                sb2.append("?,");
            } else {
                sb2.append('?');
            }
        }
        return sb2;
    }

    public static StringBuilder appendProperty(StringBuilder sb2, String str, Property property) {
        if (str != null) {
            sb2.append(str);
            sb2.append('.');
        }
        sb2.append('\"');
        sb2.append(property.columnName);
        sb2.append('\"');
        return sb2;
    }

    public static String createSqlCount(String str) {
        return "SELECT COUNT(*) FROM \"" + str + '\"';
    }

    public static String createSqlDelete(String str, String[] strArr) {
        String str2 = "\"" + str + '\"';
        StringBuilder sb2 = new StringBuilder("DELETE FROM ");
        sb2.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb2.append(" WHERE ");
            appendColumnsEqValue(sb2, str2, strArr);
        }
        return sb2.toString();
    }

    public static String createSqlInsert(String str, String str2, String[] strArr) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append('\"');
        sb2.append(str2);
        sb2.append("\" (");
        appendColumns(sb2, strArr);
        sb2.append(") VALUES (");
        appendPlaceholders(sb2, strArr.length);
        sb2.append(')');
        return sb2.toString();
    }

    public static String createSqlSelect(String str, String str2, String[] strArr, boolean z5) {
        if (str2 == null || str2.length() < 0) {
            throw new DaoException("Table alias required");
        }
        StringBuilder sb2 = new StringBuilder(z5 ? "SELECT DISTINCT " : "SELECT ");
        appendColumns(sb2, str2, strArr).append(" FROM ");
        sb2.append('\"');
        sb2.append(str);
        sb2.append('\"');
        sb2.append(' ');
        sb2.append(str2);
        sb2.append(' ');
        return sb2.toString();
    }

    public static String createSqlSelectCountStar(String str, String str2) {
        StringBuilder r = e.r("SELECT COUNT(*) FROM \"", str, "\" ");
        if (str2 != null) {
            r.append(str2);
            r.append(' ');
        }
        return r.toString();
    }

    public static String createSqlUpdate(String str, String[] strArr, String[] strArr2) {
        String str2 = "\"" + str + '\"';
        StringBuilder r = e.r("UPDATE ", str2, " SET ");
        appendColumnsEqualPlaceholders(r, strArr);
        r.append(" WHERE ");
        appendColumnsEqValue(r, str2, strArr2);
        return r.toString();
    }

    public static String escapeBlobArgument(byte[] bArr) {
        return "X'" + toHex(bArr) + '\'';
    }

    public static String toHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b3 = bArr[i3];
            int i10 = i3 * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i10] = cArr2[(b3 & 255) >>> 4];
            cArr[i10 + 1] = cArr2[b3 & 15];
        }
        return new String(cArr);
    }

    public static StringBuilder appendColumn(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(".\"");
        sb2.append(str2);
        sb2.append('\"');
        return sb2;
    }

    public static StringBuilder appendColumns(StringBuilder sb2, String[] strArr) {
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb2.append('\"');
            sb2.append(strArr[i3]);
            sb2.append('\"');
            if (i3 < length - 1) {
                sb2.append(',');
            }
        }
        return sb2;
    }
}
