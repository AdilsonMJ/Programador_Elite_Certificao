package br.com.programadordeelite.gdc.codelab.core.workmanager

import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import br.com.programadordeelite.gdc.R
import br.com.programadordeelite.gdc.databinding.FragmentSelectImageBinding

class SelectImageFragment : Fragment(R.layout.fragment_select_image) {

    // ATUALIZADO
    companion object {
        private const val KEY_PERMISSIONS_GRANTED = "KEY_PERMISSIONS_GRANTED"
        private const val KEY_PERMISSIONS_REQUEST_COUNT = "KEY_PERMISSIONS_REQUEST_COUNT"
        private const val MAX_NUMBER_REQUEST_PERMISSIONS = 2
    }

    private var permissionRequestCount: Int = 0
    private lateinit var binding: FragmentSelectImageBinding
    private lateinit var launcher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // deve ser definido ou no onAttach ou onCreate
        launcher = registerForActivityResult(ActivityResultContracts.GetContent()){
            TODO("Not yet implemented")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSelectImageBinding.bind(view)

        // +---------------------------------------------------------------------------------+
        // | ESCREVA SEU CÓDIGO ACOMPANHANDO A AULA NO YOUTUBE                               |
        // | JÁ APROVEITA E SEGUE O CANAL >> LINK PARA AS AULAS:                             |
        // | https://youtu.be/5AGWzq9JpYo                                                    |
        // | https://youtu.be/MJpeoRopmgw                                                    |
        // | https://youtu.be/vGwr9XZ8xDY                                                    |
        // +---------------------------------------------------------------------------------+
        TODO("Not yet implemented")
    }

}