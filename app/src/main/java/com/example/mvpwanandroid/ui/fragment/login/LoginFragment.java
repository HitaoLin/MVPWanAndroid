package com.example.mvpwanandroid.ui.fragment.login;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import com.cxz.baselibs.base.BaseMvpFragment;
import com.cxz.baselibs.mvp.IPresenter;
import com.cxz.baselibs.utils.SPUtils;
import com.example.mvpwanandroid.R;
import com.example.mvpwanandroid.config.SPConfig;
import com.example.mvpwanandroid.mvp.contract.LoginContract;
import com.example.mvpwanandroid.mvp.model.bean.LoginBean;
import com.example.mvpwanandroid.mvp.presenter.LoginPresenter;
import com.example.mvpwanandroid.utils.PreventQuickClicksUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends BaseMvpFragment<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.ll_registered)
    LinearLayout llRegistered;//去注册
    private String userName;//用户名
    private String password;//密码
    private String nickName;//登录后名称
    private String id;//ID

    /**
     * from:Android之---Activity与Fragment之间的传值问题
     * https://blog.csdn.net/u010936731/article/details/54380011
     */
    CallBackValue callBackValue;

    /**
     * fragment与activity产生关联是  回调这个方法
     * @param context
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //当前fragment从activity重写了回调接口  得到接口的实例化对象
        callBackValue =(CallBackValue) getActivity();
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void loginSuccess(LoginBean.DataBean login) {
        nickName = login.getNickname();
        id = login.getId();
        SPUtils.getInstance().put(SPConfig.USERNAME,nickName);
        SPUtils.getInstance().put(SPConfig.ID,id);
        showDefaultMsg("登录成功");
        callBackValue.SendMessageValue("3");


    }


    //定义一个回调接口
    public interface CallBackValue{
        void SendMessageValue(String strValue);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView() {
        //控制登录用户名图标大小
        setEditText(R.mipmap.name, 0, 0, 70, 70, etUsername);
        //控制登录密码图标大小
        setEditText(R.mipmap.password, 0, 0, 70, 70, etPassword);

    }

    /**
     * EditText控制
     */
    private void setEditText(int mipmap, int left, int top, int right, int bottom, EditText editText) {
        //控制图标大小
        Drawable drawable = getResources().getDrawable(mipmap);
        drawable.setBounds(left, top, right, bottom);//第一个 0 是距左边距离，第二个 0 是距上边距离，40 分别是长宽
        editText.setCompoundDrawables(drawable, null, null, null);//只放左边
    }

    /**
     * 监听EditText
     */
    private void listenerEditText() {
        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userName = etUsername.getText().toString().trim();
                password = etPassword.getText().toString().trim();
                if (userName != null && password != null) {
                    if (!userName.isEmpty() && !password.isEmpty()) {
                        btLogin.setBackground(getResources().getDrawable(R.drawable.bg_btn_circle_check));
                        btLogin.setEnabled(true);
                    } else {
                        btLogin.setBackground(getResources().getDrawable(R.drawable.bg_btn_circle_uncheck));
                        btLogin.setEnabled(false);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userName = etUsername.getText().toString().trim();
                password = etPassword.getText().toString().trim();
                if (userName != null && password != null) {
                    if (!userName.isEmpty() && !password.isEmpty()) {
                        btLogin.setBackground(getResources().getDrawable(R.drawable.bg_btn_circle_check));
                        btLogin.setEnabled(true);
                    } else {
                        btLogin.setBackground(getResources().getDrawable(R.drawable.bg_btn_circle_uncheck));
                        btLogin.setEnabled(false);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    protected void initShow() {

    }

    @Override
    protected void initData() {
        listenerEditText();
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.bt_login,R.id.ll_registered})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login://登录
                if (PreventQuickClicksUtil.isFastClick()){
                    mPresenter.login(userName, password);
                }
                break;

            case R.id.ll_registered://去注册
                callBackValue.SendMessageValue("0");
                break;
        }
    }

    @OnClick()
    public void onViewClicked() {
    }
}
