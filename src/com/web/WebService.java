package com.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebService {

    private static String IP = "10.42.0.1:8080";

    // ͨ��Get��ʽ��ȡHTTP����������
    public static String executeHttpGet(String username, String password) {

        HttpURLConnection conn = null;
        InputStream is = null;

        try {
            // �û��� ����
            // URL ��ַ
            String path = "http://" + IP + "/HelloWeb/servlet/MyServlet";
            path = path + "?username=" + username + "&password=" + password;

            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(3000); // ���ó�ʱʱ��
            conn.setReadTimeout(3000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET"); // ���û�ȡ��Ϣ��ʽ
            conn.setRequestProperty("Charset", "UTF-8"); // ���ý������ݱ����ʽ

            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                return parseInfo(is);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �����˳�ʱ�������ӹرձ���
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }

    // ��������ת��Ϊ String �� 
    private static String parseInfo(InputStream inStream) throws Exception {
        byte[] data = read(inStream);
        // ת��Ϊ�ַ���
        return new String(data, "UTF-8");
    }

    // ��������ת��Ϊbyte�� 
    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        inStream.close();
        return outputStream.toByteArray();
    }
}