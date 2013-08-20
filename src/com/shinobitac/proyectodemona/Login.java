package com.shinobitac.proyectodemona;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Login extends Activity
{
  Button btn_facebook;
  Button btn_twitter;
  Context ctx;
  TextView tv_entrarsinsesion;

	public void onCreate(Bundle savedInstanceState) {
  
		super.onCreate(savedInstanceState);
    setContentView(R.layout.login);
    this.ctx = this;
    this.btn_facebook = ((Button)findViewById(R.id.btn_login_facebookLogin));
    this.btn_twitter = ((Button)findViewById(R.id.btn_login_twitterLogin));
    this.tv_entrarsinsesion = ((TextView)findViewById(R.id.tv_login_entrarsinregistro));
    this.btn_facebook.setText(Html.fromHtml(this.btn_facebook.getText().toString() + "<br>" + getResources().getString(R.string.login_con) + "<b> " + getResources().getString(R.string.login_facebook) + "</b>"));
    this.btn_twitter.setText(Html.fromHtml(this.btn_twitter.getText().toString() + "<br>" + getResources().getString(R.string.login_con) + "<b> " + getResources().getString(R.string.login_twitter) + "</b>"));
    this.btn_facebook.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Login.this.startActivity(new Intent(Login.this.ctx, Principal.class));
        Login.this.finish();
      }
    });
    this.btn_twitter.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Login.this.startActivity(new Intent(Login.this.ctx, Principal.class));
        Login.this.finish();
      }
    });
    this.tv_entrarsinsesion.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Login.this.startActivity(new Intent(Login.this.ctx, Principal.class));
        Login.this.finish();
      }
    });
  }
}

