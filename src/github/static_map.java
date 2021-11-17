package github;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;

class static_map_image{
	String imgUrl;  // �̹��� URL
	String imgFilePath;    // ������ ���ϸ� (��� ����)
	
	static_map_image(){//��ü �̿��� �������� �̹��� ����
		File imgFile = new File("image/shop");
		File[] deletefileList = imgFile.listFiles();
		for(int i=0;i<deletefileList.length;i++) {
			deletefileList[i].delete();
		}
	}
	public void create_map_image(String center_x,String center_y,String x,String y,String delete,String insert) {
		imgUrl="https://api.vworld.kr/req/image?service=image&version=2.0&request=getmap&key=2DA3E23B-07A8-3A22-B701-2E6EC1B4E951&format=png&errorformat=blank&basemap=GRAPHIC&center="
		+ center_x+","+center_y
		+ "&crs=epsg:4326&zoom=16&size=600,400&marker=point:"
		+ center_x+"%20"+center_y
		+ "|label:%EA%B2%80%EC%83%89%EC%A7%80|color:red|font:%EA%B3%A0%EB%94%95%EC%B2%B4|size:13&marker=point:"
		+ x+"%20"+y
		+ "|label:%EB%AA%A9%EC%A0%81%EC%A7%80|color:blue";

		try
        {
            // Image ��������
            BufferedImage image = ImageIO.read(new URL(imgUrl));
                       
            // Image ������ ����
            imgFilePath="image/shop/"+insert+".png";   
            
            // �̹��� ���� �� �� �̹��� ����
            File imgFile = new File(imgFilePath);
            if(delete!="") {
            	File file = new File("image/shop/"+delete+".png");
            	file.delete();
            }
            // Image ����
            ImageIO.write(image, "png", imgFile);
        }
        catch (Exception e)
        {
        	System.out.println("image error");
        }
	}
}