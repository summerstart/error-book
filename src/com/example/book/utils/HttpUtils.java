package com.example.book.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.widget.Spinner;

public class HttpUtils {
	public static String ip = "";
	public static String requestHttp(String name,String pwd){
		HttpClient client = new DefaultHttpClient();
		HttpResponse httpResponse = null; 
		HttpPost post = new HttpPost(ip+"servlet/mians");
		List<NameValuePair> params = new ArrayList<NameValuePair>();//����һ��List���͵ļ��ϴ洢�û��������� 
        params.add(new BasicNameValuePair("username", name)); 
        params.add(new BasicNameValuePair("pwd", pwd)); 
		
		try {
			post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));//�����ַ�������
			httpResponse = client.execute(post);
			/**
			 * HTTP Status Code ΪHTTP״̬�룬ʹ���Ա�ʾ��ҳ������HTTP��Ӧ״̬��3Ϊ���ִ���
			 * ״̬��=200ʱ��ʾ����ɹ�������ϣ������Ӧͷ���������彫�����Ӧ���� 
			 */
			if (httpResponse.getStatusLine().getStatusCode()==200) {
				InputStream iStream = httpResponse.getEntity().getContent();
				String result = Inputstrean2String.readFromStream(iStream);
				return result;
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static String requestHttpWithUrl(String str,String url,String time,String where){
		HttpClient client = new DefaultHttpClient();
		HttpResponse httpResponse = null; 
		HttpPost post = new HttpPost(""+url);
		List<NameValuePair> params = new ArrayList<NameValuePair>(); 
        params.add(new BasicNameValuePair("result", str)); 
        params.add(new BasicNameValuePair("time", time)); 
        params.add(new BasicNameValuePair("where", where)); 
		try {
			post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
			httpResponse = client.execute(post);
			if (httpResponse.getStatusLine().getStatusCode()==200) {
				InputStream iStream = httpResponse.getEntity().getContent();
				String result = Inputstrean2String.readFromStream(iStream);
				return result;
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static String requestHttp(String userName, String repwd,
			String pwd, String phone) {
		// TODO Auto-generated method stub
		
		HttpClient client = new DefaultHttpClient();
		HttpResponse httpResponse = null; 
		HttpPost post = new HttpPost(ip+"servlet/register");
		List<NameValuePair> params = new ArrayList<NameValuePair>(); 
        params.add(new BasicNameValuePair("username", userName)); 
        params.add(new BasicNameValuePair("pwd", pwd));
        params.add(new BasicNameValuePair("repwd", repwd)); 
        params.add(new BasicNameValuePair("phone", phone)); 
 
		
		try {
			post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
			httpResponse = client.execute(post);
			if (httpResponse.getStatusLine().getStatusCode()==200) {
				InputStream iStream = httpResponse.getEntity().getContent();
				String result = Inputstrean2String.readFromStream(iStream);
				return result;
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

	}

	public static String requestHttp(String zhouji, String course,
			String jiaoxuelou) {
		HttpClient client = new DefaultHttpClient();
		HttpResponse httpResponse = null; 
		HttpPost post = new HttpPost(ip+"servlet/aaa");
		List<NameValuePair> params = new ArrayList<NameValuePair>(); 
        params.add(new BasicNameValuePair("zhouji",zhouji)); 
        params.add(new BasicNameValuePair("course", course));
        params.add(new BasicNameValuePair("jiaoxuelou", jiaoxuelou)); 
		
		try {
			post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
			httpResponse = client.execute(post);
			if (httpResponse.getStatusLine().getStatusCode()==200) {
				InputStream iStream = httpResponse.getEntity().getContent();
				String result = Inputstrean2String.readFromStream(iStream);
				return result;
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public static String requestHttp1(String time, String where) {
		// TODO Auto-generated method stub
		HttpClient client = new DefaultHttpClient();
		HttpResponse httpResponse = null; 
		HttpPost post = new HttpPost(ip+"servlet/search");
		List<NameValuePair> params = new ArrayList<NameValuePair>(); 
        params.add(new BasicNameValuePair("time",time)); 
        params.add(new BasicNameValuePair("where", where));

		try {
			  post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
			  httpResponse = client.execute(post);
			  
			  if (httpResponse.getStatusLine().getStatusCode()==200) {
				 InputStream iStream = httpResponse.getEntity().getContent();
				 /**
				  * ��ȡʱ��ص�
				  */
				 String result = Inputstrean2String.readFromStream(iStream);
				
				return result;
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}



	

