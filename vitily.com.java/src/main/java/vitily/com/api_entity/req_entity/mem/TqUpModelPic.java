package vitily.com.api_entity.req_entity.mem;

import org.springframework.web.multipart.MultipartFile;
import vitily.com.annotation.RequireValidator;

public class TqUpModelPic extends TqMemBase{
    @RequireValidator
    MultipartFile picUrl;
    @RequireValidator
    private String picType;

    public MultipartFile getPicUrl() {
        return picUrl;
    }
    public void setPicUrl(MultipartFile picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }
}
