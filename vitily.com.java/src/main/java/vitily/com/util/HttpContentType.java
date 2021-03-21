package vitily.com.util;

import javax.servlet.http.HttpServletRequest;

public class HttpContentType {

    public static final String DECODE_CHARSET = "ISO-8859-1";
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final String MEDIA_TYPE_XML = "application/xml";
    public static final String MEDIA_TYPE_TEXT_XML = "text/xml";
    public static final String MEDIA_TYPE_JSON = "application/json";
    public static final String TEXT_HTML = "text/html";

    private String charset;
    private String mediaType;

    public HttpContentType() {
    }

    public HttpContentType(String charSet, String mediaType) {
        this.charset = charSet;
        this.mediaType = mediaType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getContentType() {
        return mediaType + "; charset=" + charset;
    }


    public static final HttpContentType getHttpContentTypeFromRequest(HttpServletRequest request) {
        String charset = request.getCharacterEncoding();
        String mediaType = null;
        String contentType = request.getContentType();
        if (!StringUtil.isEmpty(contentType)) {
            String[] s = contentType.split(";");
            mediaType = s[0].trim();
            if (StringUtil.isEmpty(charset) && s.length > 1) {
                charset = s[1].split("=")[0].trim();
            }
        }

        if (StringUtil.isEmpty(charset)) {
            charset = DEFAULT_CHARSET;
        }
        if (StringUtil.isEmpty(mediaType) || (mediaType != null && mediaType.equalsIgnoreCase(MEDIA_TYPE_JSON))) {
            mediaType = MEDIA_TYPE_JSON;
        } else {
            mediaType = MEDIA_TYPE_TEXT_XML;
        }
        HttpContentType contentType_ = new HttpContentType();
        contentType_.setMediaType(mediaType);
        contentType_.setCharset(charset);
        return contentType_;
    }
}
