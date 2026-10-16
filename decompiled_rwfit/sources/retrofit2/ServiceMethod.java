package retrofit2;

import android.support.v4.media.session.e;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import r5.a;
import retrofit2.ParameterHandler;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

/* loaded from: classes2.dex */
final class ServiceMethod<R, T> {
    private final HttpUrl baseUrl;
    private final CallAdapter<R, T> callAdapter;
    private final Call.Factory callFactory;
    private final MediaType contentType;
    private final boolean hasBody;
    private final Headers headers;
    private final String httpMethod;
    private final boolean isFormEncoded;
    private final boolean isMultipart;
    private final ParameterHandler<?>[] parameterHandlers;
    private final String relativeUrl;
    private final Converter<ResponseBody, R> responseConverter;
    static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
    static final Pattern PARAM_NAME_REGEX = Pattern.compile(PARAM);

    public static final class Builder<T, R> {
        CallAdapter<T, R> callAdapter;
        MediaType contentType;
        boolean gotBody;
        boolean gotField;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotUrl;
        boolean hasBody;
        Headers headers;
        String httpMethod;
        boolean isFormEncoded;
        boolean isMultipart;
        final Method method;
        final Annotation[] methodAnnotations;
        final Annotation[][] parameterAnnotationsArray;
        ParameterHandler<?>[] parameterHandlers;
        final Type[] parameterTypes;
        String relativeUrl;
        Set<String> relativeUrlParamNames;
        Converter<ResponseBody, T> responseConverter;
        Type responseType;
        final Retrofit retrofit;

        public Builder(Retrofit retrofit, Method method) {
            this.retrofit = retrofit;
            this.method = method;
            this.methodAnnotations = method.getAnnotations();
            this.parameterTypes = method.getGenericParameterTypes();
            this.parameterAnnotationsArray = method.getParameterAnnotations();
        }

