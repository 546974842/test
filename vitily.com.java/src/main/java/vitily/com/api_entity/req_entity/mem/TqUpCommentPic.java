package vitily.com.api_entity.req_entity.mem;

import org.springframework.web.multipart.MultipartFile;
import vitily.com.annotation.RequireValidator;

/**
 * creator : whh-lether
 * date    : 2018/12/27 13:51
 * desc    :
 **/
public class TqUpCommentPic extends TqMemBase{
    @RequireValidator
    private MultipartFile imgFile;
    @RequireValidator
    private Integer index;
    @RequireValidator
    private Integer orderId;

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
