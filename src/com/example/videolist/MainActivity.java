package com.example.videolist;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ListActivity{

String[] videoFileList = {
	Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/v1.mp4",
	Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/v3.mp4"
};

public class MyThumbnaildapter extends ArrayAdapter<String>{

 public MyThumbnaildapter(Context context, int textViewResourceId,
   String[] objects) {
  super(context, textViewResourceId, objects);
  // TODO Auto-generated constructor stub
 }

 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
  // TODO Auto-generated method stub
 
  View row = convertView;
  if(row==null){
   LayoutInflater inflater=getLayoutInflater();
   row=inflater.inflate(R.layout.row, parent, false);
  }
 
  TextView textfilePath = (TextView)row.findViewById(R.id.FilePath);
  textfilePath.setText(videoFileList[position]);
  ImageView imageThumbnail = (ImageView)row.findViewById(R.id.Thumbnail);
 
  Bitmap bmThumbnail;
        bmThumbnail = ThumbnailUtils.createVideoThumbnail(videoFileList[position], Thumbnails.MICRO_KIND);
        imageThumbnail.setImageBitmap(bmThumbnail);
 
  return row;
 }

}

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setListAdapter(new MyThumbnaildapter(MainActivity.this, R.layout.row, videoFileList));
  }
}
