package com.zhxu.storeapp.activity;

import android.widget.TextView;

import com.zhxu.storeapp.R;
import com.zhxu.storeapp.view.widget.EnterLayout;

import butterknife.BindView;

public class AboutActivity extends BaseActivity {

    @BindView(R.id.title_text)
    TextView title_text ;
    @BindView(R.id.hispaceportal)
    EnterLayout hispaceportal ;
    @BindView(R.id.developercenter)
    EnterLayout developercenter ;
    @BindView(R.id.weixnaccount)
    EnterLayout weixnaccount ;
    @BindView(R.id.weiboaccount)
    EnterLayout weiboaccount ;
    @BindView(R.id.kefumm)
    EnterLayout kefumm ;
    @BindView(R.id.qqgroup)
    EnterLayout qqgroup ;



    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_about);
        //设置沉浸式状态栏
        setStatusBar();
    }
    @Override
    public void initView() {
        //设置沉浸式状态栏背景
        title_bar.setBackgroundResource(R.color.black_alpha_5);
        title_text.setText(getResources().getString(R.string.about));
        //官网
        hispaceportal.setTitle(getResources().getString(R.string.about_hispacecenter_portal_new));
        hispaceportal.setMemo(getResources().getString(R.string.about_websiteContent));
        //华为开发者联盟
        developercenter.setTitle(getResources().getString(R.string.about_developercenter_portal));
        developercenter.setMemo(getResources().getString(R.string.about_developerContent));
        //微信公众号
        weixnaccount.setTitle(getResources().getString(R.string.about_weixin_account));
        weixnaccount.setMemo(getResources().getString(R.string.about_weixinName));
        //新浪微博
        weiboaccount.setTitle(getResources().getString(R.string.about_xinweibo_account));
        weiboaccount.setMemo(getResources().getString(R.string.about_weibo_name));
        //QQ客服
        kefumm.setTitle(getResources().getString(R.string.about_kefumm));
        kefumm.setMemo(getResources().getString(R.string.about_kefumm_QQ));
        //QQ粉丝群
        qqgroup.setTitle(getResources().getString(R.string.about_fans_qq_group));
        qqgroup.setMemo(getResources().getString(R.string.about_fans_qq_group_number));

    }
}
