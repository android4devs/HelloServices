package pl.froger.helloservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ClientActivity extends Activity {
	private Button btnStartService;
	private Button btnStopService;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btnStartService = (Button) findViewById(R.id.btnStartService);
		btnStopService = (Button) findViewById(R.id.btnStopService);
		initButtonsOnClick();
	}

	private void initButtonsOnClick() {
		OnClickListener listener = new OnClickListener() {
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.btnStartService:
					startMyService();
					break;
				case R.id.btnStopService:
					stopMyService();
					break;
				default:
					break;
				}
			}
		};
		btnStartService.setOnClickListener(listener);
		btnStopService.setOnClickListener(listener);
	}
	
	private void startMyService() {
		Intent serviceIntent = new Intent(this, MyService.class);
		startService(serviceIntent);
	}
	
	private void stopMyService() {
		Intent serviceIntent = new Intent(this, MyService.class);
		stopService(serviceIntent);
	}
}