package com.jasonxu.popupwindows;

import android.annotation.TargetApi;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 *@description 
 *@author Zhebao Xu
 *created at 6/24/16 1:03 PM 
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button btn_bottom,btn_top,btn_center,btn_anchor,btn_anchor_offset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initEvents();

    }

    private void initViews(){
        btn_bottom = (Button)this.findViewById(R.id.btn_bottom);
        btn_top = (Button)this.findViewById(R.id.btn_top);
        btn_center = (Button)this.findViewById(R.id.btn_center);
        btn_anchor = (Button)this.findViewById(R.id.btn_anchor);
        btn_anchor_offset = (Button)this.findViewById(R.id.btn_anchor_offset);
    }



    private void initEvents(){
        btn_bottom.setOnClickListener(this);
        btn_top.setOnClickListener(this);
        btn_center.setOnClickListener(this);
        btn_anchor.setOnClickListener(this);
        btn_anchor_offset.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_bottom:
                showBottomDialog();
                break;
            case R.id.btn_top:
                showTopDialog();
                break;
            case R.id.btn_center:
                showCentreDialog(0);
                break;
            case R.id.btn_anchor:
                showAnchorDialog();
                break;
            case R.id.btn_anchor_offset:
                showAnchorOffsetDialog();
                break;
        }
    }

    private void showAnchorDialog(){
        View contentView = LayoutInflater.from(this).inflate(R.layout.bottom,null);
        final PopupWindow anchorDialog = new PopupWindow(contentView,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        anchorDialog.setFocusable(true);
        anchorDialog.showAsDropDown(btn_anchor);
    }

    @TargetApi(21)
    private void showAnchorOffsetDialog(){
        View contentView = LayoutInflater.from(this).inflate(R.layout.bottom,null);
        final PopupWindow anchorDialog = new PopupWindow(contentView,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        anchorDialog.setFocusable(true);
        int screenWidth = ScreenUtils.getScreenWidth(this);
        int screenHeight = ScreenUtils.getScreenHeight(this);
        int offsetX = screenWidth/2-btn_anchor_offset.getWidth()/2;
        int offsetY =  btn_anchor_offset.getHeight()/2;
        //设置阴影效果
        anchorDialog.setElevation(20);
        anchorDialog.showAsDropDown(btn_anchor,offsetX,0);
    }

    private void showTopDialog(){

        View contentView = LayoutInflater.from(this).inflate(R.layout.top,null);
        final PopupWindow topDialog = new PopupWindow(contentView,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        Button button = (Button)contentView.findViewById(R.id.btn_top);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topDialog.dismiss();
            }
        });
        View rootView = LayoutInflater.from(this).inflate(R.layout.activity_main,null);
//        topDialog.setOutsideTouchable(true);
        topDialog.setFocusable(true);
        topDialog.setBackgroundDrawable(new ColorDrawable());
        topDialog.setAnimationStyle(R.style.pop_up_animation);
        topDialog.showAtLocation(rootView,Gravity.TOP,0,0);
    }

    private void showCentreDialog(@LayoutRes  int id){

        View contentView = LayoutInflater.from(this).inflate(R.layout.centre,null);
        final PopupWindow topDialog = new PopupWindow(contentView,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        Button button = (Button)contentView.findViewById(R.id.btn_top);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topDialog.dismiss();
            }
        });
        View rootView = LayoutInflater.from(this).inflate(R.layout.activity_main,null);
        topDialog.setOutsideTouchable(true);
        topDialog.setFocusable(true);
        topDialog.setAnimationStyle(R.style.pop_up_animation);
        topDialog.showAtLocation(rootView,Gravity.TOP,0,0);
    }

    private void showBottomDialog(){
        final PopupWindow bottomDialog = new PopupWindow(this);
        View contentView = LayoutInflater.from(this).inflate(R.layout.bottom,null);
        bottomDialog.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        bottomDialog.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//        bottomDialog.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        bottomDialog.setContentView(contentView);
        bottomDialog.setOutsideTouchable(true);
//        bottomDialog.setBackgroundDrawable(new ColorDrawable("#000000"));
        Button button = (Button) contentView.findViewById(R.id.btn_bottom);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomDialog.dismiss();
            }
        });

        bottomDialog.setFocusable(true);
        bottomDialog.setAnimationStyle(R.style.pop_up_animation);
        //使用showAtLocation
        //1.根视图
        View rootView = LayoutInflater.from(this).inflate(R.layout.activity_main,null);
//        View rootView = (this.findViewById(android.R.id.content)).getRootView();
        bottomDialog.showAtLocation(rootView, Gravity.BOTTOM,0,0);
    }
}
