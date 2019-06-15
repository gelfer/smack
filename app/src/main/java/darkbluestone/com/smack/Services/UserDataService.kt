package darkbluestone.com.smack.Services

import android.graphics.Color
import darkbluestone.com.smack.Controller.App
import java.util.*

object UserDataService {

    var id = ""
    var avatarColor = ""
    var avatarName = ""
    var email = ""
    var name = ""

    fun logout() {
        id = ""
        avatarColor = ""
        avatarName = ""
        email = ""
        name = ""
        App.prefs.authToken = ""
        App.prefs.userEmail = ""
        App.prefs.isLoggedIn = false
        MessageService.clearMessages()
        MessageService.clearChannel()
    }

    fun returnAvatarColor (components : String) : Int {
        // [0.7294117647058823, 0.8549019607843137, 0.01568627450980392, 1]
        // 0.7294117647058823 0.8549019607843137 0.01568627450980392, 1

        val strippedColor = components
            .replace("[","")
            .replace("]","")
            .replace(",","")

        var r = 0
        var g = 0
        var b = 0

        val scanner = Scanner(strippedColor)
        if (scanner.hasNext()) {
            r = (scanner.nextDouble() * 255).toInt()
            g = (scanner.nextDouble() * 255).toInt()
            b = (scanner.nextDouble() * 255).toInt()
        }

        return Color.rgb(r,g,b)
    }
}