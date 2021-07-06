package actions

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.OSProcessHandler
import com.intellij.execution.process.ProcessHandler

class MyAction: AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val noti = NotificationGroup("myplugin", NotificationDisplayType.BALLOON, true)
        noti.createNotification("My Title", "My Message", NotificationType.INFORMATION, null).notify(e.project)

        val cmds: ArrayList<String> = ArrayList()
        cmds.add("code")

        val generalCommandLine = GeneralCommandLine(cmds)
//        generalCommandLine.setCharset(Charset.forName("UTF-8"))
//        generalCommandLine.setWorkDirectory(project.getBasePath())

        val processHandler: ProcessHandler = OSProcessHandler(generalCommandLine)
        processHandler.startNotify()
    }
}