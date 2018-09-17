package marshi.android.feedpond.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.auth.GoogleAuthUtil
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.Scope
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import marshi.android.feedpond.R
import marshi.android.feedpond.databinding.ActivityLoginBinding
import marshi.android.feedpond.repository.feedly.FeedlyRepository


class LoginActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {
  
  private lateinit var binding: ActivityLoginBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
  
    val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
      .requestScopes(Scope("https://www.googleapis.com/auth/plus.me"))
      .requestEmail()
      .build()
    val apiClient = GoogleApiClient.Builder(this)
      .enableAutoManage(this, this)
      .addApi(Auth.GOOGLE_SIGN_IN_API, options)
      .build()
    binding.signInButton.setOnClickListener {
      val repository = FeedlyRepository()
      val response = repository.auth().observeOn(AndroidSchedulers.mainThread()).subscribe(
        { println("aiueo $it") },
        { println("iiii ${it.message}") }
      )
      println("message $response")
      val intent = Auth.GoogleSignInApi.getSignInIntent(apiClient)
      startActivityForResult(intent, 0)
    }
  }
  
  override fun onConnectionFailed(result: ConnectionResult) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
  
  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == 0) {
      val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
      handleSignInResult(result)
    }
  }
  
  private fun handleSignInResult(result: GoogleSignInResult) {
    if (result.isSuccess) {
      // サインインが成功したら、サインインボタンを消して、ユーザー名を表示する
  
      val mGoogleSignInAccount = result.signInAccount
      println("DisplayName: " + mGoogleSignInAccount!!.displayName)
      println("idtoken: ${result.signInAccount?.idToken}")
      println("account: ${result.signInAccount?.account}")
      Single.create<String> {
        val token = GoogleAuthUtil.getToken(
          this,
          mGoogleSignInAccount.account,
          "oauth2:https://www.googleapis.com/auth/plus.me openid"
        )
        it.onSuccess(token)
      }
        .subscribeOn(Schedulers.io())
        .subscribe(
          {
            println("tokennnn $it")
          },
          { println("errorrrrr $it") }
        ).isDisposed
//      updateUI(true)
    } else {
      println("errorrr")
      // Signed out, show unauthenticated UI.
//      updateUI(false)
    }
  }
  
}
