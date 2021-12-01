package github;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;

class static_map_image{
	String imgUrl;  // 이미지 URL
	String imgFilePath;    // 저장할 파일명 (경로 포함)
	
	static_map_image(){//객체 이용전 폴더내의 이미지 정리
		File imgFile = new File("image/shop");
		if (!imgFile.exists()) {// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
			try{
				imgFile.mkdir(); //폴더 생성합니다.
			    System.out.println("폴더가 생성되었습니다.");
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	         }else {
		}	
		File[] deletefileList = imgFile.listFiles();
		for(int i=0;i<deletefileList.length;i++) {
			deletefileList[i].delete();
		}
	}
	public void create_map_image(String center_x,String center_y,String x,String y,String delete,String insert) {
		imgUrl="https://api.vworld.kr/req/image?service=image&version=2.0&request=getmap&key=2DA3E23B-07A8-3A22-B701-2E6EC1B4E951&format=png&errorformat=blank&basemap=GRAPHIC&center="
		+ x+","+y
		+ "&crs=epsg:4326&zoom=16&size=800,600&marker=point:"
		+ x+"%20"+y
		+ "|label:%EB%AA%A9%EC%A0%81%EC%A7%80|color:blue";

		try
        {
            // Image 가져오기
            BufferedImage image = ImageIO.read(new URL(imgUrl));
                       
            // Image 저장할 파일
            imgFilePath="image/shop/"+insert+".png";   
            
            // 이미지 저장 전 전 이미지 삭제
            File imgFile = new File(imgFilePath);
            if(delete!="") {
            	File file = new File("image/shop/"+delete+".png");
            	file.delete();
            }
            // Image 저장
            ImageIO.write(image, "png", imgFile);
        }
        catch (Exception e)
        {
        	System.out.println("image error");
        }
	}
}
