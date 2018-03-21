package com.example.teste2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

	private static final String[] TEXTS = { 
		"Image #1", "Image #2", "Image #3","Image #4", 
		"Image #5", "Image #6", "Image #7","Image #8",
		"Image #9", "Image #10", "Image #11","Image #12",
		"Image #13", "Image #14", "Image #15","Image #16"
		};
	private static final int[] IMAGES = { R.drawable.naruto65501, R.drawable.naruto65502,R.drawable.naruto65503,
		R.drawable.naruto65504,R.drawable.naruto65505, R.drawable.naruto65506,
		R.drawable.naruto65507,R.drawable.naruto65508,R.drawable.naruto65509,
		R.drawable.naruto65510,R.drawable.naruto65511,R.drawable.naruto65512,
		R.drawable.naruto65513,R.drawable.naruto65515,R.drawable.naruto65516 };
	private int mPosition = 0;
	private TextSwitcher mTextSwitcher;
	private ImageSwitcher mImageSwitcher;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTextSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
		mTextSwitcher.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				TextView textView = new TextView(MainActivity.this);
				textView.setGravity(Gravity.CENTER);
				return textView;
			}
		});

		mTextSwitcher.setInAnimation(this, android.R.anim.fade_in);
		mTextSwitcher.setOutAnimation(this, android.R.anim.fade_out);

		mImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
		mImageSwitcher.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				ImageView imageView = new ImageView(MainActivity.this);
				return imageView;
			}
		});
		mImageSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
		mImageSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);

		onSwitch(null);
	}

	public void onSwitch(View view) {
		mTextSwitcher.setText(TEXTS[mPosition]);
		mImageSwitcher.setBackgroundResource(IMAGES[mPosition]);
		mPosition = (mPosition + 1) % TEXTS.length;
	}
	
	//public void onSwitch2(View view) {
		//mTextSwitcher.setText(TEXTS[mPosition]);
	//	mImageSwitcher.setBackgroundResource(IMAGES[mPosition]);
		//mPosition = (mPosition - 1) % TEXTS.length;
	//}
}