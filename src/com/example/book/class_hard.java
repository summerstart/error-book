package com.example.book;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class class_hard extends Activity {
	//1.����xml�ļ��еĿؼ��ı���
		private Button btnDO;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.class_order);
	 
	// 2.ͨ��findViewById�ķ�����ȡ�ؼ����
	 btnDO = (Button) findViewById(R.id.right_ok);
	
		// 3.Ϊbutton�������click�¼��ļ���������ʱִ�ж��巽��
		btnDO.setOnClickListener(btnDoListener);
	 }
	// ʵ��button�ļ�������
		private Button.OnClickListener btnDoListener = new Button.OnClickListener() {
			public void onClick(View v) {
				
				
				Toast.makeText(getApplicationContext(),
						"��ѡ������Ѷȣ�", 0).show();
				}
			};

}
