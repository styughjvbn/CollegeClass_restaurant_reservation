package github;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

abstract class call_json {
	HttpURLConnection conn = null;
	JSONObject responseJson = null;

	abstract URL create_adress_url(String str);

	Object create_obj(URL url) {//json ���� �޾ƿ���
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", "KakaoAK c9d353af0202d8a0ae9409bf50e93233");// api Ű �Է�
			conn.setRequestProperty("Content-Type", "application/json");// ���� ���� ����

			int responseCode = conn.getResponseCode();
			if (responseCode == 401) {// ��û�� ���� �� ���� ����
				System.out.println("401:: Header�� Ȯ�����ּ���.");
			} else if (responseCode == 500) {
				System.out.println("500:: ���� ����");
			} else if (responseCode == 400) {
				System.out.println("400:: �Ķ���� ����");
			} else if (responseCode == 429) {
				System.out.println("429:: ��뷮 �ѵ� �ʰ�");
			} else if (responseCode == 200) { // �������� ����.
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(sb.toString());
				return obj;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return null;

	}
}

class call_address extends call_json {//�ּҸ� xy��ǥ�� ��ȯ
	URL url;
	String x,y;
	URL create_adress_url(String str) {
		try {
			String address = URLEncoder.encode(str, "UTF-8");// �˻��� �Է�
			url = new URL("https://dapi.kakao.com/v2/local/search/address.json?page=1&size=10&query=" + address);
			System.out.println("success create address-URL");
			return url;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	void update_XY(String str) {
		Object temp=create_obj(create_adress_url(str));
		if(temp!=null) {
			responseJson = (JSONObject)temp;
			JSONArray documents = (JSONArray) responseJson.get("documents");// ������ �˻� ��� JSON
			JSONObject tmp = (JSONObject) documents.get(0);
			x=tmp.get("x").toString();
			y=tmp.get("y").toString();
			System.out.println("success update X, Y");
		}
		else
			System.out.println("X Y update fail");
	}
}

class search extends call_address{//Ű����� ������ �˼� 
	String radius="1000";//�ش� ��ǥ���� ������ ��ŭ �˻� ������ ������� �ִ� 45
	int page=1;
	ArrayList<String[]> list1;
	
	URL create_url(String str) {
		try {
			String keyword = URLEncoder.encode(str, "UTF-8");// �˻��� �Է�
			url = new URL("https://dapi.kakao.com/v2/local/search/keyword.json?page="+Integer.toString(page)+"&size=15&sort=accuracy&x="+super.x+"&y="+super.y+"&radius="+radius+"&query="+keyword+"&category_group_code=FD6");
			System.out.println("success create search-URL");
			return url;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	void search_result(String str) {
		Object temp=create_obj(create_url(str));
		String []ary=null;
		responseJson = (JSONObject)temp;
		JSONObject tmp;
		list1 = new ArrayList();

		JSONArray documents = (JSONArray) responseJson.get("documents");// ������ �˻� ��� JSON
		System.out.println(documents);
		for(int i=0;i<15;i++) {//ù��° ��� �������� ����
			try {
				tmp = (JSONObject)documents.get(i);
				ary=new String[7];
				ary[0]=tmp.get("place_name").toString();
				ary[1]=tmp.get("distance").toString();
				ary[2]=tmp.get("phone").toString();
				ary[3]=tmp.get("category_name").toString();
				ary[4]=tmp.get("address_name").toString();
				ary[5]=tmp.get("x").toString();
				ary[6]=tmp.get("y").toString();
				list1.add(ary);
			}catch(IndexOutOfBoundsException e) {
				break;
			}
		}
		JSONObject meta = (JSONObject) responseJson.get("meta");
		int num = Integer.parseInt(meta.get("pageable_count").toString());// ������ �˻� ��� �� �ִ밪
		System.out.println("search result : "+num);
		num /= 15;
		if (num >= 3)num = 2;//�������� 1���� �Ѵ´ٸ� �� ����

		temp=null;
		responseJson=null;
		documents=null;
		tmp=null;
		for (int i = 0; i < num; i++) {
			int j=0;
			page++;
			temp=create_obj(create_url(str));
			responseJson = (JSONObject)temp;
			documents = (JSONArray) responseJson.get("documents");// ������ �˻� ��� JSON
			tmp = (JSONObject)documents.get(j);
			while(true) {
				try {
					ary=new String[7];
					ary[0]=tmp.get("place_name").toString();
					ary[1]=tmp.get("distance").toString();
					ary[2]=tmp.get("phone").toString();
					ary[3]=tmp.get("category_name").toString();
					ary[4]=tmp.get("address_name").toString();
					ary[5]=tmp.get("x").toString();
					ary[6]=tmp.get("y").toString();
					list1.add(ary);
					j++;
					tmp = (JSONObject)documents.get(j);
				} catch(IndexOutOfBoundsException e) {
					break;
				}
			}
		}	
	}
	ArrayList<String[]> get_result() {
		return list1;
	}
	String get_center_x() {
		return super.x;
	}
	String get_center_y() {
		return super.y;
	}
}
