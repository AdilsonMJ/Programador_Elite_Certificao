package br.com.programadordeelite.gdc.codelab.core.notification


import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentNotificationBinding
import kotlinx.android.synthetic.main.fragment_notification.*


// Por ser apenas um exercicio de exemplo criamos apenas 1 notification, para cada tipo de
// notificacao teria que criar um ID para usuario poder cancelar notificacao no sistema do aparelho,
// teria que criar um array em xml e guardar todos esses ID.

private const val NOTIFICATION_ID = 0
private const val PRIMARY_CHANNEL_ID = "primary_notification_channel"
private const val ACTION_UPDATE = "ACTION_UPDATE_NOTIFICATION"
private const val ACTION_CANCEL = "ACTION_CANCEL_NOTIFICATION"
private const val ACTION_DELETE_ALL = "ACTION_DELETED_NOTIFICATIONS"

class NotificationFragment : Fragment(R.layout.fragment_notification) {

    private lateinit var binding: FragmentNotificationBinding
    private lateinit var notificationManager: NotificationManager
    private val notificationReceiver = NotificationReceiver()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        setupUiButtonListeners()
        setupUiButtonStates(enableNotify = true, enableUpdate = false, enableCancel = false)
        createNotificationChannel()
        registerNotificationReceiver()

    }

    private fun setupUiButtonListeners(){
        binding.notify.setOnClickListener{sendNotification()}
        binding.update.setOnClickListener{updateNotification()}
        binding.cancel.setOnClickListener{cancelNotification()}
    }

    private fun setupUiButtonStates( // Assegurando o estado inicial dos botoes
        enableNotify: Boolean,
        enableUpdate: Boolean,
        enableCancel: Boolean
    ){
        notify.isEnabled = enableNotify
        update.isEnabled = enableUpdate
        cancel.isEnabled = enableCancel
    }


    // A partir do android 8.0 (API 26) temos que definir o canal para que o usuario possa
    // eventualmente desabilitar as notificacoes do aplicativo atraves das configuracoes
    private fun createNotificationChannel(){
        // Crair notification Manager e salva na variavel local
        notificationManager = requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(android.os.Build.VERSION.SDK_INT >= VERSION_CODES.O){
            // Isso aqui é o que vai aparece nas configuracoes do aparelho no seu aplicativo
            val notificationChannel = NotificationChannel(
                PRIMARY_CHANNEL_ID,
                "Mascot Notification",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableVibration(true)
            notificationChannel.description = "Notification from Mascot"
            //Serao exibidas se o telefone der suporte a essas coisas
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            //Criar o canal com as propriedades definidas
            notificationManager.createNotificationChannel(notificationChannel)

        } else {
            // Adicionar notification para celulares anteriores a versao API 26
        }
    }

    private fun cancelNotification(){
        notificationManager.cancel(NOTIFICATION_ID)
        setupUiButtonStates(enableNotify = true, enableUpdate = false, enableCancel = false)
    }

    private fun updateNotification(){
        // Personalizacao dinamica da notificacao adicionando um icone.
        val androidImage = BitmapFactory.decodeResource(resources, R.drawable.ic_notification)
        // atualizando o estilo e o titulo
        val notification = getNotificationBuilder()
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(androidImage)
                    .setBigContentTitle("Notificacao Personaliada")
            )
        // atualiar a notificacao atual
        notificationManager.notify(NOTIFICATION_ID, notification.build())
        // habilitar botao cancelar
        setupUiButtonStates(enableNotify = false, enableUpdate = false, enableCancel = true)
    }


}