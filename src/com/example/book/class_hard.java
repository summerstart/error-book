package com.example.book;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class class_hard extends Activity {
	//1.声明xml文件中的控件的变量
		//private Button btnDO;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
			/*requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	           		WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.class_hard);
	 
	/*// 2.通过findViewById的方法获取控件组件
	 btnDO = (Button) findViewById(R.id.right_ok);
	
		// 3.为button组件加入click事件的监听，触发时执行定义方法
		btnDO.setOnClickListener(btnDoListener);
	 }
	// 实现button的监听函数
		private Button.OnClickListener btnDoListener = new Button.OnClickListener() {
			public void onClick(View v) {
				
				
				Toast.makeText(getApplicationContext(),
						"请选择错题难度！", 0).show();
				}*/
			};

}
