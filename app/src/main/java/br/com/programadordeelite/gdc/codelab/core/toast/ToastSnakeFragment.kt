package br.com.programadordeelite.gdc.codelab.core.toast

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.codelab.util.snakeExt
import br.com.programadordeelite.gdc.codelab.util.toastExt
import br.com.programadordeelite.gdc.databinding.FragmentToastSnakeBinding

class ToastSnakeFragment : Fragment(R.layout.fragment_toast_snake) {

    private lateinit var binding: FragmentToastSnakeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        binding = FragmentToastSnakeBinding.bind(view)

        binding.toast.setOnClickListener{
            toastExt("Minhas mensagem para voce!")
        }

        binding.snake.setOnClickListener{
            snakeExt(view, "Essa é uma mensagem de snake")
        }

        binding.snakeAction.setOnClickListener{
            snakeExt(view, "Voce é uma cobra")
        }
    }
}
