package marshi.android.feedpond.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebViewClient
import marshi.android.feedpond.R
import marshi.android.feedpond.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
  
  private lateinit var binding: ActivityLoginBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    binding.webview.webViewClient = WebViewClient()
    binding.webview.loadUrl("https://cloud.feedly.com/v3/auth/auth?client_id=feedly&redirect_uri=http://localhost&scope=https://cloud.feedly.com/subscriptions&response_type=code&provider=google&migrate=false")
  }
  
}
