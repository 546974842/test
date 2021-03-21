package vitily.com.util;

import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

/**
 * 时钟验证码
 * 作用：代替常用的图形验证码
 * 缘由：使用该验证代替图形验证码，可以大大的提高恶意攻击的风险。（几乎最佳）
 * @author lether 2016年06月27日09:58:15
 *
 */
public class ClockValidateCode {
	private String code;
    // 图片的宽度。  
    private int width = 165;  
    // 图片的高度。  
    private int height = 165;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
    // 验证码图片Buffer  
    private BufferedImage buffImg=null;  

    private double[] hours = { 1d,5d,4d,6d,12d,2d,9d,10d,8d,7d,3d,11d };  
    private double[] minuts = { 
    		1d,5d,4d,6d,2d,9d,10d,8d,7d,3d,
    		31d,35d,34d,36d,32d,39d,30d,38d,37d,33d,
    		51d,55d,54d,56d,52d,59d,50d,58d,57d,53d,
    		41d,45d,44d,46d,42d,49d,40d,48d,47d,43d,
    		11d,15d,14d,16d,12d,19d,0d,18d,17d,13d,
    		21d,25d,24d,26d,22d,29d,20d,28d,27d,23d,
    		};  
  
    public ClockValidateCode() { 
    }  
    public void createCode(HttpServletRequest request)throws Exception {  

        //随机时间
        
        double hTime=hours[new Random().nextInt(hours.length)];
        double mTime=minuts[new Random().nextInt(minuts.length)];
//        hTime=9;
//        mTime=40;
        double baseHourRan=-3d;//默认起始时间
        double baseMinutRan=-15d;//默认分针倾斜度,顺时针
        
        int width=165,height=165;
        buffImg = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);  
        Graphics2D g = buffImg.createGraphics();  
        buffImg = g.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        g.dispose();
        g = buffImg.createGraphics(); 
        BufferedImage bkImg=ImageIO.read(new File(request.getSession().getServletContext().getRealPath("/")+"contents/images/clockh.png"));
        g.translate(82, 82.5);
        g.rotate((baseHourRan+hTime+mTime/60)*Math.PI*2*30/360);
        g.translate(0,-4.5);
        //g.rotate(180);
        //g.rotate(baseHourRan+time*36);
        
        
        int w=bkImg.getWidth();
        int h=bkImg.getHeight();
        g.drawImage(bkImg, 0, 0, w, h, null);
        g.dispose();
        g = buffImg.createGraphics(); 
        
        g.translate(82.5, 82.5);
        g.rotate((baseMinutRan+mTime)*Math.PI*2*6/360);
        g.translate(0,-3.5);
        BufferedImage mbkImg=ImageIO.read(new File(request.getSession().getServletContext().getRealPath("/")+"contents/images/clockm.png"));

         w=(int)(mbkImg.getWidth()/2.71428571);
         h=(int)(mbkImg.getHeight()/2.71428571);
        g.drawImage(mbkImg, 0, 0, w, h, null);
        g.dispose();
        code = ((int)hTime+"")+((int)+mTime+"");
    }
    public void write(String path) throws IOException {  
        OutputStream sos = new FileOutputStream(path);  
            this.write(sos);  
    }  
      
    public void write(OutputStream sos) throws IOException {  
            ImageIO.write(buffImg, "png", sos);  
            sos.close();  
    }
    public BufferedImage getBuffImg() {  
        return buffImg;  
    } 
}
