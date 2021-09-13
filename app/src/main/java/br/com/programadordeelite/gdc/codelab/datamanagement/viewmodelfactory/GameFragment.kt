package br.com.programadordeelite.gdc.codelab.datamanagement.viewmodelfactory

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentGameBinding

class GameFragment : Fragment(R.layout.fragment_game) {

    private lateinit var binding: FragmentGameBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGameBinding.bind(view)
        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | EM ANDAMENTO, APROVEITA E JÁ SEGUE O CANAL PARA NÃO PERDER O VÍDEO              |
        // +---------------------------------------------------------------------------------+
    }
}