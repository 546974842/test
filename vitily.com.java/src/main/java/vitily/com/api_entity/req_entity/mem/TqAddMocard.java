package vitily.com.api_entity.req_entity.mem;

import org.springframework.web.multipart.MultipartFile;
import vitily.com.annotation.RequireValidator;

public class TqAddMocard extends TqMemBase{
    @RequireValidator
    MultipartFile picUrl;

    public MultipartFile getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(MultipartFile picUrl) {
        this.picUrl = picUrl;
    }
}