        private CallAdapter<T, R> createCallAdapter() {
            Type genericReturnType = this.method.getGenericReturnType();
            if (Utils.hasUnresolvableType(genericReturnType)) {
                throw methodError("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            }
            if (genericReturnType == Void.TYPE) {
                throw methodError("Service methods cannot return void.", new Object[0]);
            }
            try {
                return (CallAdapter<T, R>) this.retrofit.callAdapter(genericReturnType, this.method.getAnnotations());
            } catch (RuntimeException e) {
                throw methodError(e, "Unable to create call adapter for %s", genericReturnType);
            }
        }

        private Converter<ResponseBody, T> createResponseConverter() {
            try {
                return this.retrofit.responseBodyConverter(this.responseType, this.method.getAnnotations());
            } catch (RuntimeException e) {
                throw methodError(e, "Unable to create converter for %s", this.responseType);
            }
        }

        private RuntimeException methodError(String str, Object... objArr) {
            return methodError(null, str, objArr);
        }

        private RuntimeException parameterError(Throwable th2, int i3, String str, Object... objArr) {
            StringBuilder u10 = l0.u(str, " (parameter #");
            u10.append(i3 + 1);
            u10.append(")");
            return methodError(th2, u10.toString(), objArr);
        }

        private Headers parseHeaders(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw methodError("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    MediaType parse = MediaType.parse(trim);
                    if (parse == null) {
                        throw methodError("Malformed content type: %s", trim);
                    }
                    this.contentType = parse;
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private void parseHttpMethodAndPath(String str, String str2, boolean z5) {
            String str3 = this.httpMethod;
            if (str3 != null) {
                throw methodError("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.httpMethod = str;
            this.hasBody = z5;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (ServiceMethod.PARAM_URL_REGEX.matcher(substring).find()) {
                    throw methodError("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.relativeUrl = str2;
            this.relativeUrlParamNames = ServiceMethod.parsePathParameters(str2);
        }

        private void parseMethodAnnotation(Annotation annotation) {
            if (annotation instanceof DELETE) {
                parseHttpMethodAndPath("DELETE", ((DELETE) annotation).value(), false);
                return;
            }
            if (annotation instanceof GET) {
                parseHttpMethodAndPath(Constants.HTTP_GET, ((GET) annotation).value(), false);
                return;
            }
            if (annotation instanceof HEAD) {
                parseHttpMethodAndPath("HEAD", ((HEAD) annotation).value(), false);
                if (!Void.class.equals(this.responseType)) {
                    throw methodError("HEAD method must use Void as response type.", new Object[0]);
                }
                return;
            }
            if (annotation instanceof PATCH) {
                parseHttpMethodAndPath("PATCH", ((PATCH) annotation).value(), true);
                return;
            }
            if (annotation instanceof POST) {
                parseHttpMethodAndPath(Constants.HTTP_POST, ((POST) annotation).value(), true);
                return;
            }
            if (annotation instanceof PUT) {
                parseHttpMethodAndPath("PUT", ((PUT) annotation).value(), true);
                return;
            }
            if (annotation instanceof OPTIONS) {
                parseHttpMethodAndPath("OPTIONS", ((OPTIONS) annotation).value(), false);
                return;
            }
            if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                parseHttpMethodAndPath(http.method(), http.path(), http.hasBody());
                return;
            }
            if (annotation instanceof retrofit2.http.Headers) {
                String[] value = ((retrofit2.http.Headers) annotation).value();
                if (value.length == 0) {
                    throw methodError("@Headers annotation is empty.", new Object[0]);
                }
                this.headers = parseHeaders(value);
                return;
            }
            if (annotation instanceof Multipart) {
                if (this.isFormEncoded) {
                    throw methodError("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.isMultipart = true;
            } else if (annotation instanceof FormUrlEncoded) {
                if (this.isMultipart) {
                    throw methodError("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.isFormEncoded = true;
            }
        }

        private ParameterHandler<?> parseParameter(int i3, Type type, Annotation[] annotationArr) {
            ParameterHandler<?> parameterHandler = null;
            for (Annotation annotation : annotationArr) {
                ParameterHandler<?> parseParameterAnnotation = parseParameterAnnotation(i3, type, annotationArr, annotation);
                if (parseParameterAnnotation != null) {
                    if (parameterHandler != null) {
                        throw parameterError(i3, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    parameterHandler = parseParameterAnnotation;
                }
            }
            if (parameterHandler != null) {
                return parameterHandler;
            }
            throw parameterError(i3, "No Retrofit annotation found.", new Object[0]);
        }

        private ParameterHandler<?> parseParameterAnnotation(int i3, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Url) {
                if (this.gotUrl) {
                    throw parameterError(i3, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.gotPath) {
                    throw parameterError(i3, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.gotQuery) {
                    throw parameterError(i3, "A @Url parameter must not come after a @Query", new Object[0]);
                }
                if (this.relativeUrl != null) {
                    throw parameterError(i3, "@Url cannot be used with @%s URL", this.httpMethod);
                }
                this.gotUrl = true;
                if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new ParameterHandler.RelativeUrl();
                }
                throw parameterError(i3, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof Path) {
                if (this.gotQuery) {
                    throw parameterError(i3, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.gotUrl) {
                    throw parameterError(i3, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.relativeUrl == null) {
                    throw parameterError(i3, "@Path can only be used with relative url on @%s", this.httpMethod);
                }
                this.gotPath = true;
                Path path = (Path) annotation;
                String value = path.value();
                validatePathName(i3, value);
                return new ParameterHandler.Path(value, this.retrofit.stringConverter(type, annotationArr), path.encoded());
            }
            if (annotation instanceof Query) {
                Query query = (Query) annotation;
                String value2 = query.value();
                boolean encoded = query.encoded();
                Class<?> rawType = Utils.getRawType(type);
                this.gotQuery = true;
                if (!Iterable.class.isAssignableFrom(rawType)) {
                    if (!rawType.isArray()) {
                        return new ParameterHandler.Query(value2, this.retrofit.stringConverter(type, annotationArr), encoded);
                    }
                    return new ParameterHandler.Query(value2, this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(rawType.getComponentType()), annotationArr), encoded).array();
                }
                if (type instanceof ParameterizedType) {
                    return new ParameterHandler.Query(value2, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded).iterable();
                }
                throw parameterError(i3, rawType.getSimpleName() + " must include generic type (e.g., " + rawType.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof QueryName) {
                boolean encoded2 = ((QueryName) annotation).encoded();
                Class<?> rawType2 = Utils.getRawType(type);
                this.gotQuery = true;
                if (!Iterable.class.isAssignableFrom(rawType2)) {
                    if (!rawType2.isArray()) {
                        return new ParameterHandler.QueryName(this.retrofit.stringConverter(type, annotationArr), encoded2);
                    }
                    return new ParameterHandler.QueryName(this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(rawType2.getComponentType()), annotationArr), encoded2).array();
                }
                if (type instanceof ParameterizedType) {
                    return new ParameterHandler.QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded2).iterable();
                }
                throw parameterError(i3, rawType2.getSimpleName() + " must include generic type (e.g., " + rawType2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof QueryMap) {
                Class<?> rawType3 = Utils.getRawType(type);
                if (!Map.class.isAssignableFrom(rawType3)) {
                    throw parameterError(i3, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type supertype = Utils.getSupertype(type, rawType3, Map.class);
                if (!(supertype instanceof ParameterizedType)) {
                    throw parameterError(i3, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) supertype;
                Type parameterUpperBound = Utils.getParameterUpperBound(0, parameterizedType);
                if (String.class == parameterUpperBound) {
                    return new ParameterHandler.QueryMap(this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
                }
                throw parameterError(i3, "@QueryMap keys must be of type String: " + parameterUpperBound, new Object[0]);
            }
            if (annotation instanceof Header) {
                String value3 = ((Header) annotation).value();
                Class<?> rawType4 = Utils.getRawType(type);
                if (!Iterable.class.isAssignableFrom(rawType4)) {
                    if (!rawType4.isArray()) {
                        return new ParameterHandler.Header(value3, this.retrofit.stringConverter(type, annotationArr));
                    }
                    return new ParameterHandler.Header(value3, this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(rawType4.getComponentType()), annotationArr)).array();
                }
                if (type instanceof ParameterizedType) {
                    return new ParameterHandler.Header(value3, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr)).iterable();
                }
                throw parameterError(i3, rawType4.getSimpleName() + " must include generic type (e.g., " + rawType4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof HeaderMap) {
                Class<?> rawType5 = Utils.getRawType(type);
                if (!Map.class.isAssignableFrom(rawType5)) {
                    throw parameterError(i3, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type supertype2 = Utils.getSupertype(type, rawType5, Map.class);
                if (!(supertype2 instanceof ParameterizedType)) {
                    throw parameterError(i3, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) supertype2;
                Type parameterUpperBound2 = Utils.getParameterUpperBound(0, parameterizedType2);
                if (String.class == parameterUpperBound2) {
                    return new ParameterHandler.HeaderMap(this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType2), annotationArr));
                }
                throw parameterError(i3, "@HeaderMap keys must be of type String: " + parameterUpperBound2, new Object[0]);
            }
            if (annotation instanceof Field) {
                if (!this.isFormEncoded) {
                    throw parameterError(i3, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                Field field = (Field) annotation;
                String value4 = field.value();
                boolean encoded3 = field.encoded();
                this.gotField = true;
                Class<?> rawType6 = Utils.getRawType(type);
                if (!Iterable.class.isAssignableFrom(rawType6)) {
                    if (!rawType6.isArray()) {
                        return new ParameterHandler.Field(value4, this.retrofit.stringConverter(type, annotationArr), encoded3);
                    }
                    return new ParameterHandler.Field(value4, this.retrofit.stringConverter(ServiceMethod.boxIfPrimitive(rawType6.getComponentType()), annotationArr), encoded3).array();
                }
                if (type instanceof ParameterizedType) {
                    return new ParameterHandler.Field(value4, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), encoded3).iterable();
                }
                throw parameterError(i3, rawType6.getSimpleName() + " must include generic type (e.g., " + rawType6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof FieldMap) {
                if (!this.isFormEncoded) {
                    throw parameterError(i3, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> rawType7 = Utils.getRawType(type);
                if (!Map.class.isAssignableFrom(rawType7)) {
                    throw parameterError(i3, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type supertype3 = Utils.getSupertype(type, rawType7, Map.class);
                if (!(supertype3 instanceof ParameterizedType)) {
                    throw parameterError(i3, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) supertype3;
                Type parameterUpperBound3 = Utils.getParameterUpperBound(0, parameterizedType3);
                if (String.class != parameterUpperBound3) {
                    throw parameterError(i3, "@FieldMap keys must be of type String: " + parameterUpperBound3, new Object[0]);
                }
                Converter<T, String> stringConverter = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, parameterizedType3), annotationArr);
                this.gotField = true;
                return new ParameterHandler.FieldMap(stringConverter, ((FieldMap) annotation).encoded());
            }
            if (!(annotation instanceof Part)) {
                if (!(annotation instanceof PartMap)) {
                    if (!(annotation instanceof Body)) {
                        return null;
                    }
                    if (this.isFormEncoded || this.isMultipart) {
                        throw parameterError(i3, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                    }
                    if (this.gotBody) {
                        throw parameterError(i3, "Multiple @Body method annotations found.", new Object[0]);
                    }
                    try {
                        Converter<T, RequestBody> requestBodyConverter = this.retrofit.requestBodyConverter(type, annotationArr, this.methodAnnotations);
                        this.gotBody = true;
                        return new ParameterHandler.Body(requestBodyConverter);
                    } catch (RuntimeException e) {
                        throw parameterError(e, i3, "Unable to create @Body converter for %s", type);
                    }
                }
                if (!this.isMultipart) {
                    throw parameterError(i3, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.gotPart = true;
                Class<?> rawType8 = Utils.getRawType(type);
                if (!Map.class.isAssignableFrom(rawType8)) {
                    throw parameterError(i3, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type supertype4 = Utils.getSupertype(type, rawType8, Map.class);
                if (!(supertype4 instanceof ParameterizedType)) {
                    throw parameterError(i3, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) supertype4;
                Type parameterUpperBound4 = Utils.getParameterUpperBound(0, parameterizedType4);
                if (String.class != parameterUpperBound4) {
                    throw parameterError(i3, "@PartMap keys must be of type String: " + parameterUpperBound4, new Object[0]);
                }
                Type parameterUpperBound5 = Utils.getParameterUpperBound(1, parameterizedType4);
                if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(parameterUpperBound5))) {
                    throw parameterError(i3, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                }
                return new ParameterHandler.PartMap(this.retrofit.requestBodyConverter(parameterUpperBound5, annotationArr, this.methodAnnotations), ((PartMap) annotation).encoding());
            }
            if (!this.isMultipart) {
                throw parameterError(i3, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            Part part = (Part) annotation;
            this.gotPart = true;
            String value5 = part.value();
            Class<?> rawType9 = Utils.getRawType(type);
            if (value5.isEmpty()) {
                if (!Iterable.class.isAssignableFrom(rawType9)) {
                    if (rawType9.isArray()) {
                        if (MultipartBody.Part.class.isAssignableFrom(rawType9.getComponentType())) {
                            return ParameterHandler.RawPart.INSTANCE.array();
                        }
                        throw parameterError(i3, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (MultipartBody.Part.class.isAssignableFrom(rawType9)) {
                        return ParameterHandler.RawPart.INSTANCE;
                    }
                    throw parameterError(i3, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                if (type instanceof ParameterizedType) {
                    if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) type)))) {
                        return ParameterHandler.RawPart.INSTANCE.iterable();
                    }
                    throw parameterError(i3, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                throw parameterError(i3, rawType9.getSimpleName() + " must include generic type (e.g., " + rawType9.getSimpleName() + "<String>)", new Object[0]);
            }
            Headers of2 = Headers.of("Content-Disposition", l0.o("form-data; name=\"", value5, "\""), "Content-Transfer-Encoding", part.encoding());
            if (!Iterable.class.isAssignableFrom(rawType9)) {
                if (!rawType9.isArray()) {
                    if (MultipartBody.Part.class.isAssignableFrom(rawType9)) {
                        throw parameterError(i3, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new ParameterHandler.Part(of2, this.retrofit.requestBodyConverter(type, annotationArr, this.methodAnnotations));
                }
                Class<?> boxIfPrimitive = ServiceMethod.boxIfPrimitive(rawType9.getComponentType());
                if (MultipartBody.Part.class.isAssignableFrom(boxIfPrimitive)) {
                    throw parameterError(i3, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new ParameterHandler.Part(of2, this.retrofit.requestBodyConverter(boxIfPrimitive, annotationArr, this.methodAnnotations)).array();
            }
            if (type instanceof ParameterizedType) {
                Type parameterUpperBound6 = Utils.getParameterUpperBound(0, (ParameterizedType) type);
                if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(parameterUpperBound6))) {
                    throw parameterError(i3, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new ParameterHandler.Part(of2, this.retrofit.requestBodyConverter(parameterUpperBound6, annotationArr, this.methodAnnotations)).iterable();
            }
            throw parameterError(i3, rawType9.getSimpleName() + " must include generic type (e.g., " + rawType9.getSimpleName() + "<String>)", new Object[0]);
        }

        private void validatePathName(int i3, String str) {
            if (!ServiceMethod.PARAM_NAME_REGEX.matcher(str).matches()) {
                throw parameterError(i3, "@Path parameter name must match %s. Found: %s", ServiceMethod.PARAM_URL_REGEX.pattern(), str);
            }
            if (!this.relativeUrlParamNames.contains(str)) {
                throw parameterError(i3, "URL \"%s\" does not contain \"{%s}\".", this.relativeUrl, str);
            }
        }

        public ServiceMethod build() {
            CallAdapter<T, R> createCallAdapter = createCallAdapter();
            this.callAdapter = createCallAdapter;
            Type responseType = createCallAdapter.responseType();
            this.responseType = responseType;
            if (responseType == Response.class || responseType == okhttp3.Response.class) {
                throw methodError("'" + Utils.getRawType(this.responseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
            }
            this.responseConverter = createResponseConverter();
            for (Annotation annotation : this.methodAnnotations) {
                parseMethodAnnotation(annotation);
            }
            if (this.httpMethod == null) {
                throw methodError("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.hasBody) {
                if (this.isMultipart) {
                    throw methodError("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.isFormEncoded) {
                    throw methodError("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.parameterAnnotationsArray.length;
            this.parameterHandlers = new ParameterHandler[length];
            for (int i3 = 0; i3 < length; i3++) {
                Type type = this.parameterTypes[i3];
                if (Utils.hasUnresolvableType(type)) {
                    throw parameterError(i3, "Parameter type must not include a type variable or wildcard: %s", type);
                }
                Annotation[] annotationArr = this.parameterAnnotationsArray[i3];
                if (annotationArr == null) {
                    throw parameterError(i3, "No Retrofit annotation found.", new Object[0]);
                }
                this.parameterHandlers[i3] = parseParameter(i3, type, annotationArr);
            }
            if (this.relativeUrl == null && !this.gotUrl) {
                throw methodError("Missing either @%s URL or @Url parameter.", this.httpMethod);
            }
            boolean z5 = this.isFormEncoded;
            if (!z5 && !this.isMultipart && !this.hasBody && this.gotBody) {
                throw methodError("Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z5 && !this.gotField) {
                throw methodError("Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.isMultipart || this.gotPart) {
                return new ServiceMethod(this);
            }
            throw methodError("Multipart method must contain at least one @Part.", new Object[0]);
        }

        private RuntimeException methodError(Throwable th2, String str, Object... objArr) {
            StringBuilder u10 = l0.u(String.format(str, objArr), "\n    for method ");
            u10.append(this.method.getDeclaringClass().getSimpleName());
            u10.append(".");
            u10.append(this.method.getName());
            return new IllegalArgumentException(u10.toString(), th2);
        }

        private RuntimeException parameterError(int i3, String str, Object... objArr) {
            StringBuilder u10 = l0.u(str, " (parameter #");
            u10.append(i3 + 1);
            u10.append(")");
            return methodError(u10.toString(), objArr);
        }
    }

    public ServiceMethod(Builder<R, T> builder) {
        this.callFactory = builder.retrofit.callFactory();
        this.callAdapter = builder.callAdapter;
        this.baseUrl = builder.retrofit.baseUrl();
        this.responseConverter = builder.responseConverter;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
    }

    public static Class<?> boxIfPrimitive(Class<?> cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }

    public static Set<String> parsePathParameters(String str) {
        Matcher matcher = PARAM_URL_REGEX.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    public T adapt(Call<R> call) {
        return this.callAdapter.adapt(call);
    }

    public okhttp3.Call toCall(@Nullable Object... objArr) throws IOException {
        RequestBuilder requestBuilder = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
        ParameterHandler<?>[] parameterHandlerArr = this.parameterHandlers;
        int length = objArr != null ? objArr.length : 0;
        if (length != parameterHandlerArr.length) {
            throw new IllegalArgumentException(a.e(e.q(length, "Argument count (", ") doesn't match expected count ("), parameterHandlerArr.length, ")"));
        }
        for (int i3 = 0; i3 < length; i3++) {
            parameterHandlerArr[i3].apply(requestBuilder, objArr[i3]);
        }
        return this.callFactory.newCall(requestBuilder.build());
    }

    public R toResponse(ResponseBody responseBody) throws IOException {
        return this.responseConverter.convert(responseBody);
    }
}
