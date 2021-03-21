package vitily.com.util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import vitily.com.util.log.LogAdapter;

/**
 * 图片压缩类
 * @author lether
 *
 */
public class NarrowImage {
	static LogAdapter logger = LogAdapter.getLogAdapter(NarrowImage.class);

	  
    /** 
     * @param im 
     *            原始图像 
     * @param resizeTimes 
     *            倍数,比如0.5就是缩小一半,0.98等等double类型 
     * @return 返回处理后的图像 
     */  
    public BufferedImage zoomImage(String src,float resize) {  
          
        BufferedImage result = null;  
  
        try {  
            File srcfile = new File(src);  
            if (!srcfile.exists()) {  
                logger.info("file no exit");  
            }  
            BufferedImage im = ImageIO.read(srcfile);  
  
            /* 原始图像的宽度和高度 */  
            int width = im.getWidth();  
            int height = im.getHeight();  
              
            //压缩计算  
            float resizeTimes = resize;  /*这个参数是要转化成的倍数,如果是1就是转化成1倍*/  
              
            /* 调整后的图片的宽度和高度 */  
            int toWidth = (int) (width * resizeTimes);  
            int toHeight = (int) (height * resizeTimes);  
  
            /* 新生成结果图片 */  
            result = new BufferedImage(toWidth, toHeight,  
                    BufferedImage.TYPE_INT_RGB);  
  
            result.getGraphics().drawImage(  
                    im.getScaledInstance(toWidth, toHeight,  
                            java.awt.Image.SCALE_SMOOTH), 0, 0, null);  
              
  
        } catch (Exception e) {  
        	logger.info("创建缩略图发生异常" + e.getMessage());  
        }  
          
        return result;  
  
    }  
       
     public static void main(String[] args) {  
          
    }  
}
