package com.autonavi.base.amap.mapcore;

import com.amap.api.col.p0003sl.y4;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.annotations.ParameterIsClass;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class NativeBase {
    private static final String CREATE_OVERLAY = "createOverlay";
    private static final int LOG_SIZE = 10;
    private static final int STACK_NUMBER = 3;
    private static final String UPDATE_OPTIONS = "updateOptions";
    private boolean mCalledFuntion = false;
    protected boolean useRunnable = true;
    protected volatile boolean destroy = false;
    private int logSizeCount = 1;
    ArrayList<Method> methodMap = new ArrayList<>();
    ArrayList<NativeFunctionRunnable> runnableArrayList = new ArrayList<>();

    public static class Method {
        private boolean baseClass;
        private Class<?>[] clazz;
        private String methodName;
        private Object object;
        private Object[] param;

        public Method(Object obj, String str, boolean z5, Object... objArr) {
            this.object = obj;
            this.methodName = str;
            this.baseClass = z5;
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        this.clazz = new Class[objArr.length];
                        if (("createOverlay".equals(str) || "updateOptions".equals(str)) ? true : z5) {
                            for (int i3 = 0; i3 < objArr.length; i3++) {
                                if (i3 == 1) {
                                    this.clazz[i3] = objArr[i3].getClass().getSuperclass();
                                } else {
                                    this.clazz[i3] = objArr[i3].getClass();
                                }
                            }
                        } else {
                            for (int i10 = 0; i10 < objArr.length; i10++) {
                                this.clazz[i10] = objArr[i10].getClass();
                            }
                        }
                        this.param = new Object[objArr.length];
                        for (int i11 = 0; i11 < objArr.length; i11++) {
                            this.param[i11] = objArr[i11];
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized void callAllFunction() {
        int i3;
        java.lang.reflect.Method declaredMethod;
        Runnable runnable;
        if (isReady() && !this.destroy) {
            if (this.mCalledFuntion) {
                return;
            }
            try {
                this.mCalledFuntion = true;
                i3 = 0;
            } catch (Throwable unused) {
            }
            if (this.useRunnable) {
                while (this.runnableArrayList.size() > 0 && !this.destroy) {
                    NativeFunctionRunnable nativeFunctionRunnable = this.runnableArrayList.get(0);
                    if (nativeFunctionRunnable != null && (runnable = nativeFunctionRunnable.getRunnable()) != null) {
                        runnable.run();
                    }
                    this.runnableArrayList.remove(0);
                }
                this.logSizeCount = 1;
                return;
            }
            ArrayList<Method> arrayList = this.methodMap;
            int size = arrayList.size();
            while (i3 < size) {
                Method method = arrayList.get(i3);
                i3++;
                Method method2 = method;
                if (this.destroy) {
                    break;
                }
                if (method2.object != null && (declaredMethod = method2.object.getClass().getDeclaredMethod(method2.methodName, method2.clazz)) != null) {
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(method2.object, method2.param);
                }
            }
            this.methodMap.clear();
        }
    }

    public abstract void createNative();

    public void destroy() {
        this.destroy = true;
        synchronized (this) {
            this.runnableArrayList.clear();
            this.methodMap.clear();
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        try {
            finalizeNative();
        } catch (Throwable th2) {
            th2.toString();
        }
    }

    public abstract void finalizeNative();

    public int findRunnableIndex(NativeFunctionRunnable nativeFunctionRunnable) {
        if (this.runnableArrayList == null || nativeFunctionRunnable == null) {
            return -1;
        }
        for (int i3 = 0; i3 < this.runnableArrayList.size(); i3++) {
            NativeFunctionRunnable nativeFunctionRunnable2 = this.runnableArrayList.get(i3);
            if (nativeFunctionRunnable2 != null && nativeFunctionRunnable2.getKey().equals(nativeFunctionRunnable.getKey())) {
                return i3;
            }
        }
        return -1;
    }

    public abstract long getNative();

    public boolean isReady() {
        return getNative() != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized void storeUncallFunction(Object obj, Object obj2, String str, String str2, Object... objArr) {
        try {
            if (!this.useRunnable || obj2 == null) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            } else {
                NativeFunctionRunnable nativeFunctionRunnable = new NativeFunctionRunnable(str2, str, (Runnable) obj2);
                synchronized (this.runnableArrayList) {
                    int size = this.runnableArrayList.size();
                    if (size > this.logSizeCount * 10) {
                        y4.d("[map][overlay]", "storeUncallFunction size = " + size);
                        this.logSizeCount = this.logSizeCount + 1;
                    }
                    int findRunnableIndex = findRunnableIndex(nativeFunctionRunnable);
                    if (findRunnableIndex >= 0) {
                        this.runnableArrayList.remove(findRunnableIndex);
                    }
                    this.runnableArrayList.add(nativeFunctionRunnable);
                }
            }
            this.mCalledFuntion = false;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public synchronized void storeUncallFunctionArray(Object obj, Object obj2, String[] strArr, String str, Object[] objArr) {
        try {
            if (!this.useRunnable || obj2 == null) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            } else {
                StringBuilder sb2 = new StringBuilder("");
                for (String str2 : strArr) {
                    sb2.append(str2);
                    sb2.append(Const.STR_MART_COMMA);
                }
                NativeFunctionRunnable nativeFunctionRunnable = new NativeFunctionRunnable(str, sb2.toString(), (Runnable) obj2);
                synchronized (this.runnableArrayList) {
                    int size = this.runnableArrayList.size();
                    if (size > this.logSizeCount * 10) {
                        y4.d("[map][overlay]", "storeUncallFunctionArray size = " + size);
                        this.logSizeCount = this.logSizeCount + 1;
                    }
                    int findRunnableIndex = findRunnableIndex(nativeFunctionRunnable);
                    if (findRunnableIndex >= 0) {
                        this.runnableArrayList.remove(findRunnableIndex);
                    }
                    this.runnableArrayList.add(nativeFunctionRunnable);
                }
            }
            this.mCalledFuntion = false;
        } catch (Throwable unused) {
        }
    }

    public void validate() {
        ParameterIsClass parameterIsClass;
        Class<?>[] parameterTypes;
        java.lang.reflect.Method[] methods = getClass().getMethods();
        if (methods == null) {
            return;
        }
        for (java.lang.reflect.Method method : methods) {
            if (method.isAnnotationPresent(ParameterIsClass.class) && (parameterIsClass = (ParameterIsClass) method.getAnnotation(ParameterIsClass.class)) != null && parameterIsClass.required() && (parameterTypes = method.getParameterTypes()) != null) {
                for (Class<?> cls : parameterTypes) {
                    if (cls == null) {
                        throw new RuntimeException("函数：" + method + " 参数不是对象类型");
                    }
                }
            }
        }
    }
}
