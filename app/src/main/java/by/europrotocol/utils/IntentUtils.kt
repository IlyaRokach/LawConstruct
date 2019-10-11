package by.europrotocol.utils

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.text.TextUtils

object IntentUtils {

    /**
     * Get open browser intent
     *
     * @param url link for opening
     * @return intent for browser
     */
    @JvmStatic
    fun getBrowserIntent(url: String): Intent {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        return intent
    }

    /**
     * Get dial intent
     *
     * @param phoneNumber phone number
     * @return intent for dial
     */
    @JvmStatic
    fun getDialIntent(phoneNumber: String): Intent {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        return intent
    }

    /**
     * Get dial intent with app chooser
     *
     * @param intent intent with phone number
     * @return dial app chooser
     */
    @JvmStatic
    fun getDialAppChooser(intent: Intent): Intent {
        return Intent.createChooser(intent, "")
    }

    /**
     * Get email intent
     *
     * @param email   email address
     * @param subject email subject
     * @param message email message
     * @return intent for email
     */
    @JvmStatic
    fun getEmailIntent(email: String, subject: String?, message: String?): Intent {
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, if (TextUtils.isEmpty(subject)) "" else subject)
        emailIntent.putExtra(Intent.EXTRA_TEXT, if (TextUtils.isEmpty(message)) "" else message)
        emailIntent.type = "message/rfc822"
        return emailIntent
    }

    @JvmStatic
    fun getOpenFileIntent(path: Uri, type: String, title: String = ""): Intent {
        val intent = Intent(Intent.ACTION_VIEW)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        }
        intent.setDataAndType(path, type)

        return Intent.createChooser(intent, title)
    }
}